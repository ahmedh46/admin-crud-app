package com.my.admin.app.demo.adminapp.webmodel;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "password")
public class UserLoginRequest {

    @NotNull
    private String userName;

    @NotNull
    private String password;
}
