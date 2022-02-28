package com.bell.twitterbot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
	
    private String author;
    
    private String title;
    
    private String description;
    
    private String url;
    
    private String urlToImage;
    
    private String publishedAt;
}
