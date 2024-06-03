package com.project.picpay.domain.Exception;

public class InvalidOperation extends Exception{
    public InvalidOperation(String message){
        super("InvalidOperation: "+message);
    }
}
