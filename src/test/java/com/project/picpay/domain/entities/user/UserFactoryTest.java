package com.project.picpay.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {
    @Test
    @DisplayName("Should be created a Commun user")
    void communUser() throws Exception{
        User commun = UserFactory.create("commun", "John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Assertions.assertEquals(Commun.class, commun.getClass());
        Assertions.assertEquals("commun", commun.getType_user());
        Assertions.assertNotNull(commun.getUser_id());
    }
    @Test
    @DisplayName("Should be created a Merchant user")
    void merchantUser() throws Exception{
        User merchant = UserFactory.create("merchant", "John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Assertions.assertEquals(Merchant.class, merchant.getClass());
        Assertions.assertEquals("merchant", merchant.getType_user());
        Assertions.assertNotNull(merchant.getUser_id());
    }
    @Test
    @DisplayName("Should be throw a Exception: Invalid type user")
    void invalid() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> UserFactory.create("test", "John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D));
        Assertions.assertEquals("Invalid type user", exception.getMessage());
    }
}