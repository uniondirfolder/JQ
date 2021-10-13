package com.nvv.except;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlerException(NoSuchEmployeeException exception) {
        EmployeeIncorrectData inf = new EmployeeIncorrectData(exception.getMessage());
        return new ResponseEntity<>(inf, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlerException(Exception exception) {
        EmployeeIncorrectData inf = new EmployeeIncorrectData(exception.getMessage());
        return new ResponseEntity<>(inf, HttpStatus.BAD_REQUEST);
    }
}
