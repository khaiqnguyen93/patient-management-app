package com.kai.patientmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;

	@Column(name = "first_name", length = 64)
	private String firstName;

	@Column(name = "last_name", length = 64)
	private String lastName;

	@Column(name = "middle_name", length = 64)
	private String middleName;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "gender", length = 1)
	private String gender;

	@Column(name = "is_soft_deleted")
	private boolean isSoftDeleted;
}
