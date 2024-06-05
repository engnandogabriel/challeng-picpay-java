package com.project.picpay.domain.gateway;

public interface AuthorizationGateway {
    boolean authorize() throws Exception;
}