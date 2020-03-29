package com.springbootredis.web;

import com.springbootredis.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author norhtking
 */
@RestController
public class UserController {

    @GetMapping("/getUser")
    @Cacheable(value = "user-key")
    public User gerUser(){
        User user = new User(2L, "xiaogang", "123456", "xiaogang@qq.com", "a", "1922-01-01");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
    
    @GetMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
