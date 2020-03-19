# 关于Spring的配置和注解说明
## 1.关于xml方式来做bean的配置
* <bean>标签的使用:id class
* 构造器注入:ref引用其他对象
* setter注入: p:简写形式

## 2.两种方式获取xml中的bean
* Application得到上下文、ac.getBean(""")，main方式使用
* @Autowired注解，单元测试使用，注意命名规范

## 3.基于Java类来做bean的配置(主流)
* 配置类 一定要加上@Configuration
* 配置中配置bean的方法，要加上@Bean注解\
```$xslt
@Configuration
public class AppConfig {
    @Bean
    public Book book(){
        return new Book();
    }
}
```
## 4.如何在SpringFramework中获取Java类配置bean
* 单元测试
```$xslt
//生成基于注解配置的应用上下文对象
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//手动开启扫包
ctx.scan("com.soft1851.spring.ioc.config");
ctx.refresh();
Book book = (Book) ctx.getBean("book");
book.setName("java");
book.setPrice(88.8);
System.out.println(book)
```
## 步骤

### 1. config类

- SpringDataSourceConfig

  - 定义DruidDataSource

    * 其中构造器注入

      * driverClassName

      * url（<font color="#ba6056">注意字符集设置</font>）

      * username

      * password

        ·········

  - 定义JdbcTemplate

    - 引用上面配置的dataSource（<font color="#ba6056">注意引用形式</font>）

      ```
          @Bean
          public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {
              //ref
              return new JdbcTemplate(druidDataSource);
          }
      ```

      也可以使用这种

      ```
          @Bean
          public JdbcTemplate jdbcTemplate() {
              //ref
              return new JdbcTemplate(dataSource());
          }
      ```

      

  - 定义ForumDao（<font color="#ba6056">如果采用自动引入可以不要创建Bean</font>）

    - 如果创建ForumDao需要在ForumDaoImpl中定义JdbcTemplate属性，添加构造方法

      ``` 
      private JdbcTemplate jdbcTemplate;
      ```

      ``` 
      public ForumDaoImpl(JdbcTemplate jdbcTemplate) {
              this.jdbcTemplate = jdbcTemplate;
          }
      ```

       建议使用这种

      ``` 
      public ForumDaoImpl(JdbcTemplate jdbcTemplate) {
              this.setJdbcTemplate(jdbcTemplate);
          }
      
      public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
              this.jdbcTemplate = jdbcTemplate;
          }
      ```

      

### 2.SpringDataSourceConfigTest类

- 生成基于注解配置的应用上下文对象

  - 手动扫包

  - 获取ForumDao

  ```
  ForumDao forumDao = (ForumDao) ctx.getBean("forumDao");
  ```

  - 调用ForumDaoImpl中的方法

* @Autowired获取对象

  ``` 
  @Autowired
  private ForumDao forumDao;
  ```

  * 调用ForumDaoImpl中的方法

## 注意点

- SpringDataSourceConfig中@Configuration和@ComponentScan注解，创建bean的时候每个方法上面加上@Bean注解
- ForumDaoImpl中的@Repository或者@Component注解
- SpringDataSourceConfigTest中的@ContextConfiguration(classes = {SpringDataSourceConfig.class})注解

