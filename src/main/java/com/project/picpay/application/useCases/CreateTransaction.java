package com.project.picpay.application.useCases;

import com.project.picpay.application.repository.ITransactionRepository;
import com.project.picpay.application.repository.IUserRepository;
import com.project.picpay.domain.DTO.TransactionDTO;
import com.project.picpay.domain.Exception.NotFoundError;
import com.project.picpay.domain.Exception.Unauthorized;
import com.project.picpay.domain.HandlerService.HandlerDTO;
import com.project.picpay.domain.HandlerService.Handlers;
import com.project.picpay.domain.entities.Transaction;
import com.project.picpay.domain.entities.user.User;
import com.project.picpay.domain.gateway.AuthorizationGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateTransaction {
    private ITransactionRepository transactionRepository;
    private IUserRepository userRepository;
    private AuthorizationGateway authorizationGateway;

    public CreateTransaction(ITransactionRepository transactionRepository, IUserRepository userRepository, AuthorizationGateway authorizationGateway) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.authorizationGateway = authorizationGateway;
    }

    public HandlerDTO execute(TransactionDTO transactionDTO) {
        try {
            Optional<User> payer = this.userRepository.getById(transactionDTO.payer());
            if(payer.isEmpty()){
                return new Handlers<>().notFound(new NotFoundError("Payer not found"));
            }
            Optional<User> payee = this.userRepository.getById(transactionDTO.payee());
            if(payee.isEmpty()){
                return new Handlers<>().notFound(new NotFoundError("Payee not found"));
            }
            Transaction transaction = Transaction.create(transactionDTO.value().doubleValue(), payer.get(), payee.get());
            if(!this.authorizationGateway.authorize()) return new Handlers<>().unauthorizedError(new Unauthorized("You do not have authorization"));
            this.userRepository.changeAmount(payer.get());
            this.userRepository.changeAmount(payee.get());
            this.transactionRepository.save(transaction);
            return new Handlers<>().success(transaction);
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}
