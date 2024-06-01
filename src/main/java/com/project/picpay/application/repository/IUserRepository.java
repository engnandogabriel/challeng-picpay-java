package com.project.picpay.application.repository;

import com.project.picpay.domain.entities.user.User;

import java.util.Optional;

public interface IUserRepository {
    void save(User user) throws Exception;
    Optional<User> getByEmail(String email) throws Exception;
    Optional<User> getByDocument(String document) throws Exception;
    Optional<User> getById(String id) throws Exception;
}
