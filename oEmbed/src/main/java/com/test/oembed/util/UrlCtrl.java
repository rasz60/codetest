package com.test.oembed.util;

import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.oembed.service.OembedServiceImpl;

@Component
public class UrlCtrl {
	
	private static final Logger logger = LoggerFactory.getLogger(UrlCtrl.class);
	
	private UrlValidator urlVali;
	
	// object setting
	public UrlCtrl() {
		this.urlVali = new UrlValidator();
	}
	
	public String urlValid(String url) {
		logger.info("urlValid in ({}) >>> ", url);
		
		// url validation ( Use urlValidator object )
		boolean check = urlVali.isValid(url);
		logger.info("urlValid result 1 : url.isValid ? {}", check);
		
		
		String providerURL = null;
		
		// url validation == true
		if ( check == true ) {
			try {
				// get providerUrl
				providerURL = new URL(url).getHost();
			} 
			
			// exceptions
			catch (Exception e) {
				logger.info("urlValid result 1-f : Exception");
				
				e.printStackTrace();
			}
		}
		
		logger.info("urlValid result 2 : providerURL ? {}", providerURL);
		return providerURL;
	}
	
	
}