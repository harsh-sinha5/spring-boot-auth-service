package com.covidmgmt.user.exception;

public class IllegalUserIdException extends RuntimeException{

    public IllegalUserIdException(String msg){
        super(msg);
    }
}
