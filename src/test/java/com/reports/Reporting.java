package com.reports;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
/**
 * 
 * @author Senthil
 * @see purpose of this class is used generate JVM report for this project
 * @since 02-06-2023

 */
public class Reporting {
	public static void generateJvmReport(String JsonFile) {
		File file = new File("C:\\Users\\HP\\eclipse-workspace\\OMRBranchAPIAutomation\\target");
		Configuration configuration = new Configuration(file, "OmrBranch Login Page Automation");
		configuration.addClassifications("browser", "Chrome");
		configuration.addClassifications("browserVersion", "112.0.5615.139");
		configuration.addClassifications("OS", "Windows11");
		configuration.addClassifications("sprint", "23");
		
		List <String> jsonfiles = new ArrayList<String>();
		jsonfiles.add(JsonFile);
		ReportBuilder builder = new ReportBuilder(jsonfiles, configuration);
		builder.generateReports();

	}


		

	
	}


