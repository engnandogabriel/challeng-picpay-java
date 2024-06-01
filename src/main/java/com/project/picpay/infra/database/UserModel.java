package com.project.picpay.infra.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @Column(name = "user_id")
    private String user_id;

    @Column(name = "name")
    private String name;
    @Column(name = "document")
    private String document;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "type_user")
    private String type_user;
    @Column(name = "amount")
    private Double amount;

    public UserModel() {
    }

    public UserModel(String user_id, String name, String document, String email, String password, String type_user, Double amount) {
        this.user_id = user_id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.type_user = type_user;
        this.amount = amount;
    }

    public String getId() {
        return user_id;
    }

    public void setId(String id) {
        this.user_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
