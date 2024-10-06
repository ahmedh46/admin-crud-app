package com.my.admin.app.adminapp.users.usersjpa;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {

    @Id
    private long userId;

    private String userName;

    private String firstName;

    private String lastName;

    private Timestamp createdDate;

    private String password;
}
