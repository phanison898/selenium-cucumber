package com.hooks;

import com.base.Base;
import com.config.Environment;
import com.config.JsonConfig;
import com.custom.exceptions.ExpectKnownException;
import com.custom.exceptions.InvalidMavenArgumentException;
import com.custom.exceptions.NoSuchBrowserException;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class AllHook {

	@BeforeAll
	public static void before_all() {

		System.out.println("--------------------------- Before All Hook ---------------------------");

		// Initializing config file
		Base.Config = new JsonConfig();

		// Initializing environments
		Base.Env = new Environment();

		// Checks valid browser name is passed or not
		try {
			ExpectKnownException.selectBrowser(Base.Config.getBrowser());
		} catch (NoSuchBrowserException e) {
			System.err.println("[ERROR] " + e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}

		// Checks valid headless mode is passed or not from cmd
		try {
			ExpectKnownException.selectCMDHeadlessMode();
		} catch (InvalidMavenArgumentException e) {
			System.err.println("[ERROR] " + e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}

	}

	@AfterAll
	public static void after_all() {

		System.out.println("--------------------------- After All Hook ---------------------------");

	}

}
