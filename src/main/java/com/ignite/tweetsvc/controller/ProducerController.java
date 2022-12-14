package com.ignite.tweetsvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.tweetsvc.model.TweetSpecifics;
import com.ignite.tweetsvc.service.ITwitterProducerUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "ignite", produces = "application/json")
@CrossOrigin
@Slf4j
public class ProducerController {

	ITwitterProducerUtil iTwitterStreamSubscribeService;
	
	@GetMapping("/getHashTags")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public TweetSpecifics getHashtagRelatedTweets() {
		return iTwitterStreamSubscribeService.readSpecifics();
	}
}
