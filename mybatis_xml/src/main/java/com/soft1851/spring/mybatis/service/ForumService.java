package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Forum;
import com.soft1851.spring.mybatis.entity.Post;

import java.util.List;

/**
 * @ClassName ForumService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/30 9:13 上午
 * @Version 1.0
 **/
public interface ForumService {

    /**
     * 新增实体
     *
     * @param forum
     */
    int insert(Forum forum);

    /**
     * 根据id删除
     *
     * @param id
     */
    void delete(int id);

    /**
     * 修改
     *
     * @param forum
     */
    void update(Forum forum);

    /**
     * 查询所有
     *
     * @return
     */
    List<Forum> selectAll();

    List<Post> selectPostsByForumId(int id);

    /**
     * 根据id查询Forum
     *
     * @param id
     * @return Forum
     */
    Forum selectForumById(int id);
}
