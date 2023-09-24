package com.fangzheng.consumer.controller;

import com.fangzheng.api.pojo.User;
import com.fangzheng.api.provider.UserListProvider;
import com.fangzheng.api.provider.UserProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserProvider userProvider;

    @Resource
    private UserListProvider userListProvider;

    @GetMapping("/info/{userId}")
    public User getUserInfo(@PathVariable("userId") String userId){
        return userProvider.getUser(userId);
    }

    @GetMapping("/list")
    public List<User> getList(){
        return userListProvider.getList();
    }
}
