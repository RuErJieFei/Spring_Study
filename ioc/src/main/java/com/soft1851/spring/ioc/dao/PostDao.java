package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;

import java.util.List;

/**
 * @ClassName PostDao
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 5:25 下午
 * @Version 1.0
 **/
public interface PostDao {
    /**
     * 新增Post
     *
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     * 批量新增posts
     *
     * @param posts
     * @return
     */
    int[] batchInsert(List<Post> posts);

    /**
     * 根据id删除Post
     *
     * @param postId
     * @return
     */
    int delete(int postId);

    /**
     * 修改Post
     *
     * @param post
     * @return
     */
    int update(Post post);

    /**
     * 根据id查询Post
     *
     * @param postId
     * @return
     */
    Post get(int postId);

    /**
     * 查询所有帖子信息
     *
     * @return
     */
    List<Post> selectAll();
}