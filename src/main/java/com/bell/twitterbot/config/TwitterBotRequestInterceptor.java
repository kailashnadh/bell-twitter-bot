package com.bell.twitterbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class TwitterBotRequestInterceptor implements RequestInterceptor{
	
	@Value("${news_api_key}")
    private String newsApiKey; // will fetch new's api key from Applictaion.properties
    private static final String apiKeyHeader = "x-api-key";

	@Override
	public void apply(RequestTemplate requestTemplate) {
		requestTemplate.header(apiKeyHeader, newsApiKey);
        //required as Pexel expect requests from a browser
        requestTemplate.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 " +
            "(KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		
	}
	
}
