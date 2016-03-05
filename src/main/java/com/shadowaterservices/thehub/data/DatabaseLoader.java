package com.shadowaterservices.thehub.data;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.shadowaterservices.thehub.data.entities.HubUser;
import com.shadowaterservices.thehub.data.entities.Post;
import com.shadowaterservices.thehub.data.repositories.HubUserRepository;
import com.shadowaterservices.thehub.data.repositories.PostRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final HubUserRepository userRepository;
	private final PostRepository postRepository;
	
	@Value("${user.default.password}")
	private String defaultPassword;

	@Autowired
	public DatabaseLoader(HubUserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		if (userRepository.count() == 0) {
			this.userRepository.save(new HubUser("admin", this.defaultPassword, "J","S","ROLE_ADMIN"));
		}

		if (postRepository.count() == 0) {
			postRepository.save(new Post("This Is A Title","This is a body for the greatest blog post of all time. Since Tuesday.","http://google.com",Calendar.getInstance()));
		}
	}
}