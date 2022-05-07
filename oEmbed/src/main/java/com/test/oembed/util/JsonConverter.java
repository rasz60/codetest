package com.test.oembed.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
public class JsonConverter {

	private final JSONParser jsonParser;
	
	public JsonConverter() {
		this.jsonParser = new JSONParser();
	}
	
	public JSONObject jsonConvert(HttpResponse httpResponse) {
		JSONObject jsonResult = null;
		try {
			jsonResult = (JSONObject)jsonParser.parse(EntityUtils.toString(httpResponse.getEntity()));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
}
