package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.orm.entity.Forum;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName JdbcTest
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/19 9:40 上午
 * @Version 1.0
 **/
public class JdbcTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        JdbcTemplate jdbcTemplate = new JdbcTemplate((DruidDataSource) ctx.getBean("dataSource"));
        String sql = "SELECT forum_id , forum_name FROM t_forum WHERE forum_id = 1";

        System.out.println(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Forum.class)));

    }
}
