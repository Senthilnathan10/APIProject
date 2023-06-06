package com.step;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

/**
 * @author Senthil
 * @see purpose of this class is used get outputs in general format
 * @since 02-06-2023
 */

public class HooksClass extends BaseClass {
	static Scenario scenario;

	/**
	 * @author Senthil
	 * @param sc
	 * @since 02-06-2023
	 */

	@After
	public void afterScenario(Scenario sc) {
		scenario = sc;

		scenario.log(getResBodyAsPrettyString(response));

	}

}
