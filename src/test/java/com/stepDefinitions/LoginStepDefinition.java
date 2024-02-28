package com.stepDefinitions;

import org.testng.Assert;

import com.pages.LoginPage;
import com.utilities.WebActions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends WebActions {

	LoginPage loginPage;

	@Given("user opens sauce demo website")
	public void user_opens_sauce_demo_website() {

		loginPage = new LoginPage();

		Assert.assertEquals(getDriver().getTitle(), "Swag Labs");
	}

	@When("user enters only username")
	public void user_enters_only_username() {
		loginPage.enterUsername(Env.getUsername());
	}

	@When("user enters only password")
	public void user_enters_only_password() {
		loginPage.enterPassword(Env.getPassword());
	}

	@When("user enters correct username and password")
	public void user_enters_username_and_password() {
		loginPage.enterUsername(Env.getUsername());
		loginPage.enterPassword(Env.getPassword());
	}

	@When("clicks login button")
	public void clicks_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("{string} warning should appear")
	public void warning_should_appear(String string) {
		String error = loginPage.getErrorMessage();
		Assert.assertTrue(error.contains(string), String.format(
				"The expected error message [ %s ] not contained in actual error message [ %s ]", string, error));
	}

	@Then("url should contains {string} string")
	public void url_should_contains_string(String string) {
		String url = getDriver().getCurrentUrl();
		Assert.assertTrue(url.contains(string),
				String.format("The expected url string [ %s ] not contained in actual url [ %s ]", string, url));
	}

}
