package com.browsers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.config.JsonConfig;

public interface Driver<T> {

	T options(); // driver options

	WebDriver driver(); // actual driver creation

	default WebDriver init() { // driver initialization

		JsonConfig config = new JsonConfig();

		WebDriver driver = driver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(config.getPageLoadTime()));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitTime()));

		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(config.getScriptLoadTime()));

		return driver;
	}
}