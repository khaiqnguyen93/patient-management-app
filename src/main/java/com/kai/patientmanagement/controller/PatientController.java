package com.kai.patientmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kai.patientmanagement.model.request.PatientRequest;
import com.kai.patientmanagement.model.response.PatientResponse;
import com.kai.patientmanagement.service.PatientService;

@RestController
@RequestMapping("/v1/patients")
public class PatientController {

	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@GetMapping
	public List<PatientResponse> findAll() {
		return patientService.findAll();
	}

	@GetMapping("/{patientId}")
	public PatientResponse findById(@PathVariable Long patientId) {
		return patientService.findById(patientId);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PatientResponse create(@Valid @RequestBody PatientRequest request) {
		return patientService.save(request);
	}
	
	@PutMapping("/{patientId}")
	public PatientResponse update(@PathVariable Long patientId, @Valid @RequestBody PatientRequest request) {
		return patientService.update(patientId, request);
	}
	
	@DeleteMapping("/{patientId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable Long patientId) {
		return patientService.deleteById(patientId);
	}
}
