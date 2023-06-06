package com.step;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;

import com.pojo.product.SearchProduct_Input_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author Senthil
 * @see purpose of this class is to perform searchproductpage in this project
 * @since 02-06-2023
 *
 */

public class TC5_SearchProductStep extends BaseClass {
	Response response;

	/**
	 * @author Senthil
	 * @see this method is used to add headers for searchproduct
	 * @since 02-06-2023
	 */

	@Given("User add headders for SearchProduct")
	public void user_add_headders_for_search_product() {
		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers head = new Headers(listHeader);
		addHeaders(head);

	}

	/**
	 * @author Senthil
	 * @see this method is used add searchproduct request body
	 * @param productName
	 *            (String)
	 * @since 02-06-2023
	 */

	@When("User add request body for SearchProduct {string}")
	public void user_add_request_body_for_search_product(String productName) {
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo(productName);
		addBody(searchProduct_Input_Pojo);

	}

	/**
	 * @author Senthil
	 * @see this method is used to send searchproduct endpoint
	 * @param reqType
	 *            (String)
	 * @since 02-06-2023
	 */

	@When("User send {string} request for SearchProduct endpoint")
	public void user_send_request_for_search_product_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.SEARCHPRODUCT);
		int statusCode = getStateusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status code");

	}

	/**
	 * @author Senthil
	 * @see this method is use to verify search product response messgae
	 * @param messgae
	 *            (String)
	 * @since 02-06-2023
	 */

	@Then("User Should verify SearchProduct response message matches {string}")
	public void user_should_verify_search_product_response_message_matches(String messgae) {
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		String message = searchProduct_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "OK", "Verify Search product endpoint");

	}

}
