package com.project.picpay.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayeeTest {
    @Test
    @DisplayName("Should be create a payer")
    void createPayee() throws Exception{
        Payee payee = Payee.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100);
        Assertions.assertNotNull(payee.getUser_id());
        Assertions.assertEquals("John Doe", payee.getName());
        Assertions.assertEquals("johndoe@gmail.com", payee.getEmail());
        Assertions.assertEquals("payee", payee.getType_user());
    }
}