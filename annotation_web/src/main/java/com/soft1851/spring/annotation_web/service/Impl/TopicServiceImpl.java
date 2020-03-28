package com.soft1851.spring.annotation_web.service.Impl;

import com.soft1851.spring.annotation_web.dao.TopicDao;
import com.soft1851.spring.annotation_web.entity.Topic;
import com.soft1851.spring.annotation_web.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TopicServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/27 11:03 上午
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicDao topicDao;

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        return topicDao.batchInsert(topics);
    }
}
