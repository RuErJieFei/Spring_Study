package com.soft1851.spring.annotation_web.service.Impl;

import com.soft1851.spring.annotation_web.config.SpringDataSourceConfig;
import com.soft1851.spring.annotation_web.entity.Topic;
import com.soft1851.spring.annotation_web.service.TopicService;
import com.soft1851.spring.annotation_web.spider.JueJinSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicServiceImplTest {

    @Resource
    private TopicService topicService;

    @Test
    public void queryAll() {
    }

    @Test
    public void addTopic() {
        topicService.addTopic(Topic.builder().id("1").topicName("同人")
                .topicIcon("Icon").description("描述").followsCount(123)
                .msgCount(213).followed(true).build());
    }

    @Test
    public void batchInsert() {
        int[] ints = topicService.batchInsert(JueJinSpider.getTopics());
        assertEquals(JueJinSpider.getTopics().size(), ints.length);
    }
}