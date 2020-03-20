package com.soft1851.spring.web.serivce;

import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.entity.ForumDto;
import com.soft1851.spring.web.util.ResponseObject;

import java.util.List;

/**
 * @ClassName ForumService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/20 9:33 上午
 * @Version 1.0
 **/
public interface ForumService {
    /**
     * 查询所有论坛
     *
     * @return
     */
    List<Forum> selectAll();

    /**
     * 根据id查询论坛
     *
     * @param forumId
     * @return
     */
    Forum get(Integer forumId);

    /**
     * 插入一条论坛数据
     *
     * @param forumDto
     * @return
     */
    ResponseObject insert(ForumDto forumDto);
}