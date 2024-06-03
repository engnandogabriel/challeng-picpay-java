package com.project.picpay.domain.HandlerService;

import org.springframework.http.HttpStatus;

public record HandlerDTO<T>(HttpStatus status, String message, T body) {

}
