package com.project.picpay.application.DAO;

import com.project.picpay.domain.DTO.TransactionResponseDTO;

import java.util.List;

public interface TransactionDAO {
    List<TransactionResponseDTO> getAll();
}
