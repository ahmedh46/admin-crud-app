package com.my.admin.app.demo.adminapp.users.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.admin.app.demo.adminapp.users.usersjpa.Users;
import com.my.admin.app.demo.adminapp.users.usersjpa.UsersRepository;

@Service
public class UsersService {

    @Autowired
    UsersRepository userRepository;

    public Users getUserByUserNameAndPassword(String userName, String password) {
        Users user = new Users();
        user.setUserName(userName);
        user.setPassword(password);
        
        return user;
        //return userRepository.findByUserNameAndPassword(userName, password);
    }

    public List<Users> findAll() {
        Users user1 = new Users();
        user1.setUserName("john");
        user1.setPassword("password123");

        Users user2 = new Users();
        user2.setUserName("jane");
        user2.setPassword("secure456");

        return List.of(user1, user2);
        //return (List<Users>) userRepository.findAll();
    }
}
