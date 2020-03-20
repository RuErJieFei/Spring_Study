package com.soft1851.spring.web.serivce.Impl;

import com.soft1851.spring.web.dao.ForumDao;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.entity.ForumDto;
import com.soft1851.spring.web.serivce.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ForumServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/20 9:35 上午
 * @Version 1.0
 **/
@Service
public class ForumServiceImpl implements ForumService {
    private final ForumDao forumDao;

    public ForumServiceImpl(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Override
    public List<Forum> selectAll() {
        return forumDao.selectAll();
    }

    @Override
    public Forum get(Integer forumId) {
        return forumDao.get(forumId);
    }

    @Override
    public ResponseObject insert(ForumDto forumDto) {
        Forum forum = Forum.builder().forumName(forumDto.getName()).build();
        System.out.println(forumDao.insert(forum));
//        if (forumDao.insert(forum) == 1) {
//            return new ResponseObject(1, "成功");
//        }
        return new ResponseObject(400, "失败");
    }
}
