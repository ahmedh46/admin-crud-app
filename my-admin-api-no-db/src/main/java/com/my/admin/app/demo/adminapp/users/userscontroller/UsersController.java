package com.my.admin.app.demo.adminapp.users.userscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.admin.app.demo.adminapp.users.usersjpa.Users;
import com.my.admin.app.demo.adminapp.users.userservice.UsersService;
import com.my.admin.app.demo.adminapp.webmodel.UserLoginRequest;

import jakarta.validation.Valid;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/users")
    Users login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        return usersService.getUserByUserNameAndPassword(userLoginRequest.userName(),
                userLoginRequest.password());
    }

    @GetMapping("/users")
    List<Users> getUsers() {
        return usersService.findAll();
    }

}
