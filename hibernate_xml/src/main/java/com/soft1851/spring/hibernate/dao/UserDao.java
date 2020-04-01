package com.soft1851.spring.hibernate.dao;

import com.soft1851.spring.hibernate.entity.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/1
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 新增
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 删除
     *
     * @param user
     */
    void deleteUser(User user);

    /**
     * 删除
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 按主键查
     *
     * @param userId
     * @return
     */
    User getUser(Integer userId);

    /**
     * 查所有
     *
     * @return
     */
    List<User> selectAll();
}
