package com.ignite.tweetsvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ignite.tweetsvc.service.TwitterStreamSubscribeService;

@SpringBootApplication
public class IgniteProducerApplication implements CommandLineRunner{

	private TwitterStreamSubscribeService twitterStreamSubscribeService;
	
	public IgniteProducerApplication(TwitterStreamSubscribeService twitterStreamSubscribeService) {
		this.twitterStreamSubscribeService = twitterStreamSubscribeService;
	}
	public static void main(String[] args) {
		SpringApplication.run(IgniteProducerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		twitterStreamSubscribeService.stream();
	}
}
