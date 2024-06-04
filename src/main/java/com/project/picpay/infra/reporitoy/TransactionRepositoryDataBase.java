package com.project.picpay.infra.reporitoy;

import com.project.picpay.application.repository.ITransactionRepository;
import com.project.picpay.domain.entities.Transaction;
import com.project.picpay.infra.database.Transaction.TransactionJPA;
import com.project.picpay.infra.database.Transaction.TransactionModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TransactionRepositoryDataBase implements ITransactionRepository {
    private TransactionJPA transactionJPA;
    public TransactionRepositoryDataBase(TransactionJPA transactionJPA){
        this.transactionJPA = transactionJPA;
    }

    @Override
    public void save(Transaction transaction) {
        System.out.println(transaction.toString());
        TransactionModel transactionModel = new TransactionModel(transaction.getTransfer_id(), transaction.getValue().doubleValue(), transaction.getPayer(), transaction.getPayee());
        System.out.println(transaction.toString());
        this.transactionJPA.save(transactionModel);
    }

    @Override
    public Optional<Transaction> getTransaction(String id) {
        TransactionModel transactionModel = this.transactionJPA.getById(id);
        if(transactionModel != null) {
            Transaction transaction = Transaction.restore(transactionModel.getTransfer_id(), transactionModel.getValue(), transactionModel.getPayer(), transactionModel.getPayee());
            return Optional.of(transaction);
        }
        return Optional.empty();
    }
}
