package com.think.learn_springboot.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler{

        @ExceptionHandler(DepartmentNotFoundException.class)
        public ResponseEntity<String> departmentNotFoundException(DepartmentNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
        }

}
