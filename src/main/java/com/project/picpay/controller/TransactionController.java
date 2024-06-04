package com.project.picpay.controller;

import com.project.picpay.application.useCases.CreateTransaction;
import com.project.picpay.domain.DTO.TransactionDTO;
import com.project.picpay.domain.HandlerService.HandlerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "transaction")
@RestController
public class TransactionController {
    private CreateTransaction createTransaction;

    public TransactionController(CreateTransaction createTransaction) {
        this.createTransaction = createTransaction;
    }

    @PostMapping
    public ResponseEntity<HandlerDTO> save(@RequestBody TransactionDTO transactionDTO) throws Exception {
        HandlerDTO output = this.createTransaction.execute(transactionDTO);
        return new ResponseEntity<>(output, output.status());
    }
}
