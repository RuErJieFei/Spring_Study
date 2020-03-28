package com.soft1851.spring.annotation_web.dao;

import com.soft1851.spring.annotation_web.entity.Topic;

import java.util.List;

/**
 * @ClassName TopicDao
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/26 9:32 上午
 * @Version 1.0
 **/
public interface TopicDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<Topic> selectAll();

    /**
     * 批量新增
     *
     * @param topics
     * @return
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增一个
     *
     * @param topic
     * @return
     */
    int insert(Topic topic);
}
