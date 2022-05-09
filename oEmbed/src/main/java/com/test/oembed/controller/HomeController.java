package com.test.oembed.controller;

import java.util.Locale;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.oembed.service.OembedService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private OembedService oembeServiceImpl;
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("home in >>> ");
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="embed", produces="application/json")
	public JSONObject embed(String url) {
		logger.info("embed in(" + url + ") >>> ");
		
		// OembedServiceImpl 클래스로 url 전달 
		JSONObject oembed = oembeServiceImpl.execute(url);
		
		logger.info("embed result : {}", oembed.get("provider_name"));
		
		return oembed;
	}
	
}
