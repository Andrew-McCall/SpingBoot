package com.qa.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

	@Autowired
	TrainerRepo repo;

	public Trainer getOneByEmail(String email) {
		return repo.getByEmail(email).orElse(null);
	}

	public List<Trainer> getAll() {
		return repo.findAll();
	}

	public Trainer getOne(Long index) {
		return repo.findById(index).orElse(null);
	}

	public Trainer create(Trainer trainer) {
		return repo.save(trainer);
	}

	public Trainer update(Long id, Trainer trainer) {
		Trainer found = repo.findById(id).orElse(new Trainer());

		found.setAge(trainer.getAge());
		found.setEmail(trainer.getEmail());
		found.setFirstName(trainer.getFirstName());

		return repo.save(found);
	}

	public boolean delete(Long index) {
		repo.deleteById(index);
		return (!repo.existsById(index));
	}

}
