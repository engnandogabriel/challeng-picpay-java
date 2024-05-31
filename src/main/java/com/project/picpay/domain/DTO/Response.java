package com.project.picpay.domain.DTO;

public record Response<T>(Number status, String message, T body) {
}
