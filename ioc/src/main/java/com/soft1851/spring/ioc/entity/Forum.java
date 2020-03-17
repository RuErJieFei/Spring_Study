package com.soft1851.spring.ioc.entity;

import lombok.*;

/**
 * @ClassName Forum
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 3:10 下午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Forum {
    private Integer forumId;
    private String forumName;
}
