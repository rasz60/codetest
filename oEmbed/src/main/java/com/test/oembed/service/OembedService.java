package com.test.oembed.service;

import org.json.simple.JSONObject;

public interface OembedService {
	
	public JSONObject execute(String url);
}
