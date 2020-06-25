package com.kai.patientmanagement.service;

import java.util.List;

import com.kai.patientmanagement.model.request.PatientRequest;
import com.kai.patientmanagement.model.response.PatientResponse;

/**
 * The service for handling the business logic of patient management
 */
public interface PatientService {
	
    /**
     * Get list Patients based on the criteria
     *
     * @param filterable The criteria for getting patients
     * @return The list Patients
     */
	List<PatientResponse> findAll();

    /**
     * Get a Patient. 
     * Patients that have been soft-deleted should still be able to be loaded by this API.
     *
     * @param id The id attribute of the Patient entity
     * @return The Patient
     */
	PatientResponse findById(Long id);

    /**
     * Save a Patient. 
     * If a record in the database exists with a conflict PatientID but it’s been soft-deleted.
     * The record should be re-activated and the attributes updated to the values from the current request.
     *
     * @param request The Patient data will be stored
     * @return The saved Patient
     */
	PatientResponse save(PatientRequest patient);

    /**
     * Update a Patient.
     *
     * @param id The id attribute of the Patient entity
     * @param request The Patient data will be stored
     * @return The updated Patient
     */
	PatientResponse update(Long id, PatientRequest request);

    /**
     * Delete a Patient.
     *
     * @param id The id attribute of the Patient entity
     * @return true if deleted successfully, otherwise return false
     */
	boolean deleteById(Long id);
}
