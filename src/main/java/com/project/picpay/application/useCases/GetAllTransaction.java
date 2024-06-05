package com.project.picpay.application.useCases;

import com.project.picpay.application.DAO.TransactionDAO;
import com.project.picpay.domain.DTO.TransactionResponseDTO;
import com.project.picpay.domain.HandlerService.HandlerDTO;
import com.project.picpay.domain.HandlerService.Handlers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTransaction {
    private TransactionDAO transactionDAO;
    public GetAllTransaction(TransactionDAO transactionDAO){
        this.transactionDAO = transactionDAO;
    }
    public HandlerDTO execute(){
        try {
            List<TransactionResponseDTO> transactions = this.transactionDAO.getAll();
            return new Handlers<>().success(transactions);
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}
