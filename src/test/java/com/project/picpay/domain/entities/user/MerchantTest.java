package com.project.picpay.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MerchantTest {
    @Test
    @DisplayName("Should be create a payer")
    void createPayee() throws Exception{
        Merchant merchant = Merchant.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Assertions.assertNotNull(merchant.getUser_id());
        Assertions.assertEquals("John Doe", merchant.getName());
        Assertions.assertEquals("johndoe@gmail.com", merchant.getEmail());
        Assertions.assertEquals("merchant", merchant.getType_user());
    }

    @Test
    @DisplayName("Should be added a new value")
    void addAmount() throws Exception{
        Merchant merchant = Merchant.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Assertions.assertEquals(100.0, merchant.getAmount());
        merchant.addAmount(30D);
        Assertions.assertEquals(130.0, merchant.getAmount());
    }

    @Test
    @DisplayName("Should be throws a Exception: You do not have permission for this action")
    void dicsontmount() throws Exception {
        Merchant merchant = Merchant.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);

        Exception exception = Assertions.assertThrows(Exception.class, () -> merchant.discountValue(30D));
        Assertions.assertEquals("You do not have permission for this action", exception.getMessage());
    }
}