package com.project.picpay.infra.database.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionJPA extends JpaRepository<TransactionModel, String> {
}
