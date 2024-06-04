package com.project.picpay.infra.database.Transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "transfers")
public class TransactionModel {
    @Column(name = "tranfer_id")
    private String tranfer_id;
    @Column(name = "value")
    private Double value;
    @Column(name = "payer")
    private String payer;
    @Column(name = "payee")
    private String payee;

    public TransactionModel(String tranfer_id, Double value, String payer, String payee) {
        this.tranfer_id = tranfer_id;
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }

    public String getTranfer_id() {
        return tranfer_id;
    }

    public void setTranfer_id(String tranfer_id) {
        this.tranfer_id = tranfer_id;
    }

    public Double getValue() {
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
