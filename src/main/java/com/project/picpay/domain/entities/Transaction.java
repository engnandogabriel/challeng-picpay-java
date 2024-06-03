package com.project.picpay.domain.entities;

import com.project.picpay.domain.entities.user.Commun;
import com.project.picpay.domain.entities.user.Merchant;

import java.util.UUID;

public class Transaction {
    private String tranfer_id;
    private Double value;
    private String payer;
    private String payee;

    private Transaction(String id, Double value, String payer, String payee) {
        this.tranfer_id = id;
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }

    public static Transaction create(Double value, Commun payer, Merchant payee) throws Exception {
        String id = UUID.randomUUID().toString();
        if (value <= 0) throw new Exception("Invalid amount!");
        if (!payer.getType_user().equals("commun")) throw new Exception("Payer most be commun");
        if (payer.getAmount() < value) {
            throw new Exception("Insufficient payer amount");
        }
        payer.discountValue(value);
        payee.addAmount(value);
        return new Transaction(id, value, payer.getUser_id(), payee.getUser_id());
    }

    public String getTranfer_id() {
        return tranfer_id;
    }

    public void setTranfer_id(String tranfer_id) {
        this.tranfer_id = tranfer_id;
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
}
