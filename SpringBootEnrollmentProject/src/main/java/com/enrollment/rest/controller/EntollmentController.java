package com.enrollment.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrollment.dao.DependentRepository;
import com.enrollment.dao.EnrolleeRepository;
import com.enrollment.exception.EnrollmentException;
import com.enrollment.model.Dependent;
import com.enrollment.model.Enrollee;

@RestController
public class EntollmentController implements ErrorController {

	@Autowired
	private EnrolleeRepository enrolleeRepo;

	@Autowired
	private DependentRepository dependentRepo;

	private static final String PATH = "/error";

	@GetMapping(value = "/enrollees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Enrollee>> getAllEnrollees() {
		List<Enrollee> enrollees = enrolleeRepo.findAll();

		return new ResponseEntity<List<Enrollee>>(enrollees, HttpStatus.OK);
	}

	@GetMapping(value = "/enrollees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Enrollee> getAllEnrolleebById(@PathVariable long id) {
		Enrollee enrollee = enrolleeRepo.findOne(id);
		if (enrollee == null) {
			throw new EnrollmentException("Enrollee Not Found.");
		}

		return new ResponseEntity<Enrollee>(enrollee, HttpStatus.OK);
	}

	@GetMapping(value = "/enrollees/{id}/dependents", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dependent>> getAllDependentsEnrolleebById(@PathVariable long id) {
		List<Dependent> dependents = dependentRepo.findByEnrolleeId(id);

		return new ResponseEntity<List<Dependent>>(dependents, HttpStatus.OK);
	}

	@PostMapping(value = "/enrollees")
	public ResponseEntity<Enrollee> addEnrollee(@RequestBody Enrollee enrollee) {
		try {
			Enrollee tempEnrollee = enrolleeRepo.save(enrollee);
			return new ResponseEntity<Enrollee>(tempEnrollee, HttpStatus.OK);
		} catch (Exception e) {
			throw new EnrollmentException(e.getLocalizedMessage());
		}
	}

	@PostMapping(value = "/enrollees/{id}/dependents")
	public ResponseEntity<Dependent> addDependent(@RequestBody Dependent dependent, @PathVariable long id) {
		try {
			Enrollee enrollee = enrolleeRepo.findOne(id);
			dependent.setEnrollee(enrollee);
			dependentRepo.save(dependent);
			return new ResponseEntity<Dependent>(dependent, HttpStatus.OK);
		} catch (Exception e) {
			throw new EnrollmentException(e.getLocalizedMessage());
		}
	}

	@GetMapping(value = PATH)
	public ResponseEntity<String> error() {
		throw new EnrollmentException("Url Not Found.");
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
