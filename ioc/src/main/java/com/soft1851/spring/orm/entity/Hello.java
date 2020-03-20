package com.soft1851.spring.orm.entity;

import lombok.Data;

/**
 * @ClassName Hello
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 8:45 上午
 * @Version 1.0
 **/
@Data
public class Hello {
    public void sayHello() {
        System.out.println("hello");
    }
}
