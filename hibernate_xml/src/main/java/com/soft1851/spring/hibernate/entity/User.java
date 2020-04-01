package com.soft1851.spring.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/1
 * @Version 1.0
 */
@Entity    //标识该类是Hibernate的实体类，最好实现序列化接口
@Table(name="t_user")//正向工程生成数据表的表名
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id            //声明属性为主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)	//主键自增
    @Column(name="user_id")	//数据库字段和类属性映射关系
    private Integer userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="age")
    private Integer age;
}