package com.kai.patientmanagement.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientResponse {
    private Long patientId;

    private String firstName;

    private String lastName;

    private String middleName;

    @JsonFormat(pattern = "yyyy/MM/dd", locale = "en_US")
    private Date dateOfBirth;

    private String gender;

    private Boolean softDeleted;
}
