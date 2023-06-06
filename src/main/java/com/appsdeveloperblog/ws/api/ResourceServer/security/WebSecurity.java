package com.appsdeveloperblog.ws.api.ResourceServer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled=true, prePostEnabled=true)
@EnableWebSecurity // Will also work if we simply annotate this with @Configuration annotation
public class WebSecurity {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
//		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
//	 
		http
			.authorizeHttpRequests()
					.requestMatchers(HttpMethod.GET, "/users/status/check") 
					.hasAuthority("SCOPE_profile")
					//.hasRole("developer")
					//.hasAnyAuthority("ROLE_developer")
					//.hasAnyRole("devleoper","user")
				.anyRequest().authenticated()
				.and()
			.oauth2ResourceServer()
			.jwt();
			//.jwtAuthenticationConverter(jwtAuthenticationConverter);
		
		return http.build();
	}
	
}
