package com.my.admin.app.adminapp.userscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.admin.app.adminapp.userjpa.Users;
import com.my.admin.app.adminapp.userservice.UsersService;
import com.my.admin.app.adminapp.webmodel.UserLoginRequest;

import jakarta.validation.Valid;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/users")
    Users login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        return usersService.getUserByUserNameAndPassword(userLoginRequest.getUserName(),
                userLoginRequest.getPassword());
    }

    @GetMapping("/users")
    List<Users> getUsers() {
        return usersService.findAll();
    }

}
