package com.soft1851.spring.annotation_web.dao;

import com.soft1851.spring.annotation_web.config.SpringDataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName TopicDaoTest
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/26 10:06 上午
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicDaoTest {
    @Autowired
    private TopicDao topicDao;

    @Test
    public void selectAll() {
        topicDao.selectAll().forEach(System.out::println);
    }

}
