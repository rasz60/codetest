package com.test.oembed.dto;

public class UrlDto {

	private String providerUrl;
	private String oembedUrl;
	
	public UrlDto(String url) {
		providerUrl = url;
		// providerUrl을 이용하여 oembedUrl setting
		setOembedUrl(url);
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	public String getOembedUrl() {
		return oembedUrl;
	}

	public void setOembedUrl(String url) {
		// provider url array
		String[] providers = {"www.youtube.com", "twitter.com", "vimeo.com"};
		
		// oembe url array
		String[] embedUrls = {"https://www.youtube.com/oembed?url=",
							  "https://publish.twitter.com/oembed?url=",
							  "https://vimeo.com/api/oembed.json?url="};
		
		// oembed url setting
		for ( int i = 0; i < providers.length; i++ ) {
			
			// 같은 index의 oembedUrl로 setting
			if ( providers[i].equals(url) ) {
				this.oembedUrl = embedUrls[i];
				break;
			} 
		}
		
	}
	
	
}
