package com.qa.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService2 {

	private boolean validIndex(int index) {
		return (index >= 0 && index < trainers.size());
	}

	@Autowired
	List<Trainer> trainers;

	public List<Trainer> getAll() {
		return trainers;
	}

	public Trainer getOne(int index) {
		if (validIndex(index)) {
			return trainers.get(index);
		}

		return null;

	}

	public int create(Trainer trainer) {
		if (trainers.add(trainer)) {
			return trainers.size() - 1;
		}
		return -1;
	}

	public Trainer delete(int index) {
		if (validIndex(index)) {
			return trainers.remove(index);
		}

		return null;
	}

}
