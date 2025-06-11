package com.my.admin.app.demo.adminapp.webmodel;

import jakarta.validation.constraints.NotNull;

public record UserLoginRequest(
    @NotNull String userName,
    @NotNull String password
) {
    @Override
    public String toString() {
        return "UserLoginRequest[userName=" + userName + ", password=****]";
    }
}
