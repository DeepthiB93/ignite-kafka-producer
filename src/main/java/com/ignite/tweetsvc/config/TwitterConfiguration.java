package com.ignite.tweetsvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class TwitterConfiguration {

	private final TwitterAppConfigProperties appConfigProps;
	
	@Autowired
	TwitterConfiguration(TwitterAppConfigProperties appConfigProps) {
		this.appConfigProps = appConfigProps;
	}
	
	@Bean
    public TwitterTemplate twitterTemplate() {
    
        return new TwitterTemplate(
        		appConfigProps.getAppId(),
        		appConfigProps.getAppSecret(),
        		appConfigProps.getAccessToken(),
        		appConfigProps.getAccessTokenSecret()
        );
    }
}
