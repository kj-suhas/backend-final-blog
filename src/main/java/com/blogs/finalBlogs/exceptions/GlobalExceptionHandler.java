package com.blogs.finalBlogs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
//    Handle Specific exceptions

    /**
     * Custom handler for resource not found exception
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Custom exception handler for bad request
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<Object> handleNumberFormatException(BadRequest ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    

//    Handle Global exceptions
    /**
     * Global exception handler
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.toString(), request.getSessionId());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
