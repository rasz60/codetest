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
		logger.info("jsonConvert({})", httpResponse.getAllHeaders());
		
		JSONObject jsonResult = null;
		
		try {
			// HttpResponse convert to JSONObject
			jsonResult = (JSONObject)jsonParser.parse(EntityUtils.toString(httpResponse.getEntity()));
			
			logger.info("jsonConverter() result 1-t : {}", jsonResult.get("provider_name"));
			
		} catch (Exception e) {
			
			logger.info("jsonConverter() result 1-f : Exception");
			
			jsonResult.put("provider_name", "serverError");
			jsonResult.put("result", "서버 오류로 oEmbed 정보가 로드되지 못했습니다.");
			
			e.printStackTrace();
			
		} 
		
		return jsonResult;
	}
}
