package com.step;

import org.testng.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;
/**
 * 
 * @author Senthil
 * @see purpose of this class is used to verify common steps for this project
 * @since 02-06-2023
 *
 */

public class CommonStep extends BaseClass {
	/**
	 * @author Senthil
	 * @see purpose fo this method is used to verify Status code 
	 * @param expStatusCode
	 * @since 02-06-2023
	 */

	@Then("User Should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int expStatusCode) {

		int actStatuscode = TC1_LoginStep.globalDatas.setStatuscode(expStatusCode);
		Assert.assertEquals(expStatusCode, actStatuscode, "Verify Status Code");

	}
}