package com.ignite.tweetsvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import com.ignite.tweetsvc.config.KafkaProducer;
import com.ignite.tweetsvc.model.TweetInfo;
import com.ignite.tweetsvc.model.TweetSpecifics;
import com.ignite.tweetsvc.util.TwitterProducerUtil;

@Service
public class TwitterStreamSubscribeService{

	private KafkaProducer kafkaProducer;
	private TwitterProducerUtil twitterProducerUtil;
	
	@Autowired
	public TwitterStreamSubscribeService(KafkaProducer kafkaProducer,
			TwitterProducerUtil twitterProducerUtil) {
		this.kafkaProducer = kafkaProducer;
		this.twitterProducerUtil = twitterProducerUtil;
	}
	
	public void stream() {
        StreamListener streamListener = new StreamListener() {
            @Override
            public void onTweet(Tweet tweet) {
            	String tweetText = tweet.getText();
            	
            	//Get the list of Hash tags from the hard-coded resource file
            	TweetSpecifics definedHashTagList = twitterProducerUtil.readSpecifics();
            	
            	//Adding the hash tags to a list
            	List<String> definedList = new ArrayList<>();
            	for(TweetInfo tweetInfo : definedHashTagList.getTweetSpecifics()) {
            		definedList.add(tweetInfo.getHashTag());
            	}
            	
            	//Get the hash tag list from the tweet messages
            	Set<String> hashTagSet = twitterProducerUtil.getHashTagListFromTweet(tweetText);
            	
            	
            	for(String hashTag : hashTagSet) {
            		if(definedList.contains(hashTag)) {
            			kafkaProducer.send("TEST_TOPIC", tweet.getText());
            			break;
            		}
            	}
            }

			@Override
			public void onDelete(StreamDeleteEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onLimit(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onWarning(StreamWarningEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        };
	}
}
