package com.ignite.tweetsvc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.social.twitter", ignoreUnknownFields = false)
@Component
public class TwitterAppConfigProperties {

	private String appId;
    private String appSecret;
    private String accessToken;
    private String accessTokenSecret;
}
