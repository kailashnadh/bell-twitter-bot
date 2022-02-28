package com.bell.twitterbot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bell.twitterbot.dto.ArticleResponse;

@FeignClient(name = "news-api", url = "${news_api_url}")
public interface NewsAPIClient {
	
	 // For fetching news articles. refer https://newsapi.org/docs
	 @RequestMapping(method = RequestMethod.GET)
	 public ArticleResponse getNewsArticles(@RequestParam("q") String q,
	                       @RequestParam("language") String language,
	                       @RequestParam("sortBy") String sortBy);
	
}
