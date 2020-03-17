package com.soft1851.spring.ioc.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class UserLoginTest {

    @Autowired
    private User user;

    @Autowired
    private UserLogin userLogin;

    @Test
    public void login() {
        System.out.println(user.toString());
        if (userLogin.userLogin(user)) {
            System.out.println("登录成功");
        } else {
            System.out.println("账号或密码错误");
        }

    }
}