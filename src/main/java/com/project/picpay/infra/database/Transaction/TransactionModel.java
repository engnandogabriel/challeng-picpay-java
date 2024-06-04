package com.project.picpay.infra.database.Transaction;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "transfers")
public class TransactionModel {
    @Id
    @Column(name = "transfer_id")
    private String transfer_id;
    @Column(name = "value")
    private Double value;
    @Column(name = "payer")
    private String payer;
    @Column(name = "payee")
    private String payee;

    public TransactionModel(){}
    public TransactionModel(String transfer_id, Double value, String payer, String payee) {
        this.transfer_id = transfer_id;
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }

    public String getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(String transfer_id) {
        this.transfer_id = transfer_id;
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

    @Override
    public String toString() {
        return "TransactionModel{" +
                "transfer_id='" + transfer_id + '\'' +
                ", value=" + value +
                ", payer='" + payer + '\'' +
                ", payee='" + payee + '\'' +
                '}';
    }
}
