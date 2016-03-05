package com.shadowaterservices.thehub.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shadowaterservices.thehub.data.entities.HubUser;
import com.shadowaterservices.thehub.data.repositories.HubUserRepository;

public class HubUserService implements UserDetailsService {
	private final HubUserRepository hubUserRepository;

	public HubUserService(HubUserRepository hubUserRepository) {
		this.hubUserRepository = hubUserRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		HubUser hubUser = hubUserRepository.findByUsername(username);
		if (hubUser != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return hubUser;
		}
		throw new UsernameNotFoundException("User '"+username+"' not found.");
	}
}
