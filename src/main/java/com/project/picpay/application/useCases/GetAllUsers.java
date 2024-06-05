package com.project.picpay.application.useCases;

import com.project.picpay.application.DAO.UserDAO;
import com.project.picpay.application.repository.IUserRepository;
import com.project.picpay.domain.DTO.UserResponseDTO;
import com.project.picpay.domain.HandlerService.HandlerDTO;
import com.project.picpay.domain.HandlerService.Handlers;
import com.project.picpay.domain.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetAllUsers {

    private UserDAO userDAO;

    public GetAllUsers(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public HandlerDTO execute() {
        try {
            List<UserResponseDTO> users = this.userDAO.getAll();
            return new Handlers<>().success(users);
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}
