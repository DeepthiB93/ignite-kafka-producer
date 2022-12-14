package com.ignite.tweetsvc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ignite.tweetsvc.model.TweetSpecifics;
import com.ignite.tweetsvc.service.ITwitterProducerUtil;


public class TwitterProducerUtil implements ITwitterProducerUtil{
	private static final Pattern HASHTAG_MATCHER = Pattern.compile("#\\w+");

	TwitterProducerUtil(){}
	
	public TweetSpecifics readSpecifics() {
		ObjectMapper mapper = new ObjectMapper();
		InputStream inputStream = TweetSpecifics.class.getResourceAsStream("/TweetSpecifics.json");
		try {
			TweetSpecifics tweetHashTagsList = mapper.readValue(inputStream, TweetSpecifics.class);
			return tweetHashTagsList;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to read the tweet specific resource file");
		}
	}
	
	
	public Set<String> getHashTagListFromTweet(String tweetMsg) {
		Set<String> hashTags = new HashSet();
		Matcher matcher =  HASHTAG_MATCHER.matcher(tweetMsg);
		while (matcher.find()) {
            String handle = matcher.group();
            hashTags.add(handle.substring(1));
        }
        return hashTags;
	}

}
