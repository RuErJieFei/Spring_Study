package com.soft1851.spring.orm.config;

import com.soft1851.spring.orm.entity.Book;
import com.soft1851.spring.orm.entity.Phone;
import com.soft1851.spring.orm.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @ClassName AppConfig
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 10:37 上午
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.orm")
public class AppConfig {
    @Bean
    public Book book() {
        return new Book();
    }

    @Bean
    public Phone phone() {
        return new Phone("iphone", 20.00);
    }

    @Bean
    public List<Phone> phones() {
        List<Phone> phoneList = new ArrayList<>(10);
        Phone phone1 = new Phone("huawei", 10.00);
        Collections.addAll(phoneList, phone1, phone());
        return phoneList;
    }

    @Bean
    public Student student(Phone phone) {
        Student student = new Student();
        student.setName("黎明");
        student.setPhone(phone);
        student.setPhones(phones());

        Map<String, String> contact = new HashMap<>();
        contact.put("玉溪", "17751680889");
        contact.put("肖龙", "15823512961");
        student.setContact(contact);
        return student;
    }


}
