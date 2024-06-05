package com.project.picpay.infra.DAO;

import com.project.picpay.application.DAO.TransactionDAO;
import com.project.picpay.domain.DTO.TransactionResponseDTO;
import com.project.picpay.infra.database.Transaction.TransactionJPA;
import com.project.picpay.infra.database.Transaction.TransactionModel;
import org.aspectj.weaver.ast.Literal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionDAODatabase implements TransactionDAO {
    private TransactionJPA transactionJPA;

    public TransactionDAODatabase(TransactionJPA transactionJPA) {
        this.transactionJPA = transactionJPA;
    }

    @Override
    public List<TransactionResponseDTO> getAll() {
        List<TransactionModel> transactioModel = this.transactionJPA.findAll();
        List<TransactionResponseDTO> transactionResponseDTO = new ArrayList<>();
        transactioModel.forEach(transaction -> transactionResponseDTO.add(new TransactionResponseDTO(transaction.getTransfer_id(), transaction.getPayer(), transaction.getPayee(), transaction.getValue())));
        return transactionResponseDTO;
    }
}
