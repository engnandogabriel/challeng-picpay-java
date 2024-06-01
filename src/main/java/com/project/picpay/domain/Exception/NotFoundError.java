package com.project.picpay.domain.Exception;

public class NotFoundError extends Exception{
    public NotFoundError(String message){
        super("NotFoundError: " +message);
    }
}
