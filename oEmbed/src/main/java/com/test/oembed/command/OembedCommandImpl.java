package com.test.oembed.command;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.oembed.util.JsonConverter;
import com.test.oembed.util.UrlCtrl;

@Service
public class OembedCommandImpl implements OembedCommand{
	
	private String[] providers = {"www.youtube.com", "www.instagram.com", "twitter.com", "vimeo.com"};
	private String[] embedUrls = {"https://www.youtube.com/oembed?url=",
								  "https://api.instagram.com/oembed?url=",
								  "https://publish.twitter.com/oembed?url=",
								  "https://vimeo.com/api/oembed.json?url="
								};
	@Autowired
	private UrlCtrl urlCtrl;
	
	@Autowired
	private JsonConverter jsonConverter;
	
	
	
	@Override
	public JSONObject execute(String url) {
		
		// Step1. URL Validation & get providerURL
		String providerURL = urlCtrl.urlValid(url);
		String embedUrl = null;
		JSONObject jsonResult = null;
		
		if (providerURL.isEmpty() == false) {
			// Step2. oembed url setting
			for ( int i = 0; i < providers.length; i++ ) {
				
				if ( providers[i].equals(providerURL) ) {
					embedUrl = embedUrls[i] + url;
					break;
				}
			}
			
			if ( embedUrl.isEmpty() == false ) {
				try {
					HttpResponse httpResponse = HttpClientBuilder.create().build().execute(new HttpGet(embedUrl));
					jsonResult = jsonConverter.jsonConvert(httpResponse);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return jsonResult;
		
	}

}
