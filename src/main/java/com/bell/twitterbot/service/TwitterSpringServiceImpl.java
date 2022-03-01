package com.bell.twitterbot.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.ApiException;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TweetData;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

@Component
public class TwitterSpringServiceImpl implements TwitterService{
	
	@Value("${twitter_api_key}")
	private String twitter_api_key;
	
	@Value("${twitter_api_key_secret}")
	private String twitter_api_key_secret;
	
	@Value("${twitter_bearer_token}")
	private String twitter_bearer_token;
	
	@Value("${twitter_access_token}")
	private String twitter_access_token;

	@Value("${twitter_access_token_secret}")
	private String twitter_access_token_secret;
	
	private static final Logger logger = Logger.getLogger(TwitterSpringServiceImpl.class);
	
	public void postTweetOnTopic(String topic, String url) {
		try {
			Twitter twitter = getTwitterInstance();
			if (twitter.isAuthorized()) {
				logger.info(String.format("Authorized"));
			} else {
				logger.info(String.format("Not Authorized"));
			}
			String profileId = twitter.userOperations().getScreenName();
			TweetData tweetData = new TweetData(topic+" "+url);
			//tweetData.withMedia(new FileUrlResource(url));
			List<Tweet> userTimeline = twitter.timelineOperations().getUserTimeline();
			twitter.timelineOperations().updateStatus(tweetData);

			logger.info(String.format("tweet completed with URL {0}", url));
		} 
//		catch (MalformedURLException e) {
//			logger.error(String.format("tweet failed in MalformedURLException with message "
//					+ " {0}", e.getMessage()));
//			System.out.println("Twitter Error in MalformedURLException"+e.getMessage());
//		} 
		catch (Exception e) {
			logger.error(String.format("tweet failed in Exception with message "
					+ " {0}", e.getMessage()));
			System.out.println("Twitter Error in Exception"+e.getMessage());
			throw new ApiException(topic,e.getMessage());
		}
	}
	
	private Twitter getTwitterInstance(){		
		Twitter twitter = new TwitterTemplate(twitter_api_key, twitter_api_key_secret, twitter_access_token, twitter_access_token_secret);
		return(twitter);
	}

}
