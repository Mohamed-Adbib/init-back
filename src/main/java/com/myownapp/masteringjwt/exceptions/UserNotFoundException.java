package com.myownapp.masteringjwt.exceptions;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){

        super(message);
    }
}
