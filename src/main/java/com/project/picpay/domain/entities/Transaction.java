package com.project.picpay.domain.entities;

import com.project.picpay.domain.entities.user.Payee;
import com.project.picpay.domain.entities.user.User;

import java.util.UUID;

public class Transaction {
    private String tranfer_id;
    private Number value;
    private String payer;
    private String payee;

    private Transaction(String id, Number value, String payer, String payee){
        this.tranfer_id = id;
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }
    public static Transaction create(Number value, User payer, User payee) throws Exception{
        String id = UUID.randomUUID().toString();
        if(value.doubleValue() <= 0) throw new Exception("Invalid amount!");
//        if()
        return new Transaction(id, value, payer.getUser_id(), payee.getUser_id());
    }
}
