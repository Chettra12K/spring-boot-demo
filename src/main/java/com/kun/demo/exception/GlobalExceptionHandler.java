package com.kun.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    //Handle validation errors (400 Bad Request)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
        MethodArgumentNotValidException ex, WebRequest request){
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.BAD_REQUEST.value());
            body.put("error", "Validation Failed");

            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach( error ->
                 errors.put(error.getField(), error.getDefaultMessage()));
            body.put("errors", errors);
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
    //Handle Todo not found (404)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleNotFoundException(RuntimeException ex, WebRequest request){
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.NOT_FOUND.value());
            body.put("error", "Not Found");
            body.put("message", ex.getMessage());
            body.put("path", request.getDescription(false));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    //Handle general exceptions (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<Object> handleTodoNotFoundException(TodoNotFoundException ex, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("sttaus", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));
        return  new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    
}
