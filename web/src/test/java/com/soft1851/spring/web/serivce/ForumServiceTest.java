package com.soft1851.spring.web.serivce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class ForumServiceTest {

    @Autowired
    private ForumService forumService;
    @Test
    public void selectAll() {
        forumService.selectAll().forEach(System.out::println);
    }
}