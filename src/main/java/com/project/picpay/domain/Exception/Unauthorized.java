package com.project.picpay.domain.Exception;

public class Unauthorized extends Exception{
    public Unauthorized(String message){
        super("UnauthorizedError: "+message);
    }
}
