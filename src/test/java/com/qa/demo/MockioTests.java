package com.qa.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.models.Trainer;
import com.qa.models.TrainerDTO;
import com.qa.repos.TrainerRepo;
import com.qa.runner.QaSpring2Application;
import com.qa.services.TrainerService;

@SpringBootTest(classes = QaSpring2Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class MockioTests {

	@Autowired
	private TrainerService service;

	@MockBean
	private TrainerRepo repo;

	@Test
	public void serviceGetAll() {

		List<Trainer> testInput = new ArrayList<Trainer>();
		testInput.add(new Trainer(1L, "andrew", "amccall@qa.com", 20));

		List<TrainerDTO> testOutput = new ArrayList<TrainerDTO>();
		testOutput.add(new TrainerDTO(testInput.get(0)));

		Mockito.when(repo.findAll()).thenReturn(testInput);

		List<TrainerDTO> result = service.getAll();

		assertThat(result).isEqualTo(testOutput);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	public void testUpdate() {

		Trainer input = new Trainer(2L, "andrew", "andrew@qa.com", 20);

		Mockito.when(repo.findById(input.getId())).thenReturn(Optional.ofNullable(input));
		Mockito.when(repo.save(input)).thenReturn(input);

		Trainer output = service.update(input.getId(), input);

		assertThat(output).isEqualTo(input);

		Mockito.verify(repo, Mockito.times(1)).findById(input.getId());
		Mockito.verify(repo, Mockito.times(1)).save(input);

	}
}
