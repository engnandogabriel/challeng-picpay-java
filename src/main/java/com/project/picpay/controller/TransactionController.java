package com.project.picpay.controller;

import com.project.picpay.application.useCases.CreateTransaction;
import com.project.picpay.application.useCases.GetAllTransaction;
import com.project.picpay.domain.DTO.TransactionDTO;
import com.project.picpay.domain.HandlerService.HandlerDTO;
import com.project.picpay.domain.HandlerService.Handlers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "transaction")
@RestController
public class TransactionController {
    private CreateTransaction createTransaction;
    private GetAllTransaction getAllTransaction;

    public TransactionController(CreateTransaction createTransaction, GetAllTransaction getAllTransaction) {
        this.createTransaction = createTransaction;
        this.getAllTransaction = getAllTransaction;
    }

    @GetMapping(value = "")
    public ResponseEntity<HandlerDTO> getAll() {
        HandlerDTO output = this.getAllTransaction.execute();
        return new ResponseEntity<>(output, output.status());
    }

    @PostMapping
    public ResponseEntity<HandlerDTO> save(@RequestBody TransactionDTO transactionDTO) throws Exception {
        HandlerDTO output = this.createTransaction.execute(transactionDTO);
        return new ResponseEntity<>(output, output.status());
    }
}
