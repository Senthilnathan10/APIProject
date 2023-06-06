package com.step;

import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoints.EndPoints;
import com.pojo.login.StateList;
import com.pojo.login.StateList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
/**
 * 
 * @author Senthil
 * @see Purpose of this class is used to perform StateList page for this project
 * @since 02-06-2023
 *
 */

public class TC2_StateListStep extends BaseClass {
	Response response;
	
/**
 * @author Senthil
 * @see this method is used add header for Statelist page
 * @since 02-06-2023
 */
	@Given("User add headers for Statelist")
	public void user_add_headers_for_statelist() {
		addHeader("accept", "application/json");
	   
	}
	/**
	 * @author Senthil
	 * @see this method is used to peform statelist list end points
	 * @param reqType(String)
	 * @since 02-06-2023
	 */
	@When("User send {string} request for statelist endpoint")
	public void user_send_request_for_statelist_endpoint(String reqType) {
		response = addReqType(reqType, EndPoints.STATELIST);
		int statuscode = getStateusCode(response);
		TC1_LoginStep.globalDatas.setStatuscode(statuscode);
		System.out.println(statuscode);
	   
	}
	/**
	 * @author Senthil
	 * @see this metho is used to verify statelist response message
	 * @param expStateName (String)
	 * @since 02-06-2023
	 */
	@Then("User Should verify statelist response message matches {string} and save state id")
	public void user_should_verify_statelist_response_message_matches_and_save_state_id(String expStateName) {
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		
		ArrayList<StateList> data = stateList_Output_Pojo.getData();
		
		for (StateList stateList : data) {
			String name = stateList.getName();
			
			if (name.equals(expStateName)) {
				int stateIdNum = stateList.getId();
				String stateId = String.valueOf(stateIdNum);
				TC1_LoginStep.globalDatas.setStateId(stateId);
				System.out.println(stateIdNum);
				break;
				

			}
		}

	}
	    
	}



