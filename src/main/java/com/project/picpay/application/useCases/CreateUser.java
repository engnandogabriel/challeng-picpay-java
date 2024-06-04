package com.project.picpay.application.useCases;

import com.project.picpay.application.repository.IUserRepository;
import com.project.picpay.domain.DTO.Response;
import com.project.picpay.domain.DTO.UserDTO;
import com.project.picpay.domain.Exception.InvalidParamError;
import com.project.picpay.domain.HandlerService.HandlerDTO;
import com.project.picpay.domain.HandlerService.Handlers;
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

    public HandlerDTO execute(UserDTO userDTO) {
        try {
            Optional<User> emailExist = this.userRepository.getByEmail(userDTO.email());
            if (emailExist.isPresent())
                throw new InvalidParamError("A user already exists with this email");
            Optional<User> documentExist = this.userRepository.getByDocument(userDTO.document());
            if (documentExist.isPresent())
                throw new InvalidParamError("A user already exists with this document");
            User user = UserFactory.create(userDTO.type_user(), userDTO.name(), userDTO.document(), userDTO.email(), userDTO.password(), userDTO.value().doubleValue());
            this.userRepository.save(user);
            return new Handlers<String>().success("Success");
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }

    }
}