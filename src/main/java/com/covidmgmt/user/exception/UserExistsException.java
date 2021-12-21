package com.covidmgmt.user.exception;

public class UserExistsException  extends RuntimeException{

    public UserExistsException(String msg){
        super(msg);
    }
}
