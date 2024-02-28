package com.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;

public class WebActions extends Base {

	private long EXPLICIT_WAIT = Config.getExplicitTime();

	public WebElement wait(By byLocator) {

		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_WAIT));

		try {

			element = wait.until(ExpectedConditions.elementToBeClickable(byLocator));

		} catch (Exception e) {

		}

		return element;
	}

	public WebElement getElement(By byLocator) {

		return wait(byLocator);
	}

	public void click(By byLocator) {
		getElement(byLocator).click();
	}

	public void sendkeys(By byLocator, String text) {
		WebElement e = getElement(byLocator);
		e.clear();
		e.sendKeys(text);
	}

	public String getText(By byLocator) {
		return getElement(byLocator).getText().toString().trim();
	}

	public String getAttribute(By byLocator, String attribute) {
		return getElement(byLocator).getAttribute(attribute).toString().trim();
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isDisplayed(By byLocator) {
		return getElement(byLocator).isDisplayed();
	}

	public boolean isEnabled(By byLocator) {
		return getElement(byLocator).isEnabled();
	}

}
