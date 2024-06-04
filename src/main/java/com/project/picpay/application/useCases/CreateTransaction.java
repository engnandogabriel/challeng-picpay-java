package com.project.picpay.application.useCases;

import com.project.picpay.application.repository.ITransactionRepository;
import com.project.picpay.application.repository.IUserRepository;
import com.project.picpay.domain.DTO.TransactionDTO;
import com.project.picpay.domain.Exception.NotFoundError;
import com.project.picpay.domain.HandlerService.HandlerDTO;
import com.project.picpay.domain.HandlerService.Handlers;
import com.project.picpay.domain.entities.Transaction;
import com.project.picpay.domain.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateTransaction {
    private ITransactionRepository transactionRepository;
    private IUserRepository userRepository;

    public CreateTransaction(ITransactionRepository transactionRepository, IUserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    public HandlerDTO execute(TransactionDTO transactionDTO) {
        try {
            User payer = this.userRepository.getById(transactionDTO.payer()).orElseThrow(() -> new NotFoundError("Payer not found"));
            User payee = this.userRepository.getById(transactionDTO.payee()).orElseThrow(() -> new NotFoundError("Payee not found"));
            Transaction transaction = Transaction.create(transactionDTO.value().doubleValue(), payer, payee);
            this.userRepository.changeAmount(payer);
            this.userRepository.changeAmount(payee);
            this.transactionRepository.save(transaction);
            return new Handlers<>().success(transaction);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}
