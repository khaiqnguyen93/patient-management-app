package com.kai.patientmanagement.model.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiErrorResponse {

    private int code;

    private String message;

    private String trace;

    private String path;

    private LocalDateTime timestamp = LocalDateTime.now();

}
