package com.enrollment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.model.Enrollee;

@Repository
public interface EnrolleeRepository extends JpaRepository<Enrollee, Long> {

	default Enrollee findOne(Long id) {
		Optional<Enrollee> enrollee = findById(id);
		if (enrollee.isPresent()) {
			return enrollee.get();
		} else {
			return null;
		}
	}

}
