package com.nvv.instame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAppExistException extends RuntimeException {
    public UserAppExistException(String s) {
        super(s);
    }
}
