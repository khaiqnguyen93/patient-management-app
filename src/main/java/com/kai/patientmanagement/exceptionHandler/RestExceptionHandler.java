package com.kai.patientmanagement.exceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kai.patientmanagement.model.response.ApiErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Validation Failed");
        response.setTrace(ex.getMessage());
        response.setPath(request.getContextPath());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers,
                                                         final HttpStatus status, final WebRequest request) {
        //
        ApiErrorResponse response = new ApiErrorResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Binding Failed");
        response.setTrace(ex.getMessage());
        response.setPath(request.getContextPath());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 422 : Constraint Violation
    @ExceptionHandler({ ConstraintViolationException.class })
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Object> handleConstraintViolation(final ConstraintViolationException ex,
                                                            final HttpServletRequest request) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        response.setMessage("Constraint Violation");
        response.setTrace(ex.getMessage());
        response.setPath(request.getRequestURL().toString());

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
