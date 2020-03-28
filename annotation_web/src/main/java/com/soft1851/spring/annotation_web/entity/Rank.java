package com.soft1851.spring.annotation_web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Rank
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/27 3:17 下午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rank {
    private String id;
    private String cover;
    private String title;
}
