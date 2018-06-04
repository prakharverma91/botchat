package com.chtbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatBot {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatBot.class);

	public static void main(String[] args) {

		LOGGER.debug("starting Starin application");

		
		SpringApplication.run(ChatBot.class, args);
	}
}
