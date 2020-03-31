package com.soft1851.spring.mybatis.service.Impl;

import com.soft1851.spring.mybatis.entity.Forum;
import com.soft1851.spring.mybatis.entity.Post;
import com.soft1851.spring.mybatis.mapper.ForumMapper;
import com.soft1851.spring.mybatis.service.ForumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ForumServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/30 9:13 上午
 * @Version 1.0
 **/
@Service
public class ForumServiceImpl implements ForumService {
    @Resource
    private ForumMapper forumMapper;

    @Override
    public int insert(Forum forum) {
        return forumMapper.insert(forum);
    }

    @Override
    public void delete(int id) {
        forumMapper.delete(id);
    }

    @Override
    public List<Post> selectPostsByForumId(int id) {
        return forumMapper.selectPostsByForumId(id);
    }

    @Override
    public void update(Forum forum) {
        forumMapper.update(forum);
    }


    @Override
    public List<Forum> selectAll() {
        return forumMapper.selectAll();
    }

    @Override
    public Forum selectForumById(int id) {
        return forumMapper.selectForumById(id);
    }
}
