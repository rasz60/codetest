package com.test.oembed.service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.oembed.controller.HomeController;
import com.test.oembed.dto.UrlDto;
import com.test.oembed.util.JsonConverter;
import com.test.oembed.util.UrlCtrl;

@Service
public class OembedServiceImpl implements OembedService {

	private static final Logger logger = LoggerFactory.getLogger(OembedServiceImpl.class);
	
	@Autowired
	private UrlCtrl urlCtrl;
	
	@Autowired
	private JsonConverter jsonConverter;
	
	@Override
	public JSONObject execute(String url) {
		logger.info("execute in ({}) >>>" , url);
		
		// Step1. URL Validation & get providerURL
		String providerURL = urlCtrl.urlValid(url);
		logger.info("execute result 1 : providerURL = {}" , providerURL);
		
		
		// oEmbed info json object
		JSONObject jsonResult = new JSONObject();
		
		// case 1 : provdierURL == null
		if (providerURL == null) {
			jsonResult.put("provider_name", "wrongURL");
			jsonResult.put("result", "잘못된 url이거나, oEmbed 정보를 제공하지 않는 사이트입니다.");
			
		}
		
		// case 2 : providerURL == www.instagram.com
		else if ( providerURL.equals("www.instagram.com") ) {
			jsonResult.put("provider_name", "instagram");
			jsonResult.put("result", "2021년 07월부로 인스타그램 oEmbed 제공이 중단되었습니다.");
		} 
		
		// case 3 : providerURL != null && providerURL != www.instagram.com
		else {
		
			// oEmbed url setting
			String embedUrl = new UrlDto(providerURL).getOembedUrl() + url;
			
			logger.info("execute result 2-1 : embedUrl = {}" , embedUrl);
			
			// get oembed info(json)
			if ( embedUrl != null ) {
				try {
					HttpResponse httpResponse = HttpClientBuilder.create().build().execute(new HttpGet(embedUrl));
					jsonResult = jsonConverter.jsonConvert(httpResponse);
				} 
				
				// exceptions
				catch (ClientProtocolException e) {
					e.printStackTrace();
					
					logger.info("execute result 2-2 : throw ClientProtocolException");
				
				} 
				
				catch (IOException e) {
					e.printStackTrace();
					
					logger.info("execute result 2-3 : throw IOException");
				}
			}
		}
		
		logger.info("execute result 3 : provider_name = {}" , jsonResult.get("provider_name"));
		
		return jsonResult;
		
	}

}
