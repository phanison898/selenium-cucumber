package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:features" }, glue = { "classpath:com.stepDefinitions",
		"classpath:com.hooks" }, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@SmokeTests")
public class LoginRunner extends AbstractTestNGCucumberTests {

}
