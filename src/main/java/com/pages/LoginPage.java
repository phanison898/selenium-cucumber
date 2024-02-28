package com.pages;

import org.openqa.selenium.By;

import com.utilities.WebActions;

public class LoginPage extends WebActions {

	By usernameIP = By.id("user-name");

	By passwordIP = By.id("password");

	By loginBTN = By.id("login-button");

	By errorMessageTXT = By.xpath("//h3[@data-test='error']");

	By errorCrossIcon = By.className("error-button");

	public void enterUsername(String username) {
		sendkeys(usernameIP, username);
	}

	public void enterPassword(String password) {
		sendkeys(passwordIP, password);
	}

	public void clickLoginButton() {
		click(loginBTN);
	}

	public boolean isErrorMessageDisplayed() {
		return isDisplayed(errorMessageTXT);
	}

	public String getErrorMessage() {
		return getText(errorMessageTXT);
	}

	public void clickErrorCrossIcon() {
		click(errorCrossIcon);
	}

}
