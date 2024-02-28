package com.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonConfig extends Paths {

	private JsonObject jo;

	private JsonObject timeoutsJO;

	public JsonConfig() {

		Gson gson = new Gson();

		FileReader fr = null;

		try {
			fr = new FileReader(JSON_CONFIG_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		jo = gson.fromJson(fr, JsonObject.class);

		timeoutsJO = jo.get("time_outs").getAsJsonObject();

	}

	public String getBrowser() {
		return jo.get("browser").getAsString();
	}

	public String getURL() {
		return jo.get("url").getAsString();
	}

	public boolean getHeadLessMode() {
		return jo.get("headless").getAsBoolean();
	}

	public long getPageLoadTime() {
		return (long) timeoutsJO.get("page_load").getAsInt();
	}

	public long getImplicitTime() {
		return (long) timeoutsJO.get("implicit").getAsInt();
	}

	public long getExplicitTime() {
		return (long) timeoutsJO.get("explicit").getAsInt();
	}

	public long getScriptLoadTime() {
		return (long) timeoutsJO.get("script_load").getAsInt();
	}

	public List<String> getDriverOptions() {
		
		List<String> list = new ArrayList<String>();
		
		JsonArray ja = jo.get("driver_options").getAsJsonArray();
		
		for (JsonElement e : ja) {
			list.add(e.getAsString());
		}
		
		return list;
	}

}
