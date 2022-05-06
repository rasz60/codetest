package com.test.oembed.util;

import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

@Component
public class UrlCtrl {
	
	private UrlValidator urlVali;
	
	public String urlValid(String url) {
		// 유효한 url인지 check
		boolean check = urlVali.isValid(url);
		
		String providerURL = null;
		
		// 유효할 경우 해당 공급자의 기본 url을 providerURL로 지정
		if ( check == true ) {
			try {
				providerURL = new URL(url).getHost();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// providerURL이 비어있지 않을 경우
		if (providerURL.isEmpty() == false) {
			// HttpServletResponse Header에 값 설정 (front에서 구분을 위함 ??? )
			HttpServletResponse httpServletResponse = null;
			httpServletResponse.addHeader("provider", providerURL);
			httpServletResponse.addHeader("Access-Control-Expose-Headers", "*");
		}
				
		return providerURL;
	}
	
	
}