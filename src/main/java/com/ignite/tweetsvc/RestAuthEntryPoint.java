package com.ignite.tweetsvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RestAuthEntryPoint extends BasicAuthenticationEntryPoint {

	public RestAuthEntryPoint() {
		super.setRealmName("ignite");
	}
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		// If accessing via web browser display login pop-up
		response.addHeader("WWW-Authenticate", "Basic");
		log.warn("Access denied. User did not provide correct credentials to access");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Please provide credentials to access this resource");
	}
}
