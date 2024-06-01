package com.project.picpay.application.useCases;

import com.project.picpay.application.repository.IUserRepository;
import com.project.picpay.domain.DTO.Response;
import com.project.picpay.domain.DTO.UserDTO;
import com.project.picpay.domain.entities.user.User;
import com.project.picpay.domain.entities.user.UserFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateUser {
    private IUserRepository userRepository;

    public CreateUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Response<String> execute(UserDTO userDTO) {
        try {
            Optional<User> emailExist = this.userRepository.getByEmail(userDTO.email());
            if (emailExist.isPresent())
                return new Response<>(400, "User Exists", "A user already exists with this email");
            Optional<User> documentExist = this.userRepository.getByDocument(userDTO.document());
            if (documentExist.isPresent())
                return new Response<>(400, "User Exists", "A user already exists with this document");
            User user = UserFactory.create(userDTO.type_user(), userDTO.name(), userDTO.document(), userDTO.email(), userDTO.password(), userDTO.value().doubleValue());
            this.userRepository.save(user);
            return new Response<>(200, "User created", null);
        } catch (Exception e) {
            return new Response<>(400, e.getMessage(), null);
        }
    }
}
