package com.hooks;

import com.base.Base;
import com.config.Environment;
import com.config.JsonConfig;

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

	}

	@AfterAll
	public static void after_all() {

		System.out.println("--------------------------- After All Hook ---------------------------");

	}

}
