package com.soft1851.spring.ioc.entity;

/**
 * @ClassName UserLogin
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/13 10:45 上午
 * @Version 1.0
 **/
public class UserLogin {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean userLogin(User user) {
        return user.getAccount().equals("admin") && user.getPassword().equals("111");
    }

}
