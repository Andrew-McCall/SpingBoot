package com.qa.controllers;

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

import com.qa.exceptions.TrainerNotFoundException;
import com.qa.models.Trainer;
import com.qa.models.TrainerDTO;
import com.qa.services.TrainerService;

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
	public List<TrainerDTO> getAll() {
		return service.getAll();
	}

	@GetMapping("/getOneByEmail/{email}")
	public TrainerDTO getOneByEmail(@PathVariable String email) throws TrainerNotFoundException {
		return service.getOneByEmail(email);
	}

	@GetMapping("/getOne/{index}")
	public Trainer getOne(@PathVariable("index") Long index) throws TrainerNotFoundException {
		return service.getOne(index);
	}

	@GetMapping("/getOneByParam")
	public Trainer getOneByParam(@PathParam("index") Long index) throws TrainerNotFoundException {
		if (index != null) {
			return service.getOne(index);
		}
		return null;
	}

	@PostMapping("/create")
	public Trainer create(@RequestBody Trainer trainer) {
		return service.create(trainer);
	}

	@PostMapping("/createMany")
	public List<Trainer> createMany(@RequestBody List<Trainer> trainers) {
		return service.createMany(trainers);
	}

	@PutMapping("/update/{id}")
	public Trainer update(@RequestBody Trainer trainer, @PathVariable("id") Long id) {
		return service.update(id, trainer);
	}

	@DeleteMapping("/delete/{index}")
	public Boolean deleteOne(@PathVariable("index") Long index) {
		return service.delete(index);
	}

}
