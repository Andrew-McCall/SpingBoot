package com.qa.runner;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TrainerController {

	@Autowired
	List<Trainer> trainers;

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

	@PutMapping("/update/{index}")
	public Trainer update(@RequestBody Trainer trainer, @PathVariable("index") int index) {
		if (index >= 0 && index < trainers.size()) {
			return trainers.set(index, trainer);
		}
		return null;
	}

	@DeleteMapping("/delete/{index}")
	public boolean deleteOne(@PathVariable("index") int index) {
		if (index >= 0 && index < trainers.size()) {
			return (trainers.remove(index) != null);
		}
		return false;
	}

}
