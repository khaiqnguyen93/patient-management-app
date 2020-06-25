package com.kai.patientmanagement.model.response;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientResponse {
    private Long patientId;

    private String firstName;

    private String lastName;

    private String middleName;

    private Date dob;

    private String gender;

    private Boolean softDeleted;
}
