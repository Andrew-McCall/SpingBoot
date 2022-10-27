package com.qa.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.models.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Long> {

	// Select * from TRAINER where email='email' LIMIT 1;
	Optional<Trainer> findByEmail(String email);

	@Query(value = "SELECT * FROM TRAINER WHERE email=?1 LIMIT 1", nativeQuery = true)
	Optional<Trainer> getByEmail(String Email);

}
