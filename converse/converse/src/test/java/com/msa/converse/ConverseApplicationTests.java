package com.msa.converse;

import com.msa.converse.controller.CommentController;
import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverseApplicationTests {

	@Autowired
	private CommentController commentController;

	@Test
	public void contextLoads() {
		assertThat(commentController).isNotNull();
	}

}
