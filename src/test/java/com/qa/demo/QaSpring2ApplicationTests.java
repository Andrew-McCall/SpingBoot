package com.qa.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.models.Trainer;
import com.qa.models.TrainerDTO;
import com.qa.runner.QaSpring2Application;

@SpringBootTest(classes = QaSpring2Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = { "classpath:demo-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
class QaSpring2ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	private final List<Trainer> DB_DATA = new ArrayList<Trainer>(Arrays
			.asList(new Trainer(1L, "Andrew", "amccall@qa.com", 20), new Trainer(1L, "Andrew", "amccall@qa.com", 20)));

	private final List<TrainerDTO> RESPONSE_DATA = new ArrayList<TrainerDTO>(
			Arrays.asList(new TrainerDTO(DB_DATA.get(0)), new TrainerDTO(DB_DATA.get(1))));

	@Test
	public void testGetAll() throws IllegalStateException, UnsupportedEncodingException, Exception {
		String result = mockMvc.perform(get("/trainer/getAll")).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		assertThat(result).isEqualTo(mapper.writeValueAsString(RESPONSE_DATA));
	}

	@Test
	public void testCreate() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		Trainer test = DB_DATA.get(0);
		test.setId(null);

		String result = mockMvc
				.perform(post("/trainer/create").contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(test)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		test.setId(3L);
		assertThat(result).isEqualTo(mapper.writeValueAsString(test));
	}

}
