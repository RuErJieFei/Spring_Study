package com.soft1851.spring.ioc.entity;

import java.util.List;

/**
 * @ClassName Hobbies
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 9:37 上午
 * @Version 1.0
 **/
public class Hobbies {
    private List<String> hobbies;
    private List<Phone> phones;

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phone) {
        this.phones = phone;
    }

}
