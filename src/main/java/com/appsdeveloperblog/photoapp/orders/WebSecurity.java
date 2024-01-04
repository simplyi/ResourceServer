package com.appsdeveloperblog.photoapp.orders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurity {

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new JwtRoleConverter());

		http.authorizeHttpRequests(authz -> authz
				// .antMatchers(HttpMethod.GET, "/test").hasAnyAuthority("ROLE_USER")
				// .antMatchers(HttpMethod.GET, "/test").hasAnyAuthority("ROLE_user")
				.anyRequest().authenticated())
				 .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)));
				//.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
		
		return http.build();
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

 
