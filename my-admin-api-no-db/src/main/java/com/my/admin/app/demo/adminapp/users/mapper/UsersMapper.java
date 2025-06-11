
package com.my.admin.app.demo.adminapp.users.mapper;

import com.my.admin.app.demo.adminapp.users.usersjpa.Users;
import com.my.admin.app.demo.adminapp.webmodel.UserLoginRequest;

public class UsersMapper {

    public static UserLoginRequest mapUsersToUserLoginRequest(Users user) {
        return toUserLoginRequest(user);
    }

    private static UserLoginRequest toUserLoginRequest(Users user) {
        if (user == null) {
            return null;
        }
        return new UserLoginRequest(user.getUserName(), user.getPassword());
    }
}
