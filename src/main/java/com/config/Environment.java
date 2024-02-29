package com.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Environment {

	private Dotenv env;

	public Environment() {

		try {
			env = Dotenv.load();
		} catch (Exception e) {
			env = null;
			System.out.println("[INFO] .env file not found. Reading system env variables..");
		}
	}

	public String getUsername() {
		return env != null ? env.get("_USERNAME") : System.getenv("_USERNAME");
	}

	public String getPassword() {
		return env != null ? env.get("_PASSWORD") : System.getenv("_PASSWORD");
	}

}
