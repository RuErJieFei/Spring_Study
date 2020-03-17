package com.soft1851.spring.ioc.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private Map<Student, String> likeToDo;
    private Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

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

    public Map<Student, String> getLikeToDo() {
        return likeToDo;
    }

    public void setLikeToDo(Map<Student, String> likeToDo) {
        this.likeToDo = likeToDo;
    }
}
