package com.project.picpay.application.DAO;

import com.project.picpay.domain.DTO.UserDTO;
import com.project.picpay.domain.DTO.UserResponseDTO;

import java.util.List;

public interface UserDAO {
    List<UserResponseDTO> getAll();
}
