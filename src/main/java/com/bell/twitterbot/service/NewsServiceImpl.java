package com.bell.twitterbot.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bell.twitterbot.client.NewsAPIClient;
import com.bell.twitterbot.dto.ArticleResponse;

@Service
public class NewsServiceImpl implements NewsService {
	
	private static final String language = "en";
	private static final String sortBy = "relevancy";	
	private static final Logger logger = Logger.getLogger(NewsServiceImpl.class);
	
	@Autowired
	private NewsAPIClient client;
	
	public String getNewsArticleURL(String topic) {
        ArticleResponse response = client.getNewsArticles(topic, language, sortBy);
        String newsUrl = response.getArticles().get(0).getUrl();
        logger.info(String.format("News url for topic {0} is {1}", topic, newsUrl));
        return newsUrl;
    }
}
