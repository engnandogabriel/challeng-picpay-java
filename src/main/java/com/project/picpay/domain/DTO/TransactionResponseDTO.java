package com.project.picpay.domain.DTO;

public record TransactionResponseDTO(String id, String payer, String payee, Double amount) {
}
