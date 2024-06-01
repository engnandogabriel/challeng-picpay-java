package com.project.picpay.domain.Exception;

public class ProprietyInvalidError extends Exception {
    public ProprietyInvalidError(String message){
        super("ProprietyInvalidError: "+message);
    }
}
