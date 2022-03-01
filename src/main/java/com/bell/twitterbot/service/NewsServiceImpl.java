package com.bell.twitterbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bell.twitterbot.client.NewsAPIClient;
import com.bell.twitterbot.dto.ArticleResponse;

@Service
public class NewsServiceImpl implements NewsService {
	
	private static final String language = "en";
	private static final String sortBy = "relevancy";

	private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);
	
	@Autowired
	private NewsAPIClient client;
	
	public String getNewsArticleURL(String topic) {
		String newsUrl = "";
        ArticleResponse response = client.getNewsArticles(topic, language, sortBy);
		if(response.getArticles().size() > 0){
			newsUrl = response.getArticles().get(0).getUrl();
			logger.info("News Article is {}", newsUrl);
		}
        return newsUrl;
    }
}
