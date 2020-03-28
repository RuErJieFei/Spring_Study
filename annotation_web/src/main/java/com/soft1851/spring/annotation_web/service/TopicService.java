package com.soft1851.spring.annotation_web.service;

import com.soft1851.spring.annotation_web.entity.Topic;

import java.util.List;

/**
 * @ClassName TopicService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/27 11:03 上午
 * @Version 1.0
 **/
public interface TopicService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Topic> queryAll();

    /**
     * 添加一个
     *
     * @param topic
     */
    void addTopic(Topic topic);

    /**
     * 批量插入
     *
     * @param topics
     * @return
     */
    int[] batchInsert(List<Topic> topics);
}
