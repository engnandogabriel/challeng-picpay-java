package com.project.picpay.domain.value_objects;

public class Email {
    private String email;

    private Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        this.email = validEmail(email);
    }

    public static Email create(String email) throws Exception {
        email = validEmail(email);
        return new Email(email);
    }

    public static Email restore(String email) {
        return new Email(email);
    }

    private static String validEmail(String email) throws Exception {
        email = email.replace(" ", "");
        if (email.contains("@") && email.contains(".com")) return email;
        throw new Exception("E-mail is invalid!");
    }
}