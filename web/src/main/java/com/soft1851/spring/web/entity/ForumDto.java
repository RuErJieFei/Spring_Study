package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ForumDto
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/20 1:37 下午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForumDto {
    private String name;
}
