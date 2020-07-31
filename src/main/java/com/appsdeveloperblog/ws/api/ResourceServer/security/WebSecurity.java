package com.appsdeveloperblog.ws.api.ResourceServer.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	 
		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.oauth2ResourceServer()
			.jwt();
	}
	
}
