package com.bell.twitterbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;


@Component
@Primary
public class TwitterLibraryServiceImpl implements TwitterService{

    private static final Logger logger = LoggerFactory.getLogger(TwitterLibraryServiceImpl.class);

    public void postTweetOnTopic(String topic, String url) {
        try {
            Twitter twitter = getTwitterInstance();
            String screenName = twitter.getScreenName();
            logger.info("Screen name of twitter profile is {}", screenName);
            twitter.updateStatus(topic+" "+url);
        }
        catch (Exception e) {
            logger.error("postTweetOnTopic failed - ", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private Twitter getTwitterInstance(){
        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
