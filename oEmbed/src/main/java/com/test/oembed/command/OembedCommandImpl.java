package com.test.oembed.command;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.oembed.util.UrlCtrl;

public class OembedCommandImpl implements OembedCommand{
	
	@Autowired
	private UrlCtrl urlCtrl;
	
	
	
	@Override
	public JSONObject execute(String url) {
		
		// Step1. URL Validation & get providerURL
		String providerURL = urlCtrl.urlValid(url);
		
		if (providerURL.isEmpty() == false) {
			// Step2. oembed url setting
			
		}
		
		
		return null;
	}

}
