package com.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.Base;
import com.browsers.ChromeBrowser;
import com.browsers.EdgeBrowser;
import com.browsers.FirefoxBrowser;
import com.custom.exceptions.NoSuchBrowserException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base {

	WebDriver driver;

	@Before
	public void setup(Scenario s) {
		
		try {
			selectBrowser();
		} catch (NoSuchBrowserException e) {
			e.printStackTrace();
		}

		getDriver().get(Config.getURL());

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

	private void selectBrowser() throws NoSuchBrowserException {

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

		default:

			String message = String.format(
					"Selected browser [ %s ] isn't available. Select any one of these browsers { 'chrome', 'firefox', 'edge' }",
					browser);
			throw new NoSuchBrowserException(message);

		}
	}

}
