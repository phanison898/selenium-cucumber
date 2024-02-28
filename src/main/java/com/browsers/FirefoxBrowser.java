package com.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.base.Base;

public class FirefoxBrowser extends Base implements Driver<FirefoxOptions> {

	@Override
	public FirefoxOptions options() {
		FirefoxOptions options = new FirefoxOptions();

		for (String option : Config.getDriverOptions()) {
			options.addArguments(option);
		}

		return options;
	}

	@Override
	public WebDriver driver() {
		return new FirefoxDriver(options());
	}

}
