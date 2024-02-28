package com.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Environment {

	private Dotenv env;

	public Environment() {
		env = Dotenv.load();
	}

	public String getUsername() {
		return env.get("_USERNAME");
	}

	public String getPassword() {
		return env.get("_PASSWORD");
	}

}
