package com.fangzheng.api.provider;

import com.fangzheng.api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-provider", path = "/user", contextId = "user-detail")
public interface UserProvider {

    @GetMapping("/info/{userId}")
    User getUser(@PathVariable("userId") String userId);

}
