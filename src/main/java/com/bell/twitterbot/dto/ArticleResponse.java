package com.bell.twitterbot.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleResponse {

	private String status;
	
    private int totalResults;
    
    private List<Article> articles;

}
