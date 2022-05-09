package com.test.oembed.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonConverter {

	private static final Logger logger = LoggerFactory.getLogger(JsonConverter.class);
	
	private final JSONParser jsonParser;
	
	public JsonConverter() {
		this.jsonParser = new JSONParser();
	}
	
	public JSONObject jsonConvert(HttpResponse httpResponse) {
		logger.info("jsonConvert({})", httpResponse.getEntity());
		
		JSONObject jsonResult = null;
		
		try {
			jsonResult = (JSONObject)jsonParser.parse(EntityUtils.toString(httpResponse.getEntity()));
			
			logger.info("jsonConverter() result 1-t : {}", jsonResult.get("provider_name"));
		} catch (ParseException e) {
			
			logger.info("jsonConverter() result 1-f : ParseException");
			
			e.printStackTrace();
			
		} catch (org.json.simple.parser.ParseException e) {
			logger.info("jsonConverter() result 1-f : org.json.simple.parser.ParseException");
			
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("jsonConverter() result 1-f : IOException");
			
			e.printStackTrace();
		}
		
		return jsonResult;
	}
}
