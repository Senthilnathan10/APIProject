package com.step;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.manager.PayloadObjectManager;
import com.payload.address.AddressPayLoad;
import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteAddress_Input_Pojo;
import com.pojo.address.DeleteAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;
import com.pojo.address.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * @author Senthil
 * @see purpose of this class is used to perform AddAddess , UpdateAddress , GetUserAddress and DeleteAddress in this project
 * @since 02-06-2023
 *
 */

public class TC4_AddressStep extends BaseClass {
	PayloadObjectManager pom = new PayloadObjectManager();
	Response response;
	
	/**
	 * @author Senthil
	 * @see this method is used to add headers in addaddress page
	 * @since 02-06-2023
	 */

	@Given("User add header and bearer authorization for accessing address endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoints() {
		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers head = new Headers(listHeader);
		addHeaders(head);
	}
	/**
	 * @author Senthil
	 * @see this method is used to add request body in addaddress page
	 * @param first_Name(string)
	 * @param Last_Name(string)
	 * @param mobile(string)
	 * @param apartment(string)
	 * @param state(integer)
	 * @param city(integer)
	 * @param country (string)
	 * @param Zipcode(strin)
	 * @param Address(string)
	 * @param address_Type(string)
	 * @since 02-06-2023
	 */

	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_add_new_address_and(String string, String string2, String string3,
			String string4, String string5, String string6, String string7, String string8, String string9,
			String string10) {
		AddUserAddress_Input_Pojo addAddressPayload =pom.getAddresspayload().addAddressPayLoad(string, string2, string3,
				string4, Integer.parseInt(TC1_LoginStep.globalDatas.getStateId()),
				Integer.parseInt(TC1_LoginStep.globalDatas.getCityId()), Integer.parseInt(string7), string8, string9,
				string10);

		addBody(addAddressPayload);

	}
	/**
	 * @author Senthil
	 * @see this method is used add endpoints for adduseraddress
	 * @param reqType
	 * @since 02-06-2023
	 */

	@When("User send {string} request for addUserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.ADDUSERADDRESS);

	}
	/**
	 * @author Senthil
	 * @see this method is used to verify adduseraddress response message
	 * @param expAddUserAddress ( String)
	 * @since 02-06-2023
	 */

	@Then("User Should verify the addUserAddress response message matches {string}")
	public void user_should_verify_the_add_user_address_response_message_matches(String expAddUserAddress) {
		AddUserAddress_Output_Pojo as = response.as(AddUserAddress_Output_Pojo.class);
		System.out.println(as.getStatus());
		System.out.println(as.getMessage());
		String addressId = String.valueOf(as.getAddress_id());
		TC1_LoginStep.globalDatas.setAddress_id(addressId);
		System.out.println(addressId);
		Assert.assertEquals(expAddUserAddress, as.getMessage(), "Address added successfully");

	}
	/**
	 * @author Senthil
	 * @see this method is used to add request body in update address page
	 * @param first_Name(string)
	 * @param Last_Name(string)
	 * @param mobile(string)
	 * @param apartment(string)
	 * @param state(integer)
	 * @param city(integer)
	 * @param country (string)
	 * @param Zipcode(strin)
	 * @param Address(string)
	 * @param address_Type(string)
	 * @since 02-06-2023
	 */

	@When("User add request body for update new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_add_request_body_for_update_new_address_and(String string, String string2, String string3,
			String string4, String string5, String string6, String string7, String string8, String string9,
			String string10) {
		UpdateUserAddress_Input_Pojo updateAddress_Input_POJO =pom.getAddresspayload().updateAddressPayLoad(
				TC1_LoginStep.globalDatas.getAddress_id(), string, string2, string3, string4,
				Integer.parseInt(TC1_LoginStep.globalDatas.getStateId()),
				Integer.parseInt(TC1_LoginStep.globalDatas.getCityId()), Integer.parseInt(string7), string8, string9,
				string10);

		addBody(updateAddress_Input_POJO);

	}
	/**
	 * @author Senthil
	 * @see this method is used to add updateUserAddress endpoint
	 * @param reqType
	 * @since 02-06-2023
	 */

	@When("User send {string} request for updateUserAddress endpoint")
	public void user_send_request_for_update_user_address_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.UPDATEUSERADDRESS);

		UpdateUserAddress_Output_Pojo ak = response.as(UpdateUserAddress_Output_Pojo.class);
		System.out.println(ak.getMessage());

	}
	/**
	 * @author Senthil
	 * @see this method is used to verify updateuseraddress response message
	 * @param  expUdateUserAddress (string)
	 */

	@Then("User Should verify the updateUserAddress  response message matches {string}")
	public void user_should_verify_the_update_user_address_response_message_matches(String expUdateUserAddress) {
		UpdateUserAddress_Output_Pojo ak = response.as(UpdateUserAddress_Output_Pojo.class);
		System.out.println(ak.getMessage());
		Assert.assertEquals(expUdateUserAddress, ak.getMessage(), "Address updated successfully");

	}
	/**
	 * @author Senthil
	 * @see this method is used to getuseraddress endpois
	 * @param reqType (String)
	 * @since 02-06-2023
	 */
	
	@Given("User send {string} request for getUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.GETUSERADDRESS);
	
	}
	
	/**
	 * @author Senthil
	 * @see this method is used to getuseraddress response messgae
	 * @param expMsg
	 * @since 02-06-2023
	 */
	
	@Then("User Should verify the GetUserAddress response message matches {string}")
	public void user_should_verify_the_get_user_address_response_message_matches(String expMsg) {

		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String message = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, expMsg, "OK");

	}

	
	/**
	 * @author Senthil
	 * @see this method is used to delete the address 
	 * @param string
	 * @since 02-06-2023
	 */

	@When("User add request body for delete the address {string}")
	public void user_add_request_body_for_delete_the_address(String string) {
		DeleteAddress_Input_Pojo delete = new DeleteAddress_Input_Pojo(TC1_LoginStep.globalDatas.getAddress_id());

		addBody(delete);

	}
	/**
	 * @author Senthil
	 * @see this method is used to add deleteAddress endpoint
	 * @param string
	 * @since 02-06-2023
	 */

	@When("User send {string} request for deleteAddress endpoint")
	public void user_send_request_for_delete_address_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.DELETEADDRESS);

	}
	
	/**
	 * @author Senthil
	 * @see this method is used to verify delete address response message
	 * @param string
	 * @since 02-06-2023
	 */

	@Then("User Should verify the deleteUserAddress  response message matches {string}")
	public void user_should_verify_the_delete_user_address_response_message_matches(String expMessage) {
		DeleteAddress_Output_Pojo output = response.as(DeleteAddress_Output_Pojo.class);
		String message = output.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, expMessage, "Address deleted successfully");
	}

}
