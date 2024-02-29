package com.browsers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.base.Base;

public interface Driver<T> {

	T options(); // driver options

	WebDriver driver(); // actual driver creation

	default WebDriver init() { // driver initialization

		WebDriver driver = driver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Base.Config.getPageLoadTime()));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Base.Config.getImplicitTime()));

		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Base.Config.getScriptLoadTime()));

		return driver;
	}
}