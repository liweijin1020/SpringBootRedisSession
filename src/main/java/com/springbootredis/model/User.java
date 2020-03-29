package com.springbootredis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 不实现实例化接口无法存入redis
 * @author lwj
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String nickname;
    private String regTime;

    public User() {
    }

    public User(Long id, String userName, String password, String email, String nickname, String regTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.regTime = regTime;
    }
}
