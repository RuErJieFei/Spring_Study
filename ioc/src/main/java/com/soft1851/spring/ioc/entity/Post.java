package com.soft1851.spring.ioc.entity;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @ClassName Post
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 5:25 下午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Post {
    private Integer postId;
    private Integer forumId;
    private String title;
    private String content;
    private String thumbnail;
    private LocalDateTime postTime;
}
