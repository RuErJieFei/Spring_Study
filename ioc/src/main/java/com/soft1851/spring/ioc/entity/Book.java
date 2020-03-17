package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Book
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 10:38 上午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private Double price;
}
