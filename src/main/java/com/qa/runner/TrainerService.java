package com.qa.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

	@Autowired
	TrainerRepo repo;

	public TrainerDTO getOneByEmail(String email) {
		Optional<Trainer> find = repo.getByEmail(email);
		if (find.isPresent()) {
			return new TrainerDTO(find.get());
		}
		return null;
	}

	public List<TrainerDTO> getAll() {
		List<TrainerDTO> output = new ArrayList<TrainerDTO>();
		repo.findAll().forEach(t -> output.add(new TrainerDTO(t)));
		return output;
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
