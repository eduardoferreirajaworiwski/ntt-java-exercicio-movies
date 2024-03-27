package com.example.academiacx.handlers.resources;

import com.example.academiacx.handlers.exceptions.ErrorDetails;
import com.example.academiacx.handlers.exceptions.InvalidParameterException;
import com.example.academiacx.handlers.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ErrorDetails> handleInvalidParameterException(InvalidParameterException exception, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), 406L, 406L, System.currentTimeMillis(), "http://localhost:8080/errors/406");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorDetails);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), 406L, 406L, System.currentTimeMillis(), "http://localhost:8080/errors/406");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorDetails);
    }
}
