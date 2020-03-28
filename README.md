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
ctx.scan("com.soft1851.spring.orm.config");
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

## 实现XML配置版Spring MVC
* ### 由于一开始建立项目不是基于maven项目的

  ### 所以web文件夹目录跟src同级，所以导致监听器无法找到

* ### 在测试借口时候注解的用法要注意

* ### 字符设置（虽然老师帮忙基本解决了）

耦合性 (计算机科学)：一程式的模组之间资讯或参数流动的程度

解耦，就是将程序积⽊化 就像我们玩的积⽊⼀样，各个积⽊可以组合在⼀起⽽形成⼀个形状，⼜可以拆分，⼜可以替换，因 为基本上 各个积⽊块都是独⽴的，只要他们之间的接⼝（形状）匹配，就可以灵活地组合在⼀起。 当然，这是理想状态。解耦是在逐渐达到这个理想状态。

解耦通俗地说就是两个东⻄原来互相影响，现在让他们独⽴发展；核⼼思想还是最⼩职责，每个地 ⽅都只做⼀件事情；只要⼀个地⽅负责了多项事情，就存在解耦的可能。在系统每个层次都可以体 现解耦的思想，⽐如在架构层⾯把存储和业务逻辑解耦，把动态⻚⾯和静态⻚⾯解耦；在模块层⾯ 把业务模块和统计模块解耦；在代码层⾯把多个功能解耦等等。解耦的思想很好，但是没必要为了 解耦⽽解耦，还是要从业务需求以及系统定位出发，满⾜⼀段时间内系统发展的需要即可。

"低耦合、⾼内聚"是⾃然界进化的普遍规律，以追求消耗最⼩的能量。 在软件中，低耦合，⾼内聚---是指模块之间低耦合、模块内部⾼内聚。这个软件系统的进化过程是 由程序员参与的过程，以追求软件系统的可重⽤和易维护---也是追求消耗最⼩的能量。 ⼀个软件系统由多个模块组成，在划分模块时，要把功能关系紧密的放到⼀个模块中(⾼内聚)，功 能关系远的放到其它模块中。 模块之间的联系越少越好，接⼝越简单越好(低耦合，细线通信)。如果划分的模块之间接⼝很复杂 (java中接⼝中函数个数太多，或c中.h中public的函数太多，或c++中纯虚函数太多)，说明功能划分 得不太合理，模块之间的耦合太⾼了，同时也说明某模块的内聚也不⾼。

关于爬虫来说 注意类型和结构，理清结构，细心分析，类型转换，不论是html文本还是Json数据

将@Controller标记在某个类上，配合@RequestMapping注解，可以在一个类中定义多个接口，这样使用起来更加灵活，如果没@ResponseBody就返回的是视图对象，否则返回的是一个JSON字符串。
若使用@RestController，则接下来每个方法都需要使用@RequestMapping，则所有返回形式都要是JSON

# Spring 事务处理

## 三种情形

### 1.开始事务处理并捕捉异常并回滚

``` @Transactional(rollbackFor = Exception.class)
@Transactional(rollbackFor = Exception.class)

 try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
```



​	结果：测试报错，数据库不会插入数据



### 2.开启事务处理没有指定异常回滚

​	但是Spring自动检测到运行时异常 RuntimeException 自动回滚

``` 
@Transactional

 try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
```

​	

​	结果：测试报错，数据库不会插入数据



### 3.开启事务处理没有指定异常回滚，并且没有抛出运行时异常

​	结果：测试通过，数据库插入一条数据



![](https://user-gold-cdn.xitu.io/2019/4/21/16a3e7b7a6894434?imageslim)

## 事务的ACID特性

###  A（atomicity），原子性。原子性指整个数据库事务是不可分割的工作单位。只有使事务中所有的数据库操作都执行成功，整个事务的执行才算成功。事务中任何一个SQL语句执行失败，那么已经执行成功的SQL语句也必须撤销，数据库状态应该退回到事务前的状态。

### C（consistency），一致性。一致性是指事务将数据库从一种状态转变为另一种状态。在事务的开始之前和事务结束以后，数据库的完整性约束没有被破坏。

### I（isolation），隔离性。隔离性还有其他的称呼，如并发控制、可串行化、锁。事务的隔离性要求每个读写事务的对象与其他事务的操作对象能互相分离，即该事务提交前对其他事务都不可见，这通常使用锁来实现。数据库系统中提供了一种粒度锁的策略，允许事务仅锁住一个实体对象的子集，以此来提高事务之间的并发度。（如果是全表锁，事务之间基本就无法实现并发，但是如果只锁住表中处理的行，可以提高事务的并发度）

### D（durability），持久性。事务一旦提交，其结果就是永久性的。即使发生宕机等故障，数据库也能将数据恢复。需要注意的是，持久性只能从事务本身的角度来保证结果的永久性，如事务提交后，所有的变化都是永久的，即使当数据库由于崩溃而需要恢复时，也能保证恢复后提交的数据都不会丢失。

## 事务分类

- 扁平事务，最简单，使用最频繁的事务。在扁平事务中，所有的操作都处于一个层次，其有BEGIN WORK开始，有COMMIT WORK或ROLLBACK WORK结束。处于之间的操作是原子的，要么全部执行，要么全部回滚。
- 带有保存点的扁平事务，除了扁平事务支持的操作外，允许在事务执行过程中回滚到同一事务中较早的一个状态，这是因为可能有些事务在执行过程中出现的错误并不会对有的操作都无效，放弃整个事务不合乎要求，开销也太大。保存点用来通知系统应该记住事务当前的状态，以便以后发生错误时，事务能回到该状态。
- 链事务可视为保存点模式的一个变种。
- 嵌套事务是一个层次结构框架。
- 分布式事务

## 事务的隔离级别

ANSI SQL标准定义的四个隔离级别为：

1. READ UNCOMMITTED（未提交读），事务中的修改，即使没有提交，在其他事务也都是可见的。事务可以读取未提交的数据，这也被称为脏读。
2. READ COMMITTED（提交读），一个事务从开始直到提交之前，所做的任何修改对其他事务都是不可见的。这个级别有时候也叫做不可重复读，因为两次执行相同的查询，可能会得到不一样的结果。因为在这2次读之间可能有其他事务更改这个数据，每次读到的数据都是已经提交的。
3. REPEATABLE READ（可重复读），解决了脏读，也保证了在同一个事务中多次读取同样记录的结果是一致的。但是理论上，可重读读隔离级别还是无法解决另外一个幻读的问题，指的是当某个事务在读取某个范围内的记录时，另外一个事务也在该范围内插入了新的记录，当之前的事务再次读取该范围内的记录时，会产生幻行。
4. SERIALIZABLE（可串行化），它通过强制事务串行执行，避免了前面说的幻读的问题。

1、脏读（dirty read）：一个事务可以读取另一个尚未提交事务的修改数据。

2、不可重复读（nonrepeatable read）：在同一个事务中，同一个查询在T1时间读取某一行，在T2时间重新读取这一行时候，这一行的数据已经发生修改，可能被更新了（update），也可能被删除了（delete）。

3、幻像读（phantom read）：在同一事务中，同一查询多次进行时候，由于其他插入操作（insert）的事务提交，导致每次返回不同的结果集。

## 事务控制语句

在 MySQL 命令行的默认设置下，事务都是自动提交（auto commit）的，即执行 SQL 语句之后就会马上执行 COMMIT 操作。因此要显式的开启一个事务需要使用命令`BEGIN`、`START TRANSACTION`，或者执行命令`SET AUTOCOMMIT=0`，禁用当前会话的自动提交。每个数据库厂商自动提交的设置都不相同，每个 DBA 或开发人员需要非常明白这一点，这对之后的 SQL 编程会有非凡的意义，因此用户不能以之前的经验来判断 MySQL 数据库的运行方式。在具体介绍其含义之前，先看看有哪些事务控制语句：

- `START TRANSACTION|BEGIN`：显式地开启一个事务。
- `COMMIT`：提交事务，等价于`COMMIT WORK`。
- `ROLLBACK`：回滚会结束用户的事务，并撤销正在进行的所有未提交的修改。等价于`ROLLBACK WORK`
- `SAVEPOINT identifier`：`SAVEPOINT`允许在事务中创建一个保存点，一个事务中可以有多个保存点。
- `ROLLBACK TO[SAVEPOINT] identifier`：这个语句与`SAVEPOINT`命令一起使用。可以把事务回滚到标记点，而不回滚在此标记点之前的任何工作。例如可以发出两条`UPDATE`语句，后面跟一个`SAVEPOINT`，然后又是两条`DELETE`语句。如果执行`DELETE`语句期间出现了某种异常情况，并且捕获到了这个异常，同时发出了`ROLLBACK TO SAVEPOINT`命令，事务就会回滚到指定的`SAVEPOINT`，撤销`DELETE`完成的所有工作，而`UPDATE`语句完成的工作不受影响。
- `SET TRANSACTION`：这个语句用来设置事物的隔离级别。InnoDB 存储引擎提供的事务隔离级别有：`READ UNCOMMITTED`、`READ COMMITTED`、`REPEATABLE READ`、`SERIALISZABLE`。

`START TRANSACTION`、`BEGIN`语句都可以在 MySQL 命令行下显式地开启一个事务。但是在存储过程中，MySQL数据库的分析器会自动将`BEGIN`识别为`BEGIN END`，因此在存储过程中只能使用`START TRANSACTION`语句来开启一个事务。

`COMMIT`和`COMMIT WORK`语句基本是一致的，都是用来提交事务。不同之处在于`COMMIT WORK`用来控制事务结束后的行为是`CHAIN`还是`RELEASE`的。如果是`CHAIN`方式，那么事务就变成了链事务。

InnoDB 存储引擎中的事务都是原子的，这说明下述两种情况：构成事务的每条语句都会提交（成为永久），或者所有语句都回滚。这种保护还延伸到单个的语句。一套语句要么完全成功，要么完全回滚（注意，这里说的是语句回滚）。因此一条语句失败并抛出异常时，并不会导致先前已经执行的语句自动回滚。所有的执行都会得到保留，必须由用户自己来决定是否对其进行提交或回滚的操作。

另一个容易犯的错误是`ROLLBACK TO SAVEPOINT`，虽然有`ROLLBACK`，但其实并不真正的结束一个事务，因此即使执行了`ROLLBACK TO SAVEPOINT`，之后也需要显式地运行`COMMIT`或`ROLLBACK`命令。

# 爬虫基本原理

## 爬虫的对象是你看到的网页

## 其一般步骤为

### 1. 发送网络请求（模拟浏览器环境，做好相应的配置）

<img src="https://ruerjiefei.oss-cn-hangzhou.aliyuncs.com/images/20200328111915.png"/>

### 2. 获取相应内容（内容格式转换）

<img src="https://ruerjiefei.oss-cn-hangzhou.aliyuncs.com/images/20200328111934.png"/>

### 3. 解析内容

![image-20200328111953973](/Users/xiaobinggan/Library/Application Support/typora-user-images/image-20200328111953973.png)

### 4. 保存数据（做好持久化 ）

## 总结：完成基本步骤结合相关API

# java爬虫 httpclient htmlunit selenium 比较



1. httpclient

httpclient 是 HttpClient 是 Apache Jakarta Common 下的子项目 ，支持常用的各种协议，相对比较底层，很多java项目的互联网编程都是依赖于该包 。

2. htmlunit

  相当与一个没有ui的浏览器，本身就是对httpclient进行封装。

 而且由于htmlunit 本身是对httpclient的封装，加上其有对于js，css等的加载，其运行速度相对要比httpclient 慢的多，看起来似乎没有优势。其实不然，导致htmlunit慢的主要原因就是在于对于js，css的加载 。很多时候这个是非常必要的。

3. selenium

   这个最早是基于firfox的自动化测试软件，现在也支持其他的浏览器，比如ie，chrome 等，同时提供了多语言的接口，如python，java 等，其功能是完全模仿浏览器行为，对于爬虫而言是最后的利器。

selenium相对而言则更暴力，他对于每一个浏览器提供不同的插件（htmlunit的也有），可以完全模仿人对于浏览器操作，在使用selenium时，你真的可以看到一个个页面的打开关闭，看到鼠标的移动，文字的键入，所以用selenium ，只要是人能在操作的，他都能做到，缺点就是速度是最慢的，而且你还得在电脑里安装相应的浏览器，要有专门的驱动程序（而且对于linux支持也不好）。

原文链接：https://blog.csdn.net/qq_34661726/article/details/80585659

以我的理解来解释说这三种，每种都有他存在的意义，httpclient兼容，强劲，可靠；htmlunit无浏览器界面，但可以模拟浏览器操作；selenium直接进行浏览器操作，自动化测试。

相对来说 更多工具提供更多选择，更多技术选型提供更完善的策略，到目前为止，我在接触更多知识广度，以后完成相对应工作就有可能往深度去提升。



