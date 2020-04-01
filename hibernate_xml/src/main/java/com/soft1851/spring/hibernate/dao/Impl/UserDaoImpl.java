package com.soft1851.spring.hibernate.dao.Impl;

import com.soft1851.spring.hibernate.dao.UserDao;
import com.soft1851.spring.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/1
 * @Version 1.0
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoImpl implements UserDao {
    @Resource
    private SessionFactory sessionFactory;

    /**
     * 获取和当前线程绑定的Session，用于一次数据库操作线程
     *
     * @return Session
     */
    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void insertUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
//        session.close();
    }

    @Override
    public void deleteUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(user);
//        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
//        session.close();
    }

    @Override
    public User getUser(Integer userId) {
        Session session = getSession();
        String hql = "from User where userId = :userId";
        Query query = session.createQuery(hql).setParameter("userId", userId);
//        session.close();
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> selectAll() {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from User";
        Query query = session.createQuery(hql);
//        session.close();
        return (List<User>) query.list();
    }
}
