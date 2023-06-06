package com.step;


import java.io.FileNotFoundException;

import java.io.IOException;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.globals.GlobalDatas;
import com.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
/**
 * 
 * @author HP
 * @see purpose of this class is used to perform login for this project
 * @since 02-06-2023
 *
 */

public class TC1_LoginStep extends BaseClass {
	Response response;
	static GlobalDatas globalDatas = new GlobalDatas();

	/**
	 * @author Senthil
	 * @see this method is used add header for this page
	 * @since 02-06-2023
	 */
	@Given("User add header")
	public void user_add_header() {
		addHeader("accept", "application/json");

	}
	
	/**
	 * @author Senthil
	 * @see purpose of this method is used to add authentications
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @since 02-06-2023
	 */

	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {
		addBasicAuth(getPropertyFileValue("Username"), getPropertyFileValue("Password"));

	}
	/**
	 * @author Senthil
	 * @see this method is used to perform login endpoints
	 * @param reqType (String)
	 * @since 02-06-2023
	 */

	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String reqType) {
		response = addReqType("POST", EndPoints.POSTMANBASICAUTH);
		int statuscode = getStateusCode(response);
		globalDatas.setStatuscode(statuscode);

	}
	/**
	 * @author Senthil
	 * @see this method is used to verify login repsponse body firstName 
	 * @param expFirstName
	 * @since 02-06-2023
	 */

	@Then("User Should verify the login repsonse body FirstName present as {string} and get the logtoken")
	public void user_should_verify_the_login_repsonse_body_first_name_present_as_and_get_the_logtoken(
			String expFirstName) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		TC1_LoginStep.globalDatas.setLogtoken(login_Output_Pojo.getData().getLogtoken());
		Assert.assertEquals(expFirstName, first_name,"Verify FirstName");
	}

}

