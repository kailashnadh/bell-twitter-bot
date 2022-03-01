package com.bell.twitterbot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bell.twitterbot.dto.PostNewsRequest;
import com.bell.twitterbot.dto.PostNewsResponse;
import com.bell.twitterbot.service.NewsService;
import com.bell.twitterbot.service.TwitterService;

@RestController
@RequestMapping("/api/twitter")
public class TwitterNewsController {
	
	@Autowired
	private TwitterService twitterService;

	@Autowired
	private NewsService newsService;

	private static final Logger logger = LoggerFactory.getLogger(TwitterNewsController.class);

	@PostMapping("/news")
	public ResponseEntity<PostNewsResponse> postNewsinTwitter(@RequestBody PostNewsRequest request) {
		logger.info("postNewsinTwitter triggered with topic {}", request.getTopic());
		if((null == request.getTopic()) || "".equals(request.getTopic())){
			logger.error("Topic not provided");
			return(new ResponseEntity("topic_not_provided", HttpStatus.BAD_REQUEST));
		}
		String newsUrl = newsService.getNewsArticleURL(request.getTopic());
		if(newsUrl.isEmpty()){
			return(new ResponseEntity("article_not_found", HttpStatus.NOT_FOUND));
		}
		try {
			twitterService.postTweetOnTopic(request.getTopic(), newsUrl);
			return new ResponseEntity<>(new PostNewsResponse(newsUrl), HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
