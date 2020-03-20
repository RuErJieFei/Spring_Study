package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName DataSource
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/19 8:16 上午
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.orm")
public class DataSourceConfig {
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/bbs?" +
                "true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setInitialSize(8);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {
        //ref
        return new JdbcTemplate(druidDataSource);
    }

//    @Bean
//    public ForumDao forumDao(JdbcTemplate jdbcTemplate) {
//        //ref
//        return new ForumDaoImpl(jdbcTemplate);
//    }

}
