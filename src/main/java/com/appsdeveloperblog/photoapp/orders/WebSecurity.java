package com.appsdeveloperblog.photoapp.orders;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
 
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	public class WebSecurity extends WebSecurityConfigurerAdapter {

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
	    	jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new JwtRoleConverter());

	    	
	        http
	          .authorizeRequests(authz -> authz
	            //.antMatchers(HttpMethod.GET, "/test").hasAnyAuthority("ROLE_USER")
	            //.antMatchers(HttpMethod.GET, "/test").hasAnyAuthority("ROLE_user")
	            .anyRequest().authenticated())
	         // .oauth2ResourceServer(oauth2 -> oauth2.jwt())
	          .oauth2ResourceServer()
	          .jwt()
	          .jwtAuthenticationConverter(jwtAuthenticationConverter);
 
	      
		}
	}
	
//	private JwtAuthenticationConverter jwtAuthenticationConverter() {
//	    // create a custom JWT converter to map the "roles" from the token as granted authorities
//	    JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//	    jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
//	    jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
//	    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//	    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
//	    return jwtAuthenticationConverter;
//	  }

 
