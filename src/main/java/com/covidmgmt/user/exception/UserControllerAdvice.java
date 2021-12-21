package com.covidmgmt.user.exception;


import com.covidmgmt.user.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Error userExistsException(UserExistsException ex){

        Error error = new Error(400, ex.getMessage());

        return error;
    }

    @ExceptionHandler(IllegalUserIdException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Error illegalUserIdException(IllegalUserIdException ex){

        Error error = new Error(400, ex.getMessage());

        return error;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Error userNotFoundException(UserNotFoundException ex){

        Error error = new Error(404, ex.getMessage());

        return error;
    }

    @ExceptionHandler(InvalidTokenException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Error invalidTokenException(InvalidTokenException ex){

        Error error = new Error(400, ex.getMessage());

        return error;
    }

}
