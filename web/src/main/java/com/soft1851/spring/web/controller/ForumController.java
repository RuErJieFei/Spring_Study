package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.entity.ForumDto;
import com.soft1851.spring.web.serivce.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ForumController
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/20 10:21 上午
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "forum")
public class ForumController {
    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
    public String getForums() {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.selectAll());
        return JSON.toJSONString(ro);
    }

    @PostMapping(value = "/sig", produces = "application/json;charset=utf-8")
    public String getForum(@RequestParam Integer forumId) {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.get(forumId));
        return JSON.toJSONString(ro);
    }

    @PostMapping(value = "/body", produces = "application/json;charset=utf-8")
    public String addForum(@RequestBody ForumDto forumDto) {
        return JSON.toJSONString(forumService.insert(forumDto));
    }
}
