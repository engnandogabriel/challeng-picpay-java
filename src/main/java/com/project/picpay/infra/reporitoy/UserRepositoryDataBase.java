package com.project.picpay.infra.reporitoy;

import com.project.picpay.application.repository.IUserRepository;
import com.project.picpay.domain.entities.user.User;
import com.project.picpay.domain.entities.user.UserFactory;
import com.project.picpay.infra.database.UserJPA;
import com.project.picpay.infra.database.UserModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryDataBase implements IUserRepository {

    private UserJPA userJPA;

    public UserRepositoryDataBase(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    @Override
    public void save(User user) throws RuntimeException {
        UserModel userModel = new UserModel(user.getUser_id(), user.getName(), user.getDocument(), user.getEmail(), user.getPassword(), user.getType_user(), user.getAmount());
        this.userJPA.save(userModel);
    }

    @Override
    public Optional<User> getByEmail(String email) throws Exception  {
        UserModel userModel = this.userJPA.getByEmail(email);
        if (userModel != null) {
            User user = UserFactory.restore(userModel.getType_user(), userModel.getId(), userModel.getName(), userModel.getDocument(), userModel.getEmail(), userModel.getPassword(), userModel.getAmount());
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getByDocument(String document) throws Exception {
        UserModel userModel = this.userJPA.getByDocument(document);
        if (userModel != null) {
            User user = UserFactory.restore(userModel.getType_user(), userModel.getId(), userModel.getName(), userModel.getDocument(), userModel.getEmail(), userModel.getPassword(), userModel.getAmount());
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getById(String id) throws Exception{

        UserModel userModel = this.userJPA.getById(id);
        if (userModel != null) {
            User user = UserFactory.restore(userModel.getType_user(), userModel.getId(), userModel.getName(), userModel.getDocument(), userModel.getEmail(), userModel.getPassword(), userModel.getAmount());
            return Optional.of(user);
        }
        return Optional.empty();
    }

}

