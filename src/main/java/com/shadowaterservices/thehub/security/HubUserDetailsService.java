package com.shadowaterservices.thehub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shadowaterservices.thehub.data.entities.HubUser;
import com.shadowaterservices.thehub.data.repositories.HubUserRepository;

@Component
public class HubUserDetailsService implements UserDetailsService {
	private final HubUserRepository hubUserRepository;

	@Autowired
	HubUserDetailsService(HubUserRepository hubUserRepository) {
		this.hubUserRepository = hubUserRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		HubUser hubUser = hubUserRepository.findByUsername(username);
		return new User(hubUser.getUsername(), hubUser.getPassword(),
				AuthorityUtils.createAuthorityList(hubUser.getRoles()));
	}}
