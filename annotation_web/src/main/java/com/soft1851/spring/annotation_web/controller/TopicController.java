package com.soft1851.spring.annotation_web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.annotation_web.common.ResponseObject;
import com.soft1851.spring.annotation_web.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName TopicController
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/27 10:02 上午
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/")
public class TopicController {
    @Resource
    private TopicService topicService;

    @RequestMapping(value = "topics", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTopics() {
        ResponseObject rs = new ResponseObject(1, "success", topicService.queryAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/topic")
    public String topic(Model model) {
        model.addAttribute("topics", topicService.queryAll());
        return "topic";
    }
}
