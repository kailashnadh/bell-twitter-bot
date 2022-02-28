package com.bell.twitterbot.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.ResourceNotFoundException;
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
	
	private static final Logger logger = Logger.getLogger(TwitterNewsController.class);

	@PostMapping("/news")
	public ResponseEntity<PostNewsResponse> postNewsinTwitter(@RequestBody PostNewsRequest request) {
		logger.info(String.format("postNewsinTwitter triggered with "
				+ "topic {0}", request.getTopic()));
		if((null == request.getTopic()) || "".equals(request.getTopic())){
			logger.error("Topic not provided");
			throw new ResourceNotFoundException(request.getTopic(),"Topic not provided"); 
		}
		String newsUrl = newsService.getNewsArticleURL(request.getTopic());
		if(newsUrl.isEmpty()){
			return(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}
		twitterService.postTweetOnTopic(request.getTopic(), newsUrl);
		return new ResponseEntity<>(new PostNewsResponse(newsUrl), HttpStatus.OK);
	}
}
