package com.pages;

import org.openqa.selenium.By;

import com.utilities.WebActions;

public class SpringPage extends WebActions {

	By content = By.xpath("//body[text()='hello world!']");

	public String getSpringContent() {
		return getText(content);
	}

}
