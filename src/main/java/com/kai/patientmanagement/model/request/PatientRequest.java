package com.kai.patientmanagement.model.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PatientRequest {
	@NotBlank(message = "Please provide first name.")
	@Length(max = 64, message = "Maximum length of first name is 64 character")
	private String firstName;

	@NotBlank(message = "Please provide last name.")
	@Length(max = 64, message = "Maximum length of last name is 64 character")
	private String lastName;

	@Length(max = 64, message = "Maximum length of middle name is 64 character")
	private String middleName;

	@NotNull(message = "Please provide a valid date.")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dob;

	@Pattern(regexp = "^[MFO]$", message = "Only M or F or O are accepted.")
	@NotBlank
	private String gender;
}
