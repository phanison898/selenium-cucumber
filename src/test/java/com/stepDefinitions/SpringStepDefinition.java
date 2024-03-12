package com.stepDefinitions;

import org.testng.Assert;

import com.pages.SpringPage;
import com.utilities.WebActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SpringStepDefinition extends WebActions {
	SpringPage ssd = null;

	@Given("user opens spring boot website")
	public void open_spring_url() {
		ssd = new SpringPage();
		getDriver().get(Config.getURL());
	}

	@Then("page content should be {string}")
	public void check_title(String title) {
		Assert.assertTrue(ssd.getSpringContent().equalsIgnoreCase(title), "Content not matched");
	}

}
