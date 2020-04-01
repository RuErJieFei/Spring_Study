package com.soft1851.spring.hibernate.dao.Impl;

import com.soft1851.spring.hibernate.dao.UserDao;
import com.soft1851.spring.hibernate.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-hibernate.xml"})
public class UserDaoImplTest {
    @Resource
    private UserDao userDao;

    @Test
    public void insertUser() {
        User user =  User.builder().userName("Java").age(20).build();
        userDao.insertUser(user);
    }

    @Test
    public void deleteUser() {
        User user = User.builder().userId(2).build();
        userDao.deleteUser(user);
    }

    @Test
    public void updateUser() {
        User user = userDao.getUser(3);
        user.setUserName("hello");
        userDao.updateUser(user);
    }

    @Test
    public void getUser() {
        System.out.println(userDao.getUser(1));
    }

    @Test
    public void selectAll() {
    }
}