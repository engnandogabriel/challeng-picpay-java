package com.project.picpay.domain.gateway;

import com.project.picpay.domain.entities.user.User;

public interface EmailGateway {
    void sender(User from, User to, Double value);
}
