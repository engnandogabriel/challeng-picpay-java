package com.project.picpay.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayeeTest {
    @Test
    @DisplayName("Should be create a payer")
    void createPayee() throws Exception{
        Assertions.assertNotNull(payer.getUser_id());
        Assertions.assertEquals("John Doe", payer.getName());
        Assertions.assertEquals("johndoe@gmail.com", payer.getEmail());
        Assertions.assertEquals("payee", payer.getType_user());
    }
}