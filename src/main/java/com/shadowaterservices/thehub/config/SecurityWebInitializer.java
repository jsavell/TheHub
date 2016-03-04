package com.shadowaterservices.thehub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@EnableWebSecurity
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().httpBasic();
	}
}
