package com.test.oembed;

import java.util.Locale;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.oembed.command.OembedCommand;
import com.test.oembed.command.OembedCommandImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("home in >>> ");
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="embed", produces="application/json")
	public JSONObject embed(String url) {
		logger.info("embed in(" + url + ") >>> ");
		
		OembedCommand oc = new OembedCommandImpl();
		
		JSONObject oembed = oc.execute(url);
		
		return oembed;
	}
	
}
