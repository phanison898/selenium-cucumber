package com.browsers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.base.Base;

public class ChromeBrowser extends Base implements Driver<ChromeOptions> {

	@Override
	public ChromeOptions options() {

		ChromeOptions options = new ChromeOptions();

		for (String option : Config.getDriverOptions()) {
			options.addArguments(option);
		}

		if (Config.getHeadLessMode()) {
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
		}

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		return options;
	}

	@Override
	public WebDriver driver() {
		return new ChromeDriver(options());
	}
	
	public void browser() throws MalformedURLException {
		WebDriver rwd = new RemoteWebDriver(new URL(""), null);
	}

}
