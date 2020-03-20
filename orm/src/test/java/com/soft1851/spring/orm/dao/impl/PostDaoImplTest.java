package com.soft1851.spring.orm.dao.impl;

import com.soft1851.spring.orm.dao.PostDao;
import com.soft1851.spring.orm.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoImplTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void insert() {
        Post post = Post.builder().title("bean的几种配置").forumId(1).content("关于xml方式来做bean的配置" +
                "Application得到上下文、ac.getBean(\"\"\")，main方式使用" +
                "@Autowired注解，单元测试使用，注意命名规范" +
                "基于Java类来做bean的配置(主流)").postTime(LocalDateTime.now()).build();
        int n = postDao.insert(post);
        assertEquals(1, n);
    }

    @Test
    public void batchInsert() {
        List<Post> postList = new ArrayList<>(3);
        Collections.addAll(postList, Post.builder().title("bean的几种配置").forumId(1).content("关于xml方式来做bean的配置" +
                        "Application得到上下文、ac.getBean(\"\"\")，main方式使用" +
                        "@Autowired注解，单元测试使用，注意命名规范" +
                        "基于Java类来做bean的配置(主流)").postTime(LocalDateTime.now()).build(),
                Post.builder().title("bean的几种配置").forumId(1).content("关于xml方式来做bean的配置" +
                        "Application得到上下文、ac.getBean(\"\"\")，main方式使用" +
                        "@Autowired注解，单元测试使用，注意命名规范" +
                        "基于Java类来做bean的配置(主流)").postTime(LocalDateTime.now()).build(), Post.builder().title("bean的几种配置").forumId(1).content("关于xml方式来做bean的配置" +
                        "Application得到上下文、ac.getBean(\"\"\")，main方式使用" +
                        "@Autowired注解，单元测试使用，注意命名规范" +
                        "基于Java类来做bean的配置(主流)").postTime(LocalDateTime.now()).build());
        int[] n = postDao.batchInsert(postList);
        System.out.println(Arrays.toString(n));
    }

    @Test
    public void delete() {
        int n = postDao.delete(4);
    }

    @Test
    public void update() {
        Post post = Post.builder().title("Update_Name").content("Update_Content")
                .forumId(1).thumbnail("https://ruerjiefei.oss-cn-hangzhou.aliyuncs.com/images/IMG_1767.jpeg")
                .postTime(LocalDateTime.now()).postId(1).build();
        int n = postDao.update(post);
        assertEquals(1, n);
    }

    @Test
    public void get() {
        Post post = postDao.get(1);
        System.out.println(post.toString());
    }

    @Test
    public void selectAll() {
        List<Post> postList = postDao.selectAll();
        postList.forEach(System.out::println);
    }

    @Test
    public void count() {
        int n = postDao.count();
        System.out.println(n);
    }

    @Test
    public void selectByKey() {
        postDao.selectByKey("1").forEach(System.out::print);
    }
}