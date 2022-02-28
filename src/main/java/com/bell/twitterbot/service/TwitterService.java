package com.bell.twitterbot.service;

import org.springframework.stereotype.Component;

@Component
public interface TwitterService {
	
	public void postTweetOnTopic(String topic, String url);

}
