package com.kai.patientmanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kai.patientmanagement.entity.Patient;
import com.kai.patientmanagement.exception.RecordNotFoundException;
import com.kai.patientmanagement.model.request.PatientRequest;
import com.kai.patientmanagement.model.response.PatientResponse;
import com.kai.patientmanagement.repository.PatientRepository;
import com.kai.patientmanagement.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;

	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public List<PatientResponse> findAll() {
		return patientRepository.findAll().stream().map(entity -> {
			return buildResponse(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public PatientResponse findById(Long id) {
		Patient patient = getPatient(id);
		return buildResponse(patient);
	}

	@Override
	public PatientResponse save(PatientRequest request) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(request, patient);
		Patient storedPatient = patientRepository.save(patient);
		return buildResponse(storedPatient);
	}

	@Override
	public PatientResponse update(Long id, PatientRequest request) {
		Patient patient = getPatient(id);
		BeanUtils.copyProperties(request, patient);
		patient.setSoftDeleted(false);
		Patient storedPatient = patientRepository.save(patient);
		return buildResponse(storedPatient);
	}

	@Override
	public boolean deleteById(Long id) {
		Patient patient = getPatient(id);
		patient.setSoftDeleted(true);
		patientRepository.save(patient);
		return true;
	}

	private Patient getPatient(Long id) {
		return patientRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(
				"The patient could not be found with the given patient id [" + id + "]"));
	}

	private PatientResponse buildResponse(Patient patient) {
		PatientResponse response = new PatientResponse();
		BeanUtils.copyProperties(patient, response);
		return response;
	}
}
