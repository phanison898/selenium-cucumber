package com.base;

import org.openqa.selenium.WebDriver;

import com.config.Environment;
import com.config.JsonConfig;

public class Base {

	public static JsonConfig Config;

	public static Environment Env;

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // public static must

	public void setDriver(WebDriver _driver) {
		driver.set(_driver);
	}

	public WebDriver getDriver() {
		return driver.get();
	}

}
