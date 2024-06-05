package com.project.picpay.infra.DAO;

import com.project.picpay.application.DAO.UserDAO;
import com.project.picpay.domain.DTO.UserDTO;
import com.project.picpay.domain.DTO.UserResponseDTO;
import com.project.picpay.infra.database.User.UserJPA;
import com.project.picpay.infra.database.User.UserModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAODatabase implements UserDAO {
    private UserJPA userJPA;

    public UserDAODatabase(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    @Override
    public List<UserResponseDTO> getAll() {
        List<UserModel> userModel = this.userJPA.findAll();
        List<UserResponseDTO> userDAOResponse = new ArrayList<>();
        userModel.forEach(user -> userDAOResponse.add(new UserResponseDTO(user.getId(), user.getName(), user.getDocument(), user.getEmail(), user.getType_user(), user.getAmount())));
        return userDAOResponse;
    }
}
