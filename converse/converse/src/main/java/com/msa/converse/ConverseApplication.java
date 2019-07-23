package com.msa.converse;

import com.msa.converse.exception.AppException;
import com.msa.converse.model.Comment;
import com.msa.converse.model.Role;
import com.msa.converse.model.RoleName;
import com.msa.converse.model.User;
import com.msa.converse.repository.CommentRepository;
import com.msa.converse.repository.UserRepository;
import com.msa.converse.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringBootApplication
public class ConverseApplication {

	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	@Qualifier("roleServicer")
	private RoleService roleService;
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ConverseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			User jason = new User("Jason", "jason@yahoo", passwordEncoder.encode("jasonpassword"));
			Role userRole = roleService.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new AppException("User Role not set."));
			jason.setRoles(Collections.singleton(userRole));
			userRepository.save(jason);
			User johnny = new User("Johnny", "johnny@gmail", passwordEncoder.encode("johnnypassword "));
			johnny.setRoles(Collections.singleton(userRole));
			userRepository.save(johnny);
			commentRepository.save(new Comment("Johnny", "What's the deal?", jason));
			commentRepository.save(new Comment("Jason", "I can't call it. Just maxing", johnny));
		};
	}

}
