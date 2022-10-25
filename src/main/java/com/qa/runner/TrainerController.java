package com.qa.runner;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TrainerController {

	// @Autowired - Bean else where
	List<Trainer> trainers = new ArrayList<Trainer>();

	@RequestMapping("/test")
	public String HelloWorld() {
		return "Hello World!";
	}

	@GetMapping("/getAll")
	public List<Trainer> getAll() {
		return trainers;
	}

	@GetMapping("/getOne/{index}")
	public Trainer getOne(@PathVariable("index") int index) {
		return trainers.get(index);
	}

	@GetMapping("/getOneByParam")
	public Trainer getOne(@PathParam("index") Integer index) {
		if (index != null) {
			return trainers.get(index);
		} else {
			return null;
		}
	}

	@PostMapping("/create")
	public int create(@RequestBody Trainer trainer) {
		if (trainers.add(trainer)) {
			return trainers.size() - 1;
		}
		return -1;
	}

}
