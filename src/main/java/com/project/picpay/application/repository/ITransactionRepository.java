package com.project.picpay.application.repository;

import com.project.picpay.domain.entities.Transaction;

import java.util.Optional;

public interface ITransactionRepository {
    void save(Transaction transaction);
    Optional<Transaction> getTransaction(String id);
}
