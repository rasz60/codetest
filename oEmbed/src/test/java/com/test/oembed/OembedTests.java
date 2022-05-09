package com.test.oembed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.oembed.service.OembedService;
import com.test.oembed.service.OembedServiceImpl;
import com.test.oembed.util.JsonConverter;
import com.test.oembed.util.UrlCtrl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class OembedTests {
	@Autowired
	private OembedService oembedCommandImpl;
	
	@Test
	public void hostTest() {
		
		String url1 = "https://www.youtube.com/watch?v=dBD54EZIrZo";
		//String url2 = "https://www.instagram.com/p/BUawPlPF_Rx/";
		String url3 = "https://twitter.com/hellopolicy/status/867177144815804416";
		String url4 = "https://vimeo.com/20097015";
		
		System.out.println(oembedCommandImpl.execute(url1));
		//System.out.println(oembedCommandImpl.execute(url2));
		System.out.println(oembedCommandImpl.execute(url3));
		System.out.println(oembedCommandImpl.execute(url4));
		
	}
}
