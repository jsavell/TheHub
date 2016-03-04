package com.shadowaterservices.thehub.data;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.shadowaterservices.thehub.data.entities.Post;
import com.shadowaterservices.thehub.data.entities.HubUser;
import com.shadowaterservices.thehub.data.repositories.PostRepository;
import com.shadowaterservices.thehub.data.repositories.HubUserRepository;

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
		this.userRepository.save(new HubUser("Harry", "Hub"));
		this.postRepository.save(new Post("This Is A Title","This is a body for the greatest blog post of all time. Since Tuesday.","http://google.com",Calendar.getInstance()));
	}
}