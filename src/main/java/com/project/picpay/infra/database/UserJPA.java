package com.project.picpay.infra.database;

import com.project.picpay.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPA extends JpaRepository<UserModel, String > {
    UserModel getByEmail(String email);
    UserModel getByDocument(String document);
}
