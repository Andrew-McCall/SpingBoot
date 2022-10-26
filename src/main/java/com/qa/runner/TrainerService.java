package com.qa.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

	@Autowired
	TrainerRepo repo;

	public List<Trainer> getAll() {
		return repo.findAll();
	}

	public Trainer getOne(Long index) {
		return repo.findById(index).orElse(null);
	}

	public Trainer create(Trainer trainer) {
		return repo.save(trainer);
	}

	public boolean delete(Long index) {
		repo.deleteById(index);
		return (!repo.existsById(index));
	}

}
