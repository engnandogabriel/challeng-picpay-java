package com.project.picpay.domain.entities.user;

public class UserFactory {
    public static User create(String type, String name, String document, String email, String password, Double amount) throws Exception{
        if(type.equals("commun")) return Commun.create(name, document, email, password, amount);
        if(type.equals("merchant")) return Merchant.create(name, document, email, password, amount);
        throw new Exception("");
    }
}
