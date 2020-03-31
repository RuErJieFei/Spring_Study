package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ForumServiceTest {
    @Resource
    private ForumService forumService;


    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("今日头条").build();
        forumService.insert(forum);
        System.out.println(forum.getForumId());
    }

    @Test
    public void delete() {
        forumService.delete(6);
    }


    @Test
    public void update() {
        forumService.update(Forum.builder().forumId(4).forumName("Update").build());
    }

    @Test
    public void selectAll() throws IOException {
        System.out.println(forumService.selectAll().size());
    }

    @Test
    public void selectForumById() {
        System.out.println(forumService.selectForumById(3));

    }

    @Test
    public void selectPostsByForumId() {
        forumService.selectPostsByForumId(1).forEach(System.out::println);
    }
}