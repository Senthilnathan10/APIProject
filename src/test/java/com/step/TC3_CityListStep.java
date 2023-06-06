package com.step;

import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.login.CityList;
import com.pojo.login.CityList_Input_Pojo;
import com.pojo.login.CityList_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * @author Senthil
 * @see Purpose of this class is used to perform CityList page for this project
 * @since 02-06-2023
 */

public class TC3_CityListStep extends BaseClass {
	Response response;
	/**
	 * @author Senthil
	 * @see this method is used add headers for Statelist page
	 * @since 02-06-2023
	 */
	@Given("User add headders for citylist")
	public void user_add_headders_for_citylist() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}
	/**
	 * @author Senthil
	 * @see this method is used to add request body to get city Id
	 * @param stateId(String)
	 * @since 02-06-2023
	 */

	@When("User add request body to get cityid {string}")
	public void user_add_request_body_to_get_cityid(String stateId) {
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(TC1_LoginStep.globalDatas.getStateId());
		addBody(cityList_Input_Pojo);

	}
	/**
	 * @author Senthil
	 * @see this method is used to perform cityList endpoints
	 * @param reqType(String)
	 * @since 02-06-2023
	 */

	@When("User send {string} request for citylist endpoint")
	public void user_send_request_for_citylist_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.CITYLIST);
	
	}
	/**
	 * @author Senthil
	 * @see purpose of this method is used verify citylist response message
	 * @param expCityName ( String)
	 * @since 02-06-2023
	 */

	@Then("User Should verify citylist response message matches {string} and save city id")
	public void user_should_verify_citylist_response_message_matches_and_save_city_id(String expCityName) {
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);

		ArrayList<CityList> data = cityList_Output_Pojo.getData();
		for (CityList cityList : data) {
			String name = cityList.getName();
			if (name.equals("Yercaud")) {
				int cityIdNum = cityList.getId();
				String cityId = String.valueOf(cityIdNum);
				TC1_LoginStep.globalDatas.setCityId(cityId);
				System.out.println(cityIdNum);
				break;

			}

		}
	}

}
