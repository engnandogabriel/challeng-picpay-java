package com.project.picpay.domain.Exception;

public class InvalidParamError extends Exception {
    public InvalidParamError(String message){
        super("InvalidParamError: "+message);
    }
}
