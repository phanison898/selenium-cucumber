package com.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.base.Base;

public class EdgeBrowser extends Base implements Driver<EdgeOptions> {

	@Override
	public EdgeOptions options() {

		EdgeOptions options = new EdgeOptions();

		for (String option : Config.getDriverOptions()) {
			options.addArguments(option);
		}

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		return options;
	}

	@Override
	public WebDriver driver() {
		return new EdgeDriver(options());
	}

}
