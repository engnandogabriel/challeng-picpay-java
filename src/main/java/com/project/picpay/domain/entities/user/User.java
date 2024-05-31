package com.project.picpay.domain.entities.user;

import com.project.picpay.domain.value_objects.Document;
import com.project.picpay.domain.value_objects.Email;
import com.project.picpay.domain.value_objects.Name;

public abstract class User {
    protected String user_id;
    protected Name name;
    protected Document document;
    protected Email email;
    protected String password;
    protected String type_user;
    protected Number amount;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name.getName();
    }

    public void setName(String name) throws Exception{
        this.name = Name.create(name);
    }

    public String getDocument() {
        return document.getDocument();
    }

    public void setDocument(String document) throws Exception{
        this.document = Document.create(document);
    }

    public String getEmail() {
        return email.getEmail();
    }

    public void setEmail(String email) throws Exception{
        this.email = Email.create(email);
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

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }
}
