package com.project.picpay.domain.entities.user;

import com.project.picpay.domain.value_objects.Document;
import com.project.picpay.domain.value_objects.Email;
import com.project.picpay.domain.value_objects.Name;

import java.util.UUID;

public class Payee extends User {
    private Payee(String id, String name, String document, String email, String password, String typeUser, Double amount) throws Exception{
        this.user_id = id;
        this.name = Name.create(name);
        this.document = Document.create(document);
        this.email = Email.create(email);
        this.password = password;
        this.type_user = typeUser;
        this.amount = amount;
    }
    public static Payee create(String name, String document, String email, String password, Double amount) throws Exception {
        String id = UUID.randomUUID().toString();
        return new Payee(id, name, document, email, password, "payee", amount);
    }

    public static Payee restore(String id, String name, String document, String email, String password, String typeUser, Double amount) throws Exception {
        return new Payee(id, name, document, email, password, typeUser, amount);
    }
}
