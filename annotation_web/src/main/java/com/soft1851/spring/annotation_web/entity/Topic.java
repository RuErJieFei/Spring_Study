package com.soft1851.spring.annotation_web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Topic
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/26 9:32 上午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topic {
    private String id;
    private String topicName;
    private String topicIcon;
    private String description;
    private Integer msgCount;
    private Integer followsCount;
    private Boolean followed;
}
