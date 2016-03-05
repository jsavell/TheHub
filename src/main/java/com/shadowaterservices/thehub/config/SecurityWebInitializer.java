package com.shadowaterservices.thehub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.shadowaterservices.thehub.data.repositories.HubUserRepository;
import com.shadowaterservices.thehub.security.HubUserService;

@Configuration
@EnableWebSecurity
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
	@Autowired
	HubUserRepository hubUserRepository;
	
	protected void configure(HttpSecurity http, AuthenticationManagerBuilder auth) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().httpBasic();
		auth.userDetailsService(new HubUserService(hubUserRepository));
	}
}
