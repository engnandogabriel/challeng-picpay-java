package com.project.picpay.domain.entities;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.project.picpay.domain.entities.user.Commun;
import com.project.picpay.domain.entities.user.Merchant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    @Test
    @DisplayName("Should be create a new Transaction")
    void createTransaction() throws Exception {
        Commun commun = Commun.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Merchant merchant = Merchant.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Transaction transaction = Transaction.create(50D, commun, merchant);
        Assertions.assertEquals(50.0, transaction.getValue());
        Assertions.assertEquals(50.0, commun.getAmount());
        Assertions.assertEquals(150.0, merchant.getAmount());
    }
    @Test
    @DisplayName("Should be throws a Exception: Invalid amount")
    void invalidAmount() throws Exception {
        Commun commun = Commun.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Merchant merchant = Merchant.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Exception exception = Assertions.assertThrows(Exception.class, () -> Transaction.create(0D, commun, merchant));
        Assertions.assertEquals("Invalid amount!", exception.getMessage());
    }
    @Test
    @DisplayName("Should be throws a Exception: Insufficient payer amount")
    void insufficientPayer() throws Exception {
        Commun commun = Commun.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 30D);
        Merchant merchant = Merchant.create("John Doe", "123.456.789-10", "johndoe@gmail.com", "johndoe123", 100D);
        Exception exception = Assertions.assertThrows(Exception.class, () -> Transaction.create(50D, commun, merchant));
        Assertions.assertEquals("Insufficient payer amount", exception.getMessage());
    }
}