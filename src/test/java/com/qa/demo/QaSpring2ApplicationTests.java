package com.qa.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.qa.repos.TrainerRepo;
import com.qa.runner.QaSpring2Application;

@SpringBootTest(classes = QaSpring2Application.class)
@ActiveProfiles("test")
@Sql(scripts = { "classpath:demo-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
class QaSpring2ApplicationTests {

	@Autowired
	TrainerRepo repo;

	@Test
	void repoDemo() {
		System.out.println(repo.findAll());
	}

	@Test
	void repoDemo2() {
		System.out.println(repo.findAll());
	}

}
