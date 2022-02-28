package com.bell.twitterbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BellTwitterBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(BellTwitterBotApplication.class, args);
	}

}
