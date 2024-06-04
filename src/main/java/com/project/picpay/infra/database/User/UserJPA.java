package com.project.picpay.infra.database.User;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJPA extends JpaRepository<UserModel, String > {
    UserModel getByEmail(String email);
    UserModel getByDocument(String document);

    @Modifying
    @Transactional
    @Query("UPDATE UserModel u SET u.amount = :amount WHERE u.user_id = :user_id")
    void changeAmount(@Param("amount") Double amount, @Param("user_id") String user_id);

}