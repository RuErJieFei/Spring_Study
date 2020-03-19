package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Student
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/12 10:43 上午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String name;
    private Phone phone;
    private List<Phone> phones;
    private Map<String, String> contact;
}
