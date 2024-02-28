package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:features" }, glue = { "classpath:com.stepDefinitions",
		"classpath:com.helpers" }, plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class LoginRunner extends AbstractTestNGCucumberTests {

}
