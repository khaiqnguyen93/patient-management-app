package com.kai.patientmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kai.patientmanagement.entity.Patient;
import com.kai.patientmanagement.repository.PatientRepository;

@Service
public class PatientServiceImpl {

	private PatientRepository patientRepository;

	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public void addPatients(Patient patient) {
		patientRepository.save(patient);
	}

	public void deletePatients(Patient patient) {
		patient.setIsSoftDeleted(Boolean.TRUE);
		patientRepository.save(patient);
	}
}
