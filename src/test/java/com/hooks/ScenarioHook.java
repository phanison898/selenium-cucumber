package com.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.Base;
import com.browsers.ChromeBrowser;
import com.browsers.EdgeBrowser;
import com.browsers.FirefoxBrowser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ScenarioHook extends Base {

	WebDriver driver;

	@Before
	public void setup(Scenario s) {

		String browser = Config.getBrowser();

		switch (browser.toLowerCase()) {

		case "chrome":
			ChromeBrowser cb = new ChromeBrowser();
			setDriver(cb.init());
			break;

		case "firefox":
			FirefoxBrowser fb = new FirefoxBrowser();
			setDriver(fb.init());
			break;

		case "edge":
			EdgeBrowser eb = new EdgeBrowser();
			setDriver(eb.init());
			break;

		}
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {

			byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshot, "image/png", "screenshot");

		}

		getDriver().close();
		getDriver().quit();
	}
}
