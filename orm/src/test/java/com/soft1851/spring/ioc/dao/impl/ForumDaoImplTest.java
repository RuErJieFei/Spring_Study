package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.config.DataSourceConfig;
import com.soft1851.spring.ioc.dao.ForumDao;
import com.soft1851.spring.ioc.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/applicationContext.xml"})
@ContextConfiguration(classes = {DataSourceConfig.class})
public class ForumDaoImplTest {

    @Autowired
    private ForumDao forumDao;

    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("测试论坛").build();
        int n = forumDao.insert(forum);
        assertEquals(1, n);
    }

    @Test
    public void batchInsert() {
        List<Forum> forumList = new ArrayList<>(3);
        Collections.addAll(forumList, Forum.builder().forumName("测试论坛").build(),
                Forum.builder().forumName("测试论坛").build(),
                Forum.builder().forumName("测试论坛").build());
        int[] n = forumDao.batchInsert(forumList);
        System.out.println(Arrays.toString(n));
    }

    @Test
    public void delete() {
        int n = forumDao.delete(7);
        assertEquals(1, n);
    }

    @Test
    public void update() {
        Forum forum = Forum.builder().forumName("Updated_Name").forumId(1).build();
        int n = forumDao.update(forum);
        assertEquals(1, n);
    }

    @Test
    public void get() {
        Forum forum = forumDao.get(1);
        System.out.println(forum.toString());
    }

    @Test
    public void selectAll() {
        List<Forum> forumList = forumDao.selectAll();
        forumList.forEach(System.out::println);
    }
}