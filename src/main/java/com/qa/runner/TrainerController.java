package com.qa.runner;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/Trainer")
public class TrainerController {

	@Autowired
	TrainerService service;

	@RequestMapping("/test")
	public String HelloWorld() {
		return "Hello World!";
	}

	@GetMapping("/getAll")
	public List<Trainer> getAll() {
		return service.getAll();
	}

	@GetMapping("/getOne/{index}")
	public Trainer getOne(@PathVariable("index") Long index) {
		return service.getOne(index);
	}

	@GetMapping("/getOneByParam")
	public Trainer getOneByParam(@PathParam("index") Long index) {
		if (index != null) {
			return service.getOne(index);
		}
		return null;
	}

	@PostMapping("/create")
	public Trainer create(@RequestBody Trainer trainer) {
		return service.create(trainer);
	}

//	@PutMapping("/update/{index}")
//	public Trainer update(@RequestBody Trainer trainer, @PathVariable("index") int index) {
//		if (index >= 0 && index < trainers.size()) {
//			return trainers.set(index, trainer);
//		}
//		return null;
//	}

	@DeleteMapping("/delete/{index}")
	public Boolean deleteOne(@PathVariable("index") Long index) {
		return service.delete(index);
	}

}
