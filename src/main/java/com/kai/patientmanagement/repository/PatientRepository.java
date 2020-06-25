package com.kai.patientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kai.patientmanagement.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
