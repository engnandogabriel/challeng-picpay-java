package com.project.picpay.controller;

import com.project.picpay.application.useCases.CreateUser;
import com.project.picpay.domain.DTO.Response;
import com.project.picpay.domain.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "users")
@RestController
public class UserController {

    private CreateUser createUser;

    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        Response output = this.createUser.execute(userDTO);
        return ResponseEntity.ok(output);

    }
}
