package com.msa.converse;

import com.msa.converse.model.Comment;
import com.msa.converse.model.User;
import com.msa.converse.repository.CommentRepository;
import com.msa.converse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConverseApplication {

	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ConverseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			User jason = new User("Jason", "jason@yahoo", "jasonpassword");
			userRepository.save(jason);
			User johnny = new User("Johnny", "johnny@gmail", "johnnypassword ");
			userRepository.save(johnny);
			commentRepository.save(new Comment("Johnny", "What's the deal?", jason));
			commentRepository.save(new Comment("Jason", "I can't call it. Just maxing", johnny));
		};
	}

}
