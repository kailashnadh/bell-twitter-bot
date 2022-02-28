package com.bell.twitterbot.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import java.util.List;

@Primary
@Component
public class TwitterLibraryServiceImpl implements TwitterService{

    private static final Logger logger = Logger.getLogger(TwitterSpringServiceImpl.class);

    public void postTweetOnTopic(String topic, String url) {
        try {
            Twitter twitter = getTwitterInstance();
            String screenName = twitter.getScreenName();
            twitter.updateStatus(topic+" "+url);
            logger.info(String.format("tweet completed with URL {0}", url));
        }
        catch (Exception e) {
            logger.error(String.format("tweet failed in Exception with message "
                    + " {0}", e.getMessage()));
            System.out.println("Twitter Error in Exception"+e.getMessage());
        }
    }

    private Twitter getTwitterInstance(){
        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
