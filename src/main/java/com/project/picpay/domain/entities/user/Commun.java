package com.project.picpay.domain.entities.user;

import com.project.picpay.domain.value_objects.Document;
import com.project.picpay.domain.value_objects.Email;
import com.project.picpay.domain.value_objects.Name;

import java.util.UUID;

public class Commun extends User {
    private Commun(String id, String name, String document, String email, String password, String typeUser, Double amount) throws Exception {
        this.user_id = id;
        this.name = Name.create(name);
        this.document = Document.create(document);
        this.email = Email.create(email);
        this.password = password;
        this.type_user = typeUser;
        this.amount = amount;
    }

    public static Commun create(String name, String document, String email, String password, Double amount) throws Exception {
        String id = UUID.randomUUID().toString();
        return new Commun(id, name, document, email, password, "commun", amount);
    }

    public static Commun restore(String id, String name, String document, String email, String password, String typeUser, Double amount) throws Exception {
        return new Commun(id, name, document, email, password, typeUser, amount);
    }

    @Override
    public void addAmount(Double value){
        this.amount += value;
    }

    @Override
    public void discountValue(Double value) throws Exception{
        if(this.amount < value) throw new Exception("Can not be disconted value");
        this.amount -= value;
    }

}

