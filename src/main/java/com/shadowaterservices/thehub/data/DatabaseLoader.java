package com.shadowaterservices.thehub.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.shadowaterservices.thehub.data.entities.HubUser;
import com.shadowaterservices.thehub.data.entities.Post;
import com.shadowaterservices.thehub.data.repositories.HubUserRepository;
import com.shadowaterservices.thehub.data.repositories.PostRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final HubUserRepository userRepository;
	private final PostRepository postRepository;

	@Autowired
	public DatabaseLoader(HubUserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		if (userRepository.count() == 0) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			userRepository.save(new HubUser("admin", "123456",authorities,"J","S"));
		}
		if (postRepository.count() == 0) {
			postRepository.save(new Post("This Is A Title","This is a body for the greatest blog post of all time. Since Tuesday.","http://google.com",Calendar.getInstance()));
		}
	}
}