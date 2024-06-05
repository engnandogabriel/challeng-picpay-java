package com.project.picpay.controller;

import com.project.picpay.application.useCases.CreateUser;
import com.project.picpay.application.useCases.GetAllUsers;
import com.project.picpay.domain.DTO.Response;
import com.project.picpay.domain.DTO.UserDTO;
import com.project.picpay.domain.HandlerService.HandlerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Handler;

@RequestMapping(value = "users")
@RestController
public class UserController {

    private CreateUser createUser;
    private GetAllUsers getAllUsers;

    public UserController(CreateUser createUser, GetAllUsers getAllUsers) {
        this.createUser = createUser;
        this.getAllUsers = getAllUsers;
    }

    @GetMapping(value = "")
    public ResponseEntity<HandlerDTO> getALl() {
        HandlerDTO output = this.getAllUsers.execute();
        return new ResponseEntity<>(output, output.status());
    }

    @PostMapping(value = "")
    public ResponseEntity<HandlerDTO> save(@RequestBody UserDTO userDTO) {
        HandlerDTO output = this.createUser.execute(userDTO);
        return new ResponseEntity<>(output, output.status());

    }
}
