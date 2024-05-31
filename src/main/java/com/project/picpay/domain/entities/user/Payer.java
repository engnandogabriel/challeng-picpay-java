package com.project.picpay.domain.entities.user;

import com.project.picpay.domain.value_objects.Document;
import com.project.picpay.domain.value_objects.Email;
import com.project.picpay.domain.value_objects.Name;

import java.util.UUID;

public class Payer extends User {
    private Payer(String id, String name, String document, String email, String password, String typeUser) throws Exception {
        this.user_id = id;
        this.name = Name.create(name);
        this.document = Document.create(document);
        this.email = Email.create(email);
        this.password = password;
        this.type_user = typeUser;
    }

    public static Payer create(String name, String document, String email, String password) throws Exception {
        String id = UUID.randomUUID().toString();
        return new Payer(id, name, document, email, password, "payer");
    }

    public static Payer restore(String id, String name, String document, String email, String password, String typeUser) throws Exception {
        return new Payer(id, name, document, email, password, typeUser);
    }

}

