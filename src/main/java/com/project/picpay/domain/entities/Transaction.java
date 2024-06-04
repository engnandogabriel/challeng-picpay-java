package com.project.picpay.domain.entities;

import com.project.picpay.domain.Exception.InvalidParamError;
import com.project.picpay.domain.entities.user.Commun;
import com.project.picpay.domain.entities.user.Merchant;
import com.project.picpay.domain.entities.user.User;

import java.util.UUID;

public class Transaction {
    private String transfer_id;
    private Double value;
    private String payer;
    private String payee;

    private Transaction(String id, Double value, String payer, String payee) {
        this.transfer_id = id;
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }

    public static Transaction create(Double value, User payer, User payee) throws Exception {
        String id = UUID.randomUUID().toString();
        if (value <= 0) throw new InvalidParamError("Invalid amount!");
        if (!payer.getType_user().equals("commun")) throw new InvalidParamError("Payer most be commun");
        if (payer.getAmount() < value) {
            throw new InvalidParamError("Insufficient payer amount");
        }
        payer.discountValue(value);
        payee.addAmount(value);
        return new Transaction(id, value, payer.getUser_id(), payee.getUser_id());
    }

    public static Transaction restore(String id, Double value, String payer, String payee){
        return new Transaction(id, value, payer, payee);
    }

    public String getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(String transfer_id) {
        this.transfer_id = transfer_id;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tranfer_id='" + transfer_id + '\'' +
                ", value=" + value +
                ", payer='" + payer + '\'' +
                ", payee='" + payee + '\'' +
                '}';
    }
}
