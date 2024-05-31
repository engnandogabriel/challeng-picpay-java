package com.project.picpay.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommunTest {

    @Test
    @DisplayName("Should be create a payer")
    void createPayer() throws Exception{
        Commun commun = Commun.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Assertions.assertNotNull(commun.getUser_id());
        Assertions.assertEquals("John Doe", commun.getName());
        Assertions.assertEquals("johndoe@gmail.com", commun.getEmail());
        Assertions.assertEquals("commun", commun.getType_user());
    }
    @Test
    @DisplayName("Should be added a new value ")
    void addAmount() throws Exception{
        Commun commun = Commun.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Assertions.assertEquals(100.0, commun.getAmount());
        commun.addAmount(30D);
        Assertions.assertEquals(130.0, commun.getAmount());
    }

    @Test
    @DisplayName("Should be disconted a value ")
    void discontAmount() throws Exception{
        Commun commun = Commun.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Assertions.assertEquals(100.0, commun.getAmount());
        commun.discountValue(30D);
        Assertions.assertEquals(70.0, commun.getAmount());
    }
}