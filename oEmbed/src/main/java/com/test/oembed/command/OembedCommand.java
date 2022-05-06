package com.test.oembed.command;

import org.json.simple.JSONObject;

public interface OembedCommand {
	
	public JSONObject execute(String url);
}
