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

import com.test.oembed.command.OembedCommand;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private OembedCommand oembedCommandImpl;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("home in >>> ");
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="embed", produces="application/json")
	public JSONObject embed(String url) {
		logger.info("embed in(" + url + ") >>> ");

		JSONObject oembed = oembedCommandImpl.execute(url);
		
		return oembed;
	}
	
}
