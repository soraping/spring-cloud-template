package com.fangzheng.provider.controller;

import com.fangzheng.api.provider.UserListProvider;
import com.fangzheng.api.provider.UserProvider;
import com.fangzheng.api.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserProvider, UserListProvider {

    @Override
    public User getUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("张三");
        user.setAge(20);
        return user;
    }

    @Override
    public List<User> getList() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserId("12");
        user.setUserName("张三");
        user.setAge(20);
        users.add(user);
        return users;
    }
}
