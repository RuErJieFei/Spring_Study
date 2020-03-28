package com.soft1851.spring.annotation_web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Fruit
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/24 3:34 下午
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fruit {
    private String name;
    private String img;
    private String intro;
    private String color;
}
