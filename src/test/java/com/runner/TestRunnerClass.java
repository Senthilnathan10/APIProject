package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * @author Senthil
 * @see Purpose of this class is used to run all the class in the project
 * @since 02-06-2023
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
		"json:target\\output.json" }, tags = "@Login or @State or @City or @Address or @SearchProduct", monochrome = true, dryRun = false, stepNotifications = false, features = "src\\test\\resources", glue = "com.step")
public class TestRunnerClass {

	/**
	 * @author Senthil
	 * @see this method is used to perform to generate generate report
	 * @since 02-06-2023
	 */
	@AfterClass
	public static void afterclass() {
		String path = System.getProperty("user.dir");
		Reporting.generateJvmReport(path + "\\target\\output.json");

	}

}
