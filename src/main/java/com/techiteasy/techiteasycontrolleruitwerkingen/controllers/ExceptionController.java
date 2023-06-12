package com.techiteasy.techiteasycontrolleruitwerkingen.controllers;

import com.techiteasy.techiteasycontrolleruitwerkingen.exceptions.RecordNotFoundException;
import com.techiteasy.techiteasycontrolleruitwerkingen.exceptions.ToManyCharException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice       //Dit moet als je een exception controller gaat maken.
public class ExceptionController {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception (RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> exception (IndexOutOfBoundsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ToManyCharException.class)
    public ResponseEntity<Object> exception (ToManyCharException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.LENGTH_REQUIRED);
    }
}
