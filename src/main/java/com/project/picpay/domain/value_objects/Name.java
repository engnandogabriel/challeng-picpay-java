package com.project.picpay.domain.value_objects;

import com.project.picpay.domain.Exception.InvalidParamError;

public class Name {
    private String name;

    private Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        this.name = validName(name);
    }

    public static Name create(String name) throws Exception {
        name = validName(validName(name));
        return new Name(name);
    }

    public static Name restore(String name) {
        return new Name(name);
    }

    private static String validName(String name) throws Exception {
        if (name.matches("[a-zA-Z\\s]+")) {
            return name;
        }
        throw new InvalidParamError("Invalid name!");
    }
}
