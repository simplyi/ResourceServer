package com.appsdeveloperblog.photoapp.orders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class JwtRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		@SuppressWarnings("unchecked")
		List<String> roles = (ArrayList<String>) jwt.getClaims().get("roles");

		if (roles == null || roles.isEmpty()) {
			return new ArrayList<>();
		}

		Collection<GrantedAuthority> returnValue = roles.stream().map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		return returnValue;
	}

}
