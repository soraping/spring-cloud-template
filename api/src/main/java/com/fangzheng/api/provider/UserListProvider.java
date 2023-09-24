package com.fangzheng.api.provider;

import com.fangzheng.api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "user-provider", contextId = "user-list", path = "/user")
public interface UserListProvider {

    @GetMapping("/list")
    List<User> getList();

}
