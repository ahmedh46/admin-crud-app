package com.my.admin.app.adminapp.users.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.admin.app.adminapp.users.usersjpa.Users;
import com.my.admin.app.adminapp.users.usersjpa.UsersRepository;

@Service
public class UsersService {

    @Autowired
    UsersRepository userRepository;

    public Users getUserByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    public List<Users> findAll() {
        return (List<Users>) userRepository.findAll();
    }
}
