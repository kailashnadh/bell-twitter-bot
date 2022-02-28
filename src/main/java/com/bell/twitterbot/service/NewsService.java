package com.bell.twitterbot.service;

import org.springframework.stereotype.Component;

@Component
public interface NewsService {
	
	public String getNewsArticleURL(String topic);
	
}
