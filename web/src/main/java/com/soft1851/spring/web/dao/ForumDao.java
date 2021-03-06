package com.soft1851.spring.web.dao;


import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @ClassName ForumDao
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 3:20 下午
 * @Version 1.0
 **/
public interface ForumDao {
    /**
     * 新增Forum
     *
     * @param forum
     * @return
     */
    int insert(Forum forum);

    /**
     * 批量新增Forum
     *
     * @param forums
     * @return
     */
    int[] batchInsert(List<Forum> forums);

    /**
     * 根据id删除Forum
     *
     * @param forumId
     * @return
     */
    int delete(int forumId);

    /**
     * 修改Forum
     *
     * @param forum
     * @return
     */
    int update(Forum forum);

    /**
     * 根据id查询Forum
     *
     * @param forumId
     * @return
     */
    Forum get(int forumId);

    /**
     * 查询所有论坛信息
     *
     * @return
     */
    List<Forum> selectAll();
}