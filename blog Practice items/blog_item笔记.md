# 导学

1.技术栈

SpringBoot、MybatisPlus、SpringSecurity、EasyExcel、Swagger2、redis、Echarts、Vue、ElementUI

2.由b站up主，''涣沷a靑惷'' 负责编写，b站主页地址:

https://space.bilibili.com/1459523909?spm_id_from=333.1007.0.0

个人网站: https://Startqc.cn

3.相关文件获取(我给的是我自己用的)，里面是一个maven3.6.3.zip文件，并且我已经配置好了(对应的是jdk8版本)，下载链接:

https://share.feijipan.com/s/k1AnzteO

4.jdk8版本下载，下载链接:

https://share.feijipan.com/s/3fAnzI3F

5.redis下载，免安装

https://share.feijipan.com/s/3WAnfZ7z

6.nodejs下载

https://share.feijipan.com/s/8LAnfKv3

7.该笔记对标的视频是 BV1hq4y1F7zk，拿着这个BV号在b站搜，就能搜到课程视频

项目介绍: 博客项目，前端有两个系统，分别是负责博客页面(前台系统)、管理页面(后台系统)。后端也有两个系统，分别是前端两个系统的具体实现

思考: 后端两个系统的代码复用性较高，所以后端创建的是多模块(3个模块)项目，把后端两个系统(两个子模块)都会用到的代码写到一个公共模块(第3个模块)

3个子模块在父模块里面，父模块叫SpringBootBlog

3个子模块分别是Start-framework(公共模块)、Start-blog(博客前台模块)、Start-admin(博客后台模块)

前端项目我会把下载链接放出来，我们不学前端代码，前端代码已经是写好的，我们需要把整个后端从0做出来

在下面的叫法中，'前台' 表示Start-blog项目、'后台' 表示Start-admin项目。不要把 '前台' 理解为是前端的项目，我们不负责前端项目的任何编写

![[Pasted image 20241022005334.png]]

------

# 项目搭建

## 1. 创建父模块

第一步: 在D盘创建SpringBootBlog目录，在D盘创建SpringBootBlogM2目录。把下载的maven3.6.3.zip文件解压到SpringBootBlogM2目录里面

第二步: 在idea创建项目，项目名是SpringBootBlog(父模块)，项目在D盘的SpringBootBlog目录。修改idea里面的maven设置

![img](未命名/__项目/assets/1693034000671-6e063e18-ae6e-4a87-9769-162419d0c285.jpg)

![img](未命名/__项目/assets/1693034000931-883d6d13-2b3e-4b2a-950d-540c49f9d8c6.jpg)

![img](未命名/__项目/assets/1693034001216-75d9bda7-2f47-40e7-9f37-169aff227d7c.jpg)

第三步: 把SpringBootBlog项目的src目录删掉，在pom.xml写入如下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.Start</groupId>
    <artifactId>SpringBootBlog</artifactId>
    <version>1.0-SNAPSHOT</version>


</project>
```

![img](未命名/__项目/assets/1693034001448-5321ede3-e8cf-4766-949d-2f968ea58630.jpg)

## 2. 创建公共模块(子)

![img](未命名/__项目/assets/1693034001700-a46c6436-9bea-431c-9714-c9d48e7df9c0.jpg)

![img](未命名/__项目/assets/1693034001936-d05f3cef-2e1d-48dc-b469-baf9f33aa73d.jpg)

![img](未命名/__项目/assets/1693034002154-75711940-3894-4bbd-9ee7-05c3c6a56f52.jpg)

第二步: 在pom.xml写入如下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringBootBlog</artifactId>
        <groupId>com.Start</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Start-framework</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-web</artifactId>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--SpringSecurity启动器-->
        <!--<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-security</artifactId>
        </dependency>-->
        <!--redis依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-data-redis</artifactId>
        </dependency>
        <!--fastjson依赖-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
        </dependency>
        <!--jwt依赖-->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
        </dependency>
        <!--mybatisPlus依赖-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-Starter</artifactId>
        </dependency>
        <!--mysql数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <!--阿里云OSS-->
        <dependency>
            <groupId>com.aliyun.oss</groupId>
            <artifactId>aliyun-sdk-oss</artifactId>
        </dependency>

        <!--AOP-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-aop</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>easyexcel</artifactId>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>

    </dependencies>

</project>
```

![img](未命名/__项目/assets/1693034002338-a2f58dab-a663-4f63-bba2-77cbed69b6b4.jpg)

## 3. 创建博客后台模块(子)

![img](未命名/__项目/assets/1693034002524-ef2c092f-ff1f-4071-baa3-7ba34b609fdb.jpg)

![img](未命名/__项目/assets/1693034002746-1b7ae6a5-80f6-48af-960a-cb25abe48239.jpg)

![img](未命名/__项目/assets/1693034002930-6372549c-de54-4fc1-963c-c0e9ef893457.jpg)

第二步: 在pom.xml写入如下

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringBootBlog</artifactId>
        <groupId>com.Start</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Start-admin</artifactId>

    <!--用Start-framework模块里面的依赖-->
    <dependencies>
        <dependency>
            <groupId>com.Start</groupId>
            <artifactId>Start-framework</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

</project>
```

![img](未命名/__项目/assets/1693034003105-b54dd98e-724a-417b-94cb-defc3df0f433.jpg)

## 4. 创建博客前台模块(子)

![img](未命名/__项目/assets/1693034003286-06e13ede-a80e-48ed-a780-975d3268a82e.jpg)

![img](未命名/__项目/assets/1693034003491-0b1bb382-1324-4e37-838f-4840c58526a8.jpg)

![img](未命名/__项目/assets/1693034003671-e45872d3-fa27-4c50-abb6-17e7392eddc2.jpg)

第二步: 在pom.xml写入如下

![img](未命名/__项目/assets/1693034003841-cfd12146-c9ab-4909-8d40-807d1f76f5b4.jpg)

# EasyCode插件

## 1. 插件安装

只演示，不实际用于项目，建议自己去掌握，真的非常好用

第一步: 在idea搜索EasyCode，安装这个插件

![img](未命名/__项目/assets/1693034003996-10ac5137-635d-46ab-9038-9b04a0dc4361.jpg)

## 2. 插件使用

第一步: 在idea连接mysql数据库，右键某个表，如下图操作，就能让EasyCode插件生成对应的controller、entity，service、dao等代码

![img](未命名/__项目/assets/1693034004157-8bd651bb-b2d3-49a3-b010-d81c6ab91796.jpg)

![img](未命名/__项目/assets/1693034004347-befc92cf-d7c4-43f6-9f6d-b936dbdb5a7b.jpg)

![img](未命名/__项目/assets/1693034004521-bc757d56-4d23-433a-bfbf-4783873f2771.jpg)

![img](未命名/__项目/assets/1693034004678-cd152cc0-046e-42ea-95a8-e848f41b21a8.jpg)

第二步: 例如我们要让EasyCode生成实体类，但是它生成的实体类有些代码我们不需要，可以在idea的settings里面修改如下，把entity.java.vm修改为如下

```java
##导入宏定义
$!{define.vm}

##保存文件（宏定义）
#save("/entity", ".java")

##包路径（宏定义）
#setPackageSuffix("entity")

##自动导入包（全局变量）
$!{autoImport.vm}
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

##表注释（宏定义）
#tableComment("表实体类")
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class $!{tableInfo.name} {
#foreach($column in $tableInfo.fullColumn)
    #if(${column.comment})//${column.comment}#end

    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end

}
```

![img](未命名/__项目/assets/1693034004852-cfe39331-3852-4ba0-8f75-211999f379f4.jpg)

第三步: 测试。使用EasyCode帮助我们根据数据库字段来生成实体类的代码

![img](未命名/__项目/assets/1693034005017-d4cc8f28-10de-4a56-92c1-2359c63b6b06.jpg)

![img](未命名/__项目/assets/1693034005182-4e98085f-4163-442a-b7b8-82b7dce38f3d.jpg)

## 3. 自定义模板

把entity.java.vm的模板替换为如下

```java
##导入宏定义
$!{define.vm}

##保存文件（宏定义）
#save("/entity", ".java")

##包路径（宏定义）
#setPackageSuffix("entity")

##自动导入包（全局变量）
$!{autoImport.vm}

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
##表注释（宏定义）
#tableComment("表实体类")
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("$!{tableInfo.obj.name}")
public class $!{tableInfo.name}  {
#foreach($column in $tableInfo.pkColumn)
    #if(${column.comment})//${column.comment}#end
@TableId
    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end

#foreach($column in $tableInfo.otherColumn)
    #if(${column.comment})//${column.comment}#end

    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end
    
}
```

![img](未命名/__项目/assets/1693034005341-dcee2da2-d660-407a-a22d-f7dd7bc7d368.jpg)

把dao.java.vm的模板替换为如下

```java
##导入宏定义
$!{define.vm}

##设置表后缀（宏定义）
#setTableSuffix("Dao")

##保存文件（宏定义）
#save("/dao", "Dao.java")

##包路径（宏定义）
#setPackageSuffix("dao")

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


##表注释（宏定义）
#tableComment("表数据库访问层")
public interface $!{tableName} extends BaseMapper<$!tableInfo.name> {

}
```

![img](未命名/__项目/assets/1693034005502-5d7e4a7b-5dda-4846-8b6c-8591025aaef8.jpg)

把service.java.vm的模板替换为如下

```java
##导入宏定义
$!{define.vm}

##设置表后缀（宏定义）
#setTableSuffix("Service")

##保存文件（宏定义）
#save("/service", "Service.java")

##包路径（宏定义）
#setPackageSuffix("service")

import com.baomidou.mybatisplus.extension.service.IService;


##表注释（宏定义）
#tableComment("表服务接口")
public interface $!{tableName} extends IService<$!tableInfo.name> {

}
```

![img](未命名/__项目/assets/1693034005638-bc9cc58f-7272-40f9-9a8e-d76482d69665.jpg)

把serviceImpl.java.vm的模板替换为如下

```java
##导入宏定义
$!{define.vm}

##设置表后缀（宏定义）
#setTableSuffix("ServiceImpl")

##保存文件（宏定义）
#save("/service/impl", "ServiceImpl.java")

##包路径（宏定义）
#setPackageSuffix("service.impl")

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

##表注释（宏定义）
#tableComment("表服务实现类")
@Service("$!tool.firstLowerCase($tableInfo.name)Service")
public class $!{tableName} extends ServiceImpl<$!{tableInfo.name}Mapper, $!{tableInfo.name}> implements $!{tableInfo.name}Service {

}
```

![img](未命名/__项目/assets/1693034005800-b55ed343-61a0-401f-8229-a0994b9e716f.jpg)

# 公共模块-准备工作

公共模块里面写的就是可复用的代码，也就是能被Start-blog(博客前台模块)、Start-admin(博客后台模块)都用到的代码

## 1. 数据库导入

手动在mysql新建一个名为sg_blog的库，然后下载"先创建sg_blog库.sql"文件，把下载下来的sql文件导入进这个sg_blog库。下载链接如下。2024-05-13之后导入的同学，导入的数据跟截图会不一样，因为我改过sql，删掉了烦人的外键，并且改过部分数据，不影响功能

```plain
https://share.feijipan.com/s/6qAnfkTf
```

![img](未命名/__项目/assets/1693034005956-0d300a9f-04eb-4aac-9791-c60f07bad7a1.jpg)

![img](未命名/__项目/assets/1693034006132-e85070d9-ce1e-491b-aed8-1dba10881fc9.jpg)

## 2. 代码相关

第一步: 在Start-framework工程的src/main/java目录新建com.Start.domain.Article类，写入如下

```java
package com.Start.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 35238
 * @date 2023/7/18 0018 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sg_article")
public class Article {

    @TableId
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;
    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第二步: 在Start-framework工程的src/main/java目录新建com.Start.mapper.ArticleMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Article;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:13
 */
public interface ArticleMapper extends BaseMapper<Article> {
}
```

第三步: 在Start-framework工程的src/main/java目录新建com.Start.service.ArticleService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Article;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */
public interface ArticleService extends IService<Article> {
}
```

第四步: 在Start-framework工程的src/main/java目录新建com.Start.service.impl.ArticleServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.Article;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
```

# 博客前台模块-准备工作

## 1. 整合mybatisplus

第一步: 在Start-blog工程的src/main/java目录新建com.Start.StartBlogApplication类，作为引导类，写入如下

```java
package com.Start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 35238
 * @date 2023/7/18 0018 19:13
 */
@SpringBootApplication
public class StartBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartBlogApplication.class,args);
    }
}
```

第二步: 在Start-blog工程的resources目录新建File，文件名为application.yml文件，写入如下

```yaml
server:
  port: 7777

spring:
  # 数据库连接信息
  datasource:
    url: jdbc:mysql://localhost:3306/sg_blog?characterEncoding=utf-8&serverTimezone=Asia/Shanghai
    username: root
    password: 228675
    driver-class-name: com.mysql.cj.jdbc.Driver

  servlet:
    # 文件上传
    multipart:
      # 单个上传文件的最大允许大小
      max-file-size: 20MB
      # HTTP请求中包含的所有文件的总大小的最大允许值
      max-request-size: 20MB

mybatis-plus:
  configuration:
    # 日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      # 逻辑删除的字段
      logic-delete-field: delFlag
      # 代表已删除的值
      logic-delete-value: 1
      # 代表未删除的值
      logic-not-delete-value: 0
      # 主键自增策略，以mysql数据库为准
      id-type: auto
```

第三步: 在Start-blog工程的src/main/java目录新建com.Start.controller.ArticleController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.Article;
import com.Start.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:48
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    //注入公共模块的ArticleService接口
    private ArticleService articleService;
    
    @GetMapping("/list")
    //Article是公共模块的实体类
    public List<Article> test(){
        //查询数据库的所有数据
        return articleService.list();
    }

}
```

第四步: 在Start-blog工程的StartBlogApplication引导类，修改为如下，主要就是添加了一个包扫描。不然我们用不了(注入不了)公共模块的类(bean)

```java
package com.Start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 35238
 * @date 2023/7/18 0018 19:13
 */

@SpringBootApplication
@MapperScan("com.Start.mapper")
public class StartBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartBlogApplication.class,args);
    }
}
```

![img](未命名/__项目/assets/1693034006314-15f8a1f3-a6ce-4f83-a876-eefb411c868c.jpg)

第五步: 运行Start-blog工程的StartBlogApplication引导类。浏览器访问如下

```plain
http://localhost:7777/article/list
```

![img](未命名/__项目/assets/1693034006493-3ac24309-507e-45ab-8c20-e8754161ad5e.jpg)

# 博客前台模块-文章列表

## 1. 文章表的字段

![img](未命名/__项目/assets/1693034006691-e72c76c3-8b60-4fdd-93ec-9a7bd549a3b5.jpg)

![img](未命名/__项目/assets/1693034006818-a4b781bd-2d84-4031-86d6-822d1b98d813.jpg)

## 2. 需求分析

需要查询浏览量最高的前10篇文章的信息。要求展示文章标题和浏览量。把能让用户自己点击跳转到具体的文章详情进行浏览

注意：不能把草稿展示出来，不能把删除了的文章查询出来。要按照浏览量进行降序排序

- ![[Pasted image 20250103212728.png]]
- 前端主要请求接口，后端返回数据，前端渲染
- ![[Pasted image 20250103214353.png]]

- 设计接口生成接口文档，这里使用swagger写接口文档
- ![[Pasted image 20250103214544.png]]
- ![[Pasted image 20250103214635.png]]
- 响应格式
- ![[Pasted image 20250103215005.png]]
- 点击右上角的try out来测试
- ![[Pasted image 20250103215106.png]]
- 点击标题会跳转到详情,跳转的过程中，会获取文章的id，然后根据id查询文章
- ![[Pasted image 20250103214842.png]]

## 3. 统一响应格式

### 一、代码实现

第一步: 在Start-framework公共模块的src/main/java目录新建com.Start.enums.AppHttpCodeEnum类，写入如下，作用是封装code和msg

```java 
package com.Start.enums;

/**
 * @author 35238
 * @date 2023/7/19 0019 12:52
 */
public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"), EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    LOGIN_ERROR(505,"用户名或密码错误");
    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
```

第二步: 在Start-framework公共模块的domain目录新建ResponseResult类，写入如下，作为统一响应格式的类

```java
package com.Start.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.Start.enums.AppHttpCodeEnum;
import java.io.Serializable;

/**
 * @author 35238
 * @date 2023/7/19 0019 12:49
 */
//统一响应格式。实体类，或者这个类严格来说叫响应体
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public ResponseResult() {
        this.code = AppHttpCodeEnum.SUCCESS.getCode();
        this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }
    public static ResponseResult okResult() {
        ResponseResult result = new ResponseResult();
        return result;
    }
    public static ResponseResult okResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, msg);
    }

    public static ResponseResult okResult(Object data) {
        ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getMsg());
        if(data!=null) {
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums,enums.getMsg());
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums, String msg){
        return setAppHttpCodeEnum(enums,msg);
    }

    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums){
        return okResult(enums.getCode(),enums.getMsg());
    }

    private static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums, String msg){
        return okResult(enums.getCode(),msg);
    }

    public ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public ResponseResult<?> ok(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
```

第三步: 把Start-framework公共模块的ArticleService修改为如下，定义了hotArticleList方法

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */
public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();
}
```

第四步: 把Start-framework公共模块的ArticleServiceImpl修改为如下，实现了hotArticleList方法

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public ResponseResult hotArticleList() {

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus,0);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(1,10);
        page(page,queryWrapper);
        //获取最终的查询结果
        List<Article> articles = page.getRecords();
        
        return ResponseResult.okResult(articles);
    }
}
```
[[01. ArticleServiceImpl代码解释]]


第五步: 把Start-blog工程的ArticleController类，修改为如下，增加了文章列表的统一响应格式的代码

```java
package com.Start.controller;

import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:48
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    //注入公共模块的ArticleService接口
    private ArticleService articleService;


    //----------------------------------测试mybatisPlus---------------------------------

    @GetMapping("/list")
    //Article是公共模块的实体类
    public List<Article> test(){
        //查询数据库的所有数据
        return articleService.list();
    }

    //----------------------------------测试统一响应格式-----------------------------------

    @GetMapping("/hotArticleList")
    //ResponseResult是Start-framework工程的domain目录的类
    public ResponseResult hotArticleList(){
        //查询热门文章，封装成ResponseResult返回
        ResponseResult result = articleService.hotArticleList();
        return result;
    }
}
```

第六步: 运行Start-blog工程，打开postman软件，使用GET请求访问下面的地址

```plain
http://localhost:7777/article/hotArticleList
```

![img](未命名/__项目/assets/1693034006959-451cfd5d-5196-49a5-9a7a-f5e9169abb85.jpg)

### 二、后端解决跨域

在Start-framework工程的src/main/java目录新建com.Start.config.WebConfig类，写入如下，然后重新运行Start-blog工程的StartBlogApplication类

```java
package com.Start.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 35238
 * @date 2023/7/19 0019 14:57
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }

}
```

### 三、前端项目的启动

第一步: 在D盘新建SpringBootBlogWeb文件夹，下载sg-blog-vue.zip源码文件，下载链接如下，解压到SpringBootBlogWeb文件夹里面。最近更新于2024-05-23，项目有bug的同学，更新这份前端源码

```plain
https://share.feijipan.com/s/1nALuYc2
```

![img](未命名/__项目/assets/1693034007140-18539102-7ac1-4d5e-9af8-1f705159a946.jpg)

第二步: 运行前端项目。请确保你电脑有安装node.js，然后以管理员身份打开命令行窗口，输入如下

```shell
d:
cd /SpringBootBlogWeb/sg-blog-vue
npm install
npm run dev
```

![img](未命名/__项目/assets/1693034007258-6220cb82-263c-4672-8046-a60f49b06be9.jpg)

![img](未命名/__项目/assets/1693034007395-885262a6-9fcf-41b9-9256-d4e11293bbad.jpg)

第三步: 如果你第二步执行不了，那么原因只能是nodejs版本问题，最简单的解决方法就是打开 '控制面板'，点击 '程序和功能'，下拉找到 'Node.js'，右键卸载，并且把你之前nodejs的安装目录删掉。最后下载稳定版14.几的nodejs，为方便下载，我把我的nodejs下载链接放下面，直接下载安装即可

```plain
nodejs的14.21.3-x64版本下载: https://share.feijipan.com/s/8LAnfKv3
```

第四步: 访问前端的项目

```plain
http://localhost:8080/#/DetailArticle?aid=1
```

### 三、前后端联调

主要就是解决跨域，跨域解决之后，就没事了

![img](未命名/__项目/assets/1693034007531-9e315bb6-2bae-4e4c-ba3c-9d68cf984e22.jpg)

## 4. 统一响应格式(优化)

在刚刚的响应格式中，其实是不符合接口文档标准的，因为我们返回了很多字段，如下图，有些字段不需要返回，或者比较敏感不能返回给前端

![img](未命名/__项目/assets/1693034006959-451cfd5d-5196-49a5-9a7a-f5e9169abb85.jpg)

为什么会返回这么多字段: 查询出来的结果是用Article来封装的，由于Article实体类里面的字段比较多，所以返回的字段也就是很多

解决: 用VO (是Value Object的缩写,表示值对象) 来接收查询的结果，一个接口对应一个VO，这样即使接口响应字段要修改也只要修改VO即可

### 一、定义并测试VO

第一步: 在Start-frameword工程的src/main/java目录新建com.Start.vo.HotArticleVO类，写入如下

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/7/19 0019 16:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//返回给前端特定的字段
public class HotArticleVO {
    
    private Long id;
    //标题
    private String title;
    //访问量
    private Long viewCount;
    
}
```

第二步: 不再使用Article实体类来封装，而是使用刚刚的HotArticleVO实体类来封装即可。把ArticleServiceImpl修改为如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.vo.HotArticleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    
    @Override
    public ResponseResult hotArticleList() {

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus,0);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(1,10);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        List<HotArticleVO> articleVos = new ArrayList<>();
        for (Article xxarticle : articles) {
            HotArticleVO xxvo = new HotArticleVO();
            //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
            //虽然xxarticle里面有很多不同的字段，但是xxvo里面只有3个字段(没有具体数据)，所以拷贝之后，就能把xxvo里面的三个字段填充具体数据
            BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
            //把我们要的数据(也就是上一行的xxvo)封装成集合
            articleVos.add(xxvo);
        }
        
        return ResponseResult.okResult(articleVos);
    }
}
```

![img](未命名/__项目/assets/1693034007684-8687f97c-96ca-424d-b797-1869d7e4ba25.jpg)

第三步: 重新运行Start-blog工程的StartBlogApplication类。打开postman软件，使用GET请求访问下面的地址

```plain
http://localhost:7777/article/hotArticleList
```

![img](未命名/__项目/assets/1693034007866-f3d620a1-9540-482b-8271-4845378c1b57.jpg)

### 二、字面值处理

实际项目中都不允许直接在代码中使用字面值(代码中的固定值)。都需要定义成常量来使用。这种方式有利于提高代码的可维护性。字面值如下图

![img](未命名/__项目/assets/1693034008056-8dbc6d71-5d02-4ab8-b7eb-4b217db7aa9d.jpg)

第一步: 在Start-framework工程的src/main/java目录新建com.Start.constants.SystemCanstants类，写入如下，作用是定义常量

```java
package com.Start.constants;

/**
 * @author 35238
 * @date 2023/7/19 0019 19:14
 */
//字面值(代码中的固定值)处理，把字面值都在这里定义成常量
public class SystemCanstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    
    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;
    
    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;
    
}
```

第二步: 把Start-framework工程的ArticleServiceImpl类修改为如下，作用是把之前的字面值全部换成常量

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.vo.HotArticleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        List<HotArticleVO> articleVos = new ArrayList<>();
        for (Article xxarticle : articles) {
            HotArticleVO xxvo = new HotArticleVO();
            //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
            BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
            //把我们要的数据封装成集合
            articleVos.add(xxvo);
        }

        return ResponseResult.okResult(articleVos);
    }
}
```

![img](未命名/__项目/assets/1693034008272-0da6b140-d084-4d6e-beef-8ae487127e25.jpg)

### 三、Bean拷贝的封装

在前面的 '统一响应格式(优化)' 的 '一、定义并测试VO'，最核心的代码就是ArticleServiceImpl类里面用到的Spring提供的BeanUtils工具类。这个工具类可以把Article类里面拿到的查询结果，拷贝给HotArticleVO类，注意HotArticleVO(少)相对于Article(多)来说，成员变量的数量可以少，但是名称和类型必须一样

我们前面是在ArticleServiceImpl类写了如下核心代码，为了提高代码复用性，我们必须把这段代码抽取出来进行封装

![img](未命名/__项目/assets/1693034008453-6e86638f-40a9-43f6-b394-13b6d2cf56a1.jpg)

具体操作如下

第一步: 在Start-framework工程的src/main/java目录新建com.Start.utils.BeanCopyUtils类，写入如下

```java
package com.Start.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/19 0019 20:13
 */
//这个类用到很多泛型知识，可以对应去补一下
public class BeanCopyUtils {

    //私有的空参构造方法
    private BeanCopyUtils() {
    }

    //1.单个实体类的拷贝(暂时还用不上)。第一个参数是要拷贝的对象，第二个参数是类的字节码对象
    public static <V> V copyBean(Object source,Class<V> clazz) {
        //创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            //实现属性拷贝。也就是把source的属性拷贝到这个目标对象。BeanUtils是spring提供的工具类
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }


    //2.集合的拷贝(在ArticleServiceImpl类里面会使用到)。第一个参数是要拷贝的集合，第二个参数是类的字节码对象
    public static <O,V> List<V> copyBeanList(List<O> list,Class<V> clazz){
        //不使用for循环，使用stream流进行转换
        return list.stream()
                .map(o -> copyBean(o, clazz))
                //把结果转换成集合
                .collect(Collectors.toList());
    }
}
```

第二步: 把Start-framework工程的ArticleServiceImpl类修改为如下，作用是把之前的bean拷贝代码换成调用BeanCopyUtils类的copyBeanList方法

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.HotArticleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);


        return ResponseResult.okResult(articleVos);
    }
}
```

![img](未命名/__项目/assets/1693034008621-83acd75a-902b-433e-a1d8-927856f37d8e.jpg)

第三步: 测试。重新运行Start-blog工程的StartBlogApplication类，然后去postman软件发送GET请求，访问如下路径

```plain
http://localhost:7777/article/hotArticleList
```

![img](未命名/__项目/assets/1693034008821-e7fd3bfa-1f64-48e2-9974-1452e1b27b18.jpg)

# 博客前台模块-分类列表

## 1. 分类表的字段

![img](未命名/__项目/assets/1693034009010-77be19eb-0872-4d2c-95c7-894f9502d7eb.jpg)

![img](未命名/__项目/assets/1693034009158-7b9d44ba-7522-4f06-bd5a-00c7883e8fd8.jpg)

## 2. 接口分析

页面上需要展示分类列表，用户可以点击具体的分类查看该分类下的文章列表。要求只展示有发布正式文章的分类 。要求必须是正常(非禁用)状态的分类

## 3. 代码实现

第一步: 在Start-framework工程的domain目录新建Category类，写入如下

```java
package com.Start.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_category")
public class Category  {
    @TableId
    private Long id;

    //分类名
    private String name;
    //父分类id，如果没有父分类为-1
    private Long pid;
    //描述
    private String description;
    //状态0:正常,1禁用
    private String status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第二步: 在Start-framework工程的mapper目录新建CategoryMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Category;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:38
 */
public interface CategoryMapper extends BaseMapper<Category> {
}
```

第三步: 在Start-framework工程的service目录新建CategoryService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Category;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:41
 */
public interface CategoryService extends IService<Category> {
    //查询文章分类的接口
    ResponseResult getCategoryList();
}
```

第四步: 在Start-framework工程的service目录新建impl.CategoryServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.Category;
import com.Start.vo.CategoryVo;
import com.Start.domain.ResponseResult;
import com.Start.mapper.CategoryMapper;
import com.Start.service.ArticleService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:41
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

    @Autowired
    //ArticleService是我们在Start-framework写的接口
    private ArticleService articleService;

    @Override
    //查询分类列表的核心代码
    public ResponseResult getCategoryList() {
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        //要求查的是getStatus字段的值为1，注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        articleWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //查询文章列表，条件就是上一行的articleWrapper
        List<Article> articleList = articleService.list(articleWrapper);
        //获取文章的分类id，并且去重。使用stream流来处理上一行得到的文章表集合
        Set<Long> categoryIds = articleList.stream()
                //下面那行可以优化为Lambda表达式+方法引用
                .map(new Function<Article, Long>() {
                    @Override
                    public Long apply(Article article) {
                        return article.getCategoryId();
                    }
                })
                //把文章的分类id转换成Set集合
                .collect(Collectors.toSet());

        //查询分类表
        List<Category> categories = listByIds(categoryIds);
        //注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        categories = categories.stream()
                .filter(category -> SystemCanstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        //封装成CategoryVo实体类后返回给前端，CategoryVo的作用是只返回前端需要的字段。BeanCopyUtils是我们写的工具类
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }
}
```

第五步: 在Start-blog工程的vo目录新建CategoryVo，写入如下

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/7/20 0020 15:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//返回给前端的特定字段
public class CategoryVo {

    private Long id;
    private String name;

}
```

第六步: 在Start-blog工程的SystemCanstants类，修改为如下，增加了分类表的 '分类状态是正常状态' 的常量

```java
package com.Start.constants;

/**
 * @author 35238
 * @date 2023/7/19 0019 19:14
 */
//字面值(代码中的固定值)处理，把字面值都在这里定义成常量
public class SystemCanstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;

    /**
     * 分类表的分类状态是正常状态
     */
    public static final String STATUS_NORMAL = "0";

}
```

第七步: 在Start-blog工程的controller目录新建CategoryController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/20 0020 14:15
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    //CategoryService是我们在Start-framework工程里面写的接口
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    //ResponseResult是我们在Start-framework工程里面写的实体类
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }

}
```

第八步: 测试。运行Start-blog工程的StartBlogApplication引导类。然后运行vue项目，浏览器访问如下

```plain
http://localhost:8080
```

![img](未命名/__项目/assets/1693034009354-66ea7900-0ad4-44bb-a531-f98bc0decf6d.jpg)

# 博客前台模块-分页查询

## 1. 文章表的字段

![img](未命名/__项目/assets/1693034006691-e72c76c3-8b60-4fdd-93ec-9a7bd549a3b5.jpg)

![img](未命名/__项目/assets/1693034006818-a4b781bd-2d84-4031-86d6-822d1b98d813.jpg)

## 2. 接口分析

首页需要查询所有的文章列表。分类页面需要查询对应分类下的文章列表。只能查询正式发布的文章，置顶的文章要显示在最前面

## 3. 代码实现

第一步: 在Start-framework工程的config目录新建MybatisPlusConfig类，作用是配置MyBatisPlus的分页插件，不然分页没有效果

```java
package com.Start.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 35238
 * @date 2023/7/20 0020 21:55
 */
@Configuration
//配置MyBatisPlus的分页插件，使得支持分页查询。这个类直接复制就能用
public class MybatisPlusConfig {

    /**
     * 3.4.0之后版本
     *
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

}
```

第二步: 在Start-framework工程的vo目录新建ArticleListVo实体类，写入如下

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/7/20 0020 20:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleListVo {

    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //所属分类名
    private String categoryName;
    //缩略图
    private String thumbnail;
    //访问量
    private Long viewCount;

    private Date createTime;

}
```

第三步: 在Start-framework工程的vo目录新建PageVo实体类，写入如下

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/20 0020 21:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {

    private List rows;
    private Long total;

}
```

第四步: 把Start-framework工程的ArticleService接口，修改为如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */
public interface ArticleService extends IService<Article> {

    //文章列表
    ResponseResult hotArticleList();

    //分类查询文章列表
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);
}
```

第五步: 把Start-framework工程的ArticleServiceImpl类，修改为如下，增加了分页查询的代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.ArticleListVo;
import com.Start.vo.HotArticleVO;
import com.Start.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);

        return ResponseResult.okResult(articleVos);
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);

        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);

        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}
```

第六步: 把Start-blog工程的ArticleController类，修改为如下，增加了articleList方法

```java
package com.Start.controller;

import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:48
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    //注入公共模块的ArticleService接口
    private ArticleService articleService;

    //----------------------------------测试mybatisPlus---------------------------------

    @GetMapping("/list")
    //Article是公共模块的实体类
    public List<Article> test(){
        //查询数据库的所有数据
        return articleService.list();
    }

    //----------------------------------测试统一响应格式-----------------------------------

    @GetMapping("/hotArticleList")
    //ResponseResult是Start-framework工程的domain目录的类
    public ResponseResult hotArticleList(){
        //查询热门文章，封装成ResponseResult返回
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @GetMapping("/articleList")
    //ResponseResult是Start-framework工程的domain目录的类
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
        return articleService.articleList(pageNum,pageSize,categoryId);
    }

}
```

第七步: 测试。运行Start-blog工程的StartBlogApplication引导类。然后运行vue项目，浏览器访问如下

```plain
http://localhost:8080
```

![img](未命名/__项目/assets/1693034009531-5188ad8d-5c88-4d5b-ba6b-f4b56a8f7691.jpg)

第八步: 存在的问题，categoryName字段没有返回值，原因是Article实体类有categoryId字段，但是没有categoryName字段的问题

```plain
http://localhost:7777/article/articleList?pageNum=1&pageSize=1
```

![img](未命名/__项目/assets/1693034009738-a2dd5893-059d-418b-b794-aeaac2db0f71.jpg)

对于categoryName字段，也就是 '分类名称'的问题，有两种解决方式，如下

## 4. 解决-普通循环的方式

第一步: 把ArticleServiceImpl类修改为如下，增加了普通循环的方式，实现从article表获取category_id字段，然后用来查询category表的name字段

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.ArticleListVo;
import com.Start.vo.HotArticleVO;
import com.Start.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);

        return ResponseResult.okResult(articleVos);
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @Autowired
    //注入我们写的CategoryService接口
    private CategoryService categoryService;

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理
         */
        //用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'。有两种方式来实现，如下
        List<Article> articles = page.getRecords();
        //第一种方式，用for循环遍历的方式
        for (Article article : articles) {
            //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
            Category category = categoryService.getById(article.getCategoryId());
            //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
            article.setCategoryName(category.getName());

        }
        
        //第二种方式，用stream流的方式
        

        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);

        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}
```

第二步: 把Article类修改为如下，增加了categoryName成员变量

```java
package com.Start.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 35238
 * @date 2023/7/18 0018 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sg_article")
public class Article {

    @TableId
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;

    //增加一个字段，为categoryName，由categoryId来查询出
    //由于数据库没有category_name字段，所以要用注解指定一下字段
    @TableField(exist = false)//代表这个字段在数据库中不存在，避免MyBatisPlus在查询时报错
    private String categoryName;

    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第三步: 测试运行Start-blog工程的StartBlogApplication引导类。然后打开postman软件访问如下

```plain
http://localhost:7777/article/articleList?pageNum=1&pageSize=1
```

![img](未命名/__项目/assets/1693034009923-5226323a-16c5-4edc-9b1c-1fc1f998f19c.jpg)

## 5. 解决-Stream流的方式

第一步: 把ArticleServiceImpl类修改为如下，增加了普通循环的方式，实现从article表获取category_id字段，然后用来查询category表的name字段

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.ArticleListVo;
import com.Start.vo.HotArticleVO;
import com.Start.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);

        return ResponseResult.okResult(articleVos);
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @Autowired
    //注入我们写的CategoryService接口
    private CategoryService categoryService;

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第一种方式，用for循环遍历的方式
         */
        ////用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        //List<Article> articles = page.getRecords();
        //for (Article article : articles) {
        //    //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
        //    Category category = categoryService.getById(article.getCategoryId());
        //    //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
        //    article.setCategoryName(category.getName());
        //
        //}

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第二种方式，用stream流的方式
         */
        //用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        List<Article> articles = page.getRecords();
        articles.stream()
                .map(new Function<Article, Article>() {
                    @Override
                    public Article apply(Article article) {
                        //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
                        Category category = categoryService.getById(article.getCategoryId());
                        String name = category.getName();
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        article.setCategoryName(name);
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        return article;
                    }
                })
                .collect(Collectors.toList());


        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);
        

        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}
```

第二步(已做可跳过): 把Article类修改为如下，增加了categoryName成员变量

```java
package com.Start.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 35238
 * @date 2023/7/18 0018 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sg_article")
public class Article {

    @TableId
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;

    //增加一个字段，为categoryName，由categoryId来查询出
    //由于数据库没有category_name字段，所以要用注解指定一下字段
    @TableField(exist = false)//代表这个字段在数据库中不存在，避免MyBatisPlus在查询时报错
    private String categoryName;

    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第三步: 测试运行Start-blog工程的StartBlogApplication引导类。然后打开postman软件访问如下

```plain
http://localhost:7777/article/articleList?pageNum=1&pageSize=1
```

![img](未命名/__项目/assets/1693034009923-5226323a-16c5-4edc-9b1c-1fc1f998f19c.jpg)

## 6. FastJson配置

由于ArticleListVO类的createTime成员变量是Date类型，默认是由java的Jackson来处理，使用 ISO-8601 规范来处理日期时间格式。ISO-8601 是一种国际标准的日期时间表示法，例如："2023-07-21T06:53:24"。我们不希望时间被处理成这种格式，如下图。解决: 使用FastJson

![img](未命名/__项目/assets/1693034010104-0019ad45-03f8-4751-a7ad-81aea2b76c47.jpg)

第一步(已做可跳过): 在Start-framework的pom.xml添加如下

```xml
<!--fastjson依赖-->
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>fastjson</artifactId>
</dependency>
```

第二步: 在Start-framework的config目录的WebConfig类，修改为如下。用线隔开了。直接复制去用

```java
package com.Start.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/19 0019 14:57
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }
    
    //-----------------------------------FastJson配置-----------------------------------------

    @Bean//使用@Bean注入fastJsonHttpMessageConvert
    public HttpMessageConverter fastJsonHttpMessageConverters() {
        //1.需要定义一个Convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

        SerializeConfig.globalInstance.put(Long.class, ToStringSerializer.instance);

        fastJsonConfig.setSerializeConfig(SerializeConfig.globalInstance);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return converter;
    }

    @Override
    //配置消息转换器
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //增加我们的消息转换器
        converters.add(fastJsonHttpMessageConverters());
    }
    
    //--------------------------------------------------------------------------------------

}
```

第三步: 测试运行Start-blog工程的StartBlogApplication引导类。然后打开postman软件访问如下

```plain
http://localhost:7777/article/articleList?pageNum=1&pageSize=1
```

或浏览器访问如下

```plain
http://localhost:8080/#/
```

![img](未命名/__项目/assets/1693034010378-9a5436aa-e7c1-4fb9-b991-783efb5c7f4b.jpg)



## 7. 前端bug解决

前端每篇文章都会有一个浅蓝色的分类图标在左上角，点击这个分类图标之后，跳转显示不了该分类下的所有文章

解决: 把后端ArticleController类的articleList方法修改为如下，然后在ArticleListVo类添加一个categoryId字段

```java
@GetMapping("/articleList")
//ResponseResult是Start-framework工程的domain目录的类
public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId,@RequestParam(required = false) String search){
    if (search!=""){
        List<ArticleListVo> articleListVo = categoryMapper.serchList(search);
        if (articleListVo.size()!=0) {
            PageVo pageVo = new PageVo(articleListVo,articleListVo.get(0).getTotal());
            List<ArticleListVo> list = pageVo.getRows();
            for (ArticleListVo one : list) {
                Category category = categoryMapper.selectById(one.getId());
                one.setCategoryName(category.getName());
                one.setCategoryId(category.getId());
            }

            return ResponseResult.okResult(pageVo);
        }

    }
    ResponseResult responseResult = articleService.articleList(pageNum, pageSize, categoryId);
    return responseResult;
}
```



# 博客前台模块-文章详情

## 1. 文章表的字段

![img](未命名/__项目/assets/1693034006691-e72c76c3-8b60-4fdd-93ec-9a7bd549a3b5.jpg)

![img](未命名/__项目/assets/1693034006818-a4b781bd-2d84-4031-86d6-822d1b98d813.jpg)

## 2. 接口分析

要求在文章列表点击阅读全文时能够跳转到文章详情页面，可以让用户阅读文章正文。并且要在文章详情中展示其分类名。响应格式：

```json
{
  "code": 200,
  "data": {
    "categoryId": "1",
    "categoryName": "java",
    "content": "文章详情的具体文章内容",
    "createTime": "2022-01-23 23:20:11",
    "id": "1",
    "isComment": "0",
    "title": "SpringSecurity从入门到精通",
    "viewCount": "114"
  },
  "msg": "操作成功"
}
```

## 3. 常用的HTTP请求形式

以GET /article/{id} 为例的路径参数形式，下面两种是比较常用的。不常用的有'请求体形式'、'请求头形式'

| 请求形式     | 示例                 | 描述                                                         |
| ------------ | -------------------- | ------------------------------------------------------------ |
| 路径参数形式 | /articles/{id}       | 参数作为路径的一部分，表示明确的资源标识符或必需的参数。     |
| 查询参数形式 | /articles?id=1&num=1 | 参数通过 "?" 或 "&" 的方式附加在URL的末尾，适合传递可选参数或过滤条件。 |

在上面的业务请求中，我们使用的都是'路径参数形式'，下面的业务请求中，我们将会使用'查询参数形式'

## 4. 代码实现

第一步: 在Start-framework工程的vo目录新建ArticleDetailVo实体类，写入如下

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/7/21 0021 21:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//封装文章详情的实体类，只把需要的字段返回给前端
public class ArticleDetailVo {

    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;

    //文章详情代码实现，新增了文章的分类id
    private Long categoryId;

    //文章详情代码实现，新增了文章的内容，也就是详情
    private String content;

    //所属分类名
    private String categoryName;
    //缩略图
    private String thumbnail;
    //访问量
    private Long viewCount;

    private Date createTime;

}
```

第二步: 把Start-framework工程的ArticleService接口修改为如下，增加了文章详情的查询

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */
public interface ArticleService extends IService<Article> {

    //文章列表
    ResponseResult hotArticleList();

    //分类查询文章列表
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    //根据id查询文章详情
    ResponseResult getArticleDetail(Long id);
}
```

第三步: 把Start-framework工程的ArticleServiceImpl类修改为如下，增加了根据id查询文章详情的业务代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.ArticleDetailVo;
import com.Start.vo.ArticleListVo;
import com.Start.vo.HotArticleVO;
import com.Start.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);

        return ResponseResult.okResult(articleVos);
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @Autowired
    //注入我们写的CategoryService接口
    private CategoryService categoryService;

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第一种方式，用for循环遍历的方式
         */
        ////用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        //List<Article> articles = page.getRecords();
        //for (Article article : articles) {
        //    //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
        //    Category category = categoryService.getById(article.getCategoryId());
        //    //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
        //    article.setCategoryName(category.getName());
        //
        //}

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第二种方式，用stream流的方式
         */
        //用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        List<Article> articles = page.getRecords();
        articles.stream()
                .map(new Function<Article, Article>() {
                    @Override
                    public Article apply(Article article) {
                        //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
                        Category category = categoryService.getById(article.getCategoryId());
                        String name = category.getName();
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        article.setCategoryName(name);
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        return article;
                    }
                })
                .collect(Collectors.toList());


        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);


        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    //---------------------------------根据id查询文章详情---------------------------------

    @Override
    public ResponseResult getArticleDetail(Long id) {

        //根据id查询文章
        Article article = getById(id);

        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);

        //根据分类id，来查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        //如果根据分类id查询的到分类名，那么就把查询到的值设置给ArticleDetailVo实体类的categoryName字段
        if(category!=null){
            articleDetailVo.setCategoryName(category.getName());
        }

        //封装响应返回。ResponseResult是我们在Start-framework工程的domain目录写的实体类
        return ResponseResult.okResult(articleDetailVo);
    }
}
```

第四步: 把Start-blog工程的ArticleController类，修改为如下，增加了getArticleDetail方法

```java
package com.Start.controller;

import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:48
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    //注入公共模块的ArticleService接口
    private ArticleService articleService;

    //----------------------------------测试mybatisPlus---------------------------------

    @GetMapping("/list")
    //Article是公共模块的实体类
    public List<Article> test(){
        //查询数据库的所有数据
        return articleService.list();
    }

    //----------------------------------测试统一响应格式-----------------------------------

    @GetMapping("/hotArticleList")
    //ResponseResult是Start-framework工程的domain目录的类
    public ResponseResult hotArticleList(){
        //查询热门文章，封装成ResponseResult返回
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @GetMapping("/articleList")
    //ResponseResult是Start-framework工程的domain目录的类
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
        return articleService.articleList(pageNum,pageSize,categoryId);
    }

    //------------------------------------查询文章详情------------------------------------

    @GetMapping("/{id}") //路径参数形式的HTTP请求，注意下面那行只有加@PathVariable注解才能接收路径参数形式的HTTP请求
    //ResponseResult是Start-framework工程的domain目录的类
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {//注解里指定的id跟上一行保持一致

        //根据id查询文章详情
        return articleService.getArticleDetail(id);

    }
}
```

第五步: 测试。运行Start-blog工程的StartBlogApplication引导类。然后运行vue项目，浏览器访问如下

```plain
http://localhost:8080
```

![img](未命名/__项目/assets/1693034010613-39e2a817-eafa-4a55-9a6b-32be0dff5e6c.jpg)

![img](未命名/__项目/assets/1693034010830-e7777d97-2280-4e67-8656-a98546e9a205.jpg)

# 博客前台模块-友链功能

## 1. 友链表的字段

![img](未命名/__项目/assets/1693034011015-a0c53334-e3af-4d74-b831-5c42778d2ff6.jpg)

![img](未命名/__项目/assets/1693034011137-5410f437-faed-4465-89c8-56eabd5017db.jpg)

## 2. 接口分析

在友链页面要查询出所有的审核通过的友链，响应格式如下

```json
{
  "code": 200,
  "data": [
    {
      "address": "https://www.baidu.com",
      "description": "sda",
      "id": "1",
      "logo": "图片url1",
      "name": "sda"
    },
    {
      "address": "https://www.qq.com",
      "description": "dada",
      "id": "2",
      "logo": "图片url2",
      "name": "sda"
    }
  ],
  "msg": "操作成功"
}
```

## 3. 代码实现

第一步: 在Start-framework工程的vo目录新建LinkVo实体类，写入如下

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/7/22 0022 15:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkVo {

    private Long id;

    private String name;

    private String logo;

    private String description;
    //网站地址
    private String address;

}
```

第二步: 把Start-framework工程的constants目录修改为如下，新增了友链状态的常量

```java
package com.Start.constants;

/**
 * @author 35238
 * @date 2023/7/19 0019 19:14
 */
//字面值(代码中的固定值)处理，把字面值都在这里定义成常量
public class SystemCanstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;

    /**
     * 分类表的分类状态是正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 友链状态为审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

}
```

第三步: 在Start-framework工程的domain目录新建Link类，写入如下

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 友链(Link)表实体类
 *
 * @author makejava
 * @since 2023-07-22 14:39:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_link")
public class Link  {
    
    @TableId
    private Long id;

    private String name;

    private String logo;

    private String description;
    //网站地址
    private String address;
    //审核状态 (0代表审核通过，1代表审核未通过，2代表未审核)
    private String status;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
}
```

第四步: 在Start-framework工程的mapper目录新建LinkMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Link;

/**
 * @author 35238
 * @date 2023/7/22 0022 14:42
 */
public interface LinkMapper extends BaseMapper<Link> {
}
```

第五步: 在Start-framework工程的service目录新建LinkService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Link;
import com.Start.domain.ResponseResult;

/**
 * @author 35238
 * @date 2023/7/22 0022 14:43
 */
public interface LinkService extends IService<Link> {

    //查询友链
    ResponseResult getAllLink();
}
```

第六步: 在Start-framework工程的service目录新建impl.LinkServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Link;
import com.Start.domain.ResponseResult;
import com.Start.mapper.LinkMapper;
import com.Start.service.LinkService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.LinkVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/22 0022 14:43
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {

        //查询所有审核通过的友链
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        //要求查的是友链表status字段的值为0，注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        queryWrapper.eq(Link::getStatus, SystemCanstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //把最后的查询结果封装成LinkListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);

        //封装响应返回。ResponseResult是我们在Start-framework工程的domain目录写的实体类
        return ResponseResult.okResult(linkVos);
    }
}
```

第七步: 在Start-blog工程的controller目录新建LinkController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/22 0022 14:34
 */
@RestController
@RequestMapping("link")
public class LinkController {

    @Autowired
    //LinkService是我们在Start-framework工程写的接口
    private LinkService linkService;


    @GetMapping("/getAllLink")
    //ResponseResult是我们在Start-framework工程写的实体类
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }

}
```

第八步: 由于sg_link表的3条测试数据的审核状态，也就是status字段的值为1，即未审核状态，我们需要修改为0，即审核通过状态才能在页面显示出来

```sql
use sg_blog
update sg_link set status = 0;
```

第九步: 测试。运行Start-blog工程的StartBlogApplication引导类。然后运行vue项目，浏览器访问如下

```java
http://localhost:8080/#/Friendslink
```

![img](未命名/__项目/assets/1693034011260-2fd51cc0-42ae-45bc-9f85-d19da2e261a2.jpg)

# 博客前台模块-登录功能

由于博客的前台、后台的登录功能，需要使用认证授权，所以我们统一都使用SpringSecurity安全框架来实现

## 1. 用户表的字段

![img](未命名/__项目/assets/1693034011446-2fe6f4fd-8b50-4840-8ec7-467050bdaf58.jpg)

![img](未命名/__项目/assets/1693034011591-f34cd80d-b080-4c2f-b9a7-c82d0fefad50.jpg)

## 2. 接口分析

需要实现登录功能，有些功能必须登录后才能使用，未登录状态是不能使用的。请求形式如下

请求体：

```json
{
    "userName":"sg",
    "password":"1234"
}
```

响应格式：

```json
{
    "code": 200,
    "data": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0ODBmOThmYmJkNmI0NjM0OWUyZjY2NTM0NGNjZWY2NSIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY0Mzg3NDMxNiwiZXhwIjoxNjQzOTYwNzE2fQ.ldLBUvNIxQCGemkCoMgT_0YsjsWndTg5tqfJb77pabk",
        "userInfo": {
            "avatar": "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F3bf9c263bc0f2ac5c3a7feb9e218d07475573ec8.gi",
            "email": "23412332@qq.com",
            "id": 1,
            "nickName": "sg333",
            "sex": "1"
        }
    },
    "msg": "操作成功"
}
```

## 3. 思路分析

登录

​	①自定义登录接口

​				调用ProviderManager的方法进行认证 如果认证通过生成jwt

​				把用户信息存入redis中

​	②自定义UserDetailsService

​				在这个实现类中去查询数据库

​	注意配置passwordEncoder为BCryptPasswordEncoder

校验：

​	①定义Jwt认证过滤器

​				获取token

​				解析token获取其中的userid

​				从redis中获取用户信息

​				存入SecurityContextHolder

## 4. 相关依赖

```xml
<!--SpringSecurity启动器。需要用到登录功能就解开，不然就注释掉-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-Starter-security</artifactId>
</dependency>

<!--redis依赖-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-Starter-data-redis</artifactId>
</dependency>

<!--fastjson依赖-->
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>fastjson</artifactId>
<version>1.2.33</version>
</dependency>

<!--jwt依赖-->
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.0</version>
</dependency>
```

## 5. 配置类和工具类

直接复制用，详细内容，可去我发的SpringSecurity笔记里面看

一: 在Start-framework工程的config目录新建FastJsonRedisSerializer类，写入如下

```java
package com.Start.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.util.Assert;
import java.nio.charset.Charset;

/**
 * Redis使用FastJson序列化
 * @author 35238
 * @date 2023/7/22 0022 21:12
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T>{

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private Class<T> clazz;

    static
    {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    public FastJsonRedisSerializer(Class<T> clazz)
    {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException
    {
        if (t == null)
        {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException
    {
        if (bytes == null || bytes.length <= 0)
        {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);

        return JSON.parseObject(str, clazz);
    }


    protected JavaType getJavaType(Class<?> clazz)
    {
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}
```

二: 在Start-framework工程的config目录新建RedisConfig类，写入如下

```java
package com.Start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings(value = { "unchecked", "rawtypes" })
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory)
    {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        FastJsonRedisSerializer serializer = new FastJsonRedisSerializer(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }
}
```

三: 在Start-framework工程的utils目录新建JwtUtil类，写入如下

```java
package com.Start.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 * @author 35238
 * @date 2023/7/22 0022 21:18
 */
public class JwtUtil {

    //有效期为
    public static final Long JWT_TTL = 72*60 * 60 *1000L;// 60 * 60 *1000  一个小时
    //设置秘钥明文
    public static final String JWT_KEY = "Startqc";

    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     * 生成jtw
     * @param subject token中要存放的数据（json格式）
     * @return
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());// 设置过期时间
        return builder.compact();
    }

    /**
     * 生成jtw
     * @param subject token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());// 设置过期时间
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis==null){
            ttlMillis=JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)              //唯一的ID
                .setSubject(subject)   // 主题  可以是JSON数据
                .setIssuer("HF")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(signatureAlgorithm, secretKey) //使用HS256对称加密算法签名, 第二个参数为秘钥
                .setExpiration(expDate);
    }

    /**
     * 创建token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);// 设置过期时间
        return builder.compact();
    }

    public static void main(String[] args) throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjYWM2ZDVhZi1mNjVlLTQ0MDAtYjcxMi0zYWEwOGIyOTIwYjQiLCJzdWIiOiJzZyIsImlzcyI6InNnIiwiaWF0IjoxNjM4MTA2NzEyLCJleHAiOjE2MzgxMTAzMTJ9.JVsSbkP94wuczb4QryQbAke3ysBDIL5ou8fWsbt_ebg";
        Claims claims = parseJWT(token);
        System.out.println(claims);
    }

    /**
     * 生成加密后的秘钥 secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
```

四: 在Start-framework工程的utils目录新建RedisCache类，写入如下

```java
package com.Start.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:18
 */
@SuppressWarnings(value = { "unchecked", "rawtypes" })
@Component
public class RedisCache {
    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCacheObject(final String key, final T value)
    {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit)
    {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout)
    {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit)
    {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key)
    {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 删除单个对象
     *
     * @param key
     */
    public boolean deleteObject(final String key)
    {
        return redisTemplate.delete(key);
    }

    /**
     * 删除集合对象
     *
     * @param collection 多个对象
     * @return
     */
    public long deleteObject(final Collection collection)
    {
        return redisTemplate.delete(collection);
    }

    /**
     * 缓存List数据
     *
     * @param key 缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> long setCacheList(final String key, final List<T> dataList)
    {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<T> getCacheList(final String key)
    {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存Set
     *
     * @param key 缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet)
    {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext())
        {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
    public <T> Set<T> getCacheSet(final String key)
    {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap)
    {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 获得缓存的Map
     *
     * @param key
     * @return
     */
    public <T> Map<String, T> getCacheMap(final String key)
    {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 往Hash中存入数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @param value 值
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value)
    {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey)
    {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 删除Hash中的数据
     *
     * @param key
     * @param hkey
     */
    public void delCacheMapValue(final String key, final String hkey)
    {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(key, hkey);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hKeys)
    {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern)
    {
        return redisTemplate.keys(pattern);
    }
}
```

五: 在Start-framework工程的utils目录新建WebUtils类，写入如下

```java
package com.Start.utils;

import org.springframework.web.context.request.RequestContextHolder;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:19
 */
public class WebUtils {
    /**
     * 将字符串渲染到客户端
     *
     * @param response 渲染对象
     * @param string 待渲染的字符串
     * @return null
     */
    public static void renderString(HttpServletResponse response, String string) {
        try
        {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void setDownLoadHeader(String filename, ServletContext context, HttpServletResponse response) throws UnsupportedEncodingException {
        String mimeType = context.getMimeType(filename);//获取文件的mime类型
        response.setHeader("content-type",mimeType);
        String fname= URLEncoder.encode(filename,"UTF-8");
        response.setHeader("Content-disposition","attachment; filename="+fname);

//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        response.setCharacterEncoding("utf-8");
    }
}
```

## 6. Redis下载安装启动

Redis是一款key-value存储结构的内存级NoSQL数据库，也就是运行在内存上的数据库

- 支持多种数据存储格式
- 支持持久化
- 支持集群

Redis下载(windows版-Redis-x64-5.0.14.msi)

```plain
https://github.com/tporadowski/redis/releases
```

为方便学习，可拿我在用的redis，如下网盘有软件包

```plain
https://share.feijipan.com/s/3WAnfZ7z
```

安装完成之后，打开安装目录

![img](未命名/__项目/assets/0333497a713c42bc8fa23673d6e0936b.jpg)

redis的服务端启动命令

```plain
redis-server.exe redis.windows.conf
```

redis的客户端启动命令

```plain
redis-cli.exe
```

具体启动步骤如下。注意: 如果你的redis启动后控制台没蜂窝图案，那么请认真按照下面第二张图的步骤，数字表示命令的先后顺序

![img](未命名/__项目/assets/e24fb6408fa948ada14048d8cefd9dc9.jpg)
![img](未命名/__项目/assets/3652b7ac1c4c4b1a8dc3ee49396ad979.jpg)
![img](未命名/__项目/assets/af6874abbaf348878cab6d84c83fb909.jpg)



## 7. 代码实现-自定义登录接口

第一步: 在Start-framework工程的domain目录新建User类，写入如下

```java
package com.Start.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-07-22 20:41:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User  {

    //主键@TableId
    private Long id;

    //用户名
    private String userName;
    //昵称
    private String nickName;
    //密码
    private String password;
    //用户类型：0代表普通用户，1代表管理员
    private String type;
    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    private String sex;
    //头像
    private String avatar;
    //创建人的用户id
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新人
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第二步: 在Start-framework工程的mapper目录新建UserMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/22 0022 20:47
 */
@Service
public interface UserMapper extends BaseMapper<User> {
}
```

第三步: 在Start-framework工程的service目录新建BlogLoginService接口，写入如下

```java
package com.Start.service;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:38
 */
public interface BlogLoginService {
    ResponseResult login(User user);
}
```

第四步: 在Start-blog工程的src/main/java/com.Start目录新建config.SecurityConfig类，写入如下

```java
package com.Start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()
                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();


        http.logout().disable();
        //允许跨域
        http.cors();
    }

}
```

第五步: 在Start-framework工程的service目录新建impl.UserDetailsServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.Start.domain.LoginUser;
import com.Start.domain.User;
import com.Start.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:59
 */
//当Start-blog的BlogLoginServiceImpl类封装好登录的用户名和密码之后，就会传到当前这个实现类
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    //UserMapper是我们在Start-framework工程mapper目录的接口
    private UserMapper userMapper;

    @Override
    //在这里之前，我们已经拿到了登录的用户名和密码。UserDetails是SpringSecurity官方提供的接口
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据拿到的用户名，并结合查询条件(数据库是否有这个用户名)，去查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);

        //判断是否查询到用户，也就是这个用户是否存在，如果没查到就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在");//后期会对异常进行统一处理
        }

        //TODO 查询权限信息，并封装

        //返回查询到的用户信息。注意下面那行直接返回user会报错，我们需要在Start-framework工程的domain目录新
        //建LoginUser类，在LoginUser类实现UserDetails接口，然后下面那行就返回LoginUser对象
        return new LoginUser(user);
    }
}
```

第六步: 在Start-framework工程的domain目录新建LoginUser类，写入如下

```java
package com.Start.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

/**
 * @author 35238
 * @date 2023/7/22 0022 22:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//UserDetails是SpringSecurity官方提供的接口
public class LoginUser implements UserDetails {

    private User user;

    @Override
    //用于返回权限信息。现在我们正在实现'认证'，'权限'后面才用得到。所以返回null即可
    //当要查询用户信息的时候，我们不能单纯返回null，要重写这个方法，作用是返回权限信息
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    //用于获取用户密码。由于使用的实体类是User，所以获取的是数据库的用户密码
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    //用于获取用户名。由于使用的实体类是User，所以获取的是数据库的用户名
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    //判断登录状态是否过期。把这个改成true，表示永不过期
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //判断账号是否被锁定。把这个改成true，表示未锁定
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //判断登录凭证是否过期。把这个改成true，表示永不过期
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //判断用户是否可用。把这个改成true，表示可用状态
    public boolean isEnabled() {
        return true;
    }
}
```

第七步: 在Start-framework工程的service目录新建impl.BlogLoginServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.Start.domain.LoginUser;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.BlogLoginService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.JwtUtil;
import com.Start.utils.RedisCache;
import com.Start.vo.BlogUserLoginVo;
import com.Start.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:39
 */
@Service
//认证，判断用户登录是否成功
public class BlogLoginServiceImpl implements BlogLoginService {

    @Autowired
    //AuthenticationManager是security官方提供的接口
    private AuthenticationManager authenticationManager;

    @Autowired
    //RedisCache是我们在Start-framework工程的config目录写的类
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //封装登录的用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        //在下一行之前，封装的数据会先走UserDetailsServiceImpl实现类，这个实现类在我们的Start-framework工程的service/impl目录里面
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //上面那一行会得到所有的认证用户信息authenticate。然后下一行需要判断用户认证是否通过，如果authenticate的值是null，就说明认证没有通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        //把这个userid通过我们写的JwtUtil工具类转成密文，这个密文就是token值
        String jwt = JwtUtil.createJWT(userId);

        //下面那行的第一个参数: 把上面那行的jwt，也就是token值保存到Redis。存到时候是键值对的形式，值就是jwt，key要加上 "bloglogin:" 前缀
        //下面那行的第二个参数: 要把哪个对象存入Redis。我们写的是loginUser，里面有权限信息，后面会用到
        redisCache.setCacheObject("bloglogin:"+userId,loginUser);


        //把User转化为UserInfoVo，再放入vo对象的第二个参数
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);
        //封装响应返回
        return ResponseResult.okResult(vo);
    }
}
```

第八步: 在Start-framework工程的vo目录新建BlogUserLoginVo实体类，写入如下

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/7/22 0022 22:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserLoginVo {

    private String token;
    private UserInfoVo userInfo;
}
```

第九步: 在Start-framework工程的vo目录新建UserInfoVo实体类，写入如下

```java
package com.Start.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 35238
 * @date 2023/7/22 0022 22:59
 */
@Data
@Accessors(chain = true)
public class UserInfoVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String sex;

    private String email;

}
```

第十步: 在Start-blog工程的controller目录新建BlogLoginController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:31
 */
@RestController
public class BlogLoginController {

    @Autowired
    //BlogLoginService是我们在service目录写的接口
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    //ResponseResult是我们在Start-framework工程里面写的实体类
    public ResponseResult login(@RequestBody User user){
        return blogLoginService.login(user);
    }

}
```

第十一步: 我把老师提供的sys_user表修改了一下数据，方便后续所有测试，对应sql如下(请在你的表中也执行)，email字段的前几位就是对应的用户密码

```sql
use sg_blog;

update sys_user
set
    user_name = 'Startqc',
    nick_name = '焕发@青春',
    password = '$2a$10$VcIamfDZIvkRP1JJZKYAHOZpsb4Z3LZptJACS9wur9mZoOpTMpsAO',
    email = '228675@Startqc.cn'
where
    id = 1;

update sys_user
set
    user_name = 'HFuser',
    nick_name = '测试用户',
    password = '$2a$10$Cjxu8UwfmUYvgzy7VJexke3suuKNM9bwy8ENHj4UEzBmMZX5p.OBm',
    email = '123@Startqc.cn'
where
    id = 2;

update sys_user
set
    user_name = 'HFadmin',
    nick_name = '测试管理员',
    password = '$2a$10$v9QNSgh6rMgjwuvmgwWJG.wxPWfARyBk/c8oDDQU4JbXI2ufIOyXu',
    email = '123456@Startqc.cn'
where
    id = 3;
    
update sys_user
set
    user_name = '用户01',
    nick_name = '张三',
    password = '$2a$10$Cjxu8UwfmUYvgzy7VJexke3suuKNM9bwy8ENHj4UEzBmMZX5p.OBm',
    email = '123@Startqc.cn'
where
    id = 4;

update sys_user
set
    user_name = '用户02',
    nick_name = '李四',
    password = '$2a$10$Cjxu8UwfmUYvgzy7VJexke3suuKNM9bwy8ENHj4UEzBmMZX5p.OBm',
    email = '123@Startqc.cn'
where
    id = 5;

update sys_user
set
    user_name = '用户03',
    nick_name = '王五',
    password = '$2a$10$Cjxu8UwfmUYvgzy7VJexke3suuKNM9bwy8ENHj4UEzBmMZX5p.OBm',
    email = '123@Startqc.cn'
where
    id = 6;
```

![img](未命名/__项目/assets/1693034011735-2b95d926-3cda-4a2f-a258-56f2be99a6ad.jpg)

第十二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第十三步: 测试。运行Start-blog工程的StartBlogApplication类，用postman测试，POST请求地址、请求体如下

```plain
http://localhost:7777/login
{
    "userName":"HFuser",
    "password":"123"
}
```

![img](未命名/__项目/assets/1693034012039-2abd29f3-e7a1-43d8-822a-722e4a27fc51.jpg)

第十三步: 测试。打开前端项目，浏览器访问如下地址

```plain
http://localhost:8080/#/Login?login=1
```

![img](未命名/__项目/assets/1693034012175-4fc5677c-6112-44bf-a694-0a836ba6510b.jpg)

![img](未命名/__项目/assets/1693034012307-51f33e6e-0880-48ec-b9ad-4e9ecb023c49.jpg)

## 8. 代码实现-认证过滤器

实现校验功能，也就是使用jwt认证过滤器，对用户的登录进行校验，是否有登录状态

分析

- 获取token，由于我们在把token存入Redis的时候加了前缀，所以获取的时候注意前缀
- 解析token获取其中的userid
- 从redis中获取用户信息
- 存入SecurityContextHolder

第一步: 在Start-blog工程的src/main/java/com.Start目录新建filter.JwtAuthenticationTokenFilter类，写入如下，作用是自定义Jwt认证过滤器

```java
package com.Start.filter;

import com.alibaba.fastjson.JSON;
import com.Start.domain.LoginUser;
import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.utils.JwtUtil;
import com.Start.utils.RedisCache;
import com.Start.utils.WebUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/23 0023 13:24
 */
@Component
//博客前台的登录认证过滤器。OncePerRequestFilter是springsecurity提供的类
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    //RedisCache是我们在Start-framework工程写的工具类，用于操作redis
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //获取请求头中的token值
        String token = request.getHeader("token");
        //判断上面那行有没有拿到token值
        if(!StringUtils.hasText(token)){
            //说明该接口不需要登录，直接放行，不拦截
            filterChain.doFilter(request,response);
            return;
        }
        //JwtUtil是我们在Start-framework工程写的工具类。解析获取的token，把原来的密文解析为原文
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            //当token过期或token被篡改就会进入下面那行的异常处理
            e.printStackTrace();
            //报异常之后，把异常响应给前端，需要重新登录。ResponseResult、AppHttpCodeEnum、WebUtils是我们在Start-framework工程写的类
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }
        String userid = claims.getSubject();

        //在redis中，通过key来获取value，注意key我们是加过前缀的，取的时候也要加上前缀
        LoginUser loginUser = redisCache.getCacheObject("bloglogin:" + userid);
        //如果在redis获取不到值，说明登录是过期了，需要重新登录
        if(Objects.isNull(loginUser)){
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }

        //把从redis获取到的value，存入到SecurityContextHolder(Security官方提供的类)
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request,response);

    }
}
```

第二步: 把Start-blog工程的SecurityConfig类修改为如下，作用是把上一步的认证过滤器添加到springsecurity的过滤器链中

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()
                
                //为方便测试认证过滤器，我们把查询友链的接口设置为需要登录才能访问。然后我们去访问的时候就能测试登录认证功能了
                .antMatchers("/link/getAllLink").authenticated()
                
                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();


        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }

}
```

![img](未命名/__项目/assets/1693034012460-e695aabd-445b-4634-b18f-84a284e45a09.jpg)

第三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 运行Start-blog工程的StartBlogApplication类，用postman测试，由于我们在第二步给友链接口添加了登录拦截，所以先GET访问一下

```java
http://localhost:7777/link/getAllLink
```

![img](未命名/__项目/assets/1693034012647-6e7b5aea-b28e-4ee3-9fb1-72fb202e31d5.jpg)

第五步: 测试。在postman发送POST请求登录一个用户，并复制token值，然后拿着token值去访问第四步的请求路径，看是否能访问

```plain
http://localhost:7777/login
{
    "userName":"HFuser",
    "password":"123"
}
```

![img](未命名/__项目/assets/1693034012773-35d9970d-06a0-49e3-8761-b797a2ae19ae.jpg)

![img](未命名/__项目/assets/1693034012944-6eaa6590-a8b7-49c5-8997-cce3467c8a87.jpg)

# 博客前台模块-异常处理

## 1. 认证授权的异常处理

目前我们的项目在认证出错或者权限不足的时候响应回来的Json，默认是使用Security官方提供的响应的格式，但是这种响应的格式肯定是不符合我们项目的接口规范的。所以需要自定义异常处理

我们需要去实现AuthenticationEntryPoint(官方提供的认证失败处理器)类、AccessDeniedHandler(官方提供的授权失败处理器)类，然后配置给Security

![img](未命名/__项目/assets/1693034013068-d466bc71-fa03-46e7-b6e2-e00cc9e38881.jpg)

第一步: 在Start-framework工程的src/main/java/com.Start目录新建handler.security.AuthenticationEntryPointImpl类，写入如下

```java
package com.Start.handler.security;

import com.alibaba.fastjson.JSON;
import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 35238
 * @date 2023/7/23 0023 20:34
 */
@Component
//自定义认证失败的处理器。ResponseResult、AppHttpCodeEnum是我们在Start-framework工程写的类
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        //输出异常信息
        authException.printStackTrace();

        //判断是登录才出现异常(返回'用户名或密码错误')，还是没有登录就访问特定接口才出现的异常(返回'需要登录后访问')，还是其它情况(返回'出现错误')
        ResponseResult result = null;
        if(authException instanceof BadCredentialsException){
            //第一个参数返回的是响应码，AppHttpCodeEnum是我们写的实体类。第二个参数是返回具体的信息
            result = ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR.getCode(),authException.getMessage());
        } else if(authException instanceof InsufficientAuthenticationException){
            //第一个参数返回的是响应码，AppHttpCodeEnum是我们写的实体类
            result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        } else {
            //第一个参数返回的是响应码，AppHttpCodeEnum是我们写的实体类。第二个参数是返回具体的信息
            result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),"认证或授权失败");
        }

        //使用spring提供的JSON工具类，把上一行的result转换成JSON，然后响应给前端。WebUtils是我们写的类
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
```

第二步: 在Start-framework工程的src/main/java/com.Start目录新建handler.security.AccessDeniedHandlerImpl类，写入如下

```java
package com.Start.handler.security;

import com.alibaba.fastjson.JSON;
import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 35238
 * @date 2023/7/23 0023 20:43
 */
//自定义授权失败的处理器
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        //输出异常信息
        accessDeniedException.printStackTrace();

        //ResponseResult、AppHttpCodeEnum是我们在Start-framework工程写的类。重点在下面那行的枚举，就是我们返回给前端的信息
        ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);

        //使用spring提供的JSON工具类，把上一行的result转换成JSON，然后响应给前端。WebUtils是我们写的类
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
```

第三步: 把Start-blog工程的SecurityConfig类修改为如下，作用是把上面两步自定义的处理器配置给Security

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()

                //为方便测试认证过滤器，我们把查询友链的接口设置为需要登录才能访问。然后我们去访问的时候就能测试登录认证功能了
                .antMatchers("/link/getAllLink").authenticated()

                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();

        //把我们写的自定义异常处理器配置给Security
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }

}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 运行Start-blog工程的StartBlogApplication类，用postman测试，测试两种情况，如下

```java
登录失败(POST请求): http://localhost:7777/login
没登录就去访问特定接口(GET请求): http://localhost:7777/link/getAllLink
```

![img](未命名/__项目/assets/1693034013210-15a5b8d7-1805-4fb6-9153-f0d2d5155ce2.jpg)

![img](未命名/__项目/assets/1693034013422-31913c0d-47b9-44a4-92df-ef051b04e03a.jpg)

## 2. 统一异常处理

实际我们在开发过程中可能需要做很多的判断校验，如果出现了非法情况我们是期望响应对应的提示的。但是如果我们每次都自己手动去处理就会非常麻烦。我们可以选择直接抛出异常的方式，然后对异常进行统一处理。把异常中的信息封装成ResponseResult响应给前端

第一步: 在Start-framework工程的src/main/java/com.Start目录新建exception.SystemException类，写入如下。直接复制用

```java
package com.Start.exception;

import com.Start.enums.AppHttpCodeEnum;

/**
 * @author 35238
 * @date 2023/7/23 0023 21:54
 */
//统一异常处理
public class SystemException extends RuntimeException{

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    //定义一个构造方法，接收的参数是枚举类型，AppHttpCodeEnum是我们在Start-framework工程定义的枚举类
    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        //把某个枚举类里面的code和msg赋值给异常对象
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }
}
```

第二步: 在Start-framework工程的src/main/java/com.Start目录新建handler.exception.GlobalExceptionHandler类，写入如下

```java
package com.Start.handler.exception;

import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 35238
 * @date 2023/7/23 0023 22:03
 */
//@ControllerAdvice //对controller层的增强
//@ResponseBody

//或者用下面一个注解代替上面的两个注解
@RestControllerAdvice

//使用Lombok提供的Slf4j注解，实现日志功能
@Slf4j

//全局异常处理。最终都会在这个类进行处理异常
public class GlobalExceptionHandler {

    //SystemException是我们写的类。用户登录的异常交给这里处理
    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e){

        //打印异常信息，方便我们追溯问题的原因。{}是占位符，具体值由e决定
        log.error("出现了异常! {}",e);

        //从异常对象中获取提示信息封装，然后返回。ResponseResult是我们写的类
        return ResponseResult.errorResult(e.getCode(),e.getMsg());
    }

    //其它异常交给这里处理
    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e){

        //打印异常信息，方便我们追溯问题的原因。{}是占位符，具体值由e决定
        log.error("出现了异常! {}",e);

        //从异常对象中获取提示信息封装，然后返回。ResponseResult、AppHttpCodeEnum是我们写的类
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),e.getMessage());//枚举值是500
    }
}
```

第三步: 把BlogLoginController类修改为如下，增加了一个if判断，如果用户在登录时，没有传用户名，就抛一个异常，交给上面两步的两个异常类处理

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:31
 */
@RestController
public class BlogLoginController {

    @Autowired
    //BlogLoginService是我们在service目录写的接口
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    //ResponseResult是我们在Start-framework工程里面写的实体类
    public ResponseResult login(@RequestBody User user){
        //如果用户在进行登录时，没有传入'用户名'
        if(!StringUtils.hasText(user.getUserName())){
            // 提示'必须要传用户名'。AppHttpCodeEnum是我们写的枚举类。SystemException是我们写的统一异常处理的类
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }
}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 测试。运行Start-blog工程的StartBlogApplication类，用postman测试，POST请求地址、请求体如下

```plain
http://localhost:7777/login
{
    "userName":"HFuser",
    "password":"123"
}
```

![img](未命名/__项目/assets/1693034013620-ed65d671-34a8-48d2-8c2c-c528abf16f38.jpg)

![img](未命名/__项目/assets/1693034013819-f47edddd-7473-4d82-87b8-cf698bff2007.jpg)

# 博客前台模块-退出登录

## 1. 接口分析

| 请求方式 | 请求地址 | 请求头          |
| -------- | -------- | --------------- |
| POST     | /logout  | 需要token请求头 |

响应格式:

```json
{
    "code": 200,
    "msg": "操作成功"
}
```

## 2. 代码实现

第一步: 把Start-blog工程的BlogLoginController类修改为如下，新增了退出登录的接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:31
 */
@RestController
public class BlogLoginController {

    @Autowired
    //BlogLoginService是我们在service目录写的接口
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    //ResponseResult是我们在Start-framework工程里面写的实体类
    public ResponseResult login(@RequestBody User user){
        //如果用户在进行登录时，没有传入'用户名'
        if(!StringUtils.hasText(user.getUserName())){
            // 提示'必须要传用户名'。AppHttpCodeEnum是我们写的枚举类。SystemException是我们写的统一异常处理的类
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }
}
```

第二步: 把Start-framework工程的BlogLoginService接口修改为如下，新增了退出登录的方法

```java
package com.Start.service;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:38
 */
public interface BlogLoginService {

    //登录
    ResponseResult login(User user);

    //退出登录
    ResponseResult logout();
}
```

第三步: 把Start-framework工程的BlogLoginServiceImpl类修改为如下，新增了退出登录的核心代码

```java
package com.Start.service.impl;

import com.Start.domain.LoginUser;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.BlogLoginService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.JwtUtil;
import com.Start.utils.RedisCache;
import com.Start.vo.BlogUserLoginVo;
import com.Start.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:39
 */
@Service
//认证，判断用户登录是否成功
public class BlogLoginServiceImpl implements BlogLoginService {

    @Autowired
    //AuthenticationManager是security官方提供的接口
    private AuthenticationManager authenticationManager;

    @Autowired
    //RedisCache是我们在Start-framework工程的config目录写的类
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //封装登录的用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        //在下一行之前，封装的数据会先走UserDetailsServiceImpl实现类，这个实现类在我们的Start-framework工程的service/impl目录里面
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //上面那一行会得到所有的认证用户信息authenticate。然后下一行需要判断用户认证是否通过，如果authenticate的值是null，就说明认证没有通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        //把这个userid通过我们写的JwtUtil工具类转成密文，这个密文就是token值
        String jwt = JwtUtil.createJWT(userId);

        //下面那行的第一个参数: 把上面那行的jwt，也就是token值保存到Redis。存到时候是键值对的形式，值就是jwt，key要加上 "bloglogin:" 前缀
        //下面那行的第二个参数: 要把哪个对象存入Redis。我们写的是loginUser，里面有权限信息，后面会用到
        redisCache.setCacheObject("bloglogin:"+userId,loginUser);


        //把User转化为UserInfoVo，再放入vo对象的第二个参数
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);
        //封装响应返回
        return ResponseResult.okResult(vo);
    }

    //-----------------------------------退出登录------------------------------------------
    
    @Override
    public ResponseResult logout() {
        
        //获取token，然后解析token值获取其中的userid。SecurityContextHolder是security官方提供的类
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //LoginUser是我们写的类
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        //获取userid
        Long userid = loginUser.getUser().getId();

        //在redis根据key来删除用户的value值，注意之前我们在存key的时候，key是加了'bloglogin:'前缀
        redisCache.deleteObject("bloglogin:"+userid);
        //封装响应返回
        return ResponseResult.okResult();
    }
}
```

第四步: 把Start-blog工程的SecurityConfig类修改为如下，增加了需要有登录状态才能执行退出登录，否则就报'401 需要登录后操作'

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()

                //为方便测试认证过滤器，我们把查询友链的接口设置为需要登录才能访问。然后我们去访问的时候就能测试登录认证功能了
                .antMatchers("/link/getAllLink").authenticated()

                //退出登录的配置。如果'没登录'就调用'退出登录'，就会报错，报的错设置为'401 需要登录后操作'，也就是authenticated
                .antMatchers("/logout").authenticated()

                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();

        //把我们写的自定义异常处理器配置给Security
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }

}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-blog工程的StartBlogApplication类，用postman测试，POST请求地址、请求体如下。作用是先登录一个用户

```plain
http://localhost:7777/login
{
    "userName":"HFuser",
    "password":"123"
}
```

![img](未命名/__项目/assets/1693034014020-649bc420-3ed0-4877-b341-1f34991bb3cf.jpg)

第七步: 测试。用postman测试，POST请求地址、请求头如下。作用是测试退出登录

```plain
http://localhost:7777/logout
```

![img](未命名/__项目/assets/1693034014176-abfaa108-7d79-4407-8989-3e5d3ecd1001.jpg)

第八步: 打开web前端项目，浏览器访问如下地址

```plain
http://localhost:8080/#/Login?login=1
```

![img](未命名/__项目/assets/1693034014304-da39b205-9d3f-4d93-9049-69aeefbba229.jpg)

![img](未命名/__项目/assets/1693034014453-5f9f2783-3e7a-418d-aef4-e69b7f9a45c3.jpg)

![img](未命名/__项目/assets/1693034014573-45c7dd1e-857f-45c6-aa4f-f220e955bbcd.jpg)

![img](未命名/__项目/assets/1693034014710-1141558c-27d5-493f-86be-e67f645b6657.jpg)

# 博客前台模块-评论列表

就是把评论的模块展示出来。从数据库查询到数据，然后展示在评论模块里面

## 1. 评论表的字段

![img](未命名/__项目/assets/1693034014842-e1d103ae-93f6-48e4-8118-3bc84d7f4f63.jpg)

![img](未命名/__项目/assets/1693034014996-e689a087-e59d-4b4d-ba9e-4fce81293710.jpg)

## 2. 接口分析

| 请求方式 | 请求地址             | 请求头                                    |
| -------- | -------------------- | ----------------------------------------- |
| GET      | /comment/commentList | 不需要token请求头(未登录也能看到评论信息) |

Query格式请求参数如下:

```plain
articleId:文章id
pageNum:页码
pageSize:每页条数
```

响应格式如下，包含了根评论+子评论:

```json
{
    "code": 200,
    "data": {
        "rows": [
            {
                "articleId": "1",
                "children": [
                    {
                        "articleId": "1",
                        "content": "评论内容(子评论)",
                        "createBy": "1",
                        "createTime": "2022-01-30 10:06:21",
                        "id": "20",
                        "rootId": "1",
                        "toCommentId": "1",
                        "toCommentUserId": "1",
                        "toCommentUserName": "这条评论(子评论)回复的是哪个人",
                        "username": "发这条评论(子评论)的人"
                    }
                ],
                "content": "评论内容(根评论)",
                "createBy": "1",
                "createTime": "2022-01-29 07:59:22",
                "id": "1",
                "rootId": "-1",
                "toCommentId": "-1",
                "toCommentUserId": "-1",
                "username": "发这条评论(根评论)的人"
            }
        ],
        "total": "15"
    },
    "msg": "操作成功"
}
```

## 3. 基础代码

第一步: 在Start-framework工程的domain目录新建Comment类，写入如下

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 评论表(Comment)表实体类
 *
 * @author makejava
 * @since 2023-07-24 23:00:06
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_comment")
public class Comment  {
    @TableId
    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    private String type;
    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    //回复目标评论id
    private Long toCommentId;
    
    private Long createBy;
    
    private Date createTime;
    
    private Long updateBy;
    
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
}
```

第二步: 在Start-framework工程的mapper目录新建CommentMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Comment;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:03
 */
//评论表的表数据访问层
public interface CommentMapper extends BaseMapper<Comment> {
}
```

第三步: 在Start-framework工程的service目录新建CommentService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Comment;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
public interface CommentService extends IService<Comment> {
}
```

第四步: 在Start-framework工程的service目录新建impl.CommentServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.Comment;
import com.Start.mapper.CommentMapper;
import com.Start.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{
}
```

## 4. 实现-不考虑子评论

先实现查询根评论，子评论的查询下一节才学

第一步: 在Start-framework工程的domain目录新建User类，写入如下

```java
package com.Start.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-07-22 20:41:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User  {

    //主键@TableId
    private Long id;

    //用户名
    private String userName;
    //昵称
    private String nickName;
    //密码
    private String password;
    //用户类型：0代表普通用户，1代表管理员
    private String type;
    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    private String sex;
    //头像
    private String avatar;
    //创建人的用户id
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新人
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第二步: 在Start-framework工程的service目录新建UserService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:48
 */
public interface UserService extends IService<User> {
}
```

第三步: 在Start-framework工程的service目录新建UserServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.mapper.UserMapper;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.UserInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:49
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	//已增加UserServiceImpl实现类，此时应该是没有实现方法的
}
```

第四步: 在Start-framework工程的vo目录新建CommentVo类，写入如下

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/7/25 0025 13:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {

    private Long id;

    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //发根评论的userid
    private Long toCommentUserId;
    //发根评论的userName
    private String toCommentUserName;
    //回复目标评论id
    private Long toCommentId;
    //当前评论的创建人id
    private Long createBy;

    private Date createTime;

    //评论是谁发的
    private String username;

}
```

第五步: 把Start-framework工程的SystemCanstants类修改为如下，增加了判定为根评论的常量

```java
package com.Start.constants;

/**
 * @author 35238
 * @date 2023/7/19 0019 19:14
 */
//字面值(代码中的固定值)处理，把字面值都在这里定义成常量。可以把这个类叫做常量类
public class SystemCanstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;

    /**
     * 分类表的分类状态是正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 友链状态为审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 评论区的某条评论是根评论
     */
    public static final String COMMENT_ROOT = "-1";

}
```

第六步: 在Start-framework工程的service目录新建CommentService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
public interface CommentService extends IService<Comment> {
    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);
}
```

第七步: 在Start-framework工程的service目录新建impl.CommentServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;
import com.Start.mapper.CommentMapper;
import com.Start.service.CommentService;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.CommentVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{

    @Autowired
    //根据userid查询用户信息，也就是查username
    private UserService userService;

    @Override
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();

        //对articleId进行判断，作用是得到指定的文章
        queryWrapper.eq(Comment::getArticleId,articleId);

        //对评论区的某条评论的rootID进行判断，如果为-1，就表示是根评论。SystemCanstants是我们写的解决字面值的类
        queryWrapper.eq(Comment::getRootId, SystemCanstants.COMMENT_ROOT);

        //分页查询。查的是整个评论区的每一条评论
        Page<Comment> page  = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);

        //调用下面那个方法
        List<CommentVo> commentVoList = xxToCommentList(page.getRecords());

        return ResponseResult.okResult(new PageVo(commentVoList,page.getTotal()));
    }

    //封装响应返回。CommentVo、BeanCopyUtils、ResponseResult、PageVo是我们写的类
    private List<CommentVo> xxToCommentList(List<Comment> list){
        //获取评论区的所有评论
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        //遍历。由于封装响应好的数据里面没有username字段，所以我们还不能返回给前端。这个遍历就是用来得到username字段
        for (CommentVo commentVo : commentVos) {
            //
            //需要根据commentVo类里面的createBy字段，然后用createBy字段去查询user表的nickname字段(子评论的用户昵称)
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            //然后把nickname字段(发这条子评论的用户昵称)的数据赋值给commentVo类的username字段
            commentVo.setUsername(nickName);

            //查询根评论的用户昵称。怎么判断是根评论的用户呢，判断getToCommentUserId为1，就表示这条评论是根评论
            if(commentVo.getToCommentUserId() != -1){
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                //然后把nickname字段(发这条根评论的用户昵称)的数据赋值给commentVo类的toCommentUserName字段
                commentVo.setToCommentUserName(toCommentUserName);
            }

        }

        //返回给前端
        return commentVos;
    }
}
```

第八步: 在Start-blog工程的controller目录新建CommentController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/25 0025 13:14
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    //CommentService是我们在Start-framework工程写的类
    private CommentService commentService;

    @GetMapping("commentList")
    //ResponseResult是我们在Start-framework工程写的类
    public ResponseResult commentList(Long articleId,Integer pageNum,Integer pageSize){
        return commentService.commentList(articleId,pageNum,pageSize);
    }
}
```

第九步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第十步: 测试。运行Start-blog工程的StartBlogApplication类，用postman测试如下的GET请求

```plain
http://localhost:7777/comment/commentList?articleId=1&pageNum=1&pageSize=1
```

![img](未命名/__项目/assets/1693034015191-49e56914-ad8f-461a-aa9f-3b0a7ba2e563.jpg)

第十一步: 测试。打开web项目，浏览器访问如下，查看文章的评论区

```plain
http://localhost:8080/#/DetailArticle?aid=1
```

![img](未命名/__项目/assets/1693034015334-4eb240f8-d658-458f-9c40-c9acf8058ae2.jpg)

## 5. 实现-考虑子评论

刚刚实现了查询根评论，现在来学习如何也查询子评论

第一步: 把CommentVo类修改为如下，增加了子评论字段

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 35238
 * @date 2023/7/25 0025 13:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {

    private Long id;

    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    //所回复的目标评论的userName
    private String toCommentUserName;
    //回复目标评论id
    private Long toCommentId;
    //当前评论的创建人id
    private Long createBy;

    private Date createTime;

    //评论是谁发的
    private String username;

    //查询子评论
    private List<CommentVo> children;
}
```

第二步: 在Start-framework工程的service目录新建UserServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.mapper.UserMapper;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.UserInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:49
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	//已增加UserServiceImpl实现类，此时应该是没有实现方法的
}
```

第三步: 把CommentServiceImpl修改为如下，增加了查询子评论、子评论按照时间排序、根评论按照时间排序

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;
import com.Start.mapper.CommentMapper;
import com.Start.service.CommentService;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.CommentVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{

    @Autowired
    //根据userid查询用户信息，也就是查username
    private UserService userService;

    @Override
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();

        //对articleId进行判断，作用是得到指定的文章
        queryWrapper.eq(Comment::getArticleId,articleId);

        //对评论区的某条评论的rootID进行判断，如果为-1，就表示是根评论。SystemCanstants是我们写的解决字面值的类
        queryWrapper.eq(Comment::getRootId, SystemCanstants.COMMENT_ROOT);

        //分页查询。查的是整个评论区的每一条评论
        Page<Comment> page  = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);

        //调用下面那个方法。根评论排序
        List<Comment> sortedComments = page.getRecords().stream()
                .sorted(Comparator.comparing(Comment::getCreateTime).reversed())
                .collect(Collectors.toList());
        List<CommentVo> commentVoList = xxToCommentList(sortedComments);

        //遍历(可以用for循环，也可以用stream流)。查询子评论(注意子评论只查到二级评论，不再往深查)
        for (CommentVo commentVo : commentVoList) {
            //查询对应的子评论
            List<CommentVo> children = getChildren(commentVo.getId());
            //把查到的children子评论集的集合，赋值给commentVo类的children字段
            commentVo.setChildren(children);

        }

        return ResponseResult.okResult(new PageVo(commentVoList,page.getTotal()));
    }

    //根据根评论的id，来查询对应的所有子评论(注意子评论只查到二级评论，不再往深查)
    private List<CommentVo> getChildren(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId,id);
        //对子评论按照时间进行排序
        queryWrapper.orderByDesc(Comment::getCreateTime);
        List<Comment> comments = list(queryWrapper);
        //调用下面那个方法
        List<CommentVo> commentVos = xxToCommentList(comments);
        return commentVos;
    }

    //封装响应返回。CommentVo、BeanCopyUtils、ResponseResult、PageVo是我们写的类
    private List<CommentVo> xxToCommentList(List<Comment> list){
        //获取评论区的所有评论
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        //遍历(可以用for循环，也可以用stream流)。由于封装响应好的数据里面没有username字段，所以我们还不能返回给前端。这个遍历就是用来得到username字段
        for (CommentVo commentVo : commentVos) {
            //
            //需要根据commentVo类里面的createBy字段，然后用createBy字段去查询user表的nickname字段(子评论的用户昵称)
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            //然后把nickname字段(发这条子评论的用户昵称)的数据赋值给commentVo类的username字段
            commentVo.setUsername(nickName);

            //查询根评论的用户昵称。怎么判断是根评论的用户呢，判断toCommentId为1，就表示这条评论是根评论
            if(commentVo.getToCommentUserId() != -1){
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                //然后把nickname字段(发这条根评论的用户昵称)的数据赋值给commentVo类的toCommentUserName字段
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }

        //返回给前端
        return commentVos;
    }
}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 测试。运行Start-blog工程的StartBlogApplication类。打开web项目，浏览器访问如下，查看文章的评论区

```plain
http://localhost:8080/#/DetailArticle?aid=1
```

![img](未命名/__项目/assets/1693034015497-415cc419-228a-49a1-a7db-03cd4a142d2d.jpg)

# 博客前台模块-发送评论

## 1. 发送文章评论

在文章的评论区发送评论

### 一. 评论表的字段

![img](未命名/__项目/assets/1693034014842-e1d103ae-93f6-48e4-8118-3bc84d7f4f63.jpg)

![img](未命名/__项目/assets/1693034014996-e689a087-e59d-4b4d-ba9e-4fce81293710.jpg)

### 二. 接口分析

用户登录后可以对文章发表评论，也可以对已有的评论进行回复

| 请求方式 | 请求地址 | 请求头      |
| -------- | -------- | ----------- |
| POST     | /comment | 需要token头 |

【请求体】

回复了文章。0表示文章评论，如果是友链评论，type应该为1：

```json
{"articleId":1,"type":0,"rootId":-1,"toCommentId":-1,"toCommentUserId":-1,"content":"评论了文章"}
```

回复了某条评论。0表示文章评论，如果是友链评论，type应该为1：

```json
{"articleId":1,"type":0,"rootId":"3","toCommentId":"3","toCommentUserId":"1","content":"回复了某条评论"}
```

【响应格式】

```java
{
	"code":200,
	"msg":"操作成功"
}
```

### 三. 文章评论的代码实现

第一步: 在Start-framework工程的utils目录新建SecurityUtils类，写入如下

```java
package com.Start.utils;

import com.Start.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author 35238
 * @date 2023/7/26 0026 20:43
 */

//在'发送评论'功能那里会用到的工具类
public class SecurityUtils {

    /**
     * 获取用户的userid
     **/
    public static LoginUser getLoginUser() {
        return (LoginUser) getAuthentication().getPrincipal();
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 指定userid为1的用户就是网站管理员
     * @return
     */
    public static Boolean isAdmin(){
        Long id = getLoginUser().getUser().getId();
        return id != null && 1L == id;
    }

    public static Long getUserId() {
        return getLoginUser().getUser().getId();
    }
}
```

第二步: 在Start-framework工程的handler目录新建mybatisplus.MyMetaObjectHandler类，写入如下

```java
package com.Start.handler.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.Start.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/7/26 0026 20:52
 */
@Component
//这个类是用来配置mybatis的字段自动填充。用于'发送评论'功能，由于我们在评论表无法对下面这四个字段进行插入数据(原因是前端在发送评论时，没有在
//请求体提供下面四个参数，所以后端在往数据库插入数据时，下面四个字段是空值)，所有就需要这个类来帮助我们往下面这四个字段自动的插入值，
//只要我们更新了评论表的字段，那么无法插入值的字段就自动有值了
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    //只要对数据库执行了插入语句，那么就会执行到这个方法
    public void insertFill(MetaObject metaObject) {
        Long userId = null;
        try {
            //获取用户id
            userId = SecurityUtils.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
            userId = -1L;//如果异常了，就说明该用户还没注册，我们就把该用户的userid字段赋值d为-1
        }
        //自动把下面四个字段新增了值。
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy",userId , metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", userId, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName(" ", SecurityUtils.getUserId(), metaObject);
    }
}
```

第三步: 把Start-framework工程的Comment类修改为如下，增加了具体的自动填充规则

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 评论表(Comment)表实体类
 *
 * @author makejava
 * @since 2023-07-24 23:00:06
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_comment")
public class Comment  {
    @TableId
    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    private String type;
    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    //回复目标评论id
    private Long toCommentId;

    //由于我们在MyMetaObjectHandler类配置了mybatisplus的字段自动填充
    //所以就能指定哪个字段在什么时候进行自动填充，例如该类其它字段新增了数据，那么createBy字段就会自动填充值
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    //由于我们在MyMetaObjectHandler类配置了mybatisplus的字段自动填充
    //所以就能指定哪个字段在什么时候进行自动填充，例如该类其它字段新增了数据，那么createTime字段就会自动填充值
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //由于我们在MyMetaObjectHandler类配置了mybatisplus的字段自动填充
    //所以就能指定哪个字段在什么时候进行自动填充，例如该类其它字段新增或更新了数据，那么createBy字段就会自动填充值
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;

    //由于我们在MyMetaObjectHandler类配置了mybatisplus的字段自动填充
    //所以就能指定哪个字段在什么时候进行自动填充，例如该类其它字段新增或更新了数据，那么updateTime字段就会自动填充值
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
}
```

第四步: 把Start-framework工程的AppHttpCodeEnum类修改为如下，增加了一个枚举变量来限制用户要发送的评论内容不能为空

```java
package com.Start.enums;

/**
 * @author 35238
 * @date 2023/7/19 0019 12:52
 */
public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"), EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    CONTENT_NOT_NULL(506, "发送的评论内容不能为空"),
    LOGIN_ERROR(505,"用户名或密码错误");
    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
```

第五步: 把Start-framework工程的CommentService接口修改为如下，增加了发送评论的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
public interface CommentService extends IService<Comment> {

    //查询评论区的评论
    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);

    //在文章的评论区发送评论
    ResponseResult addComment(Comment comment);
}
```

第六步: 把Start-framework工程的CommentServiceImpl类，增加了发送评论的代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.mapper.CommentMapper;
import com.Start.service.CommentService;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.CommentVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{

    @Autowired
    //根据userid查询用户信息，也就是查username
    private UserService userService;

    @Override
    //查询评论区的评论
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();

        //对articleId进行判断，作用是得到指定的文章
        queryWrapper.eq(Comment::getArticleId,articleId);

        //对评论区的某条评论的rootID进行判断，如果为-1，就表示是根评论。SystemCanstants是我们写的解决字面值的类
        queryWrapper.eq(Comment::getRootId, SystemCanstants.COMMENT_ROOT);

        //分页查询。查的是整个评论区的每一条评论
        Page<Comment> page  = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);

        //调用下面那个方法。根评论排序
        List<Comment> sortedComments = page.getRecords().stream()
                .sorted(Comparator.comparing(Comment::getCreateTime).reversed())
                .collect(Collectors.toList());
        List<CommentVo> commentVoList = xxToCommentList(sortedComments);

        //遍历(可以用for循环，也可以用stream流)。查询子评论(注意子评论只查到二级评论，不再往深查)
        for (CommentVo commentVo : commentVoList) {
            //查询对应的子评论
            List<CommentVo> children = getChildren(commentVo.getId());
            //把查到的children子评论集的集合，赋值给commentVo类的children字段
            commentVo.setChildren(children);

        }

        return ResponseResult.okResult(new PageVo(commentVoList,page.getTotal()));
    }

    //在文章的评论区发送评论
    @Override
    public ResponseResult addComment(Comment comment) {
        //注意前端在调用这个发送评论接口时，在请求体是没有向我们传入createTime、createId、updateTime、updateID字段，所以
        //我们这里往后端插入数据时，就会导致上面那行的四个字段没有值
        //为了解决这个问题，我们在Start-framework工程新增了MyMetaObjectHandler类、修改了Comment类。详细可自己定位去看一下代码

        //限制用户在发送评论时，评论内容不能为空。如果为空就抛出异常
        if(!StringUtils.hasText(comment.getContent())){
            //AppHttpCodeEnum是我们写的枚举类，CONTENT_NOT_NULL代表提示''
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }

        //解决了四个字段没有值的情况，就可以直接调用mybatisplus提供的save方法往数据库插入数据(用户发送的评论的各个字段)了
        save(comment);

        //封装响应返回
        return ResponseResult.okResult();
    }

    //-------------------------------下面是一些方便调用的方法--------------------------------------

    //根据根评论的id，来查询对应的所有子评论(注意子评论只查到二级评论，不再往深查)
    private List<CommentVo> getChildren(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId,id);
        //对子评论按照时间进行排序
        queryWrapper.orderByDesc(Comment::getCreateTime);
        List<Comment> comments = list(queryWrapper);
        //调用下面那个方法
        List<CommentVo> commentVos = xxToCommentList(comments);
        return commentVos;
    }

    //封装响应返回。CommentVo、BeanCopyUtils、ResponseResult、PageVo是我们写的类
    private List<CommentVo> xxToCommentList(List<Comment> list){
        //获取评论区的所有评论
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        //遍历(可以用for循环，也可以用stream流)。由于封装响应好的数据里面没有username字段，所以我们还不能返回给前端。这个遍历就是用来得到username字段
        for (CommentVo commentVo : commentVos) {
            //
            //需要根据commentVo类里面的createBy字段，然后用createBy字段去查询user表的nickname字段(子评论的用户昵称)
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            //然后把nickname字段(发这条子评论的用户昵称)的数据赋值给commentVo类的username字段
            commentVo.setUsername(nickName);

            //查询根评论的用户昵称。怎么判断是根评论的用户呢，判断toCommentId为1，就表示这条评论是根评论
            if(commentVo.getToCommentUserId() != -1){
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                //然后把nickname字段(发这条根评论的用户昵称)的数据赋值给commentVo类的toCommentUserName字段
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }

        //返回给前端
        return commentVos;
    }
}
```

第七步: 把Start-blog工程的CommentController修改为如下，增加了发送评论的请求路径

```java
package com.Start.controller;

import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;
import com.Start.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/25 0025 13:14
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    //CommentService是我们在Start-framework工程写的类
    private CommentService commentService;

    @GetMapping("commentList")
    //ResponseResult是我们在Start-framework工程写的类
    public ResponseResult commentList(Long articleId,Integer pageNum,Integer pageSize){
        return commentService.commentList(articleId,pageNum,pageSize);
    }

    @PostMapping
    //在文章的评论区发送评论。ResponseResult是我们在Start-framework工程写的类
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}
```

第八步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第九步: 测试。运行Start-blog工程的StartBlogApplication类。打开web项目，浏览器访问如下，查看文章的评论区

```plain
http://localhost:8080/#/DetailArticle?aid=1
```

![img](未命名/__项目/assets/1693034015622-6b4bd8d5-5658-45da-89c1-6c00ecaa639e.jpg)

![img](未命名/__项目/assets/1693034015762-6957565e-41d4-4145-8180-d54ea4b57ac7.jpg)

## 2. 发送友链评论

在友链的评论区发送评论

### 一. 评论表的字段

![img](未命名/__项目/assets/1693034014842-e1d103ae-93f6-48e4-8118-3bc84d7f4f63.jpg)

![img](未命名/__项目/assets/1693034014996-e689a087-e59d-4b4d-ba9e-4fce81293710.jpg)

### 二. 接口分析

用户登录后可以对友链发表评论，也可以对已有的评论进行回复

| 请求方式 | 请求地址                 | 请求头            |
| -------- | ------------------------ | ----------------- |
| GET      | /comment/linkCommentList | 不需要token请求头 |

Query格式请求参数：

```plain
pageNum: 页码
pageSize: 每页条数
```

响应格式:

```json
{
    "code": 200,
    "data": {
        "rows": [
            {
                "articleId": "1",
                "children": [
                    {
                        "articleId": "1",
                        "content": "回复友链评论3",
                        "createBy": "1",
                        "createTime": "2022-01-30 10:08:50",
                        "id": "23",
                        "rootId": "22",
                        "toCommentId": "22",
                        "toCommentUserId": "1",
                        "toCommentUserName": "sg333",
                        "username": "sg333"
                    }
                ],
                "content": "友链评论2",
                "createBy": "1",
                "createTime": "2022-01-30 10:08:28",
                "id": "22",
                "rootId": "-1",
                "toCommentId": "-1",
                "toCommentUserId": "-1",
                "username": "sg333"
            }
        ],
        "total": "1"
    },
    "msg": "操作成功"
}
```

### 三、代码实现

第一步: 把Start-framework工程的SystemCanstants类修改为如下，增加了区分文章、友链的评论类型

```java
package com.Start.constants;

/**
 * @author 35238
 * @date 2023/7/19 0019 19:14
 */
//字面值(代码中的固定值)处理，把字面值都在这里定义成常量。可以把这个类叫做常量类
public class SystemCanstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;

    /**
     * 分类表的分类状态是正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 友链状态为审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 评论区的某条评论是根评论
     */
    public static final String COMMENT_ROOT = "-1";

    /**
     * 文章的评论
     */
    public static final String ARTICLE_COMMENT = "0";

    /**
     * 友链的评论
     */
    public static final String LINK_COMMENT = "1";
}
```

第二步: 把Start-framework工程的CommentService接口修改为如下，为CommentList方法增加了commentType参数类型

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
public interface CommentService extends IService<Comment> {

    //查询评论区的评论。增加了commentType参数，用于区分文章的评论区、友链的评论区
    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    //在文章的评论区发送评论
    ResponseResult addComment(Comment comment);
}
```

第三步: 把Start-framework工程的CommentServiceImpl类修改为如下，稍微修改了commentList方法

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.mapper.CommentMapper;
import com.Start.service.CommentService;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.CommentVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/24 0024 23:08
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{

    @Autowired
    //根据userid查询用户信息，也就是查username
    private UserService userService;

    @Override
    //查询评论区的评论
    public ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize) {

        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();

        //对articleId进行判断，作用是得到指定的文章。如果是文章评论，才会判断articleId，避免友链评论判断articleId时出现空指针
        queryWrapper.eq(SystemCanstants.ARTICLE_COMMENT.equals(commentType),Comment::getArticleId,articleId);

        //对评论区的某条评论的rootID进行判断，如果为-1，就表示是根评论。SystemCanstants是我们写的解决字面值的类
        queryWrapper.eq(Comment::getRootId, SystemCanstants.COMMENT_ROOT);

        //文章的评论，避免查到友链的评论
        queryWrapper.eq(Comment::getType,commentType);

        //分页查询。查的是整个评论区的每一条评论
        Page<Comment> page  = new Page<>(pageNum,pageSize);
        page(page,queryWrapper);

        //调用下面那个方法。根评论排序
        List<Comment> sortedComments = page.getRecords().stream()
                .sorted(Comparator.comparing(Comment::getCreateTime).reversed())
                .collect(Collectors.toList());
        List<CommentVo> commentVoList = xxToCommentList(sortedComments);

        //遍历(可以用for循环，也可以用stream流)。查询子评论(注意子评论只查到二级评论，不再往深查)
        for (CommentVo commentVo : commentVoList) {
            //查询对应的子评论
            List<CommentVo> children = getChildren(commentVo.getId());
            //把查到的children子评论集的集合，赋值给commentVo类的children字段
            commentVo.setChildren(children);

        }

        return ResponseResult.okResult(new PageVo(commentVoList,page.getTotal()));
    }

    //在文章的评论区发送评论
    @Override
    public ResponseResult addComment(Comment comment) {
        //注意前端在调用这个发送评论接口时，在请求体是没有向我们传入createTime、createId、updateTime、updateID字段，所以
        //我们这里往后端插入数据时，就会导致上面那行的四个字段没有值
        //为了解决这个问题，我们在Start-framework工程新增了MyMetaObjectHandler类、修改了Comment类。详细可自己定位去看一下代码

        //限制用户在发送评论时，评论内容不能为空。如果为空就抛出异常
        if(!StringUtils.hasText(comment.getContent())){
            //AppHttpCodeEnum是我们写的枚举类，CONTENT_NOT_NULL代表提示''
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }

        //解决了四个字段没有值的情况，就可以直接调用mybatisplus提供的save方法往数据库插入数据(用户发送的评论的各个字段)了
        save(comment);

        //封装响应返回
        return ResponseResult.okResult();
    }

    //-------------------------------下面是一些方便调用的方法--------------------------------------

    //根据根评论的id，来查询对应的所有子评论(注意子评论只查到二级评论，不再往深查)
    private List<CommentVo> getChildren(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId,id);
        //对子评论按照时间进行排序
        queryWrapper.orderByDesc(Comment::getCreateTime);
        List<Comment> comments = list(queryWrapper);
        //调用下面那个方法
        List<CommentVo> commentVos = xxToCommentList(comments);
        return commentVos;
    }

    //封装响应返回。CommentVo、BeanCopyUtils、ResponseResult、PageVo是我们写的类
    private List<CommentVo> xxToCommentList(List<Comment> list){
        //获取评论区的所有评论
        List<CommentVo> commentVos = BeanCopyUtils.copyBeanList(list, CommentVo.class);
        //遍历(可以用for循环，也可以用stream流)。由于封装响应好的数据里面没有username字段，所以我们还不能返回给前端。这个遍历就是用来得到username字段
        for (CommentVo commentVo : commentVos) {
            //
            //需要根据commentVo类里面的createBy字段，然后用createBy字段去查询user表的nickname字段(子评论的用户昵称)
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            //然后把nickname字段(发这条子评论的用户昵称)的数据赋值给commentVo类的username字段
            commentVo.setUsername(nickName);

            //查询根评论的用户昵称。怎么判断是根评论的用户呢，判断toCommentId为1，就表示这条评论是根评论
            if(commentVo.getToCommentUserId() != -1){
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                //然后把nickname字段(发这条根评论的用户昵称)的数据赋值给commentVo类的toCommentUserName字段
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }

        //返回给前端
        return commentVos;
    }
}
```

第四步: 把Start-blog工程的CommentController类修改为如下，增加了linkCommentList方法

```java
package com.Start.controller;

import com.Start.constants.SystemCanstants;
import com.Start.domain.Comment;
import com.Start.domain.ResponseResult;
import com.Start.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/25 0025 13:14
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    //CommentService是我们在Start-framework工程写的类
    private CommentService commentService;

    @GetMapping("commentList")
    //ResponseResult是我们在Start-framework工程写的类
    public ResponseResult commentList(Long articleId,Integer pageNum,Integer pageSize){
        //SystemCanstants是我们写的用来解决字面值的常量类，Article_COMMENT代表0
        return commentService.commentList(SystemCanstants.ARTICLE_COMMENT,articleId,pageNum,pageSize);
    }

    @PostMapping
    //在文章的评论区发送评论。ResponseResult是我们在Start-framework工程写的类
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping("/linkCommentList")
    //在友链的评论区发送评论。ResponseResult是我们在Start-framework工程写的类
    public ResponseResult linkCommentList(Integer pageNum,Integer pageSize){
        //commentService是我们刚刚实现文章的评论区发送评论功能时(当时用的是addComment方法，现在用commentList方法)，写的类
        //SystemCanstants是我们写的用来解决字面值的常量类，Article_LINK代表1
        return commentService.commentList(SystemCanstants.LINK_COMMENT,null,pageNum,pageSize);
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-blog工程的StartBlogApplication类。打开web项目，浏览器访问如下，在友链的评论区测试发送评论

```java
http://localhost:8080/#/Friendslink
```

![img](未命名/__项目/assets/1693034015907-1d2b75fe-a5c1-46af-ac77-12199389a801.jpg)

### 四、友链页面的登录bug

每次点击打开友链页面都会弹出重新登录的弹窗，如下图

![img](未命名/__项目/assets/1693034016038-1de6dd04-bb04-4568-8b20-07a3c96fd0e5.jpg)

原因:友链接口被后端拦截了，前端是不携带token来访问友链接口，原本沟通好是不需要认证就可以访问友链接口的，而后端却写着要认证

解决: 把Start-blog工程的SecurityConfig类修改为如下，只是注释了/link/getAllLink接口的登录限制

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()

                //为方便测试认证过滤器，我们把查询友链的接口设置为需要登录才能访问。然后我们去访问的时候就能测试登录认证功能了
//                .antMatchers("/link/getAllLink").authenticated()

                //退出登录的配置。如果'没登录'就调用'退出登录'，就会报错，报的错设置为'401 需要登录后操作'，也就是authenticated
                .antMatchers("/logout").authenticated()

                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();

        //把我们写的自定义异常处理器配置给Security
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }
}
```

# 博客前台模块-个人信息

## 1. 用户表的字段

![img](未命名/__项目/assets/1693034011446-2fe6f4fd-8b50-4840-8ec7-467050bdaf58.jpg)

![img](未命名/__项目/assets/1693034011591-f34cd80d-b080-4c2f-b9a7-c82d0fefad50.jpg)

## 2. 接口分析

进入个人中心的时候需要能够查看当前用户信息。请求不需要参数

| 请求方式 | 请求地址       | 请求头          |
| -------- | -------------- | --------------- |
| GET      | /user/userInfo | 需要token请求头 |

响应格式:

```json
{
	"code":200,
	"data":{
		"avatar":"头像的网络地址",
		"email":"123@qq.com",
		"id":"1",
		"nickName":"用户名",
		"sex":"1"
	},
	"msg":"操作成功"
}
```

## 3. 代码实现

第一步: 把Start-framework工程的UserService接口修改为如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:48
 */
public interface UserService extends IService<User> {
    //个人信息查询
    ResponseResult userInfo();
}
```

第二步: 把Start-framework工程的UserServiceImpl类修改为如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.mapper.UserMapper;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.UserInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:49
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    //查询个人信息
    public ResponseResult userInfo() {

        //获取当前用户的用户id。SecurityUtils是我们在Start-framework工程写的类
        Long userId = SecurityUtils.getUserId();

        //根据用户id查询用户信息
        User user = getById(userId);

        //封装成UserInfoVo(我们在Start-framework工程写的类)，然后返回
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }
}
```

第三步: 把Start-blog工程的SecurityConfig类修改为如下，增加了/user/userInfo接口的访问限制

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()

                //为方便测试认证过滤器，我们把查询友链的接口设置为需要登录才能访问。然后我们去访问的时候就能测试登录认证功能了
//                .antMatchers("/link/getAllLink").authenticated()

                //为方便测试查询个人信息，我们把查询个人信息的接口设置为需要登录才能访问
                .antMatchers("/user/userInfo").authenticated()

                //退出登录的配置。如果'没登录'就调用'退出登录'，就会报错，报的错设置为'401 需要登录后操作'，也就是authenticated
                .antMatchers("/logout").authenticated()

                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();

        //把我们写的自定义异常处理器配置给Security
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }
}
```

第四步: 在Start-blog工程的src/main/java/com.Start.controller目录新建UserController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/27 0027 15:18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    //UserService是我们在Start-framework工程写的接口
    private UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo(){
        return userService.userInfo();
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-blog工程的StartBlogApplication类。打开web项目，浏览器访问如下，登录后点击 '个人信息'

```java
http://localhost:8080/#/UserInfo
```

![img](未命名/__项目/assets/1693034016174-de23ceee-963a-4224-bb87-af53e56c3480.jpg)

# 博客前台模块-文件上传

介绍: 刚刚我们完成了查询个人信息的功能，可以发现在个人中心有一个编辑选项，我们可以对个人信息进行编辑，其中，我们先解决用户头像的编辑，也就是下面要学习的头像文件上传

## 1. 基础-为什么使用OSS

因为如果把图片视频等文件上传到自己的应用的Web服务器的某个目录下，在读取图片的时候会占用比较多的资源。影响应用服务器的性能。所以我们一般使用OSS(Object Storage Service对象存储服务)存储图片或视频

## 2. 基础-七牛云基本使用

![img](未命名/__项目/assets/1693034016309-2f5c6565-951b-4577-84a2-4fd2c5c24af5.jpg)

![img](未命名/__项目/assets/1693034016463-ed98032e-02b4-4ef0-b216-a9f6fac0ad7b.jpg)

![img](未命名/__项目/assets/1693034016603-4a2f8636-5fa8-461b-bcbc-828204698cb5.jpg)

![img](未命名/__项目/assets/1693034016726-82124d76-3058-4fc2-8fde-7fe744a8a40e.jpg)

## 3. 基础-上传文件到七牛云

把 'D:\MyUploadFile' 目录的 'myhead.jpg' 文件上传到七牛云的对象存储的Start-blog桶

第一步: 在Start-framework工程的pom.xml修改为如下，添加了相关坐标

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringBootBlog</artifactId>
        <groupId>com.Start</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Start-framework</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-web</artifactId>
        </dependency>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-test</artifactId>
        </dependency>
        <!--SpringSecurity启动器。需要用到登录功能就解开，不然就注释掉-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-security</artifactId>
        </dependency>
        <!--redis依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-data-redis</artifactId>
        </dependency>
        <!--fastjson依赖-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
        </dependency>
        <!--jwt依赖-->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt</artifactId>
        </dependency>
        <!--mybatisPlus依赖-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-Starter</artifactId>
        </dependency>
        <!--mysql数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <!--阿里云OSS-->
        <dependency>
            <groupId>com.aliyun.oss</groupId>
            <artifactId>aliyun-sdk-oss</artifactId>
        </dependency>

        <!--七牛云OOS-->
        <dependency>
            <groupId>com.qiniu</groupId>
            <artifactId>qiniu-java-sdk</artifactId>
            <version>[7.7.0, 7.7.99]</version>
        </dependency>

        <!--AOP-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-Starter-aop</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>easyexcel</artifactId>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>

    </dependencies>

</project>
```

![img](未命名/__项目/assets/1693034016876-47ee167a-bc1c-4ff9-a404-c9af63d24973.jpg)

第二步: 结合七牛云官方文档(直接把 '数据流'代码 拷贝过来进行相应修改)。在Start-blog工程的src/test/java目录创建com.Start.OSSTest类，写入如下

![img](未命名/__项目/assets/1693034016999-d4ae178c-d2a9-4830-8704-64802df3e717.jpg)

![img](未命名/__项目/assets/1693034017162-a38e4450-8cde-4fe8-bf47-aeb5931e7c62.jpg)

![img](未命名/__项目/assets/1693034017380-f29d27bc-c93c-4be6-bc67-5be413bb1b95.jpg)

![img](未命名/__项目/assets/1693034017541-7c752d63-aea3-4e85-9e8d-cbe2e45deed6.jpg)

```java
package com.Start;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 35238
 * @date 2023/7/28 0028 14:44
 */
@Component
@SpringBootTest
@ConfigurationProperties(prefix = "myoss")//指定读取application.yml文件的myoss属性的数据
public class OSSTest {

    //注意要从application.yml读取属性数据，下面的3个成员变量的名字必须对应application.yml的myoss属性的三个子属性名字
    private String xxaccessKey;
    private String xxsecretKey;
    private String xxbucket;
    public void setXxaccessKey(String xxaccessKey) {
        this.xxaccessKey = xxaccessKey;
    }
    public void setXxsecretKey(String xxsecretKey) {
        this.xxsecretKey = xxsecretKey;
    }
    public void setXxbucket(String xxbucket) {
        this.xxbucket = xxbucket;
    }

    @Test
    public void testOss(){
        //构造一个带指定 Region 对象的配置类。你的七牛云OSS创建的是哪个区域的，那么就调用Region的什么方法即可
        Configuration cfg = new Configuration(Region.huanan());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        UploadManager uploadManager = new UploadManager(cfg);

        //打开七牛云，把鼠标悬浮在右上角的个人头像，然后就会看到'密钥管理'，点击进入就有你的密钥，把其中的AK和SK复制到下面两行
        //String accessKey = "_ibGP9wytjLCAZPqcFaWQNxbw7fMUvofSOvOFFR3";
        //String secretKey = "QSOAU-cv3sSDGNfVNPF6iXz-PsP5X9QTrjFI9zYw";
        //String bucket = "Start-blog";
        //为避免上面3行暴露信息，我们会把信息写到application.yml里面，然后添加ConfigurationProperties注解、3个成员变量即可读取

        //文件名，如果写成null的话，就以文件内容的hash值作为文件名
        String key = null;

        try {

            //byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
            //ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);

            //上面两行是官方写的(注释掉)，下面那几行是我们写的
            InputStream xxinputStream = new FileInputStream("D:\\MyUploadFile\\myhead.jpg");

            Auth auth = Auth.create(xxaccessKey, xxsecretKey);
            String upToken = auth.uploadToken(xxbucket);

            try {
                Response response = uploadManager.put(xxinputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println("上传成功! 生成的key是: "+putRet.key);
                System.out.println("上传成功! 生成的hash是: "+putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        }catch (Exception e) {
            //ignore
        }
    }
}
```

第三步: 把Start-blog工程的application.yml修改为如下，增加了自定义属性，也就是myoss

```yaml
server:
  port: 7777

spring:
  # 数据库连接信息
  datasource:
    url: jdbc:mysql://localhost:3306/sg_blog?characterEncoding=utf-8&serverTimezone=Asia/Shanghai
    username: root
    password: 228675
    driver-class-name: com.mysql.cj.jdbc.Driver

  servlet:
    # 文件上传
    multipart:
      # 单个上传文件的最大允许大小
      max-file-size: 20MB
      # HTTP请求中包含的所有文件的总大小的最大允许值
      max-request-size: 20MB

mybatis-plus:
  configuration:
    # 日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      # 逻辑删除的字段
      logic-delete-field: delFlag
      # 代表已删除的值
      logic-delete-value: 1
      # 代表未删除的值
      logic-not-delete-value: 0
      # 主键自增策略，以mysql数据库为准
      id-type: auto

# 打开七牛云，找到密钥管理，把相关信息填写到下面3行，会被Start-blog工程的OOSTest类获取
myoss:
  xxaccessKey: _ibGP9wytjLCAZPqcFaWQNxbw7fMUvofSOvOFFR3
  xxsecretKey: QSOAU-cv3sSDGNfVNPF6iXz-PsP5X9QTrjFI9zYw
  xxbucket: Start-blog
```

第四步: 运行OSSTest类的testOss方法，打开七牛云，查看对象存储的文件管理那里，有没有新文件

![img](未命名/__项目/assets/1693034017697-46001a56-0e4f-43b2-8401-a731449cc3da.jpg)

## 4. 基础-指定文件存放目录

刚刚我们实现了，把本地文件上传到了七牛云的Start-blog桶，并且是直接存放在桶的根目录，我们能不能通过代码在桶里面新建目录，然后把上传的文件放到指定目录呢，很简单，我们把key写为 "目录1/目录2/文件名" 这种格式即可，上传到七牛云的文件就会自动有自己的所属目录了

第一步: 把Start-blog工程的OSSTest类修改为如下，添加了key的赋值

```java
package com.Start;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 35238
 * @date 2023/7/28 0028 14:44
 */
@Component
@SpringBootTest
@ConfigurationProperties(prefix = "myoss")//指定读取application.yml文件的myoss属性的数据
public class OSSTest {

    //注意要从application.yml读取属性数据，下面的3个成员变量的名字必须对应application.yml的myoss属性的三个子属性名字
    private String xxaccessKey;
    private String xxsecretKey;
    private String xxbucket;
    public void setXxaccessKey(String xxaccessKey) {
        this.xxaccessKey = xxaccessKey;
    }
    public void setXxsecretKey(String xxsecretKey) {
        this.xxsecretKey = xxsecretKey;
    }
    public void setXxbucket(String xxbucket) {
        this.xxbucket = xxbucket;
    }

    @Test
    public void testOss(){
        //构造一个带指定 Region 对象的配置类。你的七牛云OSS创建的是哪个区域的，那么就调用Region的什么方法即可
        Configuration cfg = new Configuration(Region.huanan());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        UploadManager uploadManager = new UploadManager(cfg);

        //打开七牛云，把鼠标悬浮在右上角的个人头像，然后就会看到'密钥管理'，点击进入就有你的密钥，把其中的AK和SK复制到下面两行
        //String accessKey = "_ibGP9wytjLCAZPqcFaWQNxbw7fMUvofSOvOFFR3";
        //String secretKey = "QSOAU-cv3sSDGNfVNPF6iXz-PsP5X9QTrjFI9zYw";
        //String bucket = "Start-blog";
        //为避免上面3行暴露信息，我们会把信息写到application.yml里面，然后添加ConfigurationProperties注解、3个成员变量即可读取

        //文件名，如果写成null的话，就以文件内容的hash值作为文件名
        String key = "2023/7/my01.jpg";

        try {

            //byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
            //ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);

            //上面两行是官方写的(注释掉)，下面那几行是我们写的
            InputStream xxinputStream = new FileInputStream("D:\\MyUploadFile\\myhead.jpg");

            Auth auth = Auth.create(xxaccessKey, xxsecretKey);
            String upToken = auth.uploadToken(xxbucket);

            try {
                Response response = uploadManager.put(xxinputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println("上传成功! 生成的key是: "+putRet.key);
                System.out.println("上传成功! 生成的hash是: "+putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        }catch (Exception e) {
            //ignore
        }
    }
}
```

第二步: 运行OSSTest类的testOss方法，打开七牛云，查看对象存储的文件管理那里，有没有新目录+新文件

![img](未命名/__项目/assets/1693034017922-e11eaef8-a6b0-47df-9208-f5bb5f4c9fab.jpg)

![img](未命名/__项目/assets/1693034018146-ddcd701d-3bf0-4bdf-977e-32b801fc12e1.jpg)

![img](未命名/__项目/assets/1693034018414-f101dcf0-617f-4e45-a6ae-e52ae53ea700.jpg)

第三步: 如果要在七牛云的页面删除某个目录，那么必须先删除这个目录里面的所有文件，然后这个目录就会自动删除掉

## 5. 项目-接口分析

上面我们学习了文件上传的相关知识和操作。下面就回到我们的博客项目，实现头像上传的功能

在个人中心点击编辑的时候可以上传头像图片。上传完头像后，可以用于更新个人信息接口

| 请求方式 | 请求地址 | 请求头    |
| -------- | -------- | --------- |
| POST     | /upload  | 需要token |

参数:

```plain
img，值为要上传的文件
```

请求头：

```plain
Content-Type ：multipart/form-data;
```

响应格式:

```json
{
    "code": 200,
    "data": "文件的访问网址",
    "msg": "操作成功"
}
```

## 6. 项目-代码实现

第一步: 把Start-blog工程的SecurityConfig类修改为如下，增加需要登录才能进行文件上传

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()

                //为方便测试认证过滤器，我们把查询友链的接口设置为需要登录才能访问。然后我们去访问的时候就能测试登录认证功能了
//                .antMatchers("/link/getAllLink").authenticated()

                //为方便测试查询个人信息，我们把查询个人信息的接口设置为需要登录才能访问
                .antMatchers("/user/userInfo").authenticated()

                //退出登录的配置。如果'没登录'就调用'退出登录'，就会报错，报的错设置为'401 需要登录后操作'，也就是authenticated
                .antMatchers("/logout").authenticated()

                //把文件上传的接口设置为需要登录才能访问
//                .antMatchers("/upload").authenticated()

                //需要登录才能在评论区发送评论
                .antMatchers("/comment").authenticated()

                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();

        //把我们写的自定义异常处理器配置给Security
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }
}
```

第二步: 把Start-framework工程的AppHttpCodeEnum类修改为如下，增加了提示文件类型错误的枚举

```java
package com.Start.enums;

/**
 * @author 35238
 * @date 2023/7/19 0019 12:52
 */
public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"), EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    CONTENT_NOT_NULL(506, "发送的评论内容不能为空"),
    FILE_TYPE_ERROR(507, "文件类型错误，请上传jpg/png文件"),
    FILE_SIZE_ERROR(413, "文件大小不能超出2MB"),
    LOGIN_ERROR(505,"用户名或密码错误");
    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
```

第三步: 在Start-framework工程的utils目录新建PathUtils类，写入如下，作用是把某个文件名重命名为我们指定的文件名，且修改文件存放路径

```java
package com.Start.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 35238
 * @date 2023/7/29 0029 12:45
 */
//对原始文件名进行修改文件名，并修改存放目录
public class PathUtils {

    public static String generateFilePath(String fileName){
        //根据日期生成路径   2022/1/15/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        String datePath = sdf.format(new Date());
        //uuid作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //后缀和文件后缀一致
        int index = fileName.lastIndexOf(".");
        // test.jpg -> .jpg
        String fileType = fileName.substring(index);
        return new StringBuilder().append(datePath).append(uuid).append(fileType).toString();
    }
}
```

第四步: 在Start-framework工程的service目录新建OssUploadService接口，写入如下

```java
package com.Start.service;

import com.Start.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 35238
 * @date 2023/7/29 0029 11:32
 */
public interface OssUploadService {
    //图片上传到七牛云
    ResponseResult uploadImg(MultipartFile img);
}
```

第五步: 在Start-framework工程的service目录新建impl.OssUploadServiceImpl类，写入如下，文件上传的具体代码

```java
package com.Start.service.impl;

import com.google.gson.Gson;
import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.OssUploadService;
import com.Start.utils.PathUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author 35238
 * @date 2023/7/29 0029 11:41
 */
@Service
@Data//为成员变量生成get和set方法
@ConfigurationProperties(prefix = "myoss") //把OSSTest测试类的这一行注释掉，不然myoss被两个类读取会报错
//把文件上传到七牛云
public class OssUploadServiceImpl implements OssUploadService {

    @Override
    //MultipartFile是spring提供的接口
    public ResponseResult uploadImg(MultipartFile img) {

        //获取原始文件名
        String originalFilename = img.getOriginalFilename();

        // 获取文件大小
        long fileSize = img.getSize();

        // 判断文件大小是否超过2MB（2MB=2*1024*1024 bytes）
        if (fileSize > 2 * 1024 * 1024) {
            // 抛出文件大小超过限制的异常
            throw new SystemException(AppHttpCodeEnum.FILE_SIZE_ERROR);
        }

        //对原始文件名进行判断大小。只能上传png或jpg文件
        if(!originalFilename.endsWith(".png") && !originalFilename.endsWith(".jpg")){
            //AppHttpCodeEnum是我们在Start-framework写的枚举类，FILE_TYPE_ERROR代表文件类型错误的提示
            throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
        }

        //如果满足判断条件，则上传文件到七牛云OSS，并得到一个图片外链访问地址。PathUtil是我们在Start-framework工程写的工具类
        //PathUtils.generateFilePath(originalFilename)表示把原始文件名转换成指定文件名
        String filePath = PathUtils.generateFilePath(originalFilename);

        //下面用于调用的uploadOss方法返回的必须是String类型
        String url = uploadOss(img,filePath);
        //把得到的外链地址返回给前端
        return ResponseResult.okResult(url);
    }

    //----------------------------------上传文件到七牛云----------------------------------------

    //注意要从application.yml读取属性数据，下面的3个成员变量的名字必须对应application.yml的myoss属性的三个子属性名字
    private String xxaccessKey;
    private String xxsecretKey;
    private String xxbucket;

    //上传文件的具体代码。MultipartFile是spring提供的接口，作用是实现文件上传
    private String uploadOss(MultipartFile imgFile, String filePath){
        //构造一个带指定 Region 对象的配置类。你的七牛云OSS创建的是哪个区域的，那么就调用Region的什么方法即可
        Configuration cfg = new Configuration(Region.huanan());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        UploadManager uploadManager = new UploadManager(cfg);

        //打开七牛云，把鼠标悬浮在右上角的个人头像，然后就会看到'密钥管理'，点击进入就有你的密钥，把其中的AK和SK复制到下面两行
        //String accessKey = "_ibGP9wytjLCAZPqcFaWQNxbw7fMUvofSOvOFFR3";
        //String secretKey = "QSOAU-cv3sSDGNfVNPF6iXz-PsP5X9QTrjFI9zYw";
        //String bucket = "Start-blog";
        //为避免上面3行暴露信息，我们会把信息写到application.yml里面，然后添加ConfigurationProperties注解、3个成员变量即可读取

        //文件名，如果写成null的话，就以文件内容的hash值作为文件名
        String key = filePath;

        try {

            //byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
            //ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);

            //上面两行是官方写的(注释掉)，下面那几行是我们写的
            //把前端传过来的文件转换成InputStream对象
            InputStream xxinputStream = imgFile.getInputStream();

            Auth auth = Auth.create(xxaccessKey, xxsecretKey);
            String upToken = auth.uploadToken(xxbucket);

            try {
                //把前端传过来的xxinputStream图片上传到七牛云
                Response response = uploadManager.put(xxinputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println("上传成功! 生成的key是: "+putRet.key);
                System.out.println("上传成功! 生成的hash是: "+putRet.hash);
                return "http://ryhsvluq3.hn-bkt.clouddn.com/"+key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        }catch (Exception e) {
            //ignore
        }
        return "上传失败";
    }
}
```

第六步: 在Start-blog工程的controller目录新建UploadController类，写入如下，作用是暴露接口给前端访问

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.service.OssUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 35238
 * @date 2023/7/29 0029 11:17
 */
@RestController
public class UploadController {

    @Autowired
    //UploadService是我们在Start-framework写的接口
    private OssUploadService ossUploadService;

    @PostMapping("/upload")
    //MultipartFile是spring提供的接口，ResponseResult是我们在Start-framework写的实体类
    public ResponseResult uploadImg(MultipartFile img){
        //图片上传到七牛云
        return ossUploadService.uploadImg(img);
    }
}
```

第七步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第八步: 测试。运行Start-blog工程的StartBlogApplication类

第九步: 测试。在postman进行测试，先登录(POST请求)，然后拿到token、并选择本机某张图片去访问(POST请求)图片上传接口

```json
【登录】
http://localhost:7777/login
{
    "userName":"HFuser",
    "password":"123"
}

【访问】
http://localhost:7777/upload
```

![img](未命名/__项目/assets/1693034018628-bf642623-1f17-485f-abba-6bb9dad48b27.jpg)

![img](未命名/__项目/assets/1693034018768-2b96c942-f76c-4221-986c-f0f3a2be1cd9.jpg)

![img](未命名/__项目/assets/1693034018926-cff5fd3b-6825-4808-9892-725c277e5e51.jpg)

![img](未命名/__项目/assets/1693034019108-cda2cdc8-0a4a-4024-a117-f7a693dfceb9.jpg)

第十步: 测试。打开web项目，浏览器访问如下，登录后点击 '个人信息'，然后测试头像的上传

```plain
http://localhost:8080/#/UserInfo
```

![img](未命名/__项目/assets/1693034019340-8e1f6f4a-c01c-4bcc-8dc2-18d4c028f44b.jpg)

## 7. 项目-更新个人信息

在编辑完个人资料后点击保存会对个人资料进行更新。

| 请求方式 | 请求地址       | 请求头          |
| -------- | -------------- | --------------- |
| PUT      | /user/userInfo | 需要token请求头 |

请求体中json格式数据：

```json
{
    "avatar":"图片url地址",
    "email":"23412332@qq.com",
    "id":"1",
    "nickName":"用户昵称",
    "sex":"1"
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

第一步: 把Start-blog工程的UserController类修改为如下，增加了更新个人信息的访问方式

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/27 0027 15:18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    //UserService是我们在Start-framework工程写的接口
    private UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo(){
        //查询个人信息
        return userService.userInfo();
    }

    @PutMapping("userInfo")
    public ResponseResult  updateUserInfo(@RequestBody User user){
        //更新个人信息
        return userService.updateUserInfo(user);
    }
}
```

第二步: 把Start-framework工程的UserService接口修改为如下，增加了更新个人信息的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:48
 */
public interface UserService extends IService<User> {
    //查询个人信息
    ResponseResult userInfo();

    //更新个人信息
    ResponseResult updateUserInfo(User user);
}
```

第三步: 把Start-framework工程的UserServiceImpl类修改为如下，增加了更新个人信息的具体代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.mapper.UserMapper;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.UserInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:49
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    //查询个人信息
    public ResponseResult userInfo() {

        //获取当前用户的用户id。SecurityUtils是我们在Start-framework工程写的类
        Long userId = SecurityUtils.getUserId();

        //根据用户id查询用户信息
        User user = getById(userId);

        //封装成UserInfoVo(我们在Start-framework工程写的类)，然后返回
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    //更新个人信息
    public ResponseResult updateUserInfo(User user) {
        //updateById是mybatisplus提供的方法
        updateById(user);
        return ResponseResult.okResult();
    }
}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 测试。运行Start-blog工程的StartBlogApplication类

第六步: 测试。打开web项目，浏览器访问如下，登录后点击 '个人信息'，然后编辑昵称、头像、性别，最后点击提交，看是否提交成功

```java
http://localhost:8080/#/UserInfo
```

![img](未命名/__项目/assets/1693034019541-1324d774-2013-4f0e-902f-5a19211a08e7.jpg)

# 博客前台模块-注册功能

## 1. 注册的页面

![img](未命名/__项目/assets/1693034019681-ec061f89-1abc-4c30-9f7c-5cf67ec3ac99.jpg)

## 2. 接口分析

要求用户能够在注册界面完成用户的注册。要求用户名，昵称，邮箱不能和数据库中原有的数据重复。如果某项重复了注册失败并且要有对应的提示。并且要求用户名，密码，昵称，邮箱都不能为空。注意:密码必须密文存储到数据库中

| 请求方式 | 请求地址       | 请求头            |
| -------- | -------------- | ----------------- |
| POST     | /user/register | 不需要token请求头 |

请求体中json格式数据：

```json
{
  "email": "string",
  "nickName": "string",
  "password": "string",
  "userName": "string"
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

## 3. 代码实现

第一步: 把Start-framework工程的AppHttpCodeEnum枚举类修改为如下，增加了用户的相关信息为空、不存在的提示

```java
package com.Start.enums;

/**
 * @author 35238
 * @date 2023/7/19 0019 12:52
 */
public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"),
    EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    CONTENT_NOT_NULL(506, "发送的评论内容不能为空"),
    FILE_TYPE_ERROR(507, "文件类型错误，请上传jpg/png文件"),
    USERNAME_NOT_NULL(508, "用户名不能为空"),
    NICKNAME_NOT_NULL(509, "昵称不能为空"),
    PASSWORD_NOT_NULL(510, "密码不能为空"),
    EMAIL_NOT_NULL(511, "邮箱不能为空"),
    NICKNAME_EXIST(512, "昵称已经存在"),
    PHONENUMBER_NOT_NULL(521, "手机号码不能为空"),
    FILE_SIZE_ERROR(413, "文件大小不能超出2MB"),
    LOGIN_ERROR(505,"用户名或密码错误");
    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
```

第二步: 在数据库执行如下，让主键id使用自增策略，原因是我们等下不使用mybatisplus提供的雪花算法。执行之后重启mysql

```sql
use sg_blog;
alter table sys_user modify column id int auto_increment;
```

第三步: 把Start-framework工程的User类修改为如下，作用是把雪花算法禁用，使用主键自增策略

```java
package com.Start.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-07-22 20:41:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User  {

    //主键，禁用雪花算法，使用mysql的主键自增策略
    @TableId(type = IdType.AUTO)
    private Long id;

    //用户名
    private String userName;
    //昵称
    private String nickName;
    //密码
    private String password;
    //用户类型：0代表普通用户，1代表管理员
    private String type;
    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    private String sex;
    //头像
    private String avatar;
    //创建人的用户id
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新人
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第四步: 把Start-framework工程的UserService接口修改为如下，增加了用户注册接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:48
 */
public interface UserService extends IService<User> {
    //查询个人信息
    ResponseResult userInfo();

    //更新个人信息
    ResponseResult updateUserInfo(User user);

    //用户注册功能
    ResponseResult register(User user);
}
```

第五步: 把Start-framework工程的UserServiceImpl类修改为如下 ，增加了用户注册的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.mapper.UserMapper;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:49
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    //查询个人信息的具体代码
    public ResponseResult userInfo() {

        //获取当前用户的用户id。SecurityUtils是我们在Start-framework工程写的类
        Long userId = SecurityUtils.getUserId();

        //根据用户id查询用户信息
        User user = getById(userId);

        //封装成UserInfoVo(我们在Start-framework工程写的类)，然后返回
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    //更新个人信息的具体代码
    public ResponseResult updateUserInfo(User user) {
        //updateById是mybatisplus提供的方法
        updateById(user);
        return ResponseResult.okResult();
    }

    @Autowired
    //解密和加密用的这套算法。我们在Start-blog工程的securityConfig类里面覆盖过PasswordEncoder这个bean
    private PasswordEncoder passwordEncoder;

    @Override
    //用户注册功能的具体代码
    public ResponseResult register(User user) {

        //对前端传过来的用户名进行非空判断，例如null、""，就抛出异常
        if(!StringUtils.hasText(user.getUserName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        //密码
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        //邮箱
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        //昵称
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //手机号码
        if(!StringUtils.hasText(user.getPhonenumber())){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_NOT_NULL);
        }

        //判断用户传给我们的用户名是否在数据库已经存在。userNameExist方法是下面定义的
        if(userNameExist(user.getUserName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        //判断用户传给我们的昵称是否在数据库已经存在。NickNameExist方法是下面定义的
        if(NickNameExist(user.getNickName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //判断用户传给我们的邮箱是否在数据库已经存在。NickNameExist方法是下面定义的
        if(EmailExist(user.getEmail())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        //判断用户传给我们的手机号码是否在数据库已经存在。PhonenumberExist方法是下面定义的
        if(PhonenumberExist(user.getPhonenumber())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }

        //经过上面的判断，可以确保用户传给我们的用户名和昵称是数据库不存在的，且相关字段都不为空。就可以存入数据库
        //注意用户传给我们的密码是明文，对于密码我们要转成密文之后再存入数据库。注意加密要和解密用同一套算法
        //在Start-blog工程的securityConfig类里面有解密算法，当时我们写了一个passwordEncoder方法，并且注入到了spring容器
        String encodePassword = passwordEncoder.encode(user.getPassword());//加密
        user.setPassword(encodePassword);
        //存入数据库。save方法是mybatisplus提供的方法
        save(user);

        //封装响应返回
        return ResponseResult.okResult();
    }

    //'判断用户传给我们的用户名是否在数据库已经存在' 的方法
    private boolean userNameExist(String userName) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的用户名跟数据库里面的用户名进行比较
        queryWrapper.eq(User::getUserName,userName);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的昵称是否在数据库已经存在' 的方法
    private boolean NickNameExist(String nickName) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的昵称跟数据库里面的昵称进行比较
        queryWrapper.eq(User::getNickName,nickName);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的邮箱是否在数据库已经存在' 的方法
    private boolean EmailExist(String email) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的昵称跟数据库里面的昵称进行比较
        queryWrapper.eq(User::getEmail,email);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的手机号码是否在数据库已经存在' 的方法
    private boolean PhonenumberExist(String Phonenumber) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的手机号码跟数据库里面的手机号码进行比较
        queryWrapper.eq(User::getPhonenumber,Phonenumber);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }
}
```

第六步: 把Start-blog工程的UserController类修改为如下，增加了用户注册的访问方式

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/27 0027 15:18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    //UserService是我们在Start-framework工程写的接口
    private UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo(){
        //查询个人信息
        return userService.userInfo();
    }

    @PutMapping("userInfo")
    public ResponseResult  updateUserInfo(@RequestBody User user){
        //更新个人信息
        return userService.updateUserInfo(user);
    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        //注册功能
        return userService.register(user);
    }
}
```

第七步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第八步: 测试。运行Start-blog工程的StartBlogApplication类

第九步: 测试。运行vue前端项目，然后在浏览器访问如下，测试用户注册功能

```java
http://localhost:8080/#/Login?login=0
```

![img](未命名/__项目/assets/1693034019817-0e057240-a459-44cb-a328-45708de94f34.jpg)

第十步: 前端的测试页面，没有手机号码的输入框，我去改了一下前端，把手机号码带上了，测试如下图

![img](未命名/__项目/assets/1693034019983-eaf7c16a-24b3-446e-a1d3-09e2a0eab3e0.jpg)

# 博客前台模块-日志记录

## 1. 需求分析

需要通过日志记录接口调用信息。便于后期调试排查。并且可能有很多接口都需要进行日志的记录。接口被调用时日志打印格式如下:

```java
log.info("======================Start======================");
// 打印请求 URL
log.info("请求URL   : {}",);
// 打印描述信息
log.info("接口描述   : {}", );
// 打印 Http method
log.info("请求方式   : {}", );
// 打印调用 controller 的全路径以及执行方法
log.info("请求类名   : {}.{}", );
// 打印请求的 IP
log.info("访问IP    : {}",);
// 打印请求入参
log.info("传入参数   : {}",);
// 打印出参
log.info("返回参数   : {}", );
// 结束后换行
log.info("=======================end=======================" + System.lineSeparator());
```

相当于是对原有的功能进行增强。并且是批量的增强，这个时候就非常适合用AOP来进行实现，不对业务代码进行侵入，完全解耦

## 2. AOP实现日志记录的分析

定义切面类，在切面类通过 '切点表达式' 或 '自定义注解'，来指定切点

切面类: 指定要增强哪个切点，里面写通知的方法，通知的方法里面写具体的增强代码

AOP中的通知方法有五种，如下

| 通知方法 | 描述                                                         |
| -------- | ------------------------------------------------------------ |
| 前置通知 | 在一个方法执行之前的阶段，执行通知。可以在目标方法执行前做一些预处理操作 |
| 后置通知 | 在一个方法执行之后的阶段，执行通知。通常用于执行一些清理操作或日志记录 |
| 异常通知 | 在方法抛出异常退出时执行的通知。用于处理目标方法抛出的异常情况 |
| 最终通知 | 无论目标方法是否成功执行，最终通知总会被执行，常用于释放资源 |
| 环绕通知 | 环绕通知是AOP中最灵活的通知类型。能在目标方法前后完全控制连接点，决定是否执行目标方法并进行额外处理 |

## 3. AOP实现日志记录的代码

第一步(已做可跳过): 在Start-framework工程的pom.xml添加如下

```xml
<!--AOP-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-Starter-aop</artifactId>
</dependency>
```

第二步: 在Start-framework工程的src/main/java/com/Start目录新建annotation.mySystemlog接口，写入如下，作为自定义注解的接口

```java
package com.Start.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 35238
 * @date 2023/7/30 0030 21:20
 */
@Retention(RetentionPolicy.RUNTIME)//表示mySystemlog注解类会保持到runtime阶段
@Target(ElementType.METHOD) //表示mySystemlog注解类的注解功能只能用于方法上
//'自定义注解'类，以后就可以使用@mySystemlog注解了，注解名就是下面那行的接口名
public @interface mySystemlog {

    //为controller提供接口的描述信息，用于'日志记录'功能
    String xxbusinessName();

}
```

第三步: 在Start-framework工程的src/main/java/com/Start目录新建aspect.myLogAspect类，写入如下，作为切面类

```java
package com.Start.aspect;

import com.alibaba.fastjson.JSON;
import com.Start.annotation.mySystemlog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 35238
 * @date 2023/7/30 0030 21:37
 */
@Component
@Aspect//告诉spring容器，myLogAspect是切面类
@Slf4j//用于在控制台打印日志信息
public class myLogAspect {

    @Pointcut("@annotation(com.Start.annotation.mySystemlog)")
    //确定哪个切点，以后哪个类想成为切点，就在哪个类添加上面那行的注解。例如下面这个xxpt()就是切点
    public void xxpt(){

    }

    //定义通知的方法(这里用的是环绕通知)，通知的方法也就是增强的具体代码。@Around注解表示该通知的方法会用在哪个切点
    @Around("xxpt()")
    //ProceedingJoinPoint可以拿到被增强方法的信息
    public Object xxprintLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //proceed方法表示调用目标方法，ret就是目标方法执行完之后的返回值
        Object ret;
        try {
            //调用下面写的'实现打印日志信息的格式信息'的方法
            xxhandleBefore(joinPoint);
            ret = joinPoint.proceed();//这是目标方法执行完成，上一行是目标方法未执行，下一行是目标方法已经执行
            //调用下面写的'实现打印日志信息的数据信息'的方法
            xxhandleAfter(ret);
        } finally {
            //下面的'实现打印日志信息的数据信息'的方法，不管有没有出异常都会被执行，确保下面的输出必然输出在控制台
            //System.lineSeparator表示当前系统的换行符
            log.info("=======================end=======================" + System.lineSeparator());
        }

        //封装成切面，然后返回
        return ret;
    }

    //上面的xxprintLog方法执行之前会去调用下面这个xxhandleBefore方法
    private void xxhandleBefore(ProceedingJoinPoint joinPoint) {

        //ServletRequestAttributes是RequestAttributes是spring接口的实现类
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        //下面那行就可以拿到请求的报文了，其中有我们需要的url、请求方式、ip。这里拿到的request会在下面的log中大量使用
        HttpServletRequest request = requestAttributes.getRequest();

        //获取被增强方法的注解对象，例如获取UserController类的updateUserInfo方法上一行的@mySystemlog注解
        //getSystemlog是我们下面写的方法
        mySystemlog systemlog = getSystemlog(joinPoint);

        log.info("======================Start======================");//下面的几个log输出，第一个参数{}表示占位符，具体的值是第二个参数的变量
        // 打印请求 URL
        log.info("请求URL   : {}",request.getRequestURL());
        // 打印描述信息，例如获取UserController类的updateUserInfo方法上一行的@mySystemlog注解的描述信息
        log.info("接口描述   : {}",systemlog.xxbusinessName());
        // 打印 Http method
        log.info("请求方式   : {}",request.getMethod());
        // 打印调用 controller 的全路径(全类名)、方法名
        log.info("请求类名   : {}.{}",joinPoint.getSignature().getDeclaringTypeName(),((MethodSignature) joinPoint.getSignature()).getName());
        // 打印请求的 IP
        log.info("访问IP    : {}",request.getRemoteHost());
        // 打印请求入参。JSON.toJSONString十FastJson提供的工具方法，能把数组转成JSON
        log.info("传入参数   : {}", JSON.toJSONString(joinPoint.getArgs()));
    }

    //上面的xxprintLog方法执行之后会去调用下面这个xxhandleAfter方法
    private void xxhandleAfter(Object ret) {
        // 打印出参。JSON.toJSONString十FastJson提供的工具方法，能把数组转成JSON
        log.info("返回参数   : {}",JSON.toJSONString(ret));
    }

    //获取被增强方法的注解对象，例如获取UserController类的updateUserInfo方法上一行的@mySystemlog注解
    private mySystemlog getSystemlog(ProceedingJoinPoint joinPoint) {
        //Signature是spring提供的接口，MethodSignature是Signature的子接口
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //mySystemlog是我们写的自定义注解的接口
        //下面那行就能获取被增强方法的注解对象，例如获取UserController类的updateUserInfo方法上一行的@mySystemlog注解
        mySystemlog systemlog = methodSignature.getMethod().getAnnotation(mySystemlog.class);
        return systemlog;
    }
}
```

第四步: 把Start-blog工程的application.yml修改为如下，作用是注释掉mybatisplus的日志信息，避免对我们的日志信息造成干扰

```yaml
server:
  port: 7777

spring:
  # 数据库连接信息
  datasource:
    url: jdbc:mysql://localhost:3306/sg_blog?characterEncoding=utf-8&serverTimezone=Asia/Shanghai
    username: root
    password: 228675
    driver-class-name: com.mysql.cj.jdbc.Driver

  servlet:
    # 文件上传
    multipart:
      # 单个上传文件的最大允许大小
      max-file-size: 20MB
      # HTTP请求中包含的所有文件的总大小的最大允许值
      max-request-size: 20MB

mybatis-plus:
#  configuration:
#    # 日志
#    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      # 逻辑删除的字段
      logic-delete-field: delFlag
      # 代表已删除的值
      logic-delete-value: 1
      # 代表未删除的值
      logic-not-delete-value: 0
      # 主键自增策略，以mysql数据库为准
      id-type: auto

# 打开七牛云，找到密钥管理，把相关信息填写到下面3行，会被Start-blog工程的OOSTest类获取
myoss:
  xxaccessKey: _ibGP9wytjLCAZPqcFaWQNxbw7fMUvofSOvOFFR3
  xxsecretKey: QSOAU-cv3sSDGNfVNPF6iXz-PsP5X9QTrjFI9zYw
  xxbucket: Start-blog
```

第五步: 把Start-blog工程的UserController类修改为如下，作用是在每一个业务访问接口添加自定义的@mySystemlog注解，并添加xxbusinessName属性，属性值就是你这个业务接口的作用描述(看着业务自己写描述就行)。拓展: 在每一个Controller都这样做

```java
package com.Start.controller;

import com.Start.annotation.mySystemlog;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/7/27 0027 15:18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    //UserService是我们在Start-framework工程写的接口
    private UserService userService;

    @GetMapping("/userInfo")
    @mySystemlog(xxbusinessName = "查询个人信息")//接口描述，用于'日志记录'功能
    public ResponseResult userInfo(){
        //查询个人信息
        return userService.userInfo();
    }

    @PutMapping("userInfo")
    @mySystemlog(xxbusinessName = "更新用户信息")//接口描述，用于'日志记录'功能
    public ResponseResult updateUserInfo(@RequestBody User user){
        //更新个人信息
        return userService.updateUserInfo(user);
    }

    @PostMapping("/register")
    @mySystemlog(xxbusinessName = "用户注册")//接口描述，用于'日志记录'功能
    public ResponseResult register(@RequestBody User user){
        //注册功能
        return userService.register(user);
    }
}
```

第六步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第七步: 测试。运行Start-blog工程的StartBlogApplication类

第八步: 测试。运行vue前端项目，然后在浏览器随便访问，测试idea控制台是否打印相应的日志记录

![img](未命名/__项目/assets/1693034020156-438e6de6-f7f9-401d-b9a5-09dd3e982087.jpg)

# 博客前台模块-浏览次数

## 1. 项目-思路分析

在用户浏览博文时要实现对应博客浏览量的增加。我们只需要在每次用户浏览博客时更新对应的浏览数即可

但是如果直接操作博客表的浏览量的话，在并发量大的情况下会出现什么问题呢？如何去优化呢？如下四点

①在应用启动时把博客的浏览量存储到redis中 - 项目启动的预处理功能

②更新浏览量时去更新redis中的数据

③每隔3分钟把Redis中的浏览量更新到数据库中 - 定时任务功能

④读取文章浏览量时从redis读取

在实现 '浏览次数' 功能之前，我们先学习一下必要的基础知识，如下

## 2. 基础-启动预处理

如果希望在SpringBoot应用启动时进行一些初始化操作可以选择使用CommandLineRunner接口来进行处理。

我们只需要实现CommandLineRunner接口，并且把对应的bean注入容器。把相关初始化的代码重新到需要重新的方法中。

这样就会在应用启动的时候执行对应的代码。

第一步: 在Start-blog工程的src/main/java/com.Start目录新建runner.myCommandLineRunner类，写入如下

```java
package com.Start.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author 35238
 * @date 2023/7/31 0031 14:25
 */
@Component
//项目启动时，该类负责预处理一些代码。CommandLineRunner是spring提供的接口
public class myCommandLineRunner implements CommandLineRunner {
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("程序初始化");
    }
}
```

第二步: 运行Start-blog工程的StartBlogApplication类，查看控制台。只是了解基础知识，跟项目暂时无关

![img](未命名/__项目/assets/1693034020414-b7b87e80-d64d-451f-83ca-aad4e318784b.jpg)

## 3. 基础-定时任务

定时任务的实现方式有很多，比如XXL-Job等。但是其实核心功能和概念都是类似的，很多情况下只是调用的API不同而已

这里就先用SpringBoot为我们提供的定时任务的API来实现一个简单的定时任务，先对定时任务里面的一些核心概念有个大致的了解

第一步: 在Start-blog工程的StartBlogApplication类添加如下，作用是在配置类添加@EnableScheduling注解，就能开启定时任务功能

```java
package com.Start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 35238
 * @date 2023/7/18 0018 19:13
 */

@SpringBootApplication
@MapperScan("com.Start.mapper")
@EnableScheduling//@EnableScheduling是spring提供的定时任务的注解
public class StartBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartBlogApplication.class,args);
    }
}
```

第二步: 在src/main/java/com.Start目录新建cronjob.myJob类，写入如下

```java
package com.Start.cronjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

/**
 * @author 35238
 * @date 2023/7/31 0031 15:02
 */
@Component//当前这个类要作为bean，且注入容器，否则不会生效
//定时任务
public class myJob {

    @Scheduled(cron = "0/5 * * * * ?")//在哪个方法添加了@Scheduled注解，哪个方法就会定时去执行
    //上面那行@Scheduled注解的cron属性就是具体的定时规则。从每一分钟的0秒开始，每隔5秒钟就会执行下面那行的xxJob()方法
    public void xxJob(){
        //要定时执行的代码
        System.out.println("定时任务执行了，现在的时间是: "+ LocalTime.now());
    }
}
```

第三步: 运行Start-blog工程的StartBlogApplication类，查看控制台。只是了解基础知识，跟项目暂时无关

![img](未命名/__项目/assets/1693034020618-0cd97638-3f44-41f8-8f4a-19f45de7b684.jpg)

## 4. 基础-cron表达式

```basic
常用表达式例子

  （1）0/2 * * * * ?   表示每2秒 执行任务

  （1）0 0/2 * * * ?    表示每2分钟 执行任务

  （1）0 0 2 1 * ?   表示在每月的1日的凌晨2点调整任务

  （2）0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业

  （3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作

  （4）0 0 10,14,16 * * ?   每天上午10点，下午2点，4点 

  （5）0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时 

  （6）0 0 12 ? * WED    表示每个星期三中午12点 

  （7）0 0 12 * * ?   每天中午12点触发 

  （8）0 15 10 ? * *    每天上午10:15触发 

  （9）0 15 10 * * ?     每天上午10:15触发 

  （10）0 15 10 * * ?    每天上午10:15触发 

  （11）0 15 10 * * ? 2005    2005年的每天上午10:15触发 

  （12）0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发 

  （13）0 0/5 14 * * ?    在每天下午2点到下午2:55期间的每5分钟触发 

  （14）0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 

  （15）0 0-5 14 * * ?    在每天下午2点到下午2:05期间的每1分钟触发 

  （16）0 10,44 14 ? 3 WED    每年三月的星期三的下午2:10和2:44触发 

  （17）0 15 10 ? * MON-FRI    周一至周五的上午10:15触发 

  （18）0 15 10 15 * ?    每月15日上午10:15触发 

  （19）0 15 10 L * ?    每月最后一日的上午10:15触发 

  （20）0 15 10 ? * 6L    每月的最后一个星期五上午10:15触发 

  （21）0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发 

  （22）0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发
```

在刚刚的定时任务，spring提供的@Scheduled注解里面的cron属性，是控制定时规则的。我们下面有必要学习一下cron属性的基本语法、特色符号

cron表达式是用来设置定时任务执行时间的表达式。不会写的话，去这个cron表达式生成器网站 -> https://www.bejson.com/othertools/cron/

cron表达式由七部分组成，中间由空格分隔，这七部分从左往右依次是:

```plain
秒(0~59)，分钟(0~59)，小时(0~23)，日期(1-月最后一天)，月份(1-12)，星期几(1-7,1表示星期日)，年份(可不写)
```

(1) *星号用来代表任意值，如下表示 "每年每月每天每时每分每秒"

```plain
* * * * * ?
```

(2) ,逗号可以用来定义列表，如下表示 "每年每月每天每时每分的每个第1秒，第2秒，第3秒"

```plain
1,2,3 * * * * ?
```

(3) -短斜杠用来定义范围，如下表示 "每年每月每天每时每分的第1秒至第3秒"

```plain
1-3 * * * * ?
```

(4) /正斜杠用来代表每隔多少，如下表示 "每年每月每天每时每分，从第5秒开始，每10秒一次 "。正斜杠的左侧是开始值(0可以省略不写)，右侧是间隔

```plain
5/10 * * * * ?
```

日期部分还可允许特殊字符： ? L W

星期部分还可允许的特殊字符: ? L #

(1) ?问号只能用在日期和星期部分。表示没有具体的值，使用?要注意冲突。日期和星期两个部分如果其中一个部分设置了值，则另一个必须设置为 " ? "

【正确写法】

```plain
0\* * * 2 * ?    每个月的第2天，每分钟都执行任务
0\* * * ? * 2    每周的星期二，每分钟都执行任务
```

【错误写法-同时使用?和同时不使用?都是不对的】

```plain
* * * 2 * 2
* * * ? * ?
```

(2) W字母只能用在日期中，表示当月中最接近某天的工作日

```plain
0 0 0 31W * ?
```

表示最接近31号的工作日，如果31号是星期六，则表示30号，即星期五，如果31号是星期天，则表示29号，即星期五。如果31号是星期三，则表示31号本身，即星期三

(3) L字母只能用在日期和星期中，表示最后。在日期中表示每月最后一天，在一月份中表示31号，在六月份中表示30号

也可以表示每月倒是第N天。例如： L-2表示每个月的倒数第2天

在星期中表示7即星期六

```plain
0 0 0 ? * L
表示每个星期六
0 0 0 ? * 6L
若前面有其他值的话，则表示最后一个星期几，即每月的最后一个星期五
```

(4) LW可以连起来用，表示每月最后一个工作日，即每月最后一个星期五，如下

```plain
0 0 0 LW * ?
```

(5) #字符只能用在星期中，表示第几个星期几

```plain
0 0 0 ? * 6#3
表示每个月的第三个星期五。
```

## 5. 项目-接口分析

在用户浏览博文时要实现对应博客浏览量的增加。我们只需要在每次用户浏览博客时更新对应的浏览数即可

| 请求方式 | 请求地址                      | 请求头            |
| -------- | ----------------------------- | ----------------- |
| PUT      | /article/updateViewCount/{id} | 不需要token请求头 |

参数: 请求路径中携带文章id

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

## 6. 项目-代码实现

下面是 '浏览次数' 功能的具体实现。即使你前面3节基础的笔记没学，也不影响。下面的是独立与上面的基础知识，跟着下面写就好

如果你前面3节基础跟着我的笔记学了，那么为了避免控制台一直打印东西，你需要把创建的myJob类、myCommandLineRunner类注释掉

### 一、启动预处理

当项目启动时，就把博客的浏览量(id和viewCount字段)以map的形式存储到redis中

第一步: 在Start-blog工程的src/main/java/com.Start目录新建runner.ViewCountRunner类，写入如下

```java
package com.Start.runner;

import com.Start.domain.Article;
import com.Start.mapper.ArticleMapper;
import com.Start.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/31 0031 19:52
 */
@Component
//当项目启动时，就把博客的浏览量(id和viewCount字段)存储到redis中。也叫启动预处理。CommandLineRunner是spring提供的接口
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    //用于操作redis
    private RedisCache redisCache;

    @Autowired
    //用于操作数据库的article表
    private ArticleMapper articleMapper;

    //@Override
    ////下面的写法是stream流+函数式编程
    //public void run(String... args) throws Exception {
    //    //查询数据库中的博客信息，注意只需要查询id、viewCount字段的博客信息
    //    List<Article> articles = articleMapper.selectList(null);//为null即无条件，表示查询所有
    //    articles.stream()
    //            //由于我们需要key、value的数据，所有可以通过stream流，转为map集合。new Function表示函数式编程
    //            .collect(Collectors.toMap(new Function<Article, Long>() {
    //                @Override
    //                public Long apply(Article article) {
    //                    return article.getId();
    //                }
    //            }, new Function<Article, Integer>() {//new Function表示函数式编程
    //                @Override
    //                public Integer apply(Article article) {
    //                    return article.getViewCount().intValue();
    //                }
    //            }));


    @Override
    //下面的写法是stream流+方法引用+Lambda。我们用这种写法使得代码更简短，跟上面那种写法的效果是一样的
    public void run(String... args) throws Exception {
        //查询数据库中的博客信息，注意只需要查询id、viewCount字段的博客信息
        List<Article> articles = articleMapper.selectList(null);//为null即无条件，表示查询所有
        Map<String, Integer> viewCountMap = articles.stream()
                //由于我们需要key、value的数据，所有可以通过stream流

                //下面toMap方法的第一个参数用了方法引用，第二个参数用了Lambda
                //.collect(Collectors.toMap(Article::getId, article -> article.getViewCount().intValue()));

                //由于上面那行Article::getId返回值是Long类型，而我们需要String类型，为了方便转换类型，我们要写成Lambda表达式
                .collect(Collectors.toMap(article -> article.getId().toString(), article -> article.getViewCount().intValue()));


        //把查询到的id作为key，viewCount作为value，一起存入Redis
        redisCache.setCacheMap("article:viewCount",viewCountMap);
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-blog工程的StartBlogApplication类。然后去redis看一下数据

![img](未命名/__项目/assets/1693034020801-a3c0cc01-cc20-4717-bec5-6c04532b0f2c.jpg)

### 二、浏览量递增

刚刚我们实现了把不同id的文章，和对应的viewCount浏览量存入了redis。接下来就实现如何让用户每从mysql根据文章id查询一次浏览量，那么redis里这篇文章的浏览量就增加1

第一步: 在Start-framework工程的RedisCache工具类添加如下，是redis的浏览量增加1的核心代码

```java
/**
  * 对redis中，某个hash结构里面的value进行递增操作
  *
  * @param key 操作的是哪个hash结构
  * @param hKey 对hash结构里面的哪个key进行操作
  * @param v key对应的value值会递增多少
  */
public void incrementCacheMapValue(String key,String hKey,long v){
	redisTemplate.opsForHash().increment(key, hKey, v);
}
```

第二步: 在Start-framework工程的ArticleService接口修改为如下，增加了根据id从mysql查询文章的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */
public interface ArticleService extends IService<Article> {

    //文章列表
    ResponseResult hotArticleList();

    //分类查询文章列表
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    //根据id查询文章详情
    ResponseResult getArticleDetail(Long id);

    //根据文章id从mysql查询文章
    ResponseResult updateViewCount(Long id);
}
```

第三步: 在Start-framework工程的ArticleServiceImpl类添加如下，作用是根据id从mysql查询文章，并让redis里对应文章的浏览量+1

```java
@Autowired
private RedisCache redisCache;

@Override
public ResponseResult updateViewCount(Long id) {
	//更新redis中的浏览量，对应文章id的viewCount浏览量。article:viewCount是ViewCountRunner类里面写的
	//用户每从mysql根据文章id查询一次浏览量，那么redis的浏览量就增加1
	redisCache.incrementCacheMapValue("article:viewCount",id.toString(),1);
	return ResponseResult.okResult();
}
```

第四步: 在Start-blog工程的ArticleController类添加如下，作用是让用户访问从mysql根据文章id查询文章浏览量的接口

```java
@PutMapping("/updateViewCount/{id}")
@mySystemlog(xxbusinessName = "根据文章id从mysql查询文章")//接口描述，用于'日志记录'功能
public ResponseResult updateViewCount(@PathVariable("id") Long id){
	return articleService.updateViewCount(id);
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-blog工程的StartBlogApplication类。然后启动vue前端项目，随便浏览一篇文章，最后去redis看一下数据

注意: 下面图片里的文字我写错了，是从mysql查询浏览量，而不是从redis。后面我们才学从redis查询浏览量

![img](未命名/__项目/assets/1693034021033-7f1b53c8-4401-48c6-be68-a8edab270c1d.jpg)

### 三、数据同步

把redis的数据同步到mysql数据库。避免redis宕机，丢失浏览量数据。要求通过定时任务实现每隔3分钟把redis中的浏览量更新到mysql数据库中

第一步: 把Start-framework工程的Article类，修改为如下，增加了Article()构造方法

```java
package com.Start.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 35238
 * @date 2023/7/18 0018 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sg_article")
public class Article {

    @TableId
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;

    //增加一个字段，为categoryName，由categoryId来查询出
    //由于数据库没有category_name字段，所以要用注解指定一下字段
    @TableField(exist = false)//代表这个字段在数据库中不存在，避免MyBatisPlus在查询时报错
    private String categoryName;

    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

    //把redis的浏览量数据更新到mysql数据库
    public Article(Long id, long viewCount) {
        this.id = id;
        this.viewCount=viewCount;
    }
}
```

第二步: 在src/main/java/com.Start目录新建cronjob.UpdateViewCount类，写入如下

```java
package com.Start.cronjob;

import com.Start.domain.Article;
import com.Start.service.ArticleService;
import com.Start.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/1 0001 12:43
 */
@Component
//通过定时任务实现每隔3分钟把redis中的浏览量更新到mysql数据库中
public class UpdateViewCount {

    @Autowired
    //操作redis。RedisCache是我们在Start-framework工程写的工具类
    private RedisCache redisCache;

    @Autowired
    //操作数据库。ArticleService是我们在Start-framework工程写的接口
    private ArticleService articleService;

    //每隔3分钟，把redis的浏览量数据更新到mysql数据库
    @Scheduled(cron = "0/10 * * * * ?")
    public void updateViewCount(){
        //获取redis中的浏览量，注意得到的viewCountMap是HashMap双列集合
        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");
        //让双列集合调用entrySet方法即可转为单列集合，然后才能调用stream方法
        List<Article> articles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                //把最终数据转为List集合
                .collect(Collectors.toList());
        //把获取到的浏览量更新到mysql数据库中。updateBatchById是mybatisplus提供的批量操作数据的接口
        articleService.updateBatchById(articles);
        //方便在控制台看打印信息
        System.out.println("redis的文章浏览量数据已更新到数据库，现在的时间是: "+ LocalTime.now());
    }
}
```

第三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 测试。运行Start-blog工程的StartBlogApplication类。启动vue前端项目，随便浏览一篇文章，3分钟后去看redis和mysql的浏览量数据是否一致

![img](未命名/__项目/assets/1693034021484-2d3c5481-af10-43eb-a833-0a0d4a2539aa.jpg)

![img](未命名/__项目/assets/1693034021714-5dae00f0-6693-4045-a016-0bfe3def46d3.jpg)

### 四、从redis查询

前面我们实现了根据id去数据库查询文章浏览量，同时用户每查一次文章，那么redis的浏览量就递增1。每隔3分钟，redis的浏览量就会同步到数据库。但是还存在一个问题，由于redis每隔3分钟才把数据同步到数据库，那么用户在页面看到的浏览量是每隔3分钟才有变化，我们希望浏览量是实时更新的

解决: 用户每次根据文章id查询文章浏览量时，都是直接查数据库，我们希望用户从redis里面查询文章的浏览量

第一步: 把Start-framework工程的ArticleServiceImpl类修改为如下，修改了hotArticleList、hotArticleList方法，让用户查询文章浏览量时从redis查

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.RedisCache;
import com.Start.vo.ArticleDetailVo;
import com.Start.vo.ArticleListVo;
import com.Start.vo.HotArticleVO;
import com.Start.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    //操作数据库。ArticleService是我们在Start-framework工程写的接口
    private ArticleService articleService;


    @Override
    public ResponseResult hotArticleList() {

        //-------------------每调用这个方法就从redis查询文章的浏览量，展示在热门文章列表------------------------
        
        //获取redis中的浏览量，注意得到的viewCountMap是HashMap双列集合
        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");
        //让双列集合调用entrySet方法即可转为单列集合，然后才能调用stream方法
        List<Article> xxarticles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                //把最终数据转为List集合
                .collect(Collectors.toList());
        //把获取到的浏览量更新到mysql数据库中。updateBatchById是mybatisplus提供的批量操作数据的接口
        articleService.updateBatchById(xxarticles);
        
        //-----------------------------------------------------------------------------------------

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);

        return ResponseResult.okResult(articleVos);
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @Autowired
    //注入我们写的CategoryService接口
    private CategoryService categoryService;

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第一种方式，用for循环遍历的方式
         */
        ////用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        //List<Article> articles = page.getRecords();
        //for (Article article : articles) {
        //    //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
        //    Category category = categoryService.getById(article.getCategoryId());
        //    //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
        //    article.setCategoryName(category.getName());
        //
        //}

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第二种方式，用stream流的方式
         */
        //用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        List<Article> articles = page.getRecords();

        articles.stream()
                .map(new Function<Article, Article>() {
                    @Override
                    public Article apply(Article article) {
                        //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
                        Category category = categoryService.getById(article.getCategoryId());
                        String name = category.getName();
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        article.setCategoryName(name);
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        return article;
                    }
                })
                .collect(Collectors.toList());


        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);


        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    //---------------------------------根据id查询文章详情----------------------------------

    @Override
    public ResponseResult getArticleDetail(Long id) {

        //根据id查询文章
        Article article = getById(id);

        //-------------------从redis查询文章的浏览量，展示在文章详情---------------------------
        
        //从redis查询文章浏览量
        Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
        article.setViewCount(viewCount.longValue());
        
        //-----------------------------------------------------------------------------

        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);

        //根据分类id，来查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        //如果根据分类id查询的到分类名，那么就把查询到的值设置给ArticleDetailVo实体类的categoryName字段
        if(category!=null){
            articleDetailVo.setCategoryName(category.getName());
        }

        //封装响应返回。ResponseResult是我们在Start-framework工程的domain目录写的实体类
        return ResponseResult.okResult(articleDetailVo);
    }

    //--------------------------------根据文章id从mysql查询文章----------------------------

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult updateViewCount(Long id) {
        //更新redis中的浏览量，对应文章id的viewCount浏览量。article:viewCount是ViewCountRunner类里面写的
        //用户每从mysql根据文章id查询一次浏览量，那么redis的浏览量就增加1
        redisCache.incrementCacheMapValue("article:viewCount",id.toString(),1);
        return ResponseResult.okResult();
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 测试。运行Start-blog工程的StartBlogApplication类。启动vue前端项目，浏览文章，看一下前端展示的浏览量是否实时

![img](未命名/__项目/assets/1693034021910-067594cb-4832-4171-b5ef-eaad88c78a3a.jpg)

到此，文章的浏览次数功能就是完整的实现了

------

# swagger学习

## 1. swagger介绍

可跳过swagger，在我们的博客项目并不会用到。但是如果你要跟你的前端同事一起开发某个项目，作为后端的你为了文档更好的维护，建议你认真学swagger

首先你要有一个写好工程，例如前面的 '博客前台模块'，到此我们就已经把 '博客前台模块' 工程写好了

swagger 是一套基于 OpenAPI 规范构建的开源工具，用于生成接口文档，我们需要使用swagger生成 '博客前台模块' 和 '博客后台模块' 的接口文档。swagger 可以帮助我们设计、构建、记录以及使用 Rest API。当下很多公司都采取前后端分离的开发模式，前端和后端的工作由不同的工程师完成，在这种开发模式下，维持一份及时更新且完整的 Rest API 文档将会极大的提高我们的工作效率。传统意义上的文档都是后端开发人员手动编写的，这种方式很难保证文档的及时性，这种文档久而久之也就会失去其参考意义，反而还会加大我们的沟通成本。而 swagger 给我们提供了一个全新的维护 API 文档的方式

swagger的优点：

①代码变，文档变。只需要少量的注解，Swagger 就可以根据代码自动生成 API 文档，很好的保证了文档的时效性

②跨语言性，支持 40 多种语言

③Swagger UI 呈现出来的是一份可交互式的 API 文档，我们可以直接在文档页面尝试 API 的调用，省去了准备复杂的调用参数的过程

## 2. swagger快速入门

第一步(已做可跳过): 在Start-framework工程的pom.xml添加如下

```xml
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
</dependency>
<dependency>
 	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
</dependency>
```

第二步: 在Start-blog的application.yml添加如下

```yaml
spring:
  # springboot 2.6版本之后需要配置ant_path_matcher才能生使swagger生成接口文档
  # 我们目前的springboot版本是2.5.0，不需要配置ant_path_matcher也可正常使用swagger
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
```

第三步: 需要为哪个工程通过swagger生成接口文档，就在哪个工程创建一个配置类，并在这个配置类添加 [@EnableSwagger2]() 注解。由于我们的 '博客前台模块'，也就是Start-blog工程已经(在前面的学习中)写好了各种功能，我们可以为Start-blog工程通过swagger生成接口文档。 

在Start-blog工程的src/mian/java/com.Start目录新建config.SwaggerConfig类，写入如下

```java
package com.Start.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 35238
 * @date 2023/8/1 0001 21:14
 */
@Configuration //标识为配置类
@EnableSwagger2 //开启swagger，即可通过swagger为Start-blog工程生成接口文档
public class SwaggerConfig {
    
}
```

第四步: 运行Start-blog工程的StartBlogApplication启动类，浏览器访问如下

```plain
http://localhost:7777/swagger-ui.html
```

![img](未命名/__项目/assets/1693034022096-105687f2-d833-49e9-890e-e4ba572a0d9f.jpg)

第五步: 测试。随便找一个接口看一下swagger生成的接口文档信息。注意，Start-blog工程必须要已经有业务接口，swagger才能生成该接口的文档

![img](未命名/__项目/assets/1693034022245-17dad3f9-d40f-41c1-8234-fc3ec08ff90f.jpg)

第六步: 测试。点击上图的Try it out按钮，就可进行下图的接口测试

![img](未命名/__项目/assets/1693034022392-98656fb7-c0de-408b-8df0-9b25be8a87b5.jpg)

## 3. 自定义-Controller的信息

对应swagger提供给我们的页面信息，我们可以根据自己的喜好进行自定义，如下我们学习如下自定义 '标签' 和 '描述信息' 的文字

![img](未命名/__项目/assets/1693034022545-2052b59d-263b-4cf6-886d-853531e66d83.jpg)

第一步: 在Start-blog工程的CommentController类，添加如下

```java
import io.swagger.annotations.Api;

@Api(tags = "评论的相关接口文档", description = "我是描述信息")
```

第二步: 运行Start-blog工程的StartBlogApplication启动类，浏览器访问swagger提供的可视化页面。查看相关信息有没有在页面进行展示

```plain
http://localhost:7777/swagger-ui.html
```

![img](未命名/__项目/assets/1693034022703-4908cd8d-17e9-4b7c-8d60-97c64ce59fa8.jpg)

第三步: 在Start-blog工程的UserController、UploadController、LinkController、CategoryController、BlogLoginController、ArticleController类，全都跟着上面的第一步做一次。然后重新运行StartBlogApplication启动类，再次访问swagger提供的可视化页面

![img](未命名/__项目/assets/1693034022862-4c9d8396-eed5-4f75-b9dc-c4cb5ff8934b.jpg)

第四步: 去不掉的那个标签叫 '错误路径标签'，是swagger默认自带的。解决: 在Start-blog工程的SwaggerConfig类修改为如下

然后重新运行StartBlogApplication启动类，再次访问swagger提供的可视化页面

```java
package com.Start.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 35238
 * @date 2023/8/1 0001 21:14
 */
@Configuration //标识为配置类
@EnableSwagger2 //开启swagger，即可通过swagger为Start-blog工程生成接口文档
public class SwaggerConfig {

    @Bean
    // 创建API基本信息
    public Docket createTestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 对所有api进行监控
                .apis(RequestHandlerSelectors.any())
                //不显示错误的接口地址，也就是错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }   
}
```

![img](未命名/__项目/assets/1693034023026-01e8511e-da02-47a8-a11a-883b38fcad81.jpg)

## 4. 自定义-请求接口的信息

标签的自定义信息我们刚刚实现了。我们在swagger可视化页面点击某个标签时，会下拉展示出跟这个标签相关的请求接口 (例如CommentController类对应的标签是 '评论的相关接口文档'，这个标签里面下拉展示的请求接口其实就是在Start-blog工程的CommentController类出现过的请求接口

![img](未命名/__项目/assets/1693034023177-839b4691-918b-4f03-ac29-e9b00960db72.jpg)

同样，我们也是要修改swagger可视化页面的下拉展示的请求接口信息，分别是两处的描述信息。通过在请求接口注解的下一行添加@ApiOperation注解来实现

第一步: 在Start-blog工程的CommentController类的@GetMapping("/linkCommentList")的下一行添加如下

```java
@ApiOperation(value = "友链评论列表",notes = "获取友链评论区的评论")
```

第二步: 运行Start-blog工程的StartBlogApplication启动类，浏览器访问swagger提供的可视化页面。查看相关信息有没有在页面进行展示

```plain
http://localhost:7777/swagger-ui.html
```

![img](未命名/__项目/assets/1693034023366-96393fe1-2afd-4147-ae55-42748da5ecc9.jpg)

## 5. 自定义-请求接口的参数信息

下面我们实现的是自定义接口的参数信息

![img](未命名/__项目/assets/1693034023553-20550cd2-9b01-48df-afe1-66396127ac9a.jpg)

第一步: 在Start-blog工程的CommentController类的@GetMapping("/linkCommentList")的下一行添加如下

```java
@ApiImplicitParams({
	@ApiImplicitParam(name = "pageNum",value = "页号"),
	@ApiImplicitParam(name = "pageSize",value = "每页大小")
})
```

第二步: 运行Start-blog工程的StartBlogApplication启动类，浏览器访问swagger提供的可视化页面。查看相关信息有没有在页面进行展示

```plain
http://localhost:7777/swagger-ui.html
```

![img](未命名/__项目/assets/1693034023699-f2742f82-65e4-4e87-b274-be060e2b0606.jpg)

## 6. 自定义-实体类描述的信息

下面我们实现的是实体类描述的信息，@ApiModel用于描述实体类。注意只有当请求业务接口是通过@RequestBody注解要接受前端传过来的请求体的时候，我们才能在@RequestBody注解后面的xxx实体类(例如Comment，此时的实体类是用来接收前端传过来的请求体)，添加描述信息

![img](未命名/__项目/assets/1693034023902-1e4feefe-cc08-4be4-868d-d19585760179.jpg)

第一步: 在Start-framework工程的Comment类的类名的上一行添加如下

```java
@ApiModel(description = "添加评论的实体类")
```

第二步: 运行Start-blog工程的StartBlogApplication启动类，浏览器访问swagger提供的可视化页面。查看相关信息有没有在页面进行展示

```plain
http://localhost:7777/swagger-ui.html
```

![img](未命名/__项目/assets/1693034024106-c9aec172-91f6-4412-a6d6-a585c3828f6d.jpg)

第三步: 存在的问题。要是还有其它的请求业务接口也是使用@RequestBody注解接收前端传过来的请求体，并且刚好使用的也是Comment实体类进行接收前端传过来的请求体，那么我们在Comment加的注释信息无法表达两个需求的描述，这时候怎么办呢？

解决: 代码问题。Comment是我们评论表的大类，我们不能在后端使用Comment类去接收前端的请求体，杀鸡用牛刀。应该用DTO类，前面我们了解过VO类，其实概念差不多，DTO就是数据传输对象。在Start-framework工程的domain目录新建addCommentDto类，写入如下

```java
package com.Start.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/8/2 0002 14:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "自定义实体类的描述信息-我是专门用于添加评论的DTO实体类")
public class addCommentDto {

    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    private String type;

    //文章id
    @ApiModelProperty(notes = "自定义实体类的字段的描述信息-文章id")
    private Long articleId;

    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    //回复目标评论id
    private Long toCommentId;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第四步: 把Start-blog工程的CommentController类的addComment方法修改为如下

```java
@PostMapping
//在文章的评论区发送评论。ResponseResult是我们在Start-framework工程写的类
@mySystemlog(xxbusinessName = "在文章评论区发送评论")//接口描述，用于'日志记录'功能
public ResponseResult addComment(@RequestBody addCommentDto addCommentDto){
    //把addCommentDto类转换为Comment类类型。BeanCopyUtils是我们在Start-framework工程写的工具类，可以转换类的类型
	Comment comment = BeanCopyUtils.copyBean(addCommentDto, Comment.class);
	return commentService.addComment(comment);
}
```

第五步: 运行Start-blog工程的StartBlogApplication启动类，浏览器访问swagger提供的可视化页面。查看相关信息有没有在页面进行展示

```plain
http://localhost:7777/swagger-ui.html
```

![img](未命名/__项目/assets/1693034024302-384e3cf7-92f4-4925-8bbc-d816aa746aac.jpg)

## 7. 自定义-顶部文档的信息

下面我们实现的是自定义顶部文档信息

![img](未命名/__项目/assets/1693034024481-449d62bc-cc03-4a27-b4bb-7aabd5467b85.jpg)

第一步: 在Start-blog工程的SwaggerConfig类修改为如下

```java
package com.Start.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 35238
 * @date 2023/8/1 0001 21:14
 */
@Configuration //标识为配置类
@EnableSwagger2 //开启swagger，即可通过swagger为Start-blog工程生成接口文档
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()

                //只监控com.Start.controller包的api
                //.apis(RequestHandlerSelectors.basePackage("com.Start.controller"))

                // 对所有api进行监控
                .apis(RequestHandlerSelectors.any())

                //不显示错误的接口地址，也就是错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))

                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("团队名", "https://Startqc.cn", "123456@email.com");
        return new ApiInfoBuilder()
                .title("文档标题")
                .description("文档描述")
                .contact(contact)   // 联系方式
                .version("1.1.0")  // 版本
                .build();
    }
}
```

第二步: 运行Start-blog工程的StartBlogApplication启动类，浏览器访问swagger提供的可视化页面。查看相关信息有没有在页面进行展示

```plain
http://localhost:7777/swagger-ui.html
```

![img](未命名/__项目/assets/1693034024624-e35c13ba-7d0c-406c-a26e-b8965c1affb3.jpg)

# 博客后台模块-准备工作

必须把上面的全部学完才能进入下面的学习，最起码你要把上面的 '项目搭建' 和 '公共模块-准备工作' 做完，不然下面你没有相应的后端工程和数据库

## 1. 前端项目的启动

第一步: 在D盘新建SpringBootBlogWeb文件夹，下载sg-vue-admin.zip源码文件，下载链接如下，解压到SpringBootBlogWeb文件夹里面

```plain
https://share.feijipan.com/s/7gAnzdoj
```

![img](未命名/__项目/assets/1693034024759-0a884f68-0ae8-469c-8f12-275f939cff31.jpg)

第二步: 运行前端项目。请确保你电脑有安装node.js，然后以管理员身份打开命令行窗口，输入如下。或者在vscode的终端输入如下

```shell
d:
cd /SpringBootBlogWeb/sg-vue-admin
npm install
npm run dev
```

![img](未命名/__项目/assets/1693034024893-c47196ea-caa4-4b7f-b736-3c64c856f4d6.jpg)

![img](未命名/__项目/assets/1693034025062-311d9084-b6c8-4320-a484-31aa35b34e95.jpg)

第三步: 如果你第二步执行不了，那么原因只能是nodejs版本问题，最简单的解决方法就是打开 '控制面板'，点击 '程序和功能'，下拉找到 'Node.js'，右键卸载，并且把你之前nodejs的安装目录删掉。最后下载稳定版14.几的nodejs，为方便下载，我把我的nodejs下载链接放下面，直接下载安装即可

```plain
nodejs的14.21.3-x64版本下载: https://share.feijipan.com/s/8LAnfKv3
```

第四步: 访问前端的项目

```plain
http://localhost:81/
```

![img](未命名/__项目/assets/1693034025225-92810a68-dad8-4c9e-af66-883709b1e0a6.jpg)

## 2. 后台模块准备

提前说一下，这个 '后台模块准备' 太麻烦了，而且做完后发现这只是个准备的小测试，没有实际用途。建议尽快复制粘贴，能测试通过就好，不要投入太多

第一步: 在Start-admin工程的src/main/java目录新建com.Start.BlogAdminApplication类，作为引导类，写入如下

```java
package com.Start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:02
 */
@SpringBootApplication //把这个类标识为引导类(也叫启动类)
@MapperScan("com.Start.mapper") //mybatis的配置
public class BlogAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class, args);
    }
}
```

第二步: 在Start-admin工程的resources目录新建File，文件名为application.yml文件，写入如下

```yaml
server:
  port: 8989
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sg_blog?characterEncoding=utf-8&serverTimezone=UTC
    username: root
    password: 228675
    driver-class-name: com.mysql.cj.jdbc.Driver
  
  servlet:
    # 文件上传
    multipart:
      # 单个上传文件的最大允许大小
      max-file-size: 20MB
      # HTTP请求中包含的所有文件的总大小的最大允许值
      max-request-size: 20MB

mybatis-plus:
  configuration:
    # 日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      logic-delete-field: delFlag
      logic-delete-value: 1
      logic-not-delete-value: 0
      id-type: auto
```

第三步: 在Start-framework工程的src/main/java/com.Start.domain目录新建Tag类，写入如下

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 标签(Tag)表实体类
 *
 * @author makejava
 * @since 2023-08-02 21:11:28
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_tag")
public class Tag  {
    @TableId
    private Long id;

    //标签名
    private String name;
    
    private Long createBy;
    
    private Date createTime;
    
    private Long updateBy;
    
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
    //备注
    private String remark;
}
```

第四步: 在Start-framework工程的src/main/java/com.Start.mapper目录新建TagMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Tag;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:13
 */
public interface TagMapper extends BaseMapper<Tag> {

}
```

第五步: 在Start-framework工程的src/main/resources/mapper目录新建TagMapper.xml文件，写入如下

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--TagMapper接口的映射文件-->
<mapper namespace="com.Start.mapper.TagMapper">
    <!--根据id来删除标签-->
    <update id="myUpdateById" parameterType="list">
        UPDATE
            `sg_tag` tag
        SET
            tag.`del_flag` = #{flag}
        WHERE
            tag.`id` = #{id}
    </update>

</mapper>
```

第六步: 在Start-framework工程的src/main/java/com.Start.service目录新建TagService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Tag;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:14
 */

public interface TagService extends IService<Tag> {

}
```

第七步: 在Start-framework工程的src/main/java/com.Start.service目录新建impl.TagServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.Tag;
import com.Start.mapper.TagMapper;
import com.Start.service.TagService;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:15
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
```

第八步: 在Start-admin工程的src/main/java目录新建com.Start.controller.TagController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:27
 */
@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    //TagService是我们在Start-framework工程的接口
    private TagService tagService;

    //查询标签列表
    @GetMapping("/list")
    //ResponseResult是我们在Start-framework工程的实体类
    public ResponseResult list(){
        //list是mybatisplus提供的方法
        return ResponseResult.okResult(tagService.list());
    }
}
```

第九步: 由于Start-framework公共模块里面有security的相关依赖和配置，为了让 '博客后台模块' 在启动时不报错，我们需要把Start-blog工程的security的相关代码提前写道Start-admin工程里面，这些代码我们在Start-blog工程里面已经学过了，只是简单地在Start-admin工程里面也弄(复制)一份这样的代码。

在Start-admin工程的src/main/java/com.Start目录新建filter.JwtAuthenticationTokenFilter类，写入如下。不用管下面的代码什么意思，登录功能的时候会学

```java
package com.Start.filter;

import com.alibaba.fastjson.JSON;
import com.Start.domain.LoginUser;
import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.utils.JwtUtil;
import com.Start.utils.RedisCache;
import com.Start.utils.WebUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/23 0023 13:24
 */
@Component
//博客前台的登录认证过滤器(马上就要变成后台的了，这里先复制来用一下)。OncePerRequestFilter是springsecurity提供的类
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    //RedisCache是我们在Start-framework工程写的工具类，用于操作redis
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //获取请求头中的token值
        String token = request.getHeader("token");
        //判断上面那行有没有拿到token值
        if(!StringUtils.hasText(token)){
            //说明该接口不需要登录，直接放行，不拦截
            filterChain.doFilter(request,response);
            return;
        }
        //JwtUtil是我们在Start-framework工程写的工具类。解析获取的token，把原来的密文解析为原文
        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            //当token过期或token被篡改就会进入下面那行的异常处理
            e.printStackTrace();
            //报异常之后，把异常响应给前端，需要重新登录。ResponseResult、AppHttpCodeEnum、WebUtils是我们在Start-framework工程写的类
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }
        String userid = claims.getSubject();

        //在redis中，通过key来获取value，注意key我们是加过前缀的，取的时候也要加上前缀
        LoginUser loginUser = redisCache.getCacheObject("login:" + userid);
        //如果在redis获取不到值，说明登录是过期了，需要重新登录
        if(Objects.isNull(loginUser)){
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }

        //把从redis获取到的value，存入到SecurityContextHolder(Security官方提供的类)
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request,response);

    }
}
```

在Start-admin工程的src/main/java/com.Start目录新建config.SecurityConfig类，写入如下。不用管下面的代码什么意思，登录功能的时候会学

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                /* 由于刚开始博客后台模块，还没有登录、权限认证的功能，所以在复制过来后，要把下面的那部分注释掉

                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()

                //为方便测试认证过滤器，我们把查询友链的接口设置为需要登录才能访问。然后我们去访问的时候就能测试登录认证功能了
//                .antMatchers("/link/getAllLink").authenticated()

                //为方便测试查询个人信息，我们把查询个人信息的接口设置为需要登录才能访问
                .antMatchers("/user/userInfo").authenticated()

                //退出登录的配置。如果'没登录'就调用'退出登录'，就会报错，报的错设置为'401 需要登录后操作'，也就是authenticated
                .antMatchers("/logout").authenticated()

                //把文件上传的接口设置为需要登录才能访问
//                .antMatchers("/upload").authenticated()

                //需要登录才能在评论区发送评论
                .antMatchers("/comment").authenticated()

                */

                // 除上面外的所有请求全部不需要认证即可访问
                .anyRequest().permitAll();

        //把我们写的自定义异常处理器配置给Security
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }

}
```

第十步: 运行Start-admin工程的BlogAdminApplication类。在postman软件，使用GET请求访问如下

```java
http://localhost:8989/content/tag/list
```

![img](未命名/__项目/assets/1693034025380-37e01f15-2ebb-4537-bdaa-0d0312081653.jpg)

# 博客后台模块-登录功能

跟我们前面学的 '博客前台模块-登录功能' 的实现思路和过程可以说是一模一样，所以大部分代码是复制过来改改文件名

## 1. 用户表的字段

![img](未命名/__项目/assets/1693034011446-2fe6f4fd-8b50-4840-8ec7-467050bdaf58.jpg)

![img](未命名/__项目/assets/1693034011591-f34cd80d-b080-4c2f-b9a7-c82d0fefad50.jpg)

## 2. 接口分析

使用SpringSecurity安全框架来实现登录功能，并且实现登录的校验，也就是把数据库的用户表跟页面输入的用户名密码做比较

需求: 后台所有功能都必须登录才能使用

| 请求方式 | 请求路径    |
| -------- | ----------- |
| POST     | /user/login |

请求体：

```json
{
    "userName":"用户名",
    "password":"密码"
}
```

响应格式：

```json
{
    "code": 200,
    "data": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0ODBmOThmYmJkNmI0NjM0OWUyZjY2NTM0NGNjZWY2NSIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY0Mzg3NDMxNiwiZXhwIjoxNjQzOTYwNzE2fQ.ldLBUvNIxQCGemkCoMgT_0YsjsWndTg5tqfJb77pabk"
    },
    "msg": "操作成功"
}
```

## 3. 思路分析

登录

​	①自定义登录接口

​				调用ProviderManager的方法进行认证 如果认证通过生成jwt

​				把用户信息存入redis中

​	②自定义UserDetailsService(之前在前台模块的时候写的UserDetailsService)

​				在这个实现类中去查询数据库

​	注意配置passwordEncoder为BCryptPasswordEncoder

校验：

​	①定义Jwt认证过滤器(之前在前台模块的时候写的JwtAuthenticationTokenFilter)

​				获取token

​				解析token获取其中的userid

​				从redis中获取用户信息

​				存入SecurityContextHolder

## 4. 相关依赖

```xml
<!--SpringSecurity启动器。需要用到登录功能就解开，不然就注释掉-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-Starter-security</artifactId>
</dependency>

<!--redis依赖-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-Starter-data-redis</artifactId>
</dependency>

<!--fastjson依赖-->
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>fastjson</artifactId>
<version>1.2.33</version>
</dependency>

<!--jwt依赖-->
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.0</version>
</dependency>
```

## 5. 登录+校验的代码实现

第一步: 在Start-framework工程的service目录新建SystemLoginService接口，写入如下

```java
package com.Start.service;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:38
 */
public interface SystemLoginService {

    //登录
    ResponseResult login(User user);

}
```

第二步: 在Start-framework工程的service目录新建impl.SystemLoginServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.Start.domain.LoginUser;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.SystemLoginService;
import com.Start.utils.JwtUtil;
import com.Start.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:39
 */
@Service
//认证，判断用户登录是否成功
public class SystemLoginServiceImpl implements SystemLoginService {

    @Autowired
    //AuthenticationManager是security官方提供的接口
    private AuthenticationManager authenticationManager;

    @Autowired
    //RedisCache是我们在Start-framework工程的config目录写的类
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //封装登录的用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        //在下一行之前，封装的数据会先走UserDetailsServiceImpl实现类，这个实现类在我们的Start-framework工程的service/impl目录里面
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //上面那一行会得到所有的认证用户信息authenticate。然后下一行需要判断用户认证是否通过，如果authenticate的值是null，就说明认证没有通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        //把这个userid通过我们写的JwtUtil工具类转成密文，这个密文就是token值
        String jwt = JwtUtil.createJWT(userId);

        //下面那行的第一个参数: 把上面那行的jwt，也就是token值保存到Redis。存到时候是键值对的形式，值就是jwt，key要加上 "bloglogin:" 前缀
        //下面那行的第二个参数: 要把哪个对象存入Redis。我们写的是loginUser，里面有权限信息，后面会用到
        redisCache.setCacheObject("login:"+userId,loginUser);


        //把token封装 返回
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return ResponseResult.okResult(map);
    }
}
```

第三步: 把Start-admin工程的SecurityConfig类修改为如下，为了测试校验功能，我们把接口设置为只有通过登录校验才能访问，注意要放行登录接口

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                // 对于登录接口 允许匿名访问
                .antMatchers("/user/login").anonymous()

                /* 由于刚开始博客后台模块，还没有登录、权限认证的功能，所以在复制过来后，要把下面的那部分注释掉

                

                //为方便测试认证过滤器，我们把查询友链的接口设置为需要登录才能访问。然后我们去访问的时候就能测试登录认证功能了
//                .antMatchers("/link/getAllLink").authenticated()

                //为方便测试查询个人信息，我们把查询个人信息的接口设置为需要登录才能访问
                .antMatchers("/user/userInfo").authenticated()

                //退出登录的配置。如果'没登录'就调用'退出登录'，就会报错，报的错设置为'401 需要登录后操作'，也就是authenticated
                .antMatchers("/logout").authenticated()

                //把文件上传的接口设置为需要登录才能访问
//                .antMatchers("/upload").authenticated()

                //需要登录才能在评论区发送评论
                .antMatchers("/comment").authenticated()

                */

                // 除上面外的所有请求全部都需要认证才可访问
                .anyRequest().authenticated();

        //把我们写的自定义异常处理器配置给Security
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }
}
```

第四步: 在Start-admin工程的controller目录新建LoginController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.SystemLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/3 0003 14:01
 */
@RestController
public class LoginController {

    @Autowired
    private SystemLoginService systemLoginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return systemLoginService.login(user);
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-admin工程的BlogAdminApplication类，运行vue项目，测试登录接口

![img](未命名/__项目/assets/1693034025565-ac82bd30-9dcc-4608-b2ac-bbeaf96bd6e0.jpg)

第七步: 测试。打开postman，测试登录+校验功能，也就是security把用户在页面输入的数据，跟数据库中的数据进行比较，一致就表示登录成功

登录用的是POST请求地址、请求体如下

```plain
http://localhost:8989/user/login
{
    "userName":"HFuser",
    "password":"123"
}
```

复制登录成功之后的token，然后在postman使用GET请求访问如下进行校验

```plain
http://localhost:8989/content/tag/list
```

![img](未命名/__项目/assets/1693034025765-cc6e41ae-c848-4149-8bc9-a6321a1f5677.jpg)

![img](未命名/__项目/assets/1693034025910-c5a21239-5969-452a-9189-6a0210824e9a.jpg)

![img](未命名/__项目/assets/1693034026056-4ca99e28-4c51-4be6-93ef-b8472c298ab2.jpg)

# 博客后台模块-权限控制

## 1. 接口分析

接口设计。对应用户只能使用自己的权限所允许使用的功能

| 请求方式 | 请求地址 | 请求头          |
| -------- | -------- | --------------- |
| GET      | /getInfo | 需要token请求头 |

响应格式如下。如果用户id为1代表管理员，roles 中只需要有admin，permissions中需要有所有菜单类型为C或者F的，状态为正常的，未被删除的权限

```json
{
	"code":200,
	"data":{
		"permissions":[
			"system:user:list",
            "system:role:list",
			"system:menu:list",
			"system:user:query",
			"system:user:add"
            //此次省略1000字
		],
		"roles":[
			"admin"
		],
		"user":{
			"avatar":"http://r7yxkqloa.bkt.clouddn.com/2022/03/05/75fd15587811443a9a9a771f24da458d.png",
			"email":"23412332@qq.com",
			"id":1,
			"nickName":"sg3334",
			"sex":"1"
		}
	},
	"msg":"操作成功"
}
```

之前在SpringSecurity的学习中就使用过RBAC权限模型。这里我们就是在RBAC权限模型的基础上去实现这个功能

RBAC权限模型最重要最难的就是设计好下面的5张表，有了5张表之后，就是简单的连表查询了

## 2. 权限表的字段

![img](未命名/__项目/assets/1693034026210-d5256be9-7c3b-4ef4-9342-684997ff7063.jpg)

![img](未命名/__项目/assets/1693034026347-705f0289-82cd-4337-acb6-6455b7de85ec.jpg)

## 3. 角色表的字段

![img](未命名/__项目/assets/1693034026543-322d0995-d6ac-41cc-a76a-f0b1426ef14d.jpg)

![img](未命名/__项目/assets/1693034026639-809ee115-adeb-46f5-9f9d-b64cfcefd0ce.jpg)

## 4. 用户表的字段

![img](未命名/__项目/assets/1693034011446-2fe6f4fd-8b50-4840-8ec7-467050bdaf58.jpg)

![img](未命名/__项目/assets/1693034011591-f34cd80d-b080-4c2f-b9a7-c82d0fefad50.jpg)

## 5. 中间表-角色&用户

![img](未命名/__项目/assets/1693034026740-1ddb251c-de23-4df7-a6d2-62901c0f5a6a.jpg)

![img](未命名/__项目/assets/1693034026833-fbf635a8-1c2e-46e7-94a7-f72f9dbbce56.jpg)

## 6. 中间表-角色&权限

![img](未命名/__项目/assets/1693034026946-7034e462-c885-4528-99e0-5ccbf3f567c1.jpg)

![img](未命名/__项目/assets/1693034027040-6e35bc1a-18a5-4347-be39-7a9df8330383.jpg)

## 7. 代码实现

第一步: 把Start-framework工程的SystemCanstants类修改为如下，增加了两个判断权限类型的成员变量

```java
package com.Start.constants;

/**
 * @author 35238
 * @date 2023/7/19 0019 19:14
 */
//字面值(代码中的固定值)处理，把字面值都在这里定义成常量。可以把这个类叫做常量类
public class SystemCanstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;

    /**
     * 分类表的分类状态是正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 友链状态为审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 评论区的某条评论是根评论
     */
    public static final String COMMENT_ROOT = "-1";

    /**
     * 文章的评论
     */
    public static final String ARTICLE_COMMENT = "0";

    /**
     * 友链的评论
     */
    public static final String LINK_COMMENT = "1";

    /**
     * 权限类型，菜单
     */
    public static final String TYPE_MENU = "C";

    /**
     * 权限类型，按钮
     */
    public static final String TYPE_BUTTON = "F";
}
```

第二步: 在Start-framework工程的vo目录新建AdminUserInfoVo类，写入如下，负责把指定字段返回给前端

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:38
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserInfoVo {

    private List<String> permissions;

    private List<String> roles;

    private UserInfoVo user;

}
```

第三步: 在Start-framework工程的domain目录新建Menu类，写入如下，让mybatisplus去查询我们的sys_menu权限表

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 菜单权限表(Menu)表实体类
 *
 * @author makejava
 * @since 2023-08-04 13:20:58
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
public class Menu  {
    //菜单ID
    @TableId
    private Long id;

    //菜单名称
    private String menuName;
    //父菜单ID
    private Long parentId;
    //显示顺序
    private Integer orderNum;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //是否为外链（0是 1否）
    private Integer isFrame;
    //菜单类型（M目录 C菜单 F按钮）
    private String menuType;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;
    //创建者
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新者
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;
    
    private String delFlag;
}
```

第四步: 在Start-framework工程的domain目录新建Role类，写入如下，让mybatisplus去查询我们的sys_role角色表

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 角色信息表(Role)表实体类
 *
 * @author makejava
 * @since 2023-08-04 13:30:49
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role  {
    //角色ID@TableId
    private Long id;

    //角色名称
    private String roleName;
    //角色权限字符串
    private String roleKey;
    //显示顺序
    private Integer roleSort;
    //角色状态（0正常 1停用）
    private String status;
    //删除标志（0代表存在 1代表删除）
    private String delFlag;
    //创建者
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新者
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;
}
```

第五步: 在Start-framework工程的service目录新建RoleService接口，写入如下，用于查询用户的角色信息

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Role;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
public interface RoleService extends IService<Role> {
    //查询用户的角色信息
    List<String> selectRoleKeyByUserId(Long id);
}
```

第六步: 在Start-framework工程的service目录新建impl.RoleServiceImpl类，写入如下，是查询用户的角色信息的具体代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.Role;
import com.Start.mapper.RoleMapper;
import com.Start.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    //查询用户的角色信息
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员，如果是，就返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }

        //否则查询对应普通用户所具有的的角色信息
        List<String> otherRole = getBaseMapper().selectRoleKeyByOtherUserId(id);

        return otherRole;
    }
}
```

第七步: 在Start-framework工程的resources/mapper目录新建RoleMapper接口，写入如下，用于查询用户的角色信息

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Role;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:32
 */
public interface RoleMapper extends BaseMapper<Role> {
    //查询普通用户的角色权限
    List<String> selectRoleKeyByOtherUserId(Long userId);
}
```

第八步: 在Start-framework工程的resources目录新建mapper文件夹，在mapper文件夹里面新建RoleMapper.xml文件，写入如下，是查询用户的角色信息的具体代码

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.Start.mapper.RoleMapper">
    <!--MenuMapper接口的映射文件-->
    <select id="selectRoleKeyByOtherUserId" resultType="java.lang.String">
        SELECT
            r.`role_key`
        FROM
            `sys_user_role` ur
                LEFT JOIN `sys_role` r ON ur.`role_id` = r.`id`
        WHERE
            ur.`user_id` = #{userId} AND
            r.`status` = 0 AND
            r.`del_flag` = 0
    </select>
</mapper>
```



第九步: 在Start-framework工程的service目录新建MenuService接口，写入如下，用于查询超级管理员的权限信息

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Menu;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:24
 */
public interface MenuService extends IService<Menu> {
    //查询用户的权限信息
    List<String> selectPermsByUserId(Long id);
}
```

第十步: 在Start-framework工程的service目录新建impl.MenuServiceImpl类，写入如下，是查询超级管理员的权限信息的具体代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Menu;
import com.Start.mapper.MenuMapper;
import com.Start.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:25
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    //查询用户的权限信息
    public List<String> selectPermsByUserId(Long id) {
        //根据用户id查询用户的权限信息。用户id为id代表管理员，如果是管理员就返回所有的权限
        if(id == 1L){
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            //查询条件是permissions中需要有所有菜单类型为C或者F的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.in(Menu::getMenuType, SystemCanstants.TYPE_MENU,SystemCanstants.TYPE_BUTTON);
            //查询条件是permissions中需要有状态为正常的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.eq(Menu::getStatus,SystemCanstants.STATUS_NORMAL);
            //查询条件是permissions中需要未被删除的权限的权限
            List<Menu> menus = list(wrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }

        //如果不是管理员就返回对应用户所具有的权限
        List<String> otherPerms = getBaseMapper().selectPermsByOtherUserId(id);
        return otherPerms;
    }
}
```

第十一步: 在Start-framework工程的mapper目录新建MenuMapper接口，写入如下，用于查询非超级管理员的权限信息

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Menu;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:23
 */
public interface MenuMapper extends BaseMapper<Menu> {
    //查询普通用户的权限信息
    List<String> selectPermsByOtherUserId(Long userId);
}
```

第十二步: 在Start-framework工程的resources目录新建mapper/MenuMapper.xml文件，写入如下，是查询非超级管理员的权限信息的具体代码

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.Start.mapper.MenuMapper">
    <!--MenuMapper接口的映射文件-->
    <select id="selectPermsByOtherUserId" resultType="java.lang.String">
        SELECT
            DISTINCT m.perms
        FROM
            `sys_user_role` ur
                LEFT JOIN `sys_role_menu` rm ON ur.`role_id` = rm.`role_id`
                LEFT JOIN `sys_menu` m ON m.`id` = rm.`menu_id`
        WHERE
            ur.`user_id` = #{userId} AND
            m.`menu_type` IN ('C','F') AND
            m.`status` = 0 AND
            m.`del_flag` = 0
    </select>
</mapper>
```



第十三步: 把Start-admin工程的LoginController类修改为如下，增加了查询角色信息、权限信息的接口

```java
package com.Start.controller;

import com.Start.domain.LoginUser;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.MenuService;
import com.Start.service.RoleService;
import com.Start.service.SystemLoginService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.AdminUserInfoVo;
import com.Start.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/3 0003 14:01
 */
@RestController
public class LoginController {

    @Autowired
    private SystemLoginService systemLoginService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return systemLoginService.login(user);
    }

    //-----------------------------查询(超级管理员|非超级管理员)的权限和角色信息------------------------------------------

    @GetMapping("/getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo(){
        //获取当前登录的用户。SecurityUtils是我们在Start-framework写的类
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据用户id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        //根据用户id查询角色信息
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());

        //获取用户信息
        User user = loginUser.getUser();
        //BeanCopyUtils是我们在Start-framework写的类
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        //封装响应返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms,roleKeyList,userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }
}
```

第十四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第十五步: 测试。运行Start-admin工程的BlogAdminApplication类

思路: web页面我们还进不去管理后台(在下一节 '博客后台模块-动态路由'那里，我们就能在浏览器的web页面登录进管理后台了)，只能在postman软件里面，测试超级管理员用户和非超级管理员用户的权限、用户信息是否能查询到。具体测试如下

第十六步: 测试。能否查询到超级管理员的权限信息、用户信息(个人信息)

(1) 登录超级管理员，复制token。POST请求

```plain
http://localhost:8989/user/login
{
    "userName":"Startqc",
    "password":"228675"
}
```

![img](未命名/__项目/assets/1693034027144-02d19136-9a3b-43f6-801a-cd4f4177f6b1.jpg)

(2) 以超级管理员的身份访问 /getInfo 接口。GET请求

```plain
http://localhost:8989/getInfo
```

![img](未命名/__项目/assets/1693034027280-e520cc43-7cf3-4b40-a2e3-5d966b6c37dd.jpg)

第十七步: 测试。能否查询到非超级管理员的权限信息、用户信息(个人信息)

(1) 登录任意一个非超级管理员，复制token。POST请求

```plain
http://localhost:8989/user/login
{
    "userName":"HFuser",
    "password":"123"
}
```

![img](未命名/__项目/assets/1693034027400-f9377724-2710-468e-8770-c25c8dec835d.jpg)

(2) 以非超级管理员的身份访问 /getInfo 接口。GET请求

```plain
http://localhost:8989/getInfo
```

![img](未命名/__项目/assets/1693034027508-3fa457ac-1a7b-4ccf-a384-2c40d9cc0829.jpg)

# 博客后台模块-动态路由

实现了这个动态路由功能之后，就能在浏览器web页面登录进博客管理后台了，小期待不是

## 1. 接口分析

接口设计。后台系统需要能实现不同的用户权限可以看到不同的功能，即左侧的导航栏

| 请求方式 | 请求地址    | 请求头          |
| -------- | ----------- | --------------- |
| GET      | /getRouters | 需要token请求头 |

响应格式如下: 前端为了实现动态路由的效果，需要后端有接口能返回用户所能访问的菜单数据。注意: 返回的菜单数据需要体现父子菜单的层级关系

如果用户id为1代表管理员，menus中需要有所有菜单类型为C或者M的，C表示菜单，M表示目录，状态为正常的，未被删除的权限

```json
{
	"code":200,
	"data":{
		"menus":[
			{
				"children":[],
				"component":"content/article/write/index",
				"createTime":"2022-01-08 11:39:58",
				"icon":"build",
				"id":2023,
				"menuName":"写博文",
				"menuType":"C",
				"orderNum":"0",
				"parentId":0,
				"path":"write",
				"perms":"content:article:writer",
				"status":"0",
				"visible":"0"
			},
			{
				"children":[
					{
						"children":[],
						"component":"system/user/index",
						"createTime":"2021-11-12 18:46:19",
						"icon":"user",
						"id":100,
						"menuName":"用户管理",
						"menuType":"C",
						"orderNum":"1",
						"parentId":1,
						"path":"user",
						"perms":"system:user:list",
						"status":"0",
						"visible":"0"
					},
					{
						"children":[],
						"component":"system/role/index",
						"createTime":"2021-11-12 18:46:19",
						"icon":"peoples",
						"id":101,
						"menuName":"角色管理",
						"menuType":"C",
						"orderNum":"2",
						"parentId":1,
						"path":"role",
						"perms":"system:role:list",
						"status":"0",
						"visible":"0"
					},
					{
						"children":[],
						"component":"system/menu/index",
						"createTime":"2021-11-12 18:46:19",
						"icon":"tree-table",
						"id":102,
						"menuName":"菜单管理",
						"menuType":"C",
						"orderNum":"3",
						"parentId":1,
						"path":"menu",
						"perms":"system:menu:list",
						"status":"0",
						"visible":"0"
					}
				],
				"createTime":"2021-11-12 18:46:19",
				"icon":"system",
				"id":1,
				"menuName":"系统管理",
				"menuType":"M",
				"orderNum":"1",
				"parentId":0,
				"path":"system",
				"perms":"",
				"status":"0",
				"visible":"0"
			}
		]
	},
	"msg":"操作成功"
}
```

## 2. 代码实现

第一步: 在Start-framework工程的vo目录新建RoutersVo类，写入如下，负责把指定字段返回给前端

```java
package com.Start.vo;

import com.Start.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 19:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutersVo {
    private List<Menu> menus;
}
```

第二步: 把Start-framework工程的Menu类修改为如下，增加了children字段(成员变量)、增加了[@Accessors(chain]() = true)注解 

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.experimental.Accessors;

/**
 * 菜单权限表(Menu)表实体类
 *
 * @author makejava
 * @since 2023-08-04 13:20:58
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
@Accessors(chain = true) //允许链式编程
public class Menu  {
    //菜单ID
    @TableId
    private Long id;

    //菜单名称
    private String menuName;
    //父菜单ID
    private Long parentId;
    //显示顺序
    private Integer orderNum;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //是否为外链（0是 1否）
    private Integer isFrame;
    //菜单类型（M目录 C菜单 F按钮）
    private String menuType;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;
    //创建者
    private Long createBy;
    //创建时间
    private Date createTime;
    //更新者
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;
    
    private String delFlag;

    //由于数据库没有children字段，所以我们要添加@TableField(exist = false)注解让mybatis在查表时不查询这个字段
    @TableField(exist = false)
    private List<Menu> children;
}
```

第三步: 把Start-framework工程的MenuService接口修改为如下，增加了查询用户的路由信息(权限菜单)的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Menu;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:24
 */
public interface MenuService extends IService<Menu> {
    //查询用户的权限信息
    List<String> selectPermsByUserId(Long id);
    //查询用户的路由信息，也就是查询权限菜单
    List<Menu> selectRouterMenuTreeByUserId(Long userId);
}
```

第四步: 把Start-framework工程的MenuServiceImpl类修改为如下，增加了查询用户的路由信息(权限菜单)的具体代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Menu;
import com.Start.mapper.MenuMapper;
import com.Start.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:25
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    //查询用户的权限信息
    public List<String> selectPermsByUserId(Long id) {
        //根据用户id查询用户的权限信息。用户id为id代表超级管理员，如果是管理员就返回所有的权限
        if(id == 1L){
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            //查询条件是permissions中需要有所有菜单类型为C或者F的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.in(Menu::getMenuType, SystemCanstants.TYPE_MENU,SystemCanstants.TYPE_BUTTON);
            //查询条件是permissions中需要有状态为正常的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.eq(Menu::getStatus,SystemCanstants.STATUS_NORMAL);
            //查询条件是permissions中需要未被删除的权限的权限
            List<Menu> menus = list(wrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }

        //如果不是管理员就返回对应用户所具有的权限
        List<String> otherPerms = getBaseMapper().selectPermsByOtherUserId(id);
        return otherPerms;
    }

    //----------------------------------查询用户的路由信息(权限菜单)-------------------------------------

    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {

        MenuMapper menuMapper = getBaseMapper();

        List<Menu> menus = null;

        //判断是否是超级管理员，用户id为id代表超级管理员，如果是就返回所有符合要求的权限菜单
        if(userId.equals(1L)){
            menus = menuMapper.selectAllRouterMenu();
        }else{
            //如果不是超级管理员，就查询对应用户所具有的路由信息(权限菜单)
            menus = menuMapper.selectOtherRouterMenuTreeByUserId(userId);
        }

        //构建成tree，也就是子父菜单树，有层级关系
        //思路:先找出第一层的菜单，然后再找子菜单(也就是第二层)，把子菜单的结果赋值给Menu类的children字段
        List<Menu> menuTree = xxbuildMenuTree(menus,0L);

        return menuTree;
    }

    //用于把List集合里面的数据构建成tree，也就是子父菜单树，有层级关系
    private List<Menu> xxbuildMenuTree(List<Menu> menus, long parentId){
        List<Menu> menuTree = menus.stream()
                //过滤找出父菜单树，也就是第一层
                .filter(menu -> menu.getParentId().equals(parentId))
                //xxgetChildren是我们在下面写的方法，用于获取子菜单的List集合
                .map(menu -> menu.setChildren(xxgetChildren(menu, menus)))
                .collect(Collectors.toList());
        return menuTree;
    }

    //用于获取传入参数的子菜单，并封装为List集合返回
    private List<Menu> xxgetChildren(Menu menu, List<Menu> menus) {
        List<Menu> childrenList = menus.stream()
                //通过过滤得到子菜单
                .filter(m -> m.getParentId().equals(menu.getId()))
                //如果有三层菜单的话，也就是子菜单的子菜单，我们就用下面那行递归(自己调用自己)来处理
                .map(m -> m.setChildren(xxgetChildren(m,menus)))
                .collect(Collectors.toList());
        return childrenList;
    }
}
```

第五步: 把Start-framework工程的MenuMapper接口修改为如下，增加了2个(一个查超级管理员，另一个查普通用户)查询权限菜单的接口

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Menu;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:23
 */
public interface MenuMapper extends BaseMapper<Menu> {
    //查询普通用户的权限信息
    List<String> selectPermsByOtherUserId(Long userId);
    //查询超级管理员的路由信息(权限菜单)
    List<Menu> selectAllRouterMenu();
    //查询普通用户的路由信息(权限菜单)
    List<Menu> selectOtherRouterMenuTreeByUserId(Long userId);
}
```

第六步: 把Start-framework工程的resources/mapper目录下的MenuMapper.xml文件修改为如下，是查询权限菜单的具体代码

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<!--MenuMapper接口的映射文件，这里就就相当是MenuMapper接口的实现类，select标签就相当于实现类的具体方法-->
<mapper namespace="com.Start.mapper.MenuMapper">
    <!--查询普通用户的权限信息-->
    <select id="selectPermsByOtherUserId" resultType="java.lang.String">
        SELECT
            DISTINCT m.perms
        FROM
            `sys_user_role` ur
                LEFT JOIN `sys_role_menu` rm ON ur.`role_id` = rm.`role_id`
                LEFT JOIN `sys_menu` m ON m.`id` = rm.`menu_id`
        WHERE
            ur.`user_id` = #{userId} AND
            m.`menu_type` IN ('C','F') AND
            m.`status` = 0 AND
            m.`del_flag` = 0
    </select>

    <!--查询超级管理员的路由信息(权限菜单)-->
    <select id="selectAllRouterMenu" resultType="com.Start.domain.Menu">
        SELECT
            DISTINCT m.id, m.parent_id, m.menu_name, m.path, m.component, m.visible, m.status,
            IFNULL(m.perms,'') AS perms, m.is_frame,  m.menu_type, m.icon, m.order_num, m.create_time
        FROM
            `sys_menu` m
        WHERE
            m.`menu_type` IN ('C','M') AND
            m.`status` = 0 AND
            m.`del_flag` = 0
        ORDER BY
            m.parent_id,m.order_num
    </select>

    <!--查询普通用户的路由信息(权限菜单)-->
    <select id="selectOtherRouterMenuTreeByUserId" resultType="com.Start.domain.Menu">
        SELECT
            DISTINCT m.id, m.parent_id, m.menu_name, m.path, m.component, m.visible, m.status,
            IFNULL(m.perms,'') AS perms, m.is_frame,  m.menu_type, m.icon, m.order_num, m.create_time
        FROM
            `sys_user_role` ur
                LEFT JOIN `sys_role_menu` rm ON ur.`role_id` = rm.`role_id`
                LEFT JOIN `sys_menu` m ON m.`id` = rm.`menu_id`
        WHERE
            ur.`user_id` = #{userId} AND
            m.`menu_type` IN ('C','M') AND
            m.`status` = 0 AND
            m.`del_flag` = 0
        ORDER BY
            m.parent_id,m.order_num
    </select>
</mapper>
```

第七步: 把Start-admin工程的LoginController类修改为如下，增加了查询路由信息(权限菜单)的接口

```java
package com.Start.controller;

import com.Start.domain.LoginUser;
import com.Start.domain.Menu;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.MenuService;
import com.Start.service.RoleService;
import com.Start.service.SystemLoginService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.AdminUserInfoVo;
import com.Start.vo.RoutersVo;
import com.Start.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/3 0003 14:01
 */
@RestController
public class LoginController {

    @Autowired
    private SystemLoginService systemLoginService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return systemLoginService.login(user);
    }

    //---------------------------查询(超级管理员|非超级管理员)的权限和角色信息-----------------------------

    @GetMapping("/getInfo")
    //AdminUserInfoVo是我们在Start-framework工程写的类
    public ResponseResult<AdminUserInfoVo> getInfo(){
        //获取当前登录的用户。SecurityUtils是我们在Start-framework写的类
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据用户id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        //根据用户id查询角色信息
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());

        //获取用户信息
        User user = loginUser.getUser();
        //BeanCopyUtils是我们在Start-framework写的类
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        //封装响应返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms,roleKeyList,userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }

    //-------------------------------------查询路由信息(权限菜单)--------------------------------------

    @GetMapping("/getRouters")
    //RoutersVo是我们在Start-framework工程写的类
    public ResponseResult<RoutersVo> getRouters(){
        //获取用户id
        Long userId = SecurityUtils.getUserId();

        //根据用户id来查询menu(权限菜单)。要求查询结果是tree的形式，也就是子父菜单树
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        //封装响应返回
        return ResponseResult.okResult(new RoutersVo(menus));
    }
}
```

第八步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第九步: 测试。运行Start-admin工程的BlogAdminApplication类

思路: 我们完成了 权限控制+动态路由，就可以在浏览器web页面登录进管理后台了，所以就直接在管理后台测试，不需要在postman测试。如果你打开vue前端项目，访问如下地址，能够登录进管理后台，并看到左侧的管理菜单，就说明你成功实现了这节的动态路由，以及上一节的权限控制

```plain
http://localhost:81
```

![img](未命名/__项目/assets/1693034027634-79932eb3-432c-492a-99dd-57398ea5f3f4.jpg)

![img](未命名/__项目/assets/1693034027740-3672e3cf-a542-4fce-bb2e-4b37a39048df.jpg)

第十步: 补充。如果你测试的时候，不小心测试错了，然后发现怎么也退出不了登录，你想要去掉登录状态，那么就去cookie那里清除名称为Admin-Token的那条数据就能退出登录状态，如下图

![img](未命名/__项目/assets/1693034027858-6b826fbc-e243-4914-b25d-b9da97e1669d.jpg)

# 博客后台模块-退出登录

## 1. 接口分析

删除redis中的用户信息

| 请求方式 | 请求地址     | 请求头          |
| -------- | ------------ | --------------- |
| POST     | /user/logout | 需要token请求头 |

响应格式:

```plain
{
    "code": 200,
    "msg": "操作成功"
}
```

## 2. 代码实现

第一步: 把Start-framework工程的SystemLoginService接口修改为如下，增加了退出登录的接口

```java
package com.Start.service;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:38
 */
public interface SystemLoginService {

    //登录
    ResponseResult login(User user);

    //退出登录
    ResponseResult logout();
}
```

第二步: 把Start-framework工程的SystemLoginServiceImpl类修改为如下，增加了退出登录的具体代码

```java
package com.Start.service.impl;

import com.Start.domain.LoginUser;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.SystemLoginService;
import com.Start.utils.JwtUtil;
import com.Start.utils.RedisCache;
import com.Start.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:39
 */
@Service
//认证，判断用户登录是否成功
public class SystemLoginServiceImpl implements SystemLoginService {

    @Autowired
    //AuthenticationManager是security官方提供的接口
    private AuthenticationManager authenticationManager;

    @Autowired
    //RedisCache是我们在Start-framework工程的config目录写的类
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //封装登录的用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        //在下一行之前，封装的数据会先走UserDetailsServiceImpl实现类，这个实现类在我们的Start-framework工程的service/impl目录里面
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //上面那一行会得到所有的认证用户信息authenticate。然后下一行需要判断用户认证是否通过，如果authenticate的值是null，就说明认证没有通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        //把这个userid通过我们写的JwtUtil工具类转成密文，这个密文就是token值
        String jwt = JwtUtil.createJWT(userId);

        //下面那行的第一个参数: 把上面那行的jwt，也就是token值保存到Redis。存到时候是键值对的形式，值就是jwt，key要加上 "bloglogin:" 前缀
        //下面那行的第二个参数: 要把哪个对象存入Redis。我们写的是loginUser，里面有权限信息，后面会用到
        redisCache.setCacheObject("login:"+userId,loginUser);


        //把token封装 返回
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return ResponseResult.okResult(map);
    }

    //-------------------------------------退出登录---------------------------------------------

    @Override
    public ResponseResult logout() {
        //获取当前登录的用户id。SecurityUtils是我们在Start-framework工程写的类
        Long userId = SecurityUtils.getUserId();

        //删除redis中对应的值
        redisCache.deleteObject("login:" + userId);
        return ResponseResult.okResult();
    }
}
```

第三步: 那Start-admin工程的LoginController类修改为如下，增加了退出登录的访问接口

```java
package com.Start.controller;

import com.Start.domain.LoginUser;
import com.Start.domain.Menu;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.MenuService;
import com.Start.service.RoleService;
import com.Start.service.SystemLoginService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.RedisCache;
import com.Start.utils.SecurityUtils;
import com.Start.vo.AdminUserInfoVo;
import com.Start.vo.RoutersVo;
import com.Start.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/3 0003 14:01
 */
@RestController
public class LoginController {

    @Autowired
    private SystemLoginService systemLoginService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return systemLoginService.login(user);
    }

    //---------------------------查询(超级管理员|非超级管理员)的权限和角色信息-----------------------------

    @GetMapping("/getInfo")
    //AdminUserInfoVo是我们在Start-framework工程写的类
    public ResponseResult<AdminUserInfoVo> getInfo(){
        //获取当前登录的用户。SecurityUtils是我们在Start-framework写的类
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据用户id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        //根据用户id查询角色信息
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());

        //获取用户信息
        User user = loginUser.getUser();
        //BeanCopyUtils是我们在Start-framework写的类
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        //封装响应返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms,roleKeyList,userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }

    //-------------------------------------查询路由信息(权限菜单)--------------------------------------

    @GetMapping("/getRouters")
    //RoutersVo是我们在Start-framework工程写的类
    public ResponseResult<RoutersVo> getRouters(){
        //获取用户id
        Long userId = SecurityUtils.getUserId();

        //根据用户id来查询menu(权限菜单)。要求查询结果是tree的形式，也就是子父菜单树
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        //封装响应返回
        return ResponseResult.okResult(new RoutersVo(menus));
    }

    //--------------------------退出登录的接口(不建议直接写在controller)--------------------------------

    //@Autowired
    //private RedisCache redisCache;
    //
    //@PostMapping("/user/logout")
    //public ResponseResult logout(){
    //    //获取当前登录的用户id
    //    Long userId = SecurityUtils.getUserId();
    //
    //    //删除redis中对应的值
    //    redisCache.deleteObject("login:"+userId);
    //    return ResponseResult.okResult();
    //}

    //-----------------------------退出登录的接口(我们写在service比较好---------------------------------

    @Autowired
    private RedisCache redisCache;

    @PostMapping("/user/logout")
    public ResponseResult logout(){
        //退出登录
        return systemLoginService.logout();
    }
}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 测试。运行Start-admin工程的BlogAdminApplication类

第六步: 先使用postman软件进行测试。登录一个用户，请求体如下，复制token，然后用POST请求来测试退出登录的接口

```plain
http://localhost:8989/user/login
{
    "userName":"HFuser",
    "password":"123"
}
```

![img](未命名/__项目/assets/1693034027970-89e61cb7-c79f-48e0-a4e1-f288cec9f196.jpg)

![img](未命名/__项目/assets/1693034028083-acd7969c-9296-47b0-b95f-ecb333a7b501.jpg)

第七步: 运行vue前端项目，在浏览器页面进行退出用户登录的操作

![img](未命名/__项目/assets/1693034028196-d3244769-cc68-493e-9d3f-977423b8f169.jpg)

![img](未命名/__项目/assets/1693034028320-03558d0a-6670-4cee-b119-393a15eb0e9e.jpg)

# 博客后台模块-标签列表

## 1. 查询标签

### 一、标签表的字段

![img](未命名/__项目/assets/1693034028432-af196faa-cc6d-4714-bf9a-0675e8e7d123.jpg)

![img](未命名/__项目/assets/1693034028538-7a34d1fb-a485-4eb7-8696-f5cfd3a974cc.jpg)

### 二、接口分析

为了方便后期对文章进行管理，需要提供标签的功能，一个文章可以有多个标签。在后台需要分页查询标签功能，要求能根据标签名进行分页查询对应的文章

注意：不能把删除了的标签查询出来。除了可以根据标签名查询文章，后期还要添加根据备注名查询文章

| 请求方式 | 请求路径         |
| -------- | ---------------- |
| Get      | content/tag/list |

```plain
Query格式请求参数：

pageNum: 页码

pageSize: 每页条数

name：标签名

remark：备注
```

响应格式：

```json
{
	"code":200,
	"data":{
		"rows":[
			{
				"id":4,
				"name":"Java",
				"remark":"sdad"
			}
		],
		"total":1
	},
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 在Start-framework工程的src/main/java目录新建com.Start.dto.TagListDto类，写入如下

```java
package com.Start.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/5 0005 21:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "查询标签的请求参数dto") //这个是关于swagger的注解
public class TagListDto {

    //请求参数。用户可传可不传，这两个参数是给用户在搜索框根据name查询对应的标签，或根据remark查询对应的标签
    private String name;
    private String remark;

}
```

第二步: 在Start-framework工程的service目录新建TagService接口，写入如下，用于查询标签

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.Tag;
import com.Start.dto.TagListDto;
import com.Start.vo.PageVo;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:14
 */

public interface TagService extends IService<Tag> {
    //查询标签列表
    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);
}
```

第三步: 在Start-framework工程的service目录新建TagServiceImpl类，写入如下，是查询标签的具体代码，模糊+分页查询标签代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.Tag;
import com.Start.dto.TagListDto;
import com.Start.mapper.TagMapper;
import com.Start.service.TagService;
import com.Start.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:15
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Override
    //查询标签列表
    public ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto) {

        //分页查询的条件。模糊+分页
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        //第二、三个参数是互相比较。第一个参数是判空，当用户没有查询条件时，就不去比较后面两个参数
        queryWrapper.like(StringUtils.hasText(tagListDto.getName()),Tag::getName,tagListDto.getName());
        //第二、三个参数是互相比较。第一个参数是判空，当用户没有查询条件时，就不去比较后面两个参数
        queryWrapper.like(StringUtils.hasText(tagListDto.getRemark()),Tag::getRemark,tagListDto.getRemark());

        //分页查询。Page是mybatisplus提供的类，Tag是我们在Start-framework工程写的类
        Page<Tag> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //封装数据返回。PageVo是我们在Start-framework工程写的类
        PageVo pageVo = new PageVo(page.getRecords(),page.getTotal());
        return ResponseResult.okResult(pageVo);
    }
}
```

第四步: 在Start-admin工程的controller目录新建TagController类，写入如下，是查询标签的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.dto.TagListDto;
import com.Start.service.TagService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:27
 */
@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    //TagService是我们在Start-framework工程的接口
    private TagService tagService;

    //查询标签列表
    @GetMapping("/list")
    //ResponseResult是我们在Start-framework工程的实体类
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        //pageTagList是我们在Start-framework工程写的方法
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-admin工程的BlogAdminApplication类

第七步: 先使用postman软件进行测试。登录一个用户，请求体如下，复制token，然后用GET请求来测试查询标签的接口

```plain
http://localhost:8989/user/login
{
    "userName":"Startqc",
    "password":"228675"
}
```

![img](未命名/__项目/assets/1693034028647-bf5322aa-abe7-420a-a2c9-80720ab24e73.jpg)

![img](未命名/__项目/assets/1693034028771-9c61d015-8c90-4d1b-9bfe-a5dff8ffa0a3.jpg)

![img](未命名/__项目/assets/1693034028894-2271a1de-748b-43f8-8a24-70f104105dc9.jpg)

第八步: 测试。继续在postman里面用模糊查询来测试查询标签的接口

![img](未命名/__项目/assets/1693034029022-4aa8e5a0-c2cf-4470-975a-707f64058167.jpg)

![img](未命名/__项目/assets/1693034029146-951b8260-2042-424f-92b4-15ca6dc3aea3.jpg)

第九步: 测试。打开vue项目，在浏览器进行测试查询标签的接口

![img](未命名/__项目/assets/1693034029283-d11bb75c-9b02-4318-b39e-895d43c3c88b.jpg)

![img](未命名/__项目/assets/1693034029436-497d97ee-4b50-45cc-8b41-b17da1445f47.jpg)

## 2. 新增标签

### 一、标签表的字段

![img](未命名/__项目/assets/1693034028432-af196faa-cc6d-4714-bf9a-0675e8e7d123.jpg)

![img](未命名/__项目/assets/1693034028538-7a34d1fb-a485-4eb7-8696-f5cfd3a974cc.jpg)

### 二、接口分析

点击标签管理的新增按钮可以实现新增标签的功能

| 请求方式 | 请求地址     | 请求头          |
| -------- | ------------ | --------------- |
| POST     | /content/tag | 需要token请求头 |

请求体格式:

```json
{"name":"标签名","remark":"标签的备注名"}
```

响应格式：

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 确保你在Start-framework工程的com/Start/handler/mybatisplus目录里面，新建了MyMetaObjectHandler类，并且写入了如下，作用是配置是mybatisplus的字段自增

```java
package com.Start.handler.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.Start.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/7/26 0026 20:52
 */
@Component
//这个类是用来配置mybatis的字段自动填充。用于'发送评论'功能，由于我们在评论表无法对下面这四个字段进行插入数据(原因是前端在发送评论时，没有在
//请求体提供下面四个参数，所以后端在往数据库插入数据时，下面四个字段是空值)，所有就需要这个类来帮助我们往下面这四个字段自动的插入值，
//只要我们更新了评论表的字段，那么无法插入值的字段就自动有值了
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    //只要对数据库执行了插入语句，那么就会执行到这个方法
    public void insertFill(MetaObject metaObject) {
        Long userId = null;
        try {
            //获取用户id
            userId = SecurityUtils.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
            userId = -1L;//如果异常了，就说明该用户还没注册，我们就把该用户的userid字段赋值d为-1
        }
        //自动把下面四个字段新增了值。
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy",userId , metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", userId, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName(" ", SecurityUtils.getUserId(), metaObject);
    }
}
```

第二步: 在Start-framework工程的domain目录新建Tag类，写入如下，注意有四个字段是使用了mybatisplus的字段自增

```java
public class Tag  {
    @TableId
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
    //备注
    private String remark;
    //标签名
    private String name;
}
```

第三步: 在Start-framework工程的dto目录新建AddTagDto类，写入如下，用于接收前端传过来的参数

```java
package com.Start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/7 0007 13:39
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTagDto {

    //备注
    private String remark;
    //标签名
    private String name;
}
```

第四步: 把Start-admin工程的TagController类，添加如下，作用是新增标签功能的访问接口

```java
@PostMapping
public ResponseResult add(@RequestBody AddTagDto tagDto){
	Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
	tagService.save(tag);
	return ResponseResult.okResult();
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-admin工程的BlogAdminApplication类

第七步: 打开vue前端项目，在浏览器测试新增标签的功能

![img](未命名/__项目/assets/1693034029647-1d2b1352-f6c5-4095-97eb-0e48b3b7c90e.jpg)

![img](未命名/__项目/assets/1693034029764-28815223-4e3b-4bad-920d-ee3afd99b5cd.jpg)

## 3. 删除标签

### 一、标签表的字段

![img](未命名/__项目/assets/1693034028432-af196faa-cc6d-4714-bf9a-0675e8e7d123.jpg)

![img](未命名/__项目/assets/1693034028538-7a34d1fb-a485-4eb7-8696-f5cfd3a974cc.jpg)

### 二、接口分析

例如content/tag/6 代表删除id为6的标签数据。删除后在列表中是否查看不到该条数据，但是数据库中该条数据还是存在的，只是修改了逻辑删除字段的值

| 请求方式 | 请求地址          | 请求头          |
| -------- | ----------------- | --------------- |
| DELETE   | /content/tag/{id} | 需要token请求头 |

响应格式：

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 在Start-framework工程的mapper目录新建TagMapper接口，写入如下，用于使用mybatis提供的一些单表查询的方法

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Tag;
import org.apache.ibatis.annotations.Param;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:13
 */

public interface TagMapper extends BaseMapper<Tag> {
    //删除标签，注意是逻辑删除，所以不能使用mybatisplus提供的，我们要自己使用mybatis写SQL语句
    int myUpdateById(@Param("id") Long id,@Param("flag") int flag);
}
```

第二步: 在Start-admin工程的TagController类添加如下，作用是删除标签功能的访问接口

```java
@DeleteMapping("/{id}")
public ResponseResult delete(@PathVariable Long id){
	tagService.removeById(id);
	return ResponseResult.okResult();
}
```

第三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 测试。运行Start-admin工程的BlogAdminApplication类

第五步: 打开vue前端项目，在浏览器测试根据标签id来删除 '标签分类' 的功能

![img](未命名/__项目/assets/1693034029898-42813ccd-44ee-4a00-a9a6-5ef3e44330bf.jpg)

![img](未命名/__项目/assets/1693034030019-49683a1c-72f7-4fb3-8ff4-aa5bdb17bbb8.jpg)

![img](未命名/__项目/assets/1693034030153-1376e948-7d4e-4322-ba12-b90298863a52.jpg)



第六步: 批量删除会报错，解决如下

~~~java
解决:
先在前端全局搜索 /content/tag 关键字，然后就能找到下面的代码，
然后在tag后面拼接 ?ids= 
``` 
export function delTag(id) {
  return request({
    url: '/content/tag?ids=' + id,
    method: 'delete'
  })
}
```

然后把后端对应接口修改为如下
```
@DeleteMapping
public ResponseResult remove(@RequestParam(value = "ids")String ids) {
    if (!ids.contains(",")) {
        tagService.removeById(ids);
    } else {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            tagService.removeById(id);
        }
    }
    return ResponseResult.okResult();
}
```
~~~



## 4. 修改标签

### 一、标签表的字段

![img](未命名/__项目/assets/1693034028432-af196faa-cc6d-4714-bf9a-0675e8e7d123.jpg)

![img](未命名/__项目/assets/1693034028538-7a34d1fb-a485-4eb7-8696-f5cfd3a974cc.jpg)

### 二、接口分析

①根据标签id来获取某一条标签的信息，当用户点击修改按钮时触发，展示在弹框里面。例如：content/tag/6 代表获取id为6的标签数据

| 请求方式 | 请求地址          | 请求头          |
| -------- | ----------------- | --------------- |
| GET      | /content/tag/{id} | 需要token请求头 |

响应格式：

```json
{
	"code":200,
	"data":{
        "id":4,
        "name":"标签名",
        "remark":"标签的备注名"
	},
	"msg":"操作成功"
}
```

②修改标签接口:

| 请求方式 | 请求地址     | 请求头          |
| -------- | ------------ | --------------- |
| PUT      | /content/tag | 需要token请求头 |

请求体格式：

```json
{"id":7,"name":"标签名","remark":"标签的备注名"}
```

响应格式：

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 在Start-framework工程的dto目录新建EditTagDto类，写入如下，用于接收前端传过来的参数

```java
package com.Start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/7 0007 14:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditTagDto {

    private Long id;
    //备注
    private String remark;
    //标签名
    private String name;
}
```

第二步: 把Start-admin工程的TagController类修改为如下，作用是修改标签功能的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Tag;
import com.Start.dto.AddTagDto;
import com.Start.dto.EditTagDto;
import com.Start.dto.TagListDto;
import com.Start.service.TagService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:27
 */
@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    //TagService是我们在Start-framework工程的接口
    private TagService tagService;

    //查询标签列表
    @GetMapping("/list")
    //ResponseResult是我们在Start-framework工程的实体类
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        //pageTagList是我们在Start-framework工程写的方法
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }

    //-------------------------------新增标签------------------------------------

    @PostMapping
    public ResponseResult add(@RequestBody AddTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.okResult();
    }

    ////-------------------------------删除标签------------------------------------

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        tagService.removeById(id);
        return ResponseResult.okResult();
    }

    ////-------------------------------修改标签------------------------------------

    @GetMapping("/{id}")
    //①根据标签的id来查询标签
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        Tag tag = tagService.getById(id);
        return ResponseResult.okResult(tag);
    }

    @PutMapping
    //②根据标签的id来修改标签
    public ResponseResult edit(@RequestBody EditTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto,Tag.class);
        tagService.updateById(tag);
        return ResponseResult.okResult();
    }
}
```

第三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 测试。运行Start-admin工程的BlogAdminApplication类

第五步: 打开vue前端项目，在浏览器测试根据标签id来修改标签的功能

![img](未命名/__项目/assets/1693034030290-3971ab2f-c8a8-43e0-a74d-1410ab01d81d.jpg)

![img](未命名/__项目/assets/1693034030498-0d22fce2-c57c-4c6c-b359-d7b91db22a73.jpg)

# 博客后台模块-发布文章

需要提供写博文的功能，写博文时需要关联分类和标签。可以上传缩略图，也可以在正文中添加图片。文章可以直接发布，也可以保存到草稿箱

## 1. 查询分类接口

### 一、分类表的字段

![img](未命名/__项目/assets/1693034009010-77be19eb-0872-4d2c-95c7-894f9502d7eb.jpg)

![img](未命名/__项目/assets/1693034009158-7b9d44ba-7522-4f06-bd5a-00c7883e8fd8.jpg)

### 二、接口分析

请求方式如下，注意: 无请求参数

| 请求方式 | 请求地址                          | 请求头          |
| -------- | --------------------------------- | --------------- |
| GET      | /content/category/listAllCategory | 需要token请求头 |

响应格式：

```json
{
	"code":200,
	"data":[
		{
			"description":"wsd",
			"id":1,
			"name":"java"
		},
		{
			"description":"wsd",
			"id":2,
			"name":"PHP"
		}
	],
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 把Start-framework工程的SystemCanstants类修改为如下，增加了正常状态的判断常量

```java
package com.Start.constants;

/**
 * @author 35238
 * @date 2023/7/19 0019 19:14
 */
//字面值(代码中的固定值)处理，把字面值都在这里定义成常量。可以把这个类叫做常量类
public class SystemCanstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;

    /**
     * 分类表的分类状态是正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 友链状态为审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 评论区的某条评论是根评论
     */
    public static final String COMMENT_ROOT = "-1";

    /**
     * 文章的评论
     */
    public static final String ARTICLE_COMMENT = "0";

    /**
     * 友链的评论
     */
    public static final String LINK_COMMENT = "1";

    /**
     * 权限类型，菜单
     */
    public static final String TYPE_MENU = "C";

    /**
     * 权限类型，按钮
     */
    public static final String TYPE_BUTTON = "F";

    /**
     * 正常状态
     */
    public static final String NORMAL = "0";
}
```

第二步: 在Start-framework工程的vo工程新建CategoryVo类，用于指定哪些字段返回给前端

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/7/20 0020 15:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//返回给前端的特定字段
public class CategoryVo {

    private Long id;
    private String name;

    //描述
    private String description;

}
```

第三步: 把Start-framework工程的service目录的CategoryService接口修改为如下，增加了 '写博客-查询文章分类' '写博客-查询文章分类' 的接口的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.vo.CategoryVo;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:41
 */
public interface CategoryService extends IService<Category> {

    //查询文章分类的接口
    ResponseResult getCategoryList();

    //写博客-查询文章分类的接口
    List<CategoryVo> listAllCategory();
}
```

第四步: 把Start-framework工程的CategoryServiceImpl类修改为如下，增加了 '写博客-查询文章分类' 接口的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.Category;
import com.Start.vo.CategoryVo;
import com.Start.domain.ResponseResult;
import com.Start.mapper.CategoryMapper;
import com.Start.service.ArticleService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:41
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

    @Autowired
    //ArticleService是我们在Start-framework写的接口
    private ArticleService articleService;

    @Override
    //查询分类列表的核心代码
    public ResponseResult getCategoryList() {
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        //要求查的是文章表status字段的值为1，注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        articleWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //查询文章列表，条件就是上一行的articleWrapper
        List<Article> articleList = articleService.list(articleWrapper);
        //获取文章的分类id，并且去重。使用stream流来处理上一行得到的文章表集合
        Set<Long> categoryIds = articleList.stream()
                //下面那行可以优化为Lambda表达式+方法引用
                .map(new Function<Article, Long>() {
                    @Override
                    public Long apply(Article article) {
                        return article.getCategoryId();
                    }
                })
                //把文章的分类id转换成Set集合
                .collect(Collectors.toSet());

        //查询分类表
        List<Category> categories = listByIds(categoryIds);
        //注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        categories = categories.stream()
                .filter(category -> SystemCanstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        //封装成CategoryVo实体类后返回给前端，CategoryVo的作用是只返回前端需要的字段。BeanCopyUtils是我们写的工具类
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }

    //----------------------------写博客-查询文章分类的接口--------------------------------------

    @Override
    public List<CategoryVo> listAllCategory() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getStatus, SystemCanstants.NORMAL);
        List<Category> list = list(wrapper);
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(list, CategoryVo.class);
        return categoryVos;
    }
}
```

第五步: 在Start-admin工程的controller目录新建CategoryController类，写入如下，是 '写博客-查询文章分类' 的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.service.CategoryService;
import com.Start.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/7 0007 14:28
 */
@RestController
@RequestMapping("/content/category")
public class CategoryController {

    //---------------------------写博文-查询文章分类的接口--------------------------------

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory(){
        List<CategoryVo> list = categoryService.listAllCategory();
        return ResponseResult.okResult(list);
    }
}
```

第六步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第七步: 测试。运行Start-admin工程的BlogAdminApplication类

第八步: 打开vue前端项目，在浏览器测试在 '写文章' 页面，能不能查询出文章的分类列表

![img](未命名/__项目/assets/1693034030642-aab6db0b-0f95-4ae4-8dc2-3769d7b43b48.jpg)

## 2. 查询标签接口

### 一、标签表的字段

![img](未命名/__项目/assets/1693034028432-af196faa-cc6d-4714-bf9a-0675e8e7d123.jpg)

![img](未命名/__项目/assets/1693034028538-7a34d1fb-a485-4eb7-8696-f5cfd3a974cc.jpg)

### 二、接口分析

请求方式如下，注意: 无请求参数

| 请求方式 | 请求地址                | 请求头          |
| -------- | ----------------------- | --------------- |
| GET      | /content/tag/listAllTag | 需要token请求头 |

响应格式：

```json
{
	"code":200,
	"data":[
		{
			"id":1,
			"name":"Mybatis"
		},
		{
			"id":4,
			"name":"Java"
		}
	],
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 在Start-framework工程的com.Start.dto目录下新建TabListDto类，写入如下

```java
package com.Start.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/6 0006 15:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "新增标签的请求参数dto") //这个是关于swagger的注解
public class TabListDto {

    //请求参数。用户可传可不传，这两个参数是给用户在搜索框根据name查询对应的标签，或根据remark查询对应的标签
    private String name;
    private String remark;

}
```

第二步: 把Start-framework工程的TagVo类，修改为写入如下，指定哪些字段返回给前端

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/6 0006 19:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVo {

    private Long id;
    private String name;
    private String remark;
}
```

第三步: 把Start-framework工程TagService接口修改为如下，新增了 '写博文-查询文章标签的接口'

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.Tag;
import com.Start.dto.TabListDto;
import com.Start.dto.TagListDto;
import com.Start.vo.PageVo;
import com.Start.vo.TagVo;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:14
 */

public interface TagService extends IService<Tag> {
    //查询标签列表
    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);
    //新增标签
    ResponseResult addTag(TabListDto tagListDto);
    //删除标签
    ResponseResult deleteTag(Long id);
    //修改标签-①根据标签的id来查询标签
    ResponseResult getLableById(Long id);
    //修改标签-②根据标签的id来修改标签
    ResponseResult myUpdateById(TagVo tagVo);

    //写博文-查询文章标签的接口
    List<TagVo> listAllTag();
}
```

第四步: 把Start-framework工程的TagServiceImpl类修改为如下，新增了 '写博文-查询文章标签的接口' 的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.LoginUser;
import com.Start.domain.ResponseResult;
import com.Start.domain.Tag;
import com.Start.dto.TabListDto;
import com.Start.dto.TagListDto;
import com.Start.mapper.TagMapper;
import com.Start.service.TagService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.PageVo;
import com.Start.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:15
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    //操作tag表
    private TagMapper tagMapper;

    @Override
    //查询标签列表
    public ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto) {

        //分页查询的条件。模糊+分页
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        //第二、三个参数是互相比较。第一个参数是判空，当用户没有查询条件时，就不去比较后面两个参数
        queryWrapper.like(StringUtils.hasText(tagListDto.getName()),Tag::getName,tagListDto.getName());
        //第二、三个参数是互相比较。第一个参数是判空，当用户没有查询条件时，就不去比较后面两个参数
        queryWrapper.like(StringUtils.hasText(tagListDto.getRemark()),Tag::getRemark,tagListDto.getRemark());

        //分页查询。Page是mybatisplus提供的类，Tag是我们在Start-framework工程写的类
        Page<Tag> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //封装数据返回。PageVo是我们在Start-framework工程写的类
        PageVo pageVo = new PageVo(page.getRecords(),page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------新增标签------------------------------------

    @Override
    public ResponseResult addTag(TabListDto tagListDto) {

        Tag tag = new Tag();
        //获取创建人、创建时间
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //获取创建人的id
        tag.setCreateBy(loginUser.getUser().getId());

        try{
            //生成创建时间、更新时间
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //获取当前时间
            Date now = new Date();
            //将当前时间格式化为指定格式的字符串
            String strNow = dateFormat.format(now);
            //将字符串转换为Date类型
            Date date = dateFormat.parse(strNow);
            //最终得到的就是创建时间
            tag.setCreateTime(date);
        } catch (ParseException e){
            e.printStackTrace();
        }

        //修改标签名、标签的描述信息
        tag.setName(tagListDto.getName());
        tag.setRemark(tagListDto.getRemark());

        //把新增好后的数据插入数据库
        tagMapper.insert(tag);
        return ResponseResult.okResult();
    }

    //-------------------------------删除标签------------------------------------

    @Override
    public ResponseResult deleteTag(Long id) {
        // 通过数据id查找数据
        Tag tag  = tagMapper.selectById(id);
        // 把值传入数据库进行更新
        if (tag != null){
            // 把 def_flag=1 为逻辑删除
            int flag = 1;
            tagMapper.myUpdateById(id,flag);
        }
        return ResponseResult.okResult();
    }

    //-------------------------------修改标签------------------------------------

    @Override
    //①根据标签的id来查询标签
    public ResponseResult getLableById(Long id) {
        Tag tag = tagMapper.selectById(id);
        // 封装成vo响应给前端
        TagVo tagVoData = BeanCopyUtils.copyBean(tag,TagVo.class);
        return ResponseResult.okResult(tagVoData);
    }

    @Override
    //②根据标签的id来修改标签
    public ResponseResult myUpdateById(TagVo tagVo) {
        Tag tag = new Tag();
        // 获取更新时间、更新人
        LoginUser loginUser = SecurityUtils.getLoginUser();
        // 更新人的id
        tag.setUpdateBy(loginUser.getUser().getId());

        // 创建时间、更新时间
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 获取当前时间
            Date now = new Date();
            //将当前时间格式化为指定格式的字符串
            String strNow = dateFormat.format(now);
            //将字符串转换为Date类型
            Date date = dateFormat.parse(strNow);
            //最终得到的就是创建时间
            tag.setUpdateTime(date);
        } catch (ParseException e){
            e.printStackTrace();
        }

        //修改标签id、标签名、标签的描述信息
        tag.setId(tagVo.getId());
        tag.setName(tagVo.getName());
        tag.setRemark(tagVo.getRemark());

        //把新增好后的数据插入数据库
        tagMapper.updateById(tag);
        return ResponseResult.okResult();
    }

    //---------------------------写博文-查询文章标签的接口---------------------------

    @Override
    public List<TagVo> listAllTag() {
        LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Tag::getId,Tag::getName);
        List<Tag> list = list(wrapper);
        List<TagVo> tagVos = BeanCopyUtils.copyBeanList(list, TagVo.class);
        return tagVos;
    }
}
```

第五步: 把Start-admin工程的TagController类修改为如下，新增了 '写博文-查询文章标签' 功能的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Tag;
import com.Start.dto.AddTagDto;
import com.Start.dto.TabListDto;
import com.Start.dto.TagListDto;
import com.Start.service.TagService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.PageVo;
import com.Start.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/2 0002 21:27
 */
@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    //TagService是我们在Start-framework工程的接口
    private TagService tagService;

    //查询标签列表
    @GetMapping("/list")
    //ResponseResult是我们在Start-framework工程的实体类
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        //pageTagList是我们在Start-framework工程写的方法
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }

    //-------------------------------新增标签------------------------------------

    @PostMapping
    public ResponseResult add(@RequestBody AddTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.okResult();
    }

    //-------------------------------删除标签------------------------------------

    @DeleteMapping("/{id}")
    //pageTagList是我们在Start-framework工程写的方法
    public ResponseResult deleteTag(@PathVariable Long id){
        return tagService.deleteTag(id);
    }

    //-------------------------------修改标签------------------------------------


    @GetMapping("/{id}")
    //①根据标签的id来查询标签
    public ResponseResult getLableById(@PathVariable Long id){
        return tagService.getLableById(id);
    }

    @PutMapping
    //②根据标签的id来修改标签
    public ResponseResult updateById(@RequestBody TagVo tagVo){
        return tagService.myUpdateById(tagVo);
    }


    //---------------------------写博文-查询文章标签的接口---------------------------

    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }
}
```

第六步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第七步: 测试。运行Start-admin工程的BlogAdminApplication类

第八步: 打开vue前端项目，在浏览器测试在 '写文章' 页面，能不能查询出文章的标签列表

![img](未命名/__项目/assets/1693034030802-65e43310-5875-428b-8034-108d5bcc1542.jpg)

## 3. 图片上传

### 一、接口分析

请求方式如下。请求参数是img，值为要上传的文件

| 请求方式 | 请求地址 | 请求头          |
| -------- | -------- | --------------- |
| POST     | /upload  | 需要token请求头 |

请求头:

```java
Content-Type ：multipart/form-data;
```

响应格式:

```json
{
    "code": 200,
    "data": "文件访问链接",
    "msg": "操作成功"
}
```

### 二、代码实现

第一步: 把Start-admin工程的application.yml修改为如下，增加了OSS的相关配置

```yaml
server:
  port: 8989
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sg_blog?characterEncoding=utf-8&serverTimezone=UTC
    username: root
    password: 228675
    driver-class-name: com.mysql.cj.jdbc.Driver

  servlet:
    # 文件上传
    multipart:
      # 单个上传文件的最大允许大小
      max-file-size: 20MB
      # HTTP请求中包含的所有文件的总大小的最大允许值
      max-request-size: 20MB

mybatis-plus:
  configuration:
    # 日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      logic-delete-field: delFlag
      logic-delete-value: 1
      logic-not-delete-value: 0
      id-type: auto

# 打开七牛云，找到密钥管理，把相关信息填写到下面3行，会被Start-blog工程的OOSTest类获取
myoss:
  xxaccessKey: _ibGP9wytjLCAZPqcFaWQNxbw7fMUvofSOvOFFR3
  xxsecretKey: QSOAU-cv3sSDGNfVNPF6iXz-PsP5X9QTrjFI9zYw
  xxbucket: Start-blog
```

第二步: 在Start-admin工程的controller目录新建UploadController类，写入如下

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.service.OssUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:05
 */
@RestController
public class UploadController {

    @Autowired
    private OssUploadService uploadService;

    @PostMapping("/upload")
    public ResponseResult uploadImg(@RequestParam("img") MultipartFile multipartFile) {
        try {
            return uploadService.uploadImg(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传上传失败");
        }
    }
}
```

第三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 测试。运行Start-admin工程的BlogAdminApplication类

第五步: 打开vue前端项目，在浏览器测试在 '写文章' 页面，能不能在 '写文章' 页面进行图片文件的上传

![img](未命名/__项目/assets/1693034030947-b6d49e61-cf4b-43a6-9b00-ddceabf41715.jpg)

## 4. 新增博文

### 一、接口分析

请求方式如下:

| 请求方式 | 请求地址         | 请求头          |
| -------- | ---------------- | --------------- |
| POST     | /content/article | 需要token请求头 |

请求体格式：

```json
{
    "title":"测试新增博文",
    "thumbnail":"https://sg-blog-oss.oss-cn-beijing.aliyuncs.com/2022/08/21/4ceebc07e7484beba732f12b0d2c43a9.png",
    "isTop":"0",
    "isComment":"0",
    "content":"# 一级标题\n## 二级标题\n![Snipaste_20220228_224837.png](https://sg-blog-oss.oss-cn-beijing.aliyuncs.com/2022/08/21/c3af554d4a0f4935b4073533a4c26ee8.png)\n正文",
    "tags":[
        1,
        4
    ],
    "categoryId":1,
    "summary":"哈哈",
    "status":"1"
}
```

响应格式：

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 在Start-framework工程的domain目录新建ArticleTag类，写入如下，文章表&标签表的中间表，对应的实体类

```java
package com.Start.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:28
 */
@TableName(value="sg_article_tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
//新增博客文章
public class ArticleTag implements Serializable {
    private static final long serialVersionUID = 625337492348897098L;

    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 标签id
     */
    private Long tagId;

}
```

第二步: 在Start-framework工程的dto目录新建AddArticleDto类，写入如下，用来接受前端传过来的参数，最重要的是tags属性

```java
package com.Start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//新增博客文章
public class AddArticleDto {

    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;

    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    //tags属性是一个List集合，用于接收文章关联标签的id
    private List<Long> tags;

}
```

第三步: 在Start-framework工程的vo目录新建ArticleVo类修改为如下，注意有4个字段是使用了mybatisplus属性值自增的注解

```java
package com.Start.vo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.Start.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 35238
 * @date 2023/7/18 0018 21:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sg_article")
public class ArticleVo {

    @TableId
    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;

    //增加一个字段，为categoryName，由categoryId来查询出
    //由于数据库没有category_name字段，所以要用注解指定一下字段
    @TableField(exist = false)//代表这个字段在数据库中不存在，避免MyBatisPlus在查询时报错
    private String categoryName;

    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;

    //新增博客文章-使用mybatisplus的字段自增
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

    public ArticleVo(Long id, long viewCount) {
        this.id = id;
        this.viewCount = viewCount;
    }
}
```

第四步: 在Start-framework工程的mapper目录新建ArticleVoMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Article;
import com.Start.vo.ArticleVo;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:13
 */
@Service
public interface ArticleVoMapper extends BaseMapper<ArticleVo> {

}
```

第五步：在Start-framework工程的service目录新建ArticleVoService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.vo.ArticleVo;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */

public interface ArticleVoService extends IService<ArticleVo> {

}
```

第六步: 在Start-framework工程的service目录新建impl.ArticleVoServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.mapper.ArticleVoMapper;
import com.Start.service.ArticleVoService;
import com.Start.vo.ArticleVo;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/8/9 0009 21:20
 */
@Service
public class ArticleVoServiceImpl extends ServiceImpl<ArticleVoMapper, ArticleVo> implements ArticleVoService {

}
```

第七步: 在Start-framework工程的mapper目录新建ArticleTagMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.ArticleTag;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:38
 */
//新增博客文章
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

}
```

第八步: 在Start-framework工程的service目录新建ArticleTagService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ArticleTag;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:32
 */
public interface ArticleTagService extends IService<ArticleTag> {

}
```

第九步: 在Start-framework工程的service目录新建impl.ArticleTagServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ArticleTag;
import com.Start.mapper.ArticleTagMapper;
import com.Start.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:33
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

}
```

第十步: 把Start-framework工程的ArticleService接口，修改为写入如下，增加写博客文章的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */
public interface ArticleService extends IService<Article> {

    //文章列表
    ResponseResult hotArticleList();

    //分类查询文章列表
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    //根据id查询文章详情
    ResponseResult getArticleDetail(Long id);

    //根据文章id从mysql查询文章
    ResponseResult updateViewCount(Long id);

    //新增博客文章
    ResponseResult add(AddArticleDto article);
}
```

第十一步: 把Start-framework工程的ArticleServiceImpl类修改为如下，增加了写博客文章接口的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.ArticleTag;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.service.ArticleTagService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.RedisCache;
import com.Start.vo.ArticleDetailVo;
import com.Start.vo.ArticleListVo;
import com.Start.vo.ArticleVo;
import com.Start.vo.HotArticleVO;
import com.Start.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    //操作数据库。ArticleService是我们在Start-framework工程写的接口
    private ArticleService articleService;


    @Override
    public ResponseResult hotArticleList() {

        //-------------------每调用这个方法就从redis查询文章的浏览量，展示在热门文章列表------------------------

        //获取redis中的浏览量，注意得到的viewCountMap是HashMap双列集合
        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");
        //让双列集合调用entrySet方法即可转为单列集合，然后才能调用stream方法
        List<Article> xxarticles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                //把最终数据转为List集合
                .collect(Collectors.toList());
        //把获取到的浏览量更新到mysql数据库中。updateBatchById是mybatisplus提供的批量操作数据的接口
        articleService.updateBatchById(xxarticles);

        //-----------------------------------------------------------------------------------------

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);

        return ResponseResult.okResult(articleVos);
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @Autowired
    //注入我们写的CategoryService接口
    private CategoryService categoryService;

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第一种方式，用for循环遍历的方式
         */
        ////用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        //List<Article> articles = page.getRecords();
        //for (Article article : articles) {
        //    //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
        //    Category category = categoryService.getById(article.getCategoryId());
        //    //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
        //    article.setCategoryName(category.getName());
        //
        //}

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第二种方式，用stream流的方式
         */
        //用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        List<Article> articles = page.getRecords();

        articles.stream()
                .map(new Function<Article, Article>() {
                    @Override
                    public Article apply(Article article) {
                        //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
                        Category category = categoryService.getById(article.getCategoryId());
                        String name = category.getName();
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        article.setCategoryName(name);
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        return article;
                    }
                })
                .collect(Collectors.toList());


        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);


        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    //---------------------------------根据id查询文章详情----------------------------------

    @Override
    public ResponseResult getArticleDetail(Long id) {

        //根据id查询文章
        Article article = getById(id);

        //-------------------从redis查询文章的浏览量，展示在文章详情---------------------------

        //从redis查询文章浏览量
        Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
        article.setViewCount(viewCount.longValue());

        //-----------------------------------------------------------------------------

        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);

        //根据分类id，来查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        //如果根据分类id查询的到分类名，那么就把查询到的值设置给ArticleDetailVo实体类的categoryName字段
        if(category!=null){
            articleDetailVo.setCategoryName(category.getName());
        }

        //封装响应返回。ResponseResult是我们在Start-framework工程的domain目录写的实体类
        return ResponseResult.okResult(articleDetailVo);
    }

    //--------------------------------根据文章id从mysql查询文章----------------------------

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult updateViewCount(Long id) {
        //更新redis中的浏览量，对应文章id的viewCount浏览量。article:viewCount是ViewCountRunner类里面写的
        //用户每从mysql根据文章id查询一次浏览量，那么redis的浏览量就增加1
        redisCache.incrementCacheMapValue("article:viewCount",id.toString(),1);
        return ResponseResult.okResult();
    }

    //-------------------------------------增加博客文章-----------------------------------

    @Autowired
    private ArticleTagService articleTagService;

    @Autowired
    private ArticleVoService articleVoService;

    @Override
    @Transactional
    public ResponseResult add(AddArticleDto articleDto) {
        //添加 博客
        ArticleVo articlevo = BeanCopyUtils.copyBean(articleDto, ArticleVo.class);
        articleVoService.save(articlevo);


        List<ArticleTag> articleTags = articleDto.getTags().stream()
                .map(tagId -> new ArticleTag(articlevo.getId(), tagId))
                .collect(Collectors.toList());

        //添加 博客和标签的关联
        articleTagService.saveBatch(articleTags);
        return ResponseResult.okResult();
    }
}
```

第十二步: 在Start-admin工程的controller目录新建ArticleController类，写入如下，增加了写博客文章的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:21
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    //------------------------------新增博客文章-----------------------------

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }
}
```

第十三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第十四步: 测试。运行Start-admin工程的BlogAdminApplication类

第十五步: 打开vue前端项目，在浏览器测试在 '写文章' 页面，能不能写一篇博客文章并发送，然后去前台看一下能不能展示出来

![img](未命名/__项目/assets/1693034031085-53baaae0-feca-4f85-a607-023bcd6808d0.jpg)

![img](未命名/__项目/assets/1693034031218-c8124d1e-a8ff-4566-a954-c4e30c8d54ba.jpg)

![img](未命名/__项目/assets/1693034031364-558807ba-c1e5-465b-9101-28f4bdf36ee6.jpg)

![img](未命名/__项目/assets/1693034031497-bae440c8-f938-4d16-9f17-29a30c75459c.jpg)

# 博客后台模块-分类列表

## 1. 查询分类

### 一、分类表的字段

![img](未命名/__项目/assets/1693034009010-77be19eb-0872-4d2c-95c7-894f9502d7eb.jpg)

![img](未命名/__项目/assets/1693034009158-7b9d44ba-7522-4f06-bd5a-00c7883e8fd8.jpg)

### 二、接口分析

查询分类列表的信息

| 请求方式 | 请求地址               |
| -------- | ---------------------- |
| GET      | /content/category/list |

Query格式请求参数如下:

```plain
pageNum:页码
pageSize:每页条数
```

响应格式：

```json
{
	"code":200,
	"data":{
		"rows":[
			{
				"id":1,
				"name":"分类名",
				"status":"0",
                "description":"分类描述",
                "delFlag":"0",
                "pid":"-1",
			}
		],
		"total":1
	},
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 把Start-framework工程的CategoryService接口修改为如下，增加了分页查询分类列表的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.vo.CategoryVo;
import com.Start.vo.PageVo;

import java.util.List;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:41
 */
public interface CategoryService extends IService<Category> {
    //查询文章分类的接口
    ResponseResult getCategoryList();

    //写博客-查询文章分类的接口
    List<CategoryVo> listAllCategory();

    //分页查询分类列表
    PageVo selectCategoryPage(Category category, Integer pageNum, Integer pageSize);
}
```

第二步: 把Start-framework工程的CategoryServiceImpl类修改为如下，增加了分页查询分类列表接口的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.Category;
import com.Start.vo.CategoryVo;
import com.Start.domain.ResponseResult;
import com.Start.mapper.CategoryMapper;
import com.Start.service.ArticleService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:41
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

    @Autowired
    //ArticleService是我们在Start-framework写的接口
    private ArticleService articleService;

    @Override
    //查询分类列表的核心代码
    public ResponseResult getCategoryList() {
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        //要求查的是文章表status字段的值为1，注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        articleWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //查询文章列表，条件就是上一行的articleWrapper
        List<Article> articleList = articleService.list(articleWrapper);
        //获取文章的分类id，并且去重。使用stream流来处理上一行得到的文章表集合
        Set<Long> categoryIds = articleList.stream()
                //下面那行可以优化为Lambda表达式+方法引用
                .map(new Function<Article, Long>() {
                    @Override
                    public Long apply(Article article) {
                        return article.getCategoryId();
                    }
                })
                //把文章的分类id转换成Set集合
                .collect(Collectors.toSet());

        //查询分类表
        List<Category> categories = listByIds(categoryIds);
        //注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        categories = categories.stream()
                .filter(category -> SystemCanstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        //封装成CategoryVo实体类后返回给前端，CategoryVo的作用是只返回前端需要的字段。BeanCopyUtils是我们写的工具类
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }

    //----------------------------写博客-查询文章分类的接口--------------------------------------

    @Override
    public List<CategoryVo> listAllCategory() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getStatus, SystemCanstants.NORMAL);
        List<Category> list = list(wrapper);
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(list, CategoryVo.class);
        return categoryVos;
    }

    //----------------------------------分页查询分类列表------------------------------------------

    @Override
    public PageVo selectCategoryPage(Category category, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.hasText(category.getName()),Category::getName, category.getName());
        queryWrapper.eq(Objects.nonNull(category.getStatus()),Category::getStatus, category.getStatus());

        Page<Category> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换成VO
        List<Category> categories = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(categories);
        return pageVo;
    }
}
```

第三步: 把Start-admin工程的CategoryController类修改为如下，增加了分页查询分类功能的访问接口

```java
package com.Start.controller;

import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.service.CategoryService;
import com.Start.vo.CategoryVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/7 0007 14:28
 */
@RestController
@RequestMapping("/content/category")
public class CategoryController {

    //---------------------------写博文-查询文章分类的接口--------------------------------

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory(){
        List<CategoryVo> list = categoryService.listAllCategory();
        return ResponseResult.okResult(list);
    }

    //----------------------------分页查询分类列表-------------------------------------

    @GetMapping("/list")
    public ResponseResult list(Category category, Integer pageNum, Integer pageSize) {
        PageVo pageVo = categoryService.selectCategoryPage(category,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }
}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 测试。运行Start-admin工程的BlogAdminApplication类

第六步: 打开vue前端项目，在浏览器测试在 '分类管理' 页面能不能查询到文章的分类信息

![img](未命名/__项目/assets/1693034031630-d4c3e5b5-b0bb-4909-b2fa-1e76997742a5.jpg)

## 2. 新增分类

### 一、分类表的字段

![img](未命名/__项目/assets/1693034009010-77be19eb-0872-4d2c-95c7-894f9502d7eb.jpg)

![img](未命名/__项目/assets/1693034009158-7b9d44ba-7522-4f06-bd5a-00c7883e8fd8.jpg)

### 二、接口分析

点击标签管理的新增按钮可以实现新增标签的功能

| 请求方式 | 请求地址          | 请求头          |
| -------- | ----------------- | --------------- |
| POST     | /content/category | 需要token请求头 |

请求体格式:

```json
{"name":"分类名","description":"描述","status":"状态"}
```

响应格式：

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 确保你在Start-framework工程新建了MyMetaObjectHandler类，并且写入了如下，作用是配置是mybatisplus的字段自增

```java
package com.Start.handler.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.Start.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/7/26 0026 20:52
 */
@Component
//这个类是用来配置mybatis的字段自动填充。用于'发送评论'功能，由于我们在评论表无法对下面这四个字段进行插入数据(原因是前端在发送评论时，没有在
//请求体提供下面四个参数，所以后端在往数据库插入数据时，下面四个字段是空值)，所有就需要这个类来帮助我们往下面这四个字段自动的插入值，
//只要我们更新了评论表的字段，那么无法插入值的字段就自动有值了
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    //只要对数据库执行了插入语句，那么就会执行到这个方法
    public void insertFill(MetaObject metaObject) {
        Long userId = null;
        try {
            //获取用户id
            userId = SecurityUtils.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
            userId = -1L;//如果异常了，就说明该用户还没注册，我们就把该用户的userid字段赋值d为-1
        }
        //自动把下面四个字段新增了值。
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy",userId , metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", userId, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName(" ", SecurityUtils.getUserId(), metaObject);
    }
}
```

第二步: 把Start-framework工程的Category类，修改为如下，注意有四个字段是使用了mybatisplus的字段自增

```java
package com.Start.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/7/19 0019 22:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_category")
public class Category  {
    @TableId
    private Long id;

    //分类名
    private String name;
    //父分类id，如果没有父分类为-1
    private Long pid;
    //描述
    private String description;
    //状态0:正常,1禁用
    private String status;

    //字段自增
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
```

第三步: 在Start-framework工程新建CategoryDto类，写入如下，用于接收前端传过来的参数

```java
package com.Start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/8 0008 14:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    //分类名
    private String name;
    //描述
    private String description;
    //状态0:正常,1禁用
    private String status;

}
```

第四步: 把Start-admin工程的CategoryController类，添加如下，作用是新增 '文章分类' 功能的访问接口

```java
package com.Start.controller;

import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.dto.CategoryDto;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.CategoryVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/7 0007 14:28
 */
@RestController
@RequestMapping("/content/category")
public class CategoryController {

    //---------------------------写博文-查询文章分类的接口--------------------------------

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory(){
        List<CategoryVo> list = categoryService.listAllCategory();
        return ResponseResult.okResult(list);
    }

    //----------------------------分页查询文章的分类列表---------------------------------

    @GetMapping("/list")
    public ResponseResult list(Category category, Integer pageNum, Integer pageSize) {
        PageVo pageVo = categoryService.selectCategoryPage(category,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //-----------------------------增加文章的分类--------------------------------------

    @PostMapping
    public ResponseResult add(@RequestBody CategoryDto categoryDto){
        Category category = BeanCopyUtils.copyBean(categoryDto, Category.class);
        categoryService.save(category);
        return ResponseResult.okResult();
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-admin工程的BlogAdminApplication类

第七步: 打开vue前端项目，在浏览器测试新增 '文章分类' 的功能

![img](未命名/__项目/assets/1693034031781-96b7f4cc-c76a-484a-bfa5-1eaeec18ff1f.jpg)

![img](未命名/__项目/assets/1693034031918-af9d7d66-169e-48fc-bbcb-28794227ebc9.jpg)

## 3. 删除分类

### 一、分类表的字段

![img](未命名/__项目/assets/1693034009010-77be19eb-0872-4d2c-95c7-894f9502d7eb.jpg)

![img](未命名/__项目/assets/1693034009158-7b9d44ba-7522-4f06-bd5a-00c7883e8fd8.jpg)

### 二、接口分析

例如content/category/6 代表删除id为6的标签数据。删除后在列表中是否查看不到该条数据，但是数据库中该条数据还是存在的，只是修改了逻辑删除字段的值

| 请求方式 | 请求地址              | 请求头          |
| -------- | --------------------- | --------------- |
| DELETE   | content/category/{id} | 需要token请求头 |

响应格式：

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 在Start-admin工程的CategoryController类添加如下，作用是删除 '文章分类' 功能的访问接口

```java
@DeleteMapping(value = "/{id}")
public ResponseResult remove(@PathVariable(value = "id")Long id){
    categoryService.removeById(id);
    return ResponseResult.okResult();
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-admin工程的BlogAdminApplication类

第四步: 打开vue前端项目，在浏览器测试根据文章id来删除 '文章分类' 的功能

![img](未命名/__项目/assets/1693034032063-5605e67b-451e-4f43-8ad1-dbe6939c7f6e.jpg)

![img](未命名/__项目/assets/1693034032185-ca38cdc9-4360-4c4a-aa1f-2b4b5c9f3170.jpg)



第五步: 批量删除会报错，解决如下

~~~java
解决:
先在前端全局搜索 /content/category 关键字，然后就能找到下面的代码，
然后在category后面拼接 ?ids= 
``` 
// 删除分类
export function delCategory(id) {
	return request({
		url: '/content/category?ids=' + id,
		method: 'delete'
	})
}
```

然后把后端对应接口修改为如下
```
@DeleteMapping
public ResponseResult remove(@RequestParam(value = "ids")String ids) {
    if (!ids.contains(",")) {
        categoryService.removeById(ids);
    } else {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            categoryService.removeById(id);
        }
    }
    return ResponseResult.okResult();
}
```
~~~



## 4. 修改分类

### 一、分类表的字段

![img](未命名/__项目/assets/1693034009010-77be19eb-0872-4d2c-95c7-894f9502d7eb.jpg)

![img](未命名/__项目/assets/1693034009158-7b9d44ba-7522-4f06-bd5a-00c7883e8fd8.jpg)

### 二、接口分析

①根据分类id来获取某一条分类的信息，当用户点击修改按钮时触发，展示在弹框里面。例如：content/category/6 代表获取id为6的标签数据

| 请求方式 | 请求地址              | 请求头          |
| -------- | --------------------- | --------------- |
| GET      | content/category/{id} | 需要token请求头 |

响应格式：

```json
{
	"code":200,
	"data":{
        "id":1,
		"name":"分类名",
		"status":"0",
        "description":"分类描述",
        "delFlag":"0",
        "pid":"-1",
	},
	"msg":"操作成功"
}
```

②修改分类接口:

| 请求方式 | 请求地址         | 请求头          |
| -------- | ---------------- | --------------- |
| PUT      | content/category | 需要token请求头 |

请求体格式：

```json
{"name":"分类名","description":"描述","status":"状态"}
```

响应格式：

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 三、代码实现

第一步: 在Start-admin工程的CategoryController类修改为如下，增加了修改 '文章分类' 功能的具体代码

```java
package com.Start.controller;

import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.dto.CategoryDto;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.CategoryVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/7 0007 14:28
 */
@RestController
@RequestMapping("/content/category")
public class CategoryController {

    //---------------------------写博文-查询文章分类的接口--------------------------------

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory(){
        List<CategoryVo> list = categoryService.listAllCategory();
        return ResponseResult.okResult(list);
    }

    //----------------------------分页查询文章的分类列表---------------------------------

    @GetMapping("/list")
    public ResponseResult list(Category category, Integer pageNum, Integer pageSize) {
        PageVo pageVo = categoryService.selectCategoryPage(category,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //-----------------------------增加文章的分类--------------------------------------

    @PostMapping
    public ResponseResult add(@RequestBody CategoryDto categoryDto){
        Category category = BeanCopyUtils.copyBean(categoryDto, Category.class);
        categoryService.save(category);
        return ResponseResult.okResult();
    }

    //----------------------------删除文章的分类--------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseResult remove(@PathVariable(value = "id")Long id){
        categoryService.removeById(id);
        return ResponseResult.okResult();
    }

    //-----------------------------修改文章的分类--------------------------------------

    @GetMapping(value = "/{id}")
    //①根据分类的id来查询分类
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        Category category = categoryService.getById(id);
        return ResponseResult.okResult(category);
    }

    @PutMapping
    //②根据分类的id来修改分类
    public ResponseResult edit(@RequestBody Category category){
        categoryService.updateById(category);
        return ResponseResult.okResult();
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-admin工程的BlogAdminApplication类

第四步: 打开vue前端项目，在浏览器测试根据文章id来修改 '文章分类' 的功能

![img](未命名/__项目/assets/1693034032328-ae4ad994-63ed-469b-b141-3a196809bb3e.jpg)

![img](未命名/__项目/assets/1693034032450-02462410-c01c-407b-9832-cbfffce8c6f2.jpg)

# 博客后台模块-Excel表格

我们在项目中只使用了 '写Excel' 的功能。如果要学习如何实现 '读Excel'功能，那么可以对照easyExcel官方提供的 '快速开始' 文档

## 1. 接口设计

在分类管理中点击导出按钮可以把所有的分类导出到Excel文件中

| 请求方式 | 请求地址                 | 请求头          |
| -------- | ------------------------ | --------------- |
| GET      | /content/category/export | 需要token请求头 |

响应格式：

```plain
成功的话直接导出一个Excel文件
```

失败的话响应格式如下：

```json
{
	"code":500,
	"msg":"出现错误"
}
```

## 2. 接口分析

使用easyExcel实现Excel的导出操作

```plain
官方地址: https://github.com/alibaba/easyexcel

快速开始: https://easyexcel.opensource.alibaba.com/docs/current/quickStart/write#%E7%A4%BA%E4%BE%8B%E4%BB%A3%E7%A0%81-1
```

分析: 把数据库的分类数据查询出来，然后写入到Excel文件中，然后下载这个Excel文件，重点就是怎么往Excel里面写入数据，点击上面提供的快速开始的链接，点击左侧的 '写Excel'，就能看到实现的代码了，重点看右侧小导航栏的 'web中的写并且失败的时候返回json'

## 3. 代码实现

第一步: 在Start-framework工程的pom.xml添加如下

```xml
<!--easyExcel的依赖-->
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>easyexcel</artifactId>
</dependency>
```

第二步: 把Start-framework工程的WebUtils类修改为如下

```java
package com.Start.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:19
 */
public class WebUtils {
    /**
     * 将字符串渲染到客户端
     *
     * @param response 渲染对象
     * @param string 待渲染的字符串
     * @return null
     */
    //easyExcel文件导出失败时候做的操作
    public static void renderString(HttpServletResponse response, String string) {
        try
        {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //easyExcel文件导出
    public static void setDownLoadHeader(String filename, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fname= URLEncoder.encode(filename,"UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition","attachment; filename="+fname);
    }
}
```

第三步: 在Start-framework工程的vo目录新建ExcelCategoryVo类，写入如下，用于作为Excel表格的列头

```java
package com.Start.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/8 0008 12:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelCategoryVo {
    @ExcelProperty("分类名")
    private String name;
    //描述
    @ExcelProperty("描述")
    private String description;

    //状态0:正常,1禁用
    @ExcelProperty("状态0:正常,1禁用")
    private String status;
}
```

第四步: 把Start-admin工程的CategoryController类修改为如下，增加了easyExcel文件导出的具体代码实现

```java
package com.Start.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.WebUtils;
import com.Start.vo.CategoryVo;
import com.Start.vo.ExcelCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 35238
 * @date 2023/8/7 0007 14:28
 */
@RestController
@RequestMapping("/content/category")
public class CategoryController {

    //---------------------------写博文-查询文章分类的接口--------------------------------

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory(){
        List<CategoryVo> list = categoryService.listAllCategory();
        return ResponseResult.okResult(list);
    }

    //---------------------------把分类数据写入到Excel并导出-----------------------------

    @GetMapping("/export")
    //注意返回值类型是void
    public void export(HttpServletResponse response){
        try {
            //设置下载文件的请求头，下载下来的Excel文件叫'分类.xlsx'
            WebUtils.setDownLoadHeader("分类.xlsx",response);
            //获取需要导出的数据
            List<Category> xxcategory = categoryService.list();

            List<ExcelCategoryVo> excelCategoryVos = BeanCopyUtils.copyBeanList(xxcategory, ExcelCategoryVo.class);
            //把数据写入到Excel中，也就是把ExcelCategoryVo实体类的字段作为Excel表格的列头
            //sheet方法里面的字符串是Excel表格左下角工作簿的名字
            EasyExcel.write(response.getOutputStream(), ExcelCategoryVo.class).autoCloseStream(Boolean.FALSE).sheet("文章分类")
                    .doWrite(excelCategoryVos);

        } catch (Exception e) {
            //如果出现异常,就返回失败的json数据给前端。AppHttpCodeEnum和ResponseResult是我们在Start-framework工程写的类
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            //WebUtils是我们在Start-framework工程写的类，里面的renderString方法是将json字符串写入到请求体，然后返回给前端
            WebUtils.renderString(response, JSON.toJSONString(result));
        }
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-admin工程的BlogAdminApplication类

第七步: 打开vue前端项目，在浏览器测试在 '内容管理' -> '分类管理' 的页面，点击导出按钮，看是否能导出文章分类的Excel表格

![img](未命名/__项目/assets/1693034032582-5065a392-f4f3-44a8-8fb0-74db910b333d.jpg)

![img](未命名/__项目/assets/1693034032715-98a462b1-fafd-4037-a796-59137acc0244.jpg)

# 博客后台模块-权限控制

## 1. 接口分析

通过自定义权限校验，实现对导出 '文章分类' 的接口做权限控制

## 2. 代码实现

第一步: 把Start-framework工程的SystemCanstants类修改为如下，增加了是否是管理员用户的判断常量

```java
package com.Start.constants;

/**
 * @author 35238
 * @date 2023/7/19 0019 19:14
 */
//字面值(代码中的固定值)处理，把字面值都在这里定义成常量。可以把这个类叫做常量类
public class SystemCanstants {

    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;

    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    /**
     * 文章列表当前查询页数
     */
    public static final int ARTICLE_STATUS_CURRENT = 1;

    /**
     * 文章列表每页显示的数据条数
     */
    public static final int ARTICLE_STATUS_SIZE = 10;

    /**
     * 分类表的分类状态是正常状态
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 友链状态为审核通过
     */
    public static final String LINK_STATUS_NORMAL = "0";

    /**
     * 评论区的某条评论是根评论
     */
    public static final String COMMENT_ROOT = "-1";

    /**
     * 文章的评论
     */
    public static final String ARTICLE_COMMENT = "0";

    /**
     * 友链的评论
     */
    public static final String LINK_COMMENT = "1";

    /**
     * 权限类型，菜单
     */
    public static final String TYPE_MENU = "C";

    /**
     * 权限类型，按钮
     */
    public static final String TYPE_BUTTON = "F";

    /**
     * 正常状态
     */
    public static final String NORMAL = "0";

    /**
     * 判断为管理员用户
     */
    public static final String IS_ADMAIN = "1";
}
```

第二步: 把Start-framework工程的LoginUser类修改为如下，增加了权限信息集合的成员变量

```java
package com.Start.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

/**
 * @author 35238
 * @date 2023/7/22 0022 22:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//UserDetails是SpringSecurity官方提供的接口
public class LoginUser implements UserDetails {

    private User user;

    //权限信息的集合
    private List<String> permissions;

    @Override
    //用于返回权限信息。现在我们正在实现'认证'，'权限'后面才用得到。所以返回null即可
    //当要查询用户信息的时候，我们不能单纯返回null，要重写这个方法，作用是返回权限信息
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    //用于获取用户密码。由于使用的实体类是User，所以获取的是数据库的用户密码
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    //用于获取用户名。由于使用的实体类是User，所以获取的是数据库的用户名
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    //判断登录状态是否过期。把这个改成true，表示永不过期
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //判断账号是否被锁定。把这个改成true，表示未锁定
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //判断登录凭证是否过期。把这个改成true，表示永不过期
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //判断用户是否可用。把这个改成true，表示可用状态
    public boolean isEnabled() {
        return true;
    }
}
```

第三步: 把Start-admin工程的SecurityConfig修改为如下，增加了@EnableGlobalMethodSecurity注解

```java
package com.Start.config;

import com.Start.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:49
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//权限控制
//WebSecurityConfigurerAdapter是Security官方提供的类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    //注入我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    //注入官方的认证失败的处理器。注意不用写private，并且不是注入我们自定义的认证失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的认证失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    //注入官方的授权失败的处理器。注意不用写private，并且不是注入我们自定义的授权失败处理器。理由:符合开闭原则
    //虽然我们注入的不是自己写的授权失败处理器，但是最终用的实际上就是我们写的，Security会自己去找我们写的
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                // 对于登录接口 允许匿名访问
                .antMatchers("/user/login").anonymous()

                //退出登录的配置。如果'没登录'就调用'退出登录'，就会报错，报的错设置为'401 需要登录后操作'，也就是authenticated
                .antMatchers("/logout").authenticated()

                // 除上面外的所有请求全部都需要认证才可访问
                .anyRequest().authenticated();

        //把我们写的自定义异常处理器配置给Security
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        //关闭默认的注销功能
        http.logout().disable();

        //把我们在Start-blog工程写的JwtAuthenticationTokenFilter过滤器添加到Security的过滤器链中
        //第一个参数是你要添加的过滤器，第二个参数是你想把你的过滤器添加到哪个security官方过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //允许跨域
        http.cors();
    }

}
```

第四步: 把Start-framework工程的UserDetailsServiceImpl类修改为如下，增加了权限信息的相关实现代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.Start.constants.SystemCanstants;
import com.Start.domain.LoginUser;
import com.Start.domain.User;
import com.Start.mapper.MenuMapper;
import com.Start.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/22 0022 21:59
 */
//当Start-blog的BlogLoginServiceImpl类封装好登录的用户名和密码之后，就会传到当前这个实现类
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    //UserMapper是我们在Start-framework工程mapper目录的接口
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    //在这里之前，我们已经拿到了登录的用户名和密码。UserDetails是SpringSecurity官方提供的接口
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据拿到的用户名，并结合查询条件(数据库是否有这个用户名)，去查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);

        //判断是否查询到用户，也就是这个用户是否存在，如果没查到就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在");//后期会对异常进行统一处理
        }

        // 如果是后台用户，才需要查询权限，也就是只对后台用户做权限校验
        if(user.getType().equals(SystemCanstants.IS_ADMAIN)){
            //根据用户id查询权限关键字，即list是权限信息的集合
            List<String> list = menuMapper.selectPermsByOtherUserId(user.getId());
            return new LoginUser(user,list);
        }

        // 如果不是后台用户，就只封装用户信息，不封装权限信息
        //返回查询到的用户信息。注意下面那行直接返回user会报错，我们需要在Start-framework工程的domain目录新
        //建LoginUser类，在LoginUser类实现UserDetails接口，然后下面那行就返回LoginUser对象
        return new LoginUser(user,null);
    }
}
```

第五步: 在Start-framework工程的service目录创建impl.PermissionService类，写入如下

```java
package com.Start.service.impl;

import com.Start.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/9 0009 13:40
 */

@Service("ps")
public class PermissionService {

    /**
     * 判断当前用户是否具有permission
     * @param permission 要判断的权限
     * @return
     */
    public boolean hasPermission(String permission){
        //如果是超级管理员  直接返回true
        if(SecurityUtils.isAdmin()){
            return true;
        }

        //否则  获取当前登录用户所具有的权限列表 如何判断是否存在permission
        // 这个permission其实就是sys_menu表的perms字段的值
        List<String> permissions = SecurityUtils.getLoginUser().getPermissions();
        //contains方法是 'List集合官方' 提供的方法，返回值是布尔值，如果用户具有对应权限就返回true
        return permissions.contains(permission);
    }
}
```

第六步: 把Start-admin工程的CategoryController类修改为如下，在export方法的上面添加了@PreAuthorize注解

```java
package com.Start.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.dto.CategoryDto;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.WebUtils;
import com.Start.vo.CategoryVo;
import com.Start.vo.ExcelCategoryVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 35238
 * @date 2023/8/7 0007 14:28
 */
@RestController
@RequestMapping("/content/category")
public class CategoryController {

    //---------------------------写博文-查询文章分类的接口--------------------------------

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory(){
        List<CategoryVo> list = categoryService.listAllCategory();
        return ResponseResult.okResult(list);
    }

    //----------------------------分页查询文章的分类列表---------------------------------

    @GetMapping("/list")
    public ResponseResult list(Category category, Integer pageNum, Integer pageSize) {
        PageVo pageVo = categoryService.selectCategoryPage(category,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //-----------------------------增加文章的分类--------------------------------------

    @PostMapping
    public ResponseResult add(@RequestBody CategoryDto categoryDto){
        Category category = BeanCopyUtils.copyBean(categoryDto, Category.class);
        categoryService.save(category);
        return ResponseResult.okResult();
    }

    //----------------------------删除文章的分类--------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseResult remove(@PathVariable(value = "id")Long id){
        categoryService.removeById(id);
        return ResponseResult.okResult();
    }

    //-----------------------------修改文章的分类--------------------------------------

    @GetMapping(value = "/{id}")
    //①根据标签的id来查询标签
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        Category category = categoryService.getById(id);
        return ResponseResult.okResult(category);
    }

    @PutMapping
    //②根据标签的id来修改标签
    public ResponseResult edit(@RequestBody Category category){
        categoryService.updateById(category);
        return ResponseResult.okResult();
    }

    //---------------------------把分类数据写入到Excel并导出-----------------------------

    @PreAuthorize("@ps.hasPermission('content:category:export')")//权限控制，ps是PermissionService类的bean名称
    @GetMapping("/export")
    //注意返回值类型是void
    public void export(HttpServletResponse response){
        try {
            //设置下载文件的请求头，下载下来的Excel文件叫'分类.xlsx'
            WebUtils.setDownLoadHeader("分类.xlsx",response);
            //获取需要导出的数据
            List<Category> xxcategory = categoryService.list();

            List<ExcelCategoryVo> excelCategoryVos = BeanCopyUtils.copyBeanList(xxcategory, ExcelCategoryVo.class);
            //把数据写入到Excel中，也就是把ExcelCategoryVo实体类的字段作为Excel表格的列头
            //sheet方法里面的字符串是Excel表格左下角工作簿的名字
            EasyExcel.write(response.getOutputStream(), ExcelCategoryVo.class).autoCloseStream(Boolean.FALSE).sheet("文章分类")
                    .doWrite(excelCategoryVos);

        } catch (Exception e) {
            //如果出现异常,就返回失败的json数据给前端。AppHttpCodeEnum和ResponseResult是我们在Start-framework工程写的类
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            //WebUtils是我们在Start-framework工程写的类，里面的renderString方法是将json字符串写入到请求体，然后返回给前端
            WebUtils.renderString(response, JSON.toJSONString(result));
        }
    }
}
```

第七步: 把Start-framework工程的GlobalExceptionHandler类修改为如下，增加了处理springsecurity的权限异常处理

```java
package com.Start.handler.exception;

import com.Start.domain.ResponseResult;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 35238
 * @date 2023/7/23 0023 22:03
 */
//@ControllerAdvice //对controller层的增强
//@ResponseBody

//或者用下面一个注解代替上面的两个注解
@RestControllerAdvice

//使用Lombok提供的Slf4j注解，实现日志功能
@Slf4j

//全局异常处理。最终都会在这个类进行处理异常
public class GlobalExceptionHandler {

    //SystemException是我们写的类。用户登录的异常交给这里处理
    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e){

        //打印异常信息，方便我们追溯问题的原因。{}是占位符，具体值由e决定
        log.error("出现了异常! {}",e);

        //从异常对象中获取提示信息封装，然后返回。ResponseResult是我们写的类
        return ResponseResult.errorResult(e.getCode(),e.getMsg());
    }
    
    // 处理SpringSecurity的权限异常
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseResult handleAccessDeniedException(AccessDeniedException e) {
        return ResponseResult.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH.getCode(),e.getMessage());//枚举值是500
    }

    //其它异常交给这里处理
    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e){

        //打印异常信息，方便我们追溯问题的原因。{}是占位符，具体值由e决定
        log.error("出现了异常! {}",e);

        //从异常对象中获取提示信息封装，然后返回。ResponseResult、AppHttpCodeEnum是我们写的类
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),e.getMessage());//枚举值是500
    }
}
```

第八步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第九步: 测试。运行Start-admin工程的BlogAdminApplication类

第十步: 打开vue前端项目，在浏览器测试没有该权限的普通用户是否能使用 '把分类数据写入到Excel并导出' 的功能

![img](未命名/__项目/assets/1693034032881-11f72f13-bf50-47d5-8099-fdc1f7b23696.jpg)

![img](未命名/__项目/assets/1693034033080-d1bf6beb-e7b7-4c74-858e-017de324ad2e.jpg)

第十一步: 可以为更多的controller接口添加权限控制的 ' @PreAuthorize("@ps.hasPermission('权限字符串')")' 注解。例如如下，效果截图也如下

注意，权限字符串的数据是在数据库的sys_menu表的perms字段

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:21
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    //------------------------------新增博客文章-----------------------------

    @Autowired
    private ArticleService articleService;

    @PostMapping
    @PreAuthorize("@ps.hasPermission('content:article:writer')")//权限控制
    public ResponseResult add(@RequestBody AddArticleDto article){
        return articleService.add(article);
    }
}
```

![img](未命名/__项目/assets/1693034033205-59fa63f9-3d0e-4a57-a1f1-3fcc7116ba03.jpg)

# 博客后台模块-文章列表

新增文章功能其实就是发布文章，我在前面的 '博客后台模块-发布文章' 已经写了很详细的笔记，下面我们着重实现查询、修改、删除文章的功能

## 1. 查询文章

### 一、接口设计

在 '内容管理 -> 文章管理' 页面查询出有效的已发布文章的信息

| 请求方式 | 请求路径              | 是否需求token头 |
| -------- | --------------------- | --------------- |
| Get      | /content/article/list | 是              |

请求参数:

```plain
pageNum: 页码

pageSize: 每页条数

title：文章标题

summary：文章摘要
```

响应格式:

```json
{
	"code":200,
	"data":{
		"rows":[
			{
				"categoryId":"1",
				"content":"文章内容",
				"createTime":"2023-08-10 07:20:11",
				"id":"1",
				"isComment":"0",
				"isTop":"1",
				"status":"0",
				"summary":"文章摘要",
				"thumbnail":"文章缩略图.png|jpg",
				"title":"文章标题",
				"viewCount":"文章被浏览的次数"
			}
		],
		"total":"1"
	},
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-framework工程的ArticleService接口修改为如下，增加了分页查询文章的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.vo.PageVo;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */
public interface ArticleService extends IService<Article> {

    //文章列表
    ResponseResult hotArticleList();

    //分类查询文章列表
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    //根据id查询文章详情
    ResponseResult getArticleDetail(Long id);

    //根据文章id从mysql查询文章
    ResponseResult updateViewCount(Long id);

    //新增博客文章
    ResponseResult add(AddArticleDto article);

    //管理后台(文章管理)-分页查询文章
    PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize);
}
```

第二步: 把Start-framework工程的ArticleServiceImpl修改为如下，增加了分页查询文章的具体实现代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.ArticleTag;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.service.ArticleTagService;
import com.Start.service.ArticleVoService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.RedisCache;
import com.Start.vo.ArticleDetailVo;
import com.Start.vo.ArticleListVo;
import com.Start.vo.ArticleVo;
import com.Start.vo.HotArticleVO;
import com.Start.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    //操作数据库。ArticleService是我们在Start-framework工程写的接口
    private ArticleService articleService;


    @Override
    public ResponseResult hotArticleList() {

        //-------------------每调用这个方法就从redis查询文章的浏览量，展示在热门文章列表------------------------

        //获取redis中的浏览量，注意得到的viewCountMap是HashMap双列集合
        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");
        //让双列集合调用entrySet方法即可转为单列集合，然后才能调用stream方法
        List<Article> xxarticles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                //把最终数据转为List集合
                .collect(Collectors.toList());
        //把获取到的浏览量更新到mysql数据库中。updateBatchById是mybatisplus提供的批量操作数据的接口
        articleService.updateBatchById(xxarticles);

        //-----------------------------------------------------------------------------------------

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);

        return ResponseResult.okResult(articleVos);
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @Autowired
    //注入我们写的CategoryService接口
    private CategoryService categoryService;

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第一种方式，用for循环遍历的方式
         */
        ////用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        //List<Article> articles = page.getRecords();
        //for (Article article : articles) {
        //    //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
        //    Category category = categoryService.getById(article.getCategoryId());
        //    //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
        //    article.setCategoryName(category.getName());
        //
        //}

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第二种方式，用stream流的方式
         */
        //用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        List<Article> articles = page.getRecords();

        articles.stream()
                .map(new Function<Article, Article>() {
                    @Override
                    public Article apply(Article article) {
                        //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
                        Category category = categoryService.getById(article.getCategoryId());
                        String name = category.getName();
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        article.setCategoryName(name);
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        return article;
                    }
                })
                .collect(Collectors.toList());


        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);


        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    //---------------------------------根据id查询文章详情----------------------------------

    @Override
    public ResponseResult getArticleDetail(Long id) {

        //根据id查询文章
        Article article = getById(id);

        //-------------------从redis查询文章的浏览量，展示在文章详情---------------------------

        //从redis查询文章浏览量
        Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
        article.setViewCount(viewCount.longValue());

        //-----------------------------------------------------------------------------

        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);

        //根据分类id，来查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        //如果根据分类id查询的到分类名，那么就把查询到的值设置给ArticleDetailVo实体类的categoryName字段
        if(category!=null){
            articleDetailVo.setCategoryName(category.getName());
        }

        //封装响应返回。ResponseResult是我们在Start-framework工程的domain目录写的实体类
        return ResponseResult.okResult(articleDetailVo);
    }

    //--------------------------------根据文章id从mysql查询文章----------------------------

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult updateViewCount(Long id) {
        //更新redis中的浏览量，对应文章id的viewCount浏览量。article:viewCount是ViewCountRunner类里面写的
        //用户每从mysql根据文章id查询一次浏览量，那么redis的浏览量就增加1
        redisCache.incrementCacheMapValue("article:viewCount",id.toString(),1);
        return ResponseResult.okResult();
    }

    //-------------------------------------增加博客文章-----------------------------------

    @Autowired
    private ArticleTagService articleTagService;

    @Autowired
    private ArticleVoService articleVoService;

    @Override
    @Transactional
    public ResponseResult add(AddArticleDto articleDto) {
        //添加 博客
        ArticleVo articlevo = BeanCopyUtils.copyBean(articleDto, ArticleVo.class);
        articleVoService.save(articlevo);


        List<ArticleTag> articleTags = articleDto.getTags().stream()
                .map(tagId -> new ArticleTag(articlevo.getId(), tagId))
                .collect(Collectors.toList());

        //添加 博客和标签的关联
        articleTagService.saveBatch(articleTags);
        return ResponseResult.okResult();
    }

    //---------------------------管理后台(文章管理)-分页查询文章----------------------------

    @Override
    public PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.hasText(article.getTitle()),Article::getTitle, article.getTitle());
        queryWrapper.like(StringUtils.hasText(article.getSummary()),Article::getSummary, article.getSummary());

        Page<Article> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换成VO
        List<Article> articles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(articles);
        return pageVo;
    }
}
```

第三步: 把Start-admin工程的ArticleController类修改为如下，增加了分页查询文章的访问接口

```java
package com.Start.controller;

import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.service.ArticleService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:21
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    //------------------------------新增博客文章-----------------------------

    @PostMapping
    @PreAuthorize("@ps.hasPermission('content:article:writer')")//权限控制
    public ResponseResult add(@RequestBody AddArticleDto articleDto){
        return articleService.add(articleDto);
    }

    //-----------------------------分页查询博客文章---------------------------

    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize){
        PageVo pageVo = articleService.selectArticlePage(article,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }
}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 测试。运行Start-admin工程的BlogAdminApplication类

第六步: 打开vue前端项目，在浏览器测试文章管理页面是否能查询到有效的已发布文章的信息

![img](未命名/__项目/assets/1693034033321-92bcd0f7-1eaf-4fea-ba2f-269179550330.jpg)

## 2. 修改文章

### 一、接口设计

点击文章列表中的修改按钮可以跳转到写博文页面。回显示该文章的具体信息。用户可以在该页面修改文章信息。点击更新按钮后修改文章

这个功能的实现首先需要能够根据文章id查询文章的详细信息这样才能实现文章的回显

①先查询根据文章id查询对应的文章

| 请求方式 | 请求路径             | 是否需求token头 |
| -------- | -------------------- | --------------- |
| Get      | content/article/{id} | 是              |

请求参数:

```plain
id: 文章id
```

响应格式:

```json
{
	"code":200,
	"data":{
		"categoryId":"1",
		"content":"文章内容",
		"createBy":"1",
		"createTime":"2023-08-28 15:15:46",
		"delFlag":0,
		"id":"10",
		"isComment":"0",
		"isTop":"1",
		"status":"0",
		"summary":"文章摘要",
		"tags":[
			"1",
			"4",
			"5"
		],
		"thumbnail":"文章缩略图.png|jpg",
		"title":"文章标题",
		"updateBy":"1",
		"updateTime":"2022-08-28 15:15:46",
		"viewCount":"0"
	},
	"msg":"操作成功"
}
```

②然后才是修改文章

| 请求方式 | 请求路径        | 是否需求token头 |
| -------- | --------------- | --------------- |
| PUT      | content/article | 是              |

请求体参数格式:

```json
{
    "categoryId":"1",
    "content":"文章内容",
    "createBy":"1",
    "createTime":"2023-08-28 15:15:46",
    "delFlag":0,
    "id":"10",
    "isComment":"0",
    "isTop":"1",
    "status":"0",
    "summary":"文章摘要",
    "tags":[
        "1",
        "4",
        "5"
    ],
    "thumbnail":"文章缩略图.png|jpg",
    "title":"文章标题",
    "updateBy":"1",
    "updateTime":"2022-08-28 15:15:46",
    "viewCount":"0"
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 在Start-framework工程的vo目录新建ArticleByIdVo类，写入如下，指定某些字段返回给前端

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/9 0009 22:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleByIdVo {

    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;

    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;
    private List<Long> tags;
}
```

第二步: 在Start-framework工程的dto目录新建ArticleDto类，写入如下，用于接收前端传过来的参数

```java
package com.Start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/9 0009 22:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Long id;
    //标题
    private String title;
    //文章内容
    private String content;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;

    //缩略图
    private String thumbnail;
    //是否置顶（0否，1是）
    private String isTop;
    //状态（0已发布，1草稿）
    private String status;
    //访问量
    private Long viewCount;
    //是否允许评论 1是，0否
    private String isComment;
    private List<Long> tags;
}
```

第三步: 把Start-framework工的ArticleService接口修改为如下，增加了两个用于修改文章的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.dto.ArticleDto;
import com.Start.vo.ArticleByIdVo;
import com.Start.vo.ArticleVo;
import com.Start.vo.PageVo;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:16
 */
public interface ArticleService extends IService<Article> {

    //文章列表
    ResponseResult hotArticleList();

    //分类查询文章列表
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    //根据id查询文章详情
    ResponseResult getArticleDetail(Long id);

    //根据文章id从mysql查询文章
    ResponseResult updateViewCount(Long id);

    //新增博客文章
    ResponseResult add(AddArticleDto article);

    //管理后台(文章管理)-分页查询文章
    PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize);

    //修改文章-①根据文章id查询对应的文章
    ArticleByIdVo getInfo(Long id);

    //修改文章-②然后才是修改文章
    void edit(ArticleDto article);
}
```

第四步: 把Start-framework工程的ArticleServiceImpl类修改为如下，增加了两个用于增加文章接口的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Article;
import com.Start.domain.ArticleTag;
import com.Start.domain.Category;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.dto.ArticleDto;
import com.Start.mapper.ArticleMapper;
import com.Start.service.ArticleService;
import com.Start.service.ArticleTagService;
import com.Start.service.ArticleVoService;
import com.Start.service.CategoryService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.RedisCache;
import com.Start.vo.ArticleByIdVo;
import com.Start.vo.ArticleDetailVo;
import com.Start.vo.ArticleListVo;
import com.Start.vo.ArticleVo;
import com.Start.vo.HotArticleVO;
import com.Start.vo.PageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/18 0018 21:19
 */
@Service
//ServiceImpl是mybatisPlus官方提供的
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    //操作数据库。ArticleService是我们在Start-framework工程写的接口
    private ArticleService articleService;


    @Override
    public ResponseResult hotArticleList() {

        //-------------------每调用这个方法就从redis查询文章的浏览量，展示在热门文章列表------------------------

        //获取redis中的浏览量，注意得到的viewCountMap是HashMap双列集合
        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");
        //让双列集合调用entrySet方法即可转为单列集合，然后才能调用stream方法
        List<Article> xxarticles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                //把最终数据转为List集合
                .collect(Collectors.toList());
        //把获取到的浏览量更新到mysql数据库中。updateBatchById是mybatisplus提供的批量操作数据的接口
        articleService.updateBatchById(xxarticles);

        //-----------------------------------------------------------------------------------------

        //查询热门文章，封装成ResponseResult返回。把所有查询条件写在queryWrapper里面
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        //查询的不能是草稿。也就是Status字段不能是0
        queryWrapper.eq(Article::getStatus, SystemCanstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序。也就是根据ViewCount字段降序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只能查询出来10条消息。当前显示第一页的数据，每页显示10条数据
        Page<Article> page = new Page<>(SystemCanstants.ARTICLE_STATUS_CURRENT,SystemCanstants.ARTICLE_STATUS_SIZE);
        page(page,queryWrapper);

        //获取最终的查询结果，把结果封装在Article实体类里面会有很多不需要的字段
        List<Article> articles = page.getRecords();

        //解决: 把结果封装在HotArticleVo实体类里面，在HotArticleVo实体类只写我们要的字段
        //List<HotArticleVO> articleVos = new ArrayList<>();
        //for (Article xxarticle : articles) {
        //    HotArticleVO xxvo = new HotArticleVO();
        //    //使用spring提供的BeanUtils类，来实现bean拷贝。第一个参数是源数据，第二个参数是目标数据，把源数据拷贝给目标数据
        //    BeanUtils.copyProperties(xxarticle,xxvo); //xxarticle就是Article实体类，xxvo就是HotArticleVo实体类
        //    //把我们要的数据封装成集合
        //    articleVos.add(xxvo);
        //}
        //注释掉，使用我们定义的BeanCopyUtils工具类的copyBeanList方法。如下

        //一行搞定
        List<HotArticleVO> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVO.class);

        return ResponseResult.okResult(articleVos);
    }

    //----------------------------------分页查询文章的列表---------------------------------

    @Autowired
    //注入我们写的CategoryService接口
    private CategoryService categoryService;

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {

        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        //判空。如果前端传了categoryId这个参数，那么查询时要和传入的相同。第二个参数是数据表的文章id，第三个字段是前端传来的文章id
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        //只查询状态是正式发布的文章。Article实体类的status字段跟0作比较，一样就表示是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemCanstants.ARTICLE_STATUS_NORMAL);

        //对isTop字段进行降序排序，实现置顶的文章(isTop值为1)在最前面
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第一种方式，用for循环遍历的方式
         */
        ////用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        //List<Article> articles = page.getRecords();
        //for (Article article : articles) {
        //    //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
        //    Category category = categoryService.getById(article.getCategoryId());
        //    //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
        //    article.setCategoryName(category.getName());
        //
        //}

        /**
         * 解决categoryName字段没有返回值的问题。在分页之后，封装成ArticleListVo之前，进行处理。第二种方式，用stream流的方式
         */
        //用categoryId来查询categoryName(category表的name字段)，也就是查询'分类名称'
        List<Article> articles = page.getRecords();

        articles.stream()
                .map(new Function<Article, Article>() {
                    @Override
                    public Article apply(Article article) {
                        //'article.getCategoryId()'表示从article表获取category_id字段，然后作为查询category表的name字段
                        Category category = categoryService.getById(article.getCategoryId());
                        String name = category.getName();
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        article.setCategoryName(name);
                        //把查询出来的category表的name字段值，也就是article，设置给Article实体类的categoryName成员变量
                        return article;
                    }
                })
                .collect(Collectors.toList());


        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);


        //把上面那行的查询结果和文章总数封装在PageVo(我们写的实体类)
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    //---------------------------------根据id查询文章详情----------------------------------

    @Override
    public ResponseResult getArticleDetail(Long id) {

        //根据id查询文章
        Article article = getById(id);

        //-------------------从redis查询文章的浏览量，展示在文章详情---------------------------

        //从redis查询文章浏览量
        Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
        article.setViewCount(viewCount.longValue());

        //-----------------------------------------------------------------------------

        //把最后的查询结果封装成ArticleListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);

        //根据分类id，来查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        //如果根据分类id查询的到分类名，那么就把查询到的值设置给ArticleDetailVo实体类的categoryName字段
        if(category!=null){
            articleDetailVo.setCategoryName(category.getName());
        }

        //封装响应返回。ResponseResult是我们在Start-framework工程的domain目录写的实体类
        return ResponseResult.okResult(articleDetailVo);
    }

    //--------------------------------根据文章id从mysql查询文章----------------------------

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult updateViewCount(Long id) {
        //更新redis中的浏览量，对应文章id的viewCount浏览量。article:viewCount是ViewCountRunner类里面写的
        //用户每从mysql根据文章id查询一次浏览量，那么redis的浏览量就增加1
        redisCache.incrementCacheMapValue("article:viewCount",id.toString(),1);
        return ResponseResult.okResult();
    }

    //-------------------------------------增加博客文章-----------------------------------

    @Autowired
    private ArticleTagService articleTagService;

    @Autowired
    private ArticleVoService articleVoService;

    @Override
    @Transactional
    public ResponseResult add(AddArticleDto articleDto) {
        //添加 博客
        ArticleVo articlevo = BeanCopyUtils.copyBean(articleDto, ArticleVo.class);
        articleVoService.save(articlevo);


        List<ArticleTag> articleTags = articleDto.getTags().stream()
                .map(tagId -> new ArticleTag(articlevo.getId(), tagId))
                .collect(Collectors.toList());

        //添加 博客和标签的关联
        articleTagService.saveBatch(articleTags);
        return ResponseResult.okResult();
    }

    //---------------------------管理后台(文章管理)-分页查询文章----------------------------

    @Override
    public PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.hasText(article.getTitle()),Article::getTitle, article.getTitle());
        queryWrapper.like(StringUtils.hasText(article.getSummary()),Article::getSummary, article.getSummary());

        Page<Article> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换成VO
        List<Article> articles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(articles);
        return pageVo;
    }

    //----------------------------修改文章-①根据文章id查询对应的文章--------------------------------

    @Override
    //①先查询根据文章id查询对应的文章
    public ArticleByIdVo getInfo(Long id) {
        Article article = getById(id);
        //获取关联标签
        LambdaQueryWrapper<ArticleTag> articleTagLambdaQueryWrapper = new LambdaQueryWrapper<>();
        articleTagLambdaQueryWrapper.eq(ArticleTag::getArticleId,article.getId());
        List<ArticleTag> articleTags = articleTagService.list(articleTagLambdaQueryWrapper);
        List<Long> tags = articleTags.stream().map(articleTag -> articleTag.getTagId()).collect(Collectors.toList());

        ArticleByIdVo articleVo = BeanCopyUtils.copyBean(article,ArticleByIdVo.class);
        articleVo.setTags(tags);
        return articleVo;
    }

    @Override
    //②然后才是修改文章
    public void edit(ArticleDto articleDto) {
        Article article = BeanCopyUtils.copyBean(articleDto, Article.class);
        //更新博客信息
        updateById(article);
        //删除原有的 标签和博客的关联
        LambdaQueryWrapper<ArticleTag> articleTagLambdaQueryWrapper = new LambdaQueryWrapper<>();
        articleTagLambdaQueryWrapper.eq(ArticleTag::getArticleId,article.getId());
        articleTagService.remove(articleTagLambdaQueryWrapper);
        //添加新的博客和标签的关联信息
        List<ArticleTag> articleTags = articleDto.getTags().stream()
                .map(tagId -> new ArticleTag(articleDto.getId(), tagId))
                .collect(Collectors.toList());
        articleTagService.saveBatch(articleTags);
    }
}
```

第五步: 把Start-admin工程的ArticleController类修改为如下，增加了修改文章的访问接口

```java
package com.Start.controller;

import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.dto.ArticleDto;
import com.Start.service.ArticleService;
import com.Start.vo.ArticleByIdVo;
import com.Start.vo.ArticleVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:21
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    //------------------------------新增博客文章-----------------------------

    @PostMapping
    @PreAuthorize("@ps.hasPermission('content:article:writer')")//权限控制
    public ResponseResult add(@RequestBody AddArticleDto articleDto){
        return articleService.add(articleDto);
    }

    //-----------------------------分页查询博客文章---------------------------

    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize){
        PageVo pageVo = articleService.selectArticlePage(article,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //---------------------------根据文章id来修改文章--------------------------

    @GetMapping(value = "/{id}")
    //①先查询根据文章id查询对应的文章
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        ArticleByIdVo article = articleService.getInfo(id);
        return ResponseResult.okResult(article);
    }

    @PutMapping
    //②然后才是修改文章
    public ResponseResult edit(@RequestBody ArticleDto article){
        articleService.edit(article);
        return ResponseResult.okResult();
    }
}
```

第六步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第七步: 测试。运行Start-admin工程的BlogAdminApplication类

第八步: 打开vue前端项目，在浏览器测试在文章管理页面，点击 '修改'，看一下能不能先查询到我们要修改的这篇文章

![img](未命名/__项目/assets/1693034033471-81bf4245-7e11-45ca-bb4a-15813d523c46.jpg)

![img](未命名/__项目/assets/1693034033607-0d880252-feb6-4cbd-afda-1f41f377e253.jpg)

第九步: 测试。对文章的信息进行修改，然后点击 '更新'，看文章信息是否更新成功

![img](未命名/__项目/assets/1693034033766-3b01a10c-80d2-4713-9af7-3653a83e756b.jpg)

![img](未命名/__项目/assets/1693034033912-3c5ab51d-9cea-423e-8c3f-9c1df6407261.jpg)

第十步: 打开前台页面，看一下文章的信息是否真的成功修改

![img](未命名/__项目/assets/1693034034047-8515072e-e82e-4975-af31-da9db3c077d7.jpg)

## 3. 删除文章

### 一、接口设计

点击文章后面的删除按钮可以删除该文章。注意: 是逻辑删除不是物理删除

| 请求方式 | 请求路径             | 是否需求token头 |
| -------- | -------------------- | --------------- |
| DELETE   | content/article/{id} | 是              |

请求参数:

```plain
id：要删除的文章id
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-admin工程的ArticleController类修改为如下，增加了删除文章的具体实现代码

```java
package com.Start.controller;

import com.Start.domain.Article;
import com.Start.domain.ResponseResult;
import com.Start.dto.AddArticleDto;
import com.Start.dto.ArticleDto;
import com.Start.service.ArticleService;
import com.Start.vo.ArticleByIdVo;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/7 0007 15:21
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    //------------------------------新增博客文章-----------------------------

    @PostMapping
    @PreAuthorize("@ps.hasPermission('content:article:writer')")//权限控制
    public ResponseResult add(@RequestBody AddArticleDto articleDto){
        return articleService.add(articleDto);
    }

    //-----------------------------分页查询博客文章---------------------------

    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize){
        PageVo pageVo = articleService.selectArticlePage(article,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //---------------------------根据文章id来修改文章--------------------------

    @GetMapping(value = "/{id}")
    //①先查询根据文章id查询对应的文章
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        ArticleByIdVo article = articleService.getInfo(id);
        return ResponseResult.okResult(article);
    }

    @PutMapping
    //②然后才是修改文章
    public ResponseResult edit(@RequestBody ArticleDto article){
        articleService.edit(article);
        return ResponseResult.okResult();
    }

    //---------------------------根据文章id来删除文章-------------------------

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        //直接使用mybatisplus提供的removeById方法
        articleService.removeById(id);
        return ResponseResult.okResult();
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-admin工程的BlogAdminApplication类

第四步: 打开vue前端项目，在浏览器测试在文章管理页面，选中文章之后，点击 '删除'，测试是否能删除文章

![img](未命名/__项目/assets/1693034034187-08c3ae99-cd60-40a6-a7b9-acc3a2fd5c83.jpg)

![img](未命名/__项目/assets/1693034034323-720bb535-789c-415e-90e2-8388a96ad07c.jpg)



第五步: 批量删除会报错，解决如下

~~~java
解决:
先在前端全局搜索 /content/article 关键字，然后就能找到下面的代码，
然后在article后面拼接 ?ids= 
``` 
export function delArticle(id) {
  return request({
    url: '/content/article?ids=' + id,
    method: 'delete'
  })
}
```

然后把后端对应接口修改为如下
```
@DeleteMapping
public ResponseResult remove(@RequestParam(value = "ids")String ids) {
    if (!ids.contains(",")) {
        articleService.removeById(ids);
    } else {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            articleService.removeById(id);
        }
    }
    return ResponseResult.okResult();
}
```
~~~



# 博客后台模块-菜单列表

菜单指的是权限菜单，也就是一堆权限字符串

## 1.查询菜单

### 一、接口分析

需要展示菜单列表，不需要分页。可以针对菜单名进行模糊查询。也可以针对菜单的状态进行查询。菜单要按照父菜单id和orderNum进行排序

| 请求方式 | 请求路径         | 是否需求token头 |
| -------- | ---------------- | --------------- |
| GET      | system/menu/list | 是              |

请求参数:

```plain
status  : 状态

menuName： 菜单名
```

响应格式:

```json
{
	"code":200,
	"data":[
		{
			"component":"组件路径",
			"icon":"build",
			"id":"2023",
			"isFrame":1,
			"menuName":"菜单名称",
			"menuType":"C",
			"orderNum":0,
			"parentId":"0",
			"path":"write",
			"perms":"权限字符串",
			"remark":"备注信息",
			"status":"0",
			"visible":"0"
		},
		{
			"icon":"system",
			"id":"1",
			"isFrame":1,
			"menuName":"菜单名称",
			"menuType":"M",
			"orderNum":1,
			"parentId":"0",
			"path":"system",
			"perms":"权限字符串",
			"remark":"备注信息",
			"status":"0",
			"visible":"0"
		}
	],
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 在Start-framework工程的Vo目录新建MenuVo类，写入如下，用于把指定字段返回给前端

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 35238
 * @date 2023/8/10 0010 10:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuVo {
    //菜单ID
    private Long id;

    //菜单名称
    private String menuName;
    //父菜单ID
    private Long parentId;
    //显示顺序
    private Integer orderNum;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //是否为外链（0是 1否）
    private Integer isFrame;
    //菜单类型（M目录 C菜单 F按钮）
    private String menuType;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;

    //备注
    private String remark;
}
```

第二步: 把Start-framework工程的MenuService接口修改为如下，增加了查询菜单列表的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Menu;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:24
 */
public interface MenuService extends IService<Menu> {
    //查询用户的权限信息
    List<String> selectPermsByUserId(Long id);
    //查询用户的路由信息，也就是查询权限菜单
    List<Menu> selectRouterMenuTreeByUserId(Long userId);
    //查询菜单列表
    List<Menu> selectMenuList(Menu menu);
}
```

第三步: 把Start-framework工程的MenuServiceImpl类修改为如下，增加了查询菜单列表的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Menu;
import com.Start.mapper.MenuMapper;
import com.Start.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:25
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    //查询用户的权限信息
    public List<String> selectPermsByUserId(Long id) {
        //根据用户id查询用户的权限信息。用户id为id代表超级管理员，如果是管理员就返回所有的权限
        if(id == 1L){
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            //查询条件是permissions中需要有所有菜单类型为C或者F的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.in(Menu::getMenuType, SystemCanstants.TYPE_MENU,SystemCanstants.TYPE_BUTTON);
            //查询条件是permissions中需要有状态为正常的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.eq(Menu::getStatus,SystemCanstants.STATUS_NORMAL);
            //查询条件是permissions中需要未被删除的权限的权限
            List<Menu> menus = list(wrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }

        //如果不是管理员就返回对应用户所具有的权限
        List<String> otherPerms = getBaseMapper().selectPermsByOtherUserId(id);
        return otherPerms;
    }

    //----------------------------------查询用户的路由信息(权限菜单)-------------------------------------

    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {

        MenuMapper menuMapper = getBaseMapper();

        List<Menu> menus = null;

        //判断是否是超级管理员，用户id为id代表超级管理员，如果是就返回所有符合要求的权限菜单
        if(userId.equals(1L)){
            menus = menuMapper.selectAllRouterMenu();
        }else{
            //如果不是超级管理员，就查询对应用户所具有的路由信息(权限菜单)
            menus = menuMapper.selectOtherRouterMenuTreeByUserId(userId);
        }

        //构建成tree，也就是子父菜单树，有层级关系
        //思路:先找出第一层的菜单，然后再找子菜单(也就是第二层)，把子菜单的结果赋值给Menu类的children字段
        List<Menu> menuTree = xxbuildMenuTree(menus,0L);

        return menuTree;
    }

    //用于把List集合里面的数据构建成tree，也就是子父菜单树，有层级关系
    private List<Menu> xxbuildMenuTree(List<Menu> menus, long parentId){
        List<Menu> menuTree = menus.stream()
                //过滤找出父菜单树，也就是第一层
                .filter(menu -> menu.getParentId().equals(parentId))
                //xxgetChildren是我们在下面写的方法，用于获取子菜单的List集合
                .map(menu -> menu.setChildren(xxgetChildren(menu, menus)))
                .collect(Collectors.toList());
        return menuTree;
    }

    //用于获取传入参数的子菜单，并封装为List集合返回
    private List<Menu> xxgetChildren(Menu menu, List<Menu> menus) {
        List<Menu> childrenList = menus.stream()
                //通过过滤得到子菜单
                .filter(m -> m.getParentId().equals(menu.getId()))
                //如果有三层菜单的话，也就是子菜单的子菜单，我们就用下面那行递归(自己调用自己)来处理
                .map(m -> m.setChildren(xxgetChildren(m,menus)))
                .collect(Collectors.toList());
        return childrenList;
    }

    //---------------------------------查询菜单列表--------------------------------------

    @Override
    public List<Menu> selectMenuList(Menu menu) {

        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        //menuName模糊查询
        queryWrapper.like(StringUtils.hasText(menu.getMenuName()),Menu::getMenuName,menu.getMenuName());
        queryWrapper.eq(StringUtils.hasText(menu.getStatus()),Menu::getStatus,menu.getStatus());
        //排序 parent_id和order_num
        queryWrapper.orderByAsc(Menu::getParentId,Menu::getOrderNum);
        List<Menu> menus = list(queryWrapper);;
        return menus;
    }
}
```

第四步: 在Start-admin工程的controller目录新建MenuController类，写入如下，是查询菜单列表的访问接口

```java
package com.Start.controller;

import com.Start.domain.Menu;
import com.Start.domain.ResponseResult;
import com.Start.service.MenuService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 10:54
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //---------------------------------查询菜单列表--------------------------------------

    @GetMapping("/list")
    public ResponseResult list(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-admin工程的BlogAdminApplication类

第七步: 打开vue前端项目，在浏览器测试点击 '菜单管理'，能否查到所有的菜单数据，这个菜单指的是权限菜单

![img](未命名/__项目/assets/1693034034469-c30b644d-e7b6-4a7f-ae99-2a39ed6e0f2b.jpg)

## 2. 新增菜单

### 一、接口分析

新增权限菜单

| 请求方式 | 请求路径    | 是否需求token头 |
| -------- | ----------- | --------------- |
| POST     | system/menu | 是              |

请求体参数:

```plain
Menu类对应的json格式
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-framework工程的Menu类修改为如下，注意有四个字段使用了mybatisplus的字段自增

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.experimental.Accessors;

/**
 * 菜单权限表(Menu)表实体类
 *
 * @author makejava
 * @since 2023-08-04 13:20:58
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
@Accessors(chain = true) //允许链式编程
public class Menu  {
    //菜单ID
    @TableId
    private Long id;

    //菜单名称
    private String menuName;
    //父菜单ID
    private Long parentId;
    //显示顺序
    private Integer orderNum;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //是否为外链（0是 1否）
    private Integer isFrame;
    //菜单类型（M目录 C菜单 F按钮）
    private String menuType;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;

    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //备注
    private String remark;
    
    private String delFlag;

    //由于数据库没有children字段，所以我们要添加@TableField(exist = false)注解让mybatis在查表时不查询这个字段
    @TableField(exist = false)
    private List<Menu> children;
}
```

第二步: 把Start-admin工程的MenuController类修改为如下，增加了新增菜单的具体代码实现

```java
package com.Start.controller;

import com.Start.domain.Menu;
import com.Start.domain.ResponseResult;
import com.Start.service.MenuService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 10:54
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //---------------------------------查询菜单列表--------------------------------------

    @GetMapping("/list")
    public ResponseResult list(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }

    //-----------------------------------新增菜单---------------------------------------


    @PostMapping
    public ResponseResult add(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseResult.okResult();
    }
}
```

第三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 测试。运行Start-admin工程的BlogAdminApplication类

第五步: 打开vue前端项目，在浏览器测试在 '菜单管理' 页面，点击 '新增'，能否可以添加目录类型的菜单

![img](未命名/__项目/assets/1693034034614-cfd3116c-6faf-409c-b373-18c1e1525397.jpg)

![img](未命名/__项目/assets/1693034034733-cc41a7b3-30d7-4552-adfc-ed47eb93023d.jpg)

![img](未命名/__项目/assets/1693034034854-07e71a14-95d2-4ea6-a346-510e75efd6a3.jpg)

第六步: 测试。在浏览器测试在 '菜单管理' 页面，点击 '新增'，能否可以添加权限类型的菜单

![img](未命名/__项目/assets/1693034034976-b303ff20-cb9c-4df6-a26a-e35ad68d427f.jpg)

![img](未命名/__项目/assets/1693034035109-4019358c-9a0a-469d-a736-1624bae0cc9a.jpg)

![img](未命名/__项目/assets/1693034035233-78d95343-a457-4e9a-8770-fc70d9232a23.jpg)

## 3. 修改菜单

### 一、接口分析

能够修改菜单，但是修改的时候不能把父菜单设置为当前菜单，如果设置了需要给出相应的提示。并且修改失败

①先查询根据菜单id查询对应的权限菜单

| 请求方式 | 请求路径             | 是否需求token头 |
| -------- | -------------------- | --------------- |
| Get      | system/menu/{menuId} | 是              |

请求参数:

```plain
menuId :菜单id
```

响应格式:

```json
{
	"code":200,
	"data":{
		"icon":"table",
		"id":"2017",
		"menuName":"菜单名称",
		"menuType":"M",
		"orderNum":"4",
		"parentId":"0",
		"path":"content",
		"remark":"备注信息",
		"status":"0",
		"visible":"0"
	},
	"msg":"操作成功"
}
```

②然后才是更新菜单

| 请求方式 | 请求路径    | 是否需求token头 |
| -------- | ----------- | --------------- |
| PUT      | system/menu | 是              |

请求体参数:

```plain
Menu类对应的json格式
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

如果把父菜单设置为当前菜单:

```java
{
	"code":500,
	"msg":"修改菜单'写博文'失败，上级菜单不能选择自己"
}
```

### 二、代码实现

第一步: 把Start-framework工程的MenuController类修改为如下，增加了修改菜单的具体代码实现

```java
package com.Start.controller;

import com.Start.domain.Menu;
import com.Start.domain.ResponseResult;
import com.Start.service.MenuService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 10:54
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //---------------------------------查询菜单列表--------------------------------------

    @GetMapping("/list")
    public ResponseResult list(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }

    //-----------------------------------新增菜单---------------------------------------


    @PostMapping
    public ResponseResult add(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseResult.okResult();
    }

    //-----------------------------------修改菜单---------------------------------------

    @GetMapping(value = "/{menuId}")
    //①先查询根据菜单id查询对应的权限菜单
    public ResponseResult getInfo(@PathVariable Long menuId) {
        return ResponseResult.okResult(menuService.getById(menuId));
    }

    @PutMapping
    //②然后才是更新菜单
    public ResponseResult edit(@RequestBody Menu menu) {
        if (menu.getId().equals(menu.getParentId())) {
            return ResponseResult.errorResult(500,"修改菜单'" + menu.getMenuName() + "'失败，上级菜单不能选择自己");
        }
        menuService.updateById(menu);
        return ResponseResult.okResult();
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-admin工程的BlogAdminApplication类

第四步: 打开vue前端项目，在浏览器测试在 '菜单管理' 页面，点击 '修改

![img](未命名/__项目/assets/1693034035361-429532da-6687-4b75-b8d3-fd3e8dd797f4.jpg)

![img](未命名/__项目/assets/1693034035478-02dda0f7-daeb-40e3-86af-91291987b18f.jpg)

![img](未命名/__项目/assets/1693034035613-b2c6c82b-a3c2-4136-b726-f669785d0c13.jpg)

第五步: 测试当修改某个菜单时，上级菜单也是选择自己时，有没有相关错误提示，拒绝这种修改

![img](未命名/__项目/assets/1693034035745-43738bf2-9ef6-4fd2-85e5-a17974a4bf0f.jpg)

![img](未命名/__项目/assets/1693034035871-00b80156-b172-48e0-9030-a885ccad2d18.jpg)

## 4. 删除菜单

### 一、接口分析

能够删除菜单，但是如果要删除的菜单有子菜单则提示：存在子菜单不允许删除 并且删除失败

| 请求方式 | 请求路径             | 是否需求token头 |
| -------- | -------------------- | --------------- |
| DELETE   | system/menu/{menuId} | 是              |

请求参数:

```plain
menuId：要删除菜单的id
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

如果要删除的菜单有子菜单则不允许删除

```java
{
	"code":500,
	"msg":"存在子菜单不允许删除"
}
```

### 二、代码实现

第一步: 把Start-framework工程的MenuService接口修改为如下，增加了判断菜单里面是否存在子菜单的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Menu;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:24
 */
public interface MenuService extends IService<Menu> {
    //查询用户的权限信息
    List<String> selectPermsByUserId(Long id);
    //查询用户的路由信息，也就是查询权限菜单
    List<Menu> selectRouterMenuTreeByUserId(Long userId);
    //查询菜单列表
    List<Menu> selectMenuList(Menu menu);
    //删除菜单-判断是否存在子菜单
    boolean hasChild(Long menuId);
}
```

第二步: 把Start-framework工程的MenuServiceImpl类修改为如下，增加了判断菜单里面是否存在子菜单的具体判断代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Menu;
import com.Start.mapper.MenuMapper;
import com.Start.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:25
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    //查询用户的权限信息
    public List<String> selectPermsByUserId(Long id) {
        //根据用户id查询用户的权限信息。用户id为id代表超级管理员，如果是管理员就返回所有的权限
        if(id == 1L){
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            //查询条件是permissions中需要有所有菜单类型为C或者F的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.in(Menu::getMenuType, SystemCanstants.TYPE_MENU,SystemCanstants.TYPE_BUTTON);
            //查询条件是permissions中需要有状态为正常的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.eq(Menu::getStatus,SystemCanstants.STATUS_NORMAL);
            //查询条件是permissions中需要未被删除的权限的权限
            List<Menu> menus = list(wrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }

        //如果不是管理员就返回对应用户所具有的权限
        List<String> otherPerms = getBaseMapper().selectPermsByOtherUserId(id);
        return otherPerms;
    }

    //----------------------------------查询用户的路由信息(权限菜单)-------------------------------------

    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {

        MenuMapper menuMapper = getBaseMapper();

        List<Menu> menus = null;

        //判断是否是超级管理员，用户id为id代表超级管理员，如果是就返回所有符合要求的权限菜单
        if(userId.equals(1L)){
            menus = menuMapper.selectAllRouterMenu();
        }else{
            //如果不是超级管理员，就查询对应用户所具有的路由信息(权限菜单)
            menus = menuMapper.selectOtherRouterMenuTreeByUserId(userId);
        }

        //构建成tree，也就是子父菜单树，有层级关系
        //思路:先找出第一层的菜单，然后再找子菜单(也就是第二层)，把子菜单的结果赋值给Menu类的children字段
        List<Menu> menuTree = xxbuildMenuTree(menus,0L);

        return menuTree;
    }

    //用于把List集合里面的数据构建成tree，也就是子父菜单树，有层级关系
    private List<Menu> xxbuildMenuTree(List<Menu> menus, long parentId){
        List<Menu> menuTree = menus.stream()
                //过滤找出父菜单树，也就是第一层
                .filter(menu -> menu.getParentId().equals(parentId))
                //xxgetChildren是我们在下面写的方法，用于获取子菜单的List集合
                .map(menu -> menu.setChildren(xxgetChildren(menu, menus)))
                .collect(Collectors.toList());
        return menuTree;
    }

    //用于获取传入参数的子菜单，并封装为List集合返回
    private List<Menu> xxgetChildren(Menu menu, List<Menu> menus) {
        List<Menu> childrenList = menus.stream()
                //通过过滤得到子菜单
                .filter(m -> m.getParentId().equals(menu.getId()))
                //如果有三层菜单的话，也就是子菜单的子菜单，我们就用下面那行递归(自己调用自己)来处理
                .map(m -> m.setChildren(xxgetChildren(m,menus)))
                .collect(Collectors.toList());
        return childrenList;
    }

    //---------------------------------查询菜单列表--------------------------------------

    @Override
    public List<Menu> selectMenuList(Menu menu) {

        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        //menuName模糊查询
        queryWrapper.like(StringUtils.hasText(menu.getMenuName()),Menu::getMenuName,menu.getMenuName());
        queryWrapper.eq(StringUtils.hasText(menu.getStatus()),Menu::getStatus,menu.getStatus());
        //排序 parent_id和order_num
        queryWrapper.orderByAsc(Menu::getParentId,Menu::getOrderNum);
        List<Menu> menus = list(queryWrapper);;
        return menus;
    }

    //-------------------------------删除菜单-是否存在子菜单-------------------------------

    @Override
    public boolean hasChild(Long menuId) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getParentId,menuId);
        return count(queryWrapper) != 0;
    }
}
```

第三步: 把Start-admin工程的MenuController类修改为如下，增加了删除菜单的访问接口、删除菜单的具体实现代码

```java
package com.Start.controller;

import com.Start.domain.Menu;
import com.Start.domain.ResponseResult;
import com.Start.service.MenuService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 10:54
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //---------------------------------查询菜单列表--------------------------------------

    @GetMapping("/list")
    public ResponseResult list(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }

    //-----------------------------------新增菜单---------------------------------------


    @PostMapping
    public ResponseResult add(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseResult.okResult();
    }

    //-----------------------------------修改菜单---------------------------------------

    @GetMapping(value = "/{menuId}")
    //①先查询根据菜单id查询对应的权限菜单
    public ResponseResult getInfo(@PathVariable Long menuId) {
        return ResponseResult.okResult(menuService.getById(menuId));
    }

    @PutMapping
    //②然后才是更新菜单
    public ResponseResult edit(@RequestBody Menu menu) {
        if (menu.getId().equals(menu.getParentId())) {
            return ResponseResult.errorResult(500,"修改菜单'" + menu.getMenuName() + "'失败，上级菜单不能选择自己");
        }
        menuService.updateById(menu);
        return ResponseResult.okResult();
    }

    //-----------------------------------删除菜单---------------------------------------

    @DeleteMapping("/{menuId}")
    public ResponseResult remove(@PathVariable("menuId") Long menuId) {
        if (menuService.hasChild(menuId)) {
            return ResponseResult.errorResult(500,"存在子菜单不允许删除");
        }
        menuService.removeById(menuId);
        return ResponseResult.okResult();
    }
}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 测试。运行Start-admin工程的BlogAdminApplication类

第六步: 打开vue前端项目，在浏览器测试删除菜单功能

![img](未命名/__项目/assets/1693034035997-ce55438e-4caf-4caa-a0af-30d5be9ad606.jpg)

第七步: 测试。删除普通菜单

![img](未命名/__项目/assets/1693034036137-8db465b6-0e95-4c33-9f91-fab125d8a62b.jpg)

![img](未命名/__项目/assets/1693034036252-fd95504a-a32b-453c-af9a-e3a5573b9c59.jpg)

第八步: 测试有子菜单的菜单，也就是测试父菜单能不能被删除

![img](未命名/__项目/assets/1693034036421-ce6fec70-1ea8-4101-b94f-c1c91e027732.jpg)

![img](未命名/__项目/assets/1693034036537-ce736634-12d5-4d83-874a-ca4272b2c722.jpg)

# 博客后台模块-角色列表

## 1. 查询角色

### 一、接口设计

需要有角色列表分页查询的功能。要求能够针对角色名称进行模糊查询。要求能够针对状态进行查询。要求按照role_sort进行升序排列

| 请求方式 | 请求路径         | 是否需求token头 |
| -------- | ---------------- | --------------- |
| GET      | system/role/list | 是              |

请求参数:

```plain
pageNum: 页码

pageSize: 每页条数

roleName：角色名称

status：状态
```

响应格式:

```json
{
	"code":200,
	"data":{
		"rows":[
			{
				"id":"12",
				"roleKey":"link",
				"roleName":"角色名称",
				"roleSort":"1",
				"status":"0"
			}
		],
		"total":"1"
	},
	"msg":"操作成功"
}
```

### 二、代码实现



代码补充: 

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 35238
 * @date 2023/8/10 0010 10:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuVo {
    //菜单ID
    private Long id;

    //菜单名称
    private String menuName;
    //父菜单ID
    private Long parentId;
    //显示顺序
    private Integer orderNum;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //是否为外链（0是 1否）
    private Integer isFrame;
    //菜单类型（M目录 C菜单 F按钮）
    private String menuType;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;

    //备注
    private String remark;
}
```



第一步: 把Start-framework工程的Role表修改为如下，为其中的四个字段使用mybatisplus提供的字段字段、添加了menuIds属性

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 角色信息表(Role)表实体类
 *
 * @author makejava
 * @since 2023-08-04 13:30:49
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role  {
    //角色ID@TableId
    private Long id;

    //角色名称
    private String roleName;
    //角色权限字符串
    private String roleKey;
    //显示顺序
    private Integer roleSort;

    //角色状态（0正常 1停用）
    private String status;
    //删除标志（0代表存在 2代表删除）
    private String delFlag;
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //备注
    private String remark;

    //关联菜单id数组，不是表中的字段  用来接收参数使用
    @TableField(exist = false)
    private Long[] menuIds;
}
```

第二步: 把Start-framework工程的RoleService接口修改为如下，增加了查询角色列表的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
public interface RoleService extends IService<Role> {
    
    //查询用户的角色信息
    List<String> selectRoleKeyByUserId(Long id);

    //查询角色列表
    ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize);
}
```

第三步: 把Start-framework工程的RoleServiceImpl类修改为如下，增加了查询角色列表的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.mapper.RoleMapper;
import com.Start.service.RoleService;
import com.Start.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    //查询用户的角色信息
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员，如果是，就返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }

        //否则查询对应普通用户所具有的的角色信息
        List<String> otherRole = getBaseMapper().selectRoleKeyByOtherUserId(id);

        return otherRole;
    }

    //------------------------------查询角色列表---------------------------------------

    @Override
    public ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.hasText(role.getRoleName()),Role::getRoleName,role.getRoleName());
        lambdaQueryWrapper.eq(StringUtils.hasText(role.getStatus()),Role::getStatus,role.getStatus());
        lambdaQueryWrapper.orderByAsc(Role::getRoleSort);

        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,lambdaQueryWrapper);

        //转换成VO
        List<Role> roles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(roles);
        return ResponseResult.okResult(pageVo);
    }
}
```

第四步: 在Start-admin工程的controller目录新建RoleController类，写入如下，是查询角色列表的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/10 0010 14:05
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //------------------------------查询角色列表---------------------------------------
    @GetMapping("/list")
    public ResponseResult list(Role role, Integer pageNum, Integer pageSize) {
        return roleService.selectRolePage(role,pageNum,pageSize);
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-admin工程的BlogAdminApplication类

第七步: 打开vue前端项目，在浏览器测试点击 '角色管理' 是否能查询到所有的角色

![img](未命名/__项目/assets/1693034036686-90b1569b-5286-44b0-835d-426eb2e383f8.jpg)

## 2. 修改状态

### 一、接口设计

要求能够修改角色的停启用状态

| 请求方式 | 请求路径                 | 是否需求token头 |
| -------- | ------------------------ | --------------- |
| PUT      | system/role/changeStatus | 是              |

请求体:

```json
{"roleId":"11","status":"1"}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 在Start-framework工程的dto目录新建ChangeRoleStatusDto类，写入如下，用于接收前端的参数

```java
package com.Start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/10 0010 14:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeRoleStatusDto {

    private Long roleId;
    private String status;
}
```

第二步: 把Start-admin工程的RoleController类修改为如下，增加了修改角色状态的具体代码实现

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.dto.ChangeRoleStatusDto;
import com.Start.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/10 0010 14:05
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //------------------------------查询角色列表---------------------------------------
    @GetMapping("/list")
    public ResponseResult list(Role role, Integer pageNum, Integer pageSize) {
        return roleService.selectRolePage(role,pageNum,pageSize);
    }

    //-----------------------------修改角色的状态--------------------------------------

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody ChangeRoleStatusDto roleStatusDto){
        Role role = new Role();
        role.setId(roleStatusDto.getRoleId());
        role.setStatus(roleStatusDto.getStatus());
        return ResponseResult.okResult(roleService.updateById(role));
    }
}
```

第三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 测试。运行Start-admin工程的BlogAdminApplication类

第五步: 打开vue前端项目，在浏览器测试关闭角色状态的功能

![img](未命名/__项目/assets/1693034036840-cbf563ee-9f86-4795-9bec-265c58429f43.jpg)

![img](未命名/__项目/assets/1693034036961-72264be5-35ea-4a7c-bdfe-464be71aa264.jpg)

第六步: 测试关闭角色状态的功能

![img](未命名/__项目/assets/1693034037131-d11e36d7-61b4-44da-9381-e7c5611f4ba5.jpg)

![img](未命名/__项目/assets/1693034037239-75333198-edce-4d14-9a1a-1e9550dbcb4d.jpg)

## 3. 新增角色

需要提供新增角色的功能。

### 一、接口设计

①要想新增角色时能够直接设置角色所关联的菜单权限，就需要先查询出所有菜单，也就是获取菜单树

| 请求方式 | 请求路径                | 是否需求token头 |
| -------- | ----------------------- | --------------- |
| GET      | /system/menu/treeselect | 是              |

无请求参数。响应格式如下:

```json
{
	"code":200,
	"data":[
		{
			"children":[],
			"id":"2023",
			"label":"写博文",
			"parentId":"0"
		},
		{
			"children":[
				{
					"children":[
						{
							"children":[],
							"id":"1001",
							"label":"用户查询",
							"parentId":"100"
						},
						{
							"children":[],
							"id":"1007",
							"label":"重置密码",
							"parentId":"100"
						}
					],
					"id":"100",
					"label":"用户管理",
					"parentId":"1"
				},
				{
					"children":[
						{
							"children":[],
							"id":"2024",
							"label":"友链新增",
							"parentId":"2022"
						},
						{
							"children":[],
							"id":"2025",
							"label":"友链修改",
							"parentId":"2022"
						}
					],
					"id":"2022",
					"label":"友链管理",
					"parentId":"2017"
				}
			],
			"id":"2017",
			"label":"内容管理",
			"parentId":"0"
		}
	],
	"msg":"操作成功"
}
```

②新增角色接口

| 请求方式 | 请求路径    | 是否需求token头 |
| -------- | ----------- | --------------- |
| POST     | system/role | 是              |

请求体:

```json
{
    "roleName":"测试新增角色",
    "roleKey":"wds",
    "roleSort":0,
    "status":"0",
    "menuIds":[
        "1",
        "100"
    ],
    "remark":"我是角色备注"
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 在Start-framework工程的utils目录新建SystemConverter类，写入如下，是一个工具类

```java
package com.Start.utils;

import com.Start.domain.Menu;
import com.Start.vo.MenuTreeVo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:17
 */
//新增角色-获取菜单下拉树列表
public class SystemConverter {

    private SystemConverter() {}

    public static List<MenuTreeVo> buildMenuSelectTree(List<Menu> menus) {
        List<MenuTreeVo> MenuTreeVos = menus.stream()
                .map(m -> new MenuTreeVo(m.getId(), m.getMenuName(), m.getParentId(), null))
                .collect(Collectors.toList());
        List<MenuTreeVo> options = MenuTreeVos.stream()
                .filter(o -> o.getParentId().equals(0L))
                .map(o -> o.setChildren(getChildList(MenuTreeVos, o)))
                .collect(Collectors.toList());


        return options;
    }


    /**
     * 得到子节点列表
     */
    private static List<MenuTreeVo> getChildList(List<MenuTreeVo> list, MenuTreeVo option) {
        List<MenuTreeVo> options = list.stream()
                .filter(o -> Objects.equals(o.getParentId(), option.getId()))
                .map(o -> o.setChildren(getChildList(list, o)))
                .collect(Collectors.toList());
        return options;

    }
}
```

第二步: 在Start-framework工程的vo目录新建MenuTreeVo类，写入如下，用于把指定字段返回给前端

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
//新增角色-获取菜单下拉树列表
public class MenuTreeVo {

    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    private Long parentId;

    /** 子节点 */
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MenuTreeVo> children;
}
```

第三步: 在Start-framework工程的domain目录新建RoleMenu类，写入如下

```java
package com.Start.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role_menu")
public class RoleMenu {
    /** 角色ID */
    private Long roleId;

    /** 菜单ID */
    private Long menuId;
}
```

第四步: 在Start-framework工程的mapper目录新建RoleMenuMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.RoleMenu;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:48
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

}
```

第五步: 在Start-framework工程的service目录新建RoleMenuService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.RoleMenu;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:47
 */
public interface RoleMenuService extends IService<RoleMenu> {

}
```

第六步: 在Start-framework工程的service目录新建impl.RoleMenuServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.RoleMenu;
import com.Start.mapper.RoleMenuMapper;
import com.Start.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:50
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
```

第七步: 把Start-framework工程的RoleService接口修改为如下，增加了新增角色的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
public interface RoleService extends IService<Role> {

    //查询用户的角色信息
    List<String> selectRoleKeyByUserId(Long id);

    //查询角色列表
    ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize);

    //新增角色
    void insertRole(Role role);
}
```

第八步: 把Start-framework工程的RoleServiceImpl类修改为如下，增加了新增角色的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.domain.RoleMenu;
import com.Start.mapper.RoleMapper;
import com.Start.service.RoleMenuService;
import com.Start.service.RoleService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    //查询用户的角色信息
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员，如果是，就返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }

        //否则查询对应普通用户所具有的的角色信息
        List<String> otherRole = getBaseMapper().selectRoleKeyByOtherUserId(id);

        return otherRole;
    }

    //------------------------------查询角色列表---------------------------------------

    @Override
    public ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.hasText(role.getRoleName()),Role::getRoleName,role.getRoleName());
        lambdaQueryWrapper.eq(StringUtils.hasText(role.getStatus()),Role::getStatus,role.getStatus());
        lambdaQueryWrapper.orderByAsc(Role::getRoleSort);

        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,lambdaQueryWrapper);

        //转换成VO
        List<Role> roles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(roles);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------新增角色----------------------------------------

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    @Transactional
    public void insertRole(Role role) {
        save(role);
        System.out.println(role.getId());
        if(role.getMenuIds()!=null&&role.getMenuIds().length>0){
            insertRoleMenu(role);
        }
    }

    private void insertRoleMenu(Role role) {
        List<RoleMenu> roleMenuList = Arrays.stream(role.getMenuIds())
                .map(memuId -> new RoleMenu(role.getId(), memuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenuList);
    }
}
```

第九步: 把Start-admin工程的MenuController类修改为如下，增加了 '新增角色-获取菜单下拉树列表' 的代码实现

```java
package com.Start.controller;

import com.Start.domain.Menu;
import com.Start.domain.ResponseResult;
import com.Start.service.MenuService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SystemConverter;
import com.Start.vo.MenuTreeVo;
import com.Start.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 10:54
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //---------------------------------查询菜单列表--------------------------------------

    @GetMapping("/list")
    public ResponseResult list(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }

    //-----------------------------------新增菜单---------------------------------------


    @PostMapping
    public ResponseResult add(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseResult.okResult();
    }

    //-----------------------------------修改菜单---------------------------------------

    @GetMapping(value = "/{menuId}")
    //①先查询根据菜单id查询对应的权限菜单
    public ResponseResult getInfo(@PathVariable Long menuId) {
        return ResponseResult.okResult(menuService.getById(menuId));
    }

    @PutMapping
    //②然后才是更新菜单
    public ResponseResult edit(@RequestBody Menu menu) {
        if (menu.getId().equals(menu.getParentId())) {
            return ResponseResult.errorResult(500,"修改菜单'" + menu.getMenuName() + "'失败，上级菜单不能选择自己");
        }
        menuService.updateById(menu);
        return ResponseResult.okResult();
    }

    //-----------------------------------删除菜单---------------------------------------

    @DeleteMapping("/{menuId}")
    public ResponseResult remove(@PathVariable("menuId") Long menuId) {
        if (menuService.hasChild(menuId)) {
            return ResponseResult.errorResult(500,"存在子菜单不允许删除");
        }
        menuService.removeById(menuId);
        return ResponseResult.okResult();
    }

    //----------------------------新增角色-获取菜单下拉树列表-------------------------------


    @GetMapping("/treeselect")
    public ResponseResult treeselect() {
        //复用之前的selectMenuList方法。方法需要参数，参数可以用来进行条件查询，而这个方法不需要条件，所以直接new Menu()传入
        List<Menu> menus = menuService.selectMenuList(new Menu());
        List<MenuTreeVo> options =  SystemConverter.buildMenuSelectTree(menus);
        return ResponseResult.okResult(options);
    }
}
```

第十步: 把Start-admin工程的RoleController类修改为如下，增加了 '新增角色' 的代码实现

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.dto.ChangeRoleStatusDto;
import com.Start.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/10 0010 14:05
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //------------------------------查询角色列表---------------------------------------
    @GetMapping("/list")
    public ResponseResult list(Role role, Integer pageNum, Integer pageSize) {
        return roleService.selectRolePage(role,pageNum,pageSize);
    }

    //-----------------------------修改角色的状态--------------------------------------

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody ChangeRoleStatusDto roleStatusDto){
        Role role = new Role();
        role.setId(roleStatusDto.getRoleId());
        role.setStatus(roleStatusDto.getStatus());
        return ResponseResult.okResult(roleService.updateById(role));
    }

    //-------------------------------新增角色-----------------------------------------

    @PostMapping
    public ResponseResult add( @RequestBody Role role) {
        roleService.insertRole(role);
        return ResponseResult.okResult();

    }
}
```

第十一步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第十二步: 测试。运行Start-admin工程的BlogAdminApplication类

第十三步: 打开vue前端项目，在浏览器测试新增角色功能

![img](未命名/__项目/assets/1693034037352-49f563f8-b6c2-4932-8faa-2897f14d2caa.jpg)

![img](未命名/__项目/assets/1693034037490-e146aff5-3a7e-4e67-a144-cbbdfb42a143.jpg)

## 4. 修改角色

需要提供修改角色的功能。修改角色时可以修改角色所关联的菜单权限

### 一、接口设计

①先根据角色id查询对应的角色

| 请求方式 | 请求路径             | 是否需求token头 |
| -------- | -------------------- | --------------- |
| Get      | system/role/{roleId} | 是              |

请求参数:

```plain
roleId: 角色id
```

响应格式:

```json
{
	"code":200,
	"data":{
		"id":"11",
		"remark":"备注信息",
		"roleKey":"aggag",
		"roleName":"角色名称",
		"roleSort":"5",
		"status":"0"
	},
	"msg":"操作成功"
}
```

②然后根据角色id查询对应角色菜单列表树

| 请求方式 | 请求路径                             | 是否需求token头 |
| -------- | ------------------------------------ | --------------- |
| Get      | /system/menu/roleMenuTreeselect/{id} | 是              |

请求参数：

```plain
id: 角色id
```

响应格式如下，注意menus表示菜单树，checkedKeys表示角色所关联的菜单权限id列表:

```json
{
	"code":200,
	"data":{
		"menus":[
			{
				"children":[],
				"id":"2023",
				"label":"写博文",
				"parentId":"0"
			},
			{
				"children":[
					{
						"children":[
							{
								"children":[],
								"id":"1001",
								"label":"用户查询",
								"parentId":"100"
							},
							{
								"children":[],
								"id":"1002",
								"label":"用户新增",
								"parentId":"100"
							}
						],
						"id":"100",
						"label":"用户管理",
						"parentId":"1"
					},
					{
						"children":[
							{
								"children":[],
								"id":"1008",
								"label":"角色查询",
								"parentId":"101"
							}
						],
						"id":"101",
						"label":"角色管理",
						"parentId":"1"
					}
				],
				"id":"1",
				"label":"系统管理",
				"parentId":"0"
			},
			{
				"children":[
					{
						"children":[],
						"id":"2019",
						"label":"文章管理",
						"parentId":"2017"
					},
					{
						"children":[
							{
								"children":[],
								"id":"2028",
								"label":"导出分类",
								"parentId":"2018"
							}
						],
						"id":"2018",
						"label":"分类管理",
						"parentId":"2017"
					},
					{
						"children":[
							{
								"children":[],
								"id":"2024",
								"label":"友链新增",
								"parentId":"2022"
							},
							{
								"children":[],
								"id":"2025",
								"label":"友链修改",
								"parentId":"2022"
							}
						],
						"id":"2022",
						"label":"友链管理",
						"parentId":"2017"
					},
					{
						"children":[],
						"id":"2021",
						"label":"标签管理",
						"parentId":"2017"
					}
				],
				"id":"2017",
				"label":"内容管理",
				"parentId":"0"
			}
		],
		"checkedKeys":[
			"1001"  
		]
	},
	"msg":"操作成功"
}
```

③更新角色信息接口

| 请求方式 | 请求路径    | 是否需求token头 |
| -------- | ----------- | --------------- |
| PUT      | system/role | 是              |

请求体：

```json
{
    "id":"13",
    "remark":"我是角色备注",
    "roleKey":"wds",
    "roleName":"测试新增角色",
    "roleSort":0,
    "status":"0",
    "menuIds":[
        "1",
        "100",
        "1001"
    ]
}
```

响应格式：

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 在Start-framework工程的vo目录新建RoleMenuTreeSelectVo类，写入如下，用于把指定字段返回给前端

```java
package com.Start.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 16:29
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenuTreeSelectVo {

    private List<Long> checkedKeys;

    private List<MenuTreeVo> menus;
}
```

第二步: 把Start-framework工程的MenuService接口修改为如下，增加了 '根据角色id查询对应角色菜单列表树' 的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Menu;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:24
 */
public interface MenuService extends IService<Menu> {
    //查询用户的权限信息
    List<String> selectPermsByUserId(Long id);
    //查询用户的路由信息，也就是查询权限菜单
    List<Menu> selectRouterMenuTreeByUserId(Long userId);
    //查询菜单列表
    List<Menu> selectMenuList(Menu menu);
    //删除菜单-判断是否存在子菜单
    boolean hasChild(Long menuId);
    //修改角色-根据角色id查询对应角色菜单列表树
    List<Long> selectMenuListByRoleId(Long roleId);
}
```

第三步: 补充MenuMapper接口

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Menu;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:23
 */
public interface MenuMapper extends BaseMapper<Menu> {
    //查询普通用户的权限信息
    List<String> selectPermsByOtherUserId(Long userId);
    //查询超级管理员的路由信息(权限菜单)
    List<Menu> selectAllRouterMenu();
    //查询普通用户的路由信息(权限菜单)
    List<Menu> selectOtherRouterMenuTreeByUserId(Long userId);
    //修改角色-根据角色id查询对应角色菜单列表树
    List<Long> selectMenuListByRoleId(Long roleId);
}
```

第四步: 把Start-framework工程的resources/mapper目录的MenuMapper.xml修改为如下，增加了 '根据角色id查询对应角色菜单列表树' 的具体实现代码

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<!--MenuMapper接口的映射文件，这里就就相当是MenuMapper接口的实现类，select标签就相当于实现类的具体方法-->
<mapper namespace="com.Start.mapper.MenuMapper">
    <!--查询普通用户的权限信息-->
    <select id="selectPermsByOtherUserId" resultType="java.lang.String">
        SELECT
            DISTINCT m.perms
        FROM
            `sys_user_role` ur
                LEFT JOIN `sys_role_menu` rm ON ur.`role_id` = rm.`role_id`
                LEFT JOIN `sys_menu` m ON m.`id` = rm.`menu_id`
        WHERE
            ur.`user_id` = #{userId} AND
            m.`menu_type` IN ('C','F') AND
            m.`status` = 0 AND
            m.`del_flag` = 0
    </select>

    <!--查询超级管理员的路由信息(权限菜单)-->
    <select id="selectAllRouterMenu" resultType="com.Start.domain.Menu">
        SELECT
            DISTINCT m.id, m.parent_id, m.menu_name, m.path, m.component, m.visible, m.status,
            IFNULL(m.perms,'') AS perms, m.is_frame,  m.menu_type, m.icon, m.order_num, m.create_time
        FROM
            `sys_menu` m
        WHERE
            m.`menu_type` IN ('C','M') AND
            m.`status` = 0 AND
            m.`del_flag` = 0
        ORDER BY
            m.parent_id,m.order_num
    </select>

    <!--查询普通用户的路由信息(权限菜单)-->
    <select id="selectOtherRouterMenuTreeByUserId" resultType="com.Start.domain.Menu">
        SELECT
            DISTINCT m.id, m.parent_id, m.menu_name, m.path, m.component, m.visible, m.status,
            IFNULL(m.perms,'') AS perms, m.is_frame,  m.menu_type, m.icon, m.order_num, m.create_time
        FROM
            `sys_user_role` ur
                LEFT JOIN `sys_role_menu` rm ON ur.`role_id` = rm.`role_id`
                LEFT JOIN `sys_menu` m ON m.`id` = rm.`menu_id`
        WHERE
            ur.`user_id` = #{userId} AND
            m.`menu_type` IN ('C','M') AND
            m.`status` = 0 AND
            m.`del_flag` = 0
        ORDER BY
            m.parent_id,m.order_num
    </select>

    <!--修改角色-根据角色id查询对应角色菜单列表树-->
    <select id="selectMenuListByRoleId" resultType="java.lang.Long">
        select m.id
        from sys_menu m
                 left join sys_role_menu rm on m.id = rm.menu_id
        where rm.role_id = #{roleId}


        order by m.parent_id, m.order_num
    </select>
</mapper>
```

第五步: 把Start-framework工程的MenuServiceImpl类修改为如下，增加了 '根据角色id查询对应角色菜单列表树' 的具体实现代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Menu;
import com.Start.mapper.MenuMapper;
import com.Start.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:25
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    //查询用户的权限信息
    public List<String> selectPermsByUserId(Long id) {
        //根据用户id查询用户的权限信息。用户id为id代表超级管理员，如果是管理员就返回所有的权限
        if(id == 1L){
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            //查询条件是permissions中需要有所有菜单类型为C或者F的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.in(Menu::getMenuType, SystemCanstants.TYPE_MENU,SystemCanstants.TYPE_BUTTON);
            //查询条件是permissions中需要有状态为正常的权限。SystemCanstants是我们在Start-framework工程写的类
            wrapper.eq(Menu::getStatus,SystemCanstants.STATUS_NORMAL);
            //查询条件是permissions中需要未被删除的权限的权限
            List<Menu> menus = list(wrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }

        //如果不是管理员就返回对应用户所具有的权限
        List<String> otherPerms = getBaseMapper().selectPermsByOtherUserId(id);
        return otherPerms;
    }

    //----------------------------------查询用户的路由信息(权限菜单)-------------------------------------

    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {

        MenuMapper menuMapper = getBaseMapper();

        List<Menu> menus = null;

        //判断是否是超级管理员，用户id为id代表超级管理员，如果是就返回所有符合要求的权限菜单
        if(userId.equals(1L)){
            menus = menuMapper.selectAllRouterMenu();
        }else{
            //如果不是超级管理员，就查询对应用户所具有的路由信息(权限菜单)
            menus = menuMapper.selectOtherRouterMenuTreeByUserId(userId);
        }

        //构建成tree，也就是子父菜单树，有层级关系
        //思路:先找出第一层的菜单，然后再找子菜单(也就是第二层)，把子菜单的结果赋值给Menu类的children字段
        List<Menu> menuTree = xxbuildMenuTree(menus,0L);

        return menuTree;
    }

    //用于把List集合里面的数据构建成tree，也就是子父菜单树，有层级关系
    private List<Menu> xxbuildMenuTree(List<Menu> menus, long parentId){
        List<Menu> menuTree = menus.stream()
                //过滤找出父菜单树，也就是第一层
                .filter(menu -> menu.getParentId().equals(parentId))
                //xxgetChildren是我们在下面写的方法，用于获取子菜单的List集合
                .map(menu -> menu.setChildren(xxgetChildren(menu, menus)))
                .collect(Collectors.toList());
        return menuTree;
    }

    //用于获取传入参数的子菜单，并封装为List集合返回
    private List<Menu> xxgetChildren(Menu menu, List<Menu> menus) {
        List<Menu> childrenList = menus.stream()
                //通过过滤得到子菜单
                .filter(m -> m.getParentId().equals(menu.getId()))
                //如果有三层菜单的话，也就是子菜单的子菜单，我们就用下面那行递归(自己调用自己)来处理
                .map(m -> m.setChildren(xxgetChildren(m,menus)))
                .collect(Collectors.toList());
        return childrenList;
    }

    //---------------------------------查询菜单列表--------------------------------------

    @Override
    public List<Menu> selectMenuList(Menu menu) {

        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        //menuName模糊查询
        queryWrapper.like(StringUtils.hasText(menu.getMenuName()),Menu::getMenuName,menu.getMenuName());
        queryWrapper.eq(StringUtils.hasText(menu.getStatus()),Menu::getStatus,menu.getStatus());
        //排序 parent_id和order_num
        queryWrapper.orderByAsc(Menu::getParentId,Menu::getOrderNum);
        List<Menu> menus = list(queryWrapper);;
        return menus;
    }

    //-------------------------------删除菜单-是否存在子菜单-------------------------------

    @Override
    public boolean hasChild(Long menuId) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Menu::getParentId,menuId);
        return count(queryWrapper) != 0;
    }

    //--------------------------修改角色-根据角色id查询对应角色菜单列表树---------------------

    @Override
    public List<Long> selectMenuListByRoleId(Long roleId) {
        return getBaseMapper().selectMenuListByRoleId(roleId);
    }
}
```

第六步: 把Start-admin工程的MenuController类修改为如下，是 '根据角色id查询对应角色菜单列表树' 的访问接口

```java
package com.Start.controller;

import com.Start.domain.Menu;
import com.Start.domain.ResponseResult;
import com.Start.service.MenuService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SystemConverter;
import com.Start.vo.MenuTreeVo;
import com.Start.vo.MenuVo;
import com.Start.vo.RoleMenuTreeSelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 10:54
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //---------------------------------查询菜单列表--------------------------------------

    @GetMapping("/list")
    public ResponseResult list(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }

    //-----------------------------------新增菜单---------------------------------------


    @PostMapping
    public ResponseResult add(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseResult.okResult();
    }

    //-----------------------------------修改菜单---------------------------------------

    @GetMapping(value = "/{menuId}")
    //①先查询根据菜单id查询对应的权限菜单
    public ResponseResult getInfo(@PathVariable Long menuId) {
        return ResponseResult.okResult(menuService.getById(menuId));
    }

    @PutMapping
    //②然后才是更新菜单
    public ResponseResult edit(@RequestBody Menu menu) {
        if (menu.getId().equals(menu.getParentId())) {
            return ResponseResult.errorResult(500,"修改菜单'" + menu.getMenuName() + "'失败，上级菜单不能选择自己");
        }
        menuService.updateById(menu);
        return ResponseResult.okResult();
    }

    //-----------------------------------删除菜单---------------------------------------

    @DeleteMapping("/{menuId}")
    public ResponseResult remove(@PathVariable("menuId") Long menuId) {
        if (menuService.hasChild(menuId)) {
            return ResponseResult.errorResult(500,"存在子菜单不允许删除");
        }
        menuService.removeById(menuId);
        return ResponseResult.okResult();
    }

    //----------------------------新增角色-获取菜单下拉树列表-------------------------------


    @GetMapping("/treeselect")
    public ResponseResult treeselect() {
        //复用之前的selectMenuList方法。方法需要参数，参数可以用来进行条件查询，而这个方法不需要条件，所以直接new Menu()传入
        List<Menu> menus = menuService.selectMenuList(new Menu());
        List<MenuTreeVo> options =  SystemConverter.buildMenuSelectTree(menus);
        return ResponseResult.okResult(options);
    }

    //---------------------修改角色-根据角色id查询对应角色菜单列表树--------------------------

    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
    public ResponseResult roleMenuTreeSelect(@PathVariable("roleId") Long roleId) {
        List<Menu> menus = menuService.selectMenuList(new Menu());
        List<Long> checkedKeys = menuService.selectMenuListByRoleId(roleId);
        List<MenuTreeVo> menuTreeVos = SystemConverter.buildMenuSelectTree(menus);
        RoleMenuTreeSelectVo vo = new RoleMenuTreeSelectVo(checkedKeys,menuTreeVos);
        return ResponseResult.okResult(vo);
    }
}
```

第七步: 在Start-framework工程的service目录新建RoleMenuService接口，写入如下，是 '保存角色信息' 的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.RoleMenu;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:47
 */
public interface RoleMenuService extends IService<RoleMenu> {

    //修改角色-保存修改好的角色信息
    void deleteRoleMenuByRoleId(Long id);

}
```

第八步: 在Start-framework工程的service目录新建RoleMenuServiceImpl类，写入如下，是 '保存角色信息' 的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.RoleMenu;
import com.Start.mapper.RoleMenuMapper;
import com.Start.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/8/10 0010 15:50
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Override
    //修改角色-保存修改好的角色信息
    public void deleteRoleMenuByRoleId(Long id) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleMenu::getRoleId,id);
        remove(queryWrapper);
    }
}
```

第九步: 把Start-framework工程的RoleService接口修改为如下，增加了 '保存角色信息' 的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
public interface RoleService extends IService<Role> {

    //查询用户的角色信息
    List<String> selectRoleKeyByUserId(Long id);

    //查询角色列表
    ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize);

    //新增角色
    void insertRole(Role role);

    //修改角色-保存修改好的角色信息
    void updateRole(Role role);
}
```

第十步: 把Start-framework工程的RoleServiceImpl类修改为如下，是 '保存角色信息' 的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.domain.RoleMenu;
import com.Start.mapper.RoleMapper;
import com.Start.service.RoleMenuService;
import com.Start.service.RoleService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    //查询用户的角色信息
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员，如果是，就返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }

        //否则查询对应普通用户所具有的的角色信息
        List<String> otherRole = getBaseMapper().selectRoleKeyByOtherUserId(id);

        return otherRole;
    }

    //------------------------------查询角色列表---------------------------------------

    @Override
    public ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.hasText(role.getRoleName()),Role::getRoleName,role.getRoleName());
        lambdaQueryWrapper.eq(StringUtils.hasText(role.getStatus()),Role::getStatus,role.getStatus());
        lambdaQueryWrapper.orderByAsc(Role::getRoleSort);

        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,lambdaQueryWrapper);

        //转换成VO
        List<Role> roles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(roles);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------新增角色----------------------------------------

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    @Transactional
    public void insertRole(Role role) {
        save(role);
        System.out.println(role.getId());
        if(role.getMenuIds()!=null&&role.getMenuIds().length>0){
            insertRoleMenu(role);
        }
    }

    private void insertRoleMenu(Role role) {
        List<RoleMenu> roleMenuList = Arrays.stream(role.getMenuIds())
                .map(memuId -> new RoleMenu(role.getId(), memuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenuList);
    }

    //-----------------------修改角色-保存修改好的角色信息----------------------------

    @Override
    public void updateRole(Role role) {
        updateById(role);
        roleMenuService.deleteRoleMenuByRoleId(role.getId());
        insertRoleMenu(role);
    }
}
```

第十一步: 把Start-admin工程的RoleController类修改为如下，增加了 '根据角色id查询对应的角色' 和 '保存角色信息' 的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.dto.ChangeRoleStatusDto;
import com.Start.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/10 0010 14:05
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //------------------------------查询角色列表---------------------------------------
    @GetMapping("/list")
    public ResponseResult list(Role role, Integer pageNum, Integer pageSize) {
        return roleService.selectRolePage(role,pageNum,pageSize);
    }

    //-----------------------------修改角色的状态--------------------------------------

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody ChangeRoleStatusDto roleStatusDto){
        Role role = new Role();
        role.setId(roleStatusDto.getRoleId());
        role.setStatus(roleStatusDto.getStatus());
        return ResponseResult.okResult(roleService.updateById(role));
    }

    //-------------------------------新增角色-----------------------------------------

    @PostMapping
    public ResponseResult add( @RequestBody Role role) {
        roleService.insertRole(role);
        return ResponseResult.okResult();
    }

    //----------------------修改角色-根据角色id查询对应的角色-----------------------------

    @GetMapping(value = "/{roleId}")
    public ResponseResult getInfo(@PathVariable Long roleId) {
        Role role = roleService.getById(roleId);
        return ResponseResult.okResult(role);
    }

    //-------------------------修改角色-保存修改好的角色信息------------------------------

    @PutMapping
    public ResponseResult edit(@RequestBody Role role) {
        roleService.updateRole(role);
        return ResponseResult.okResult();
    }
}
```

第十二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第十三步: 测试。运行Start-admin工程的BlogAdminApplication类

第十四步: 打开vue前端项目，在浏览器测试修改角色功能

![img](未命名/__项目/assets/1693034037616-7d7ec563-4d4d-4431-8f3c-79953e024714.jpg)

![img](未命名/__项目/assets/1693034037748-29c902b9-612b-4c9d-a07c-367d7da7be53.jpg)

![img](未命名/__项目/assets/1693034037877-b81ca613-b5f6-438e-b7b3-3e135e8f9fb5.jpg)

## 5. 删除角色

### 一、接口设计

删除固定的某个角色，注意是逻辑删除

| 请求方式 | 请求路径         | 是否需求token头 |
| -------- | ---------------- | --------------- |
| DELETE   | system/role/{id} | 是              |

请求参数:

```plain
id：要删除的角色id
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-admin工程的RoleController类修改为如下，增加了删除角色的具体代码实现

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.dto.ChangeRoleStatusDto;
import com.Start.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/10 0010 14:05
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //------------------------------查询角色列表---------------------------------------
    @GetMapping("/list")
    public ResponseResult list(Role role, Integer pageNum, Integer pageSize) {
        return roleService.selectRolePage(role,pageNum,pageSize);
    }

    //-----------------------------修改角色的状态--------------------------------------

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody ChangeRoleStatusDto roleStatusDto){
        Role role = new Role();
        role.setId(roleStatusDto.getRoleId());
        role.setStatus(roleStatusDto.getStatus());
        return ResponseResult.okResult(roleService.updateById(role));
    }

    //-------------------------------新增角色-----------------------------------------

    @PostMapping
    public ResponseResult add( @RequestBody Role role) {
        roleService.insertRole(role);
        return ResponseResult.okResult();
    }

    //----------------------修改角色-根据角色id查询对应的角色-----------------------------

    @GetMapping(value = "/{roleId}")
    public ResponseResult getInfo(@PathVariable Long roleId) {
        Role role = roleService.getById(roleId);
        return ResponseResult.okResult(role);
    }

    //-------------------------修改角色-保存修改好的角色信息------------------------------

    @PutMapping
    public ResponseResult edit(@RequestBody Role role) {
        roleService.updateRole(role);
        return ResponseResult.okResult();
    }

    //--------------------------------删除角色---------------------------------------

    @DeleteMapping("/{id}")
    public ResponseResult remove(@PathVariable(name = "id") Long id) {
        roleService.removeById(id);
        return ResponseResult.okResult();
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-admin工程的BlogAdminApplication类

第四步: 打开vue前端项目，在浏览器测试删除角色功能

![img](未命名/__项目/assets/1693034038009-c5630153-eacb-48d5-9212-55ae6f041aa7.jpg)

![img](未命名/__项目/assets/1693034038136-73e3efec-6503-484b-b53e-cadd92d520ed.jpg)

# 博客后台模块-用户列表

## 1. 查询用户

### 一、接口分析

需要用户分页列表接口。可以根据用户名模糊搜索。可以进行手机号的搜索。可以进行状态的查询

| 请求方式 | 请求路径         | 是否需求token头 |
| -------- | ---------------- | --------------- |
| GET      | system/user/list | 是              |

请求参数:

```plain
pageNum: 页码

pageSize: 每页条数

userName：用户名

phonenumber：手机号

status:状态
```

响应格式:

```json
{
	"code":200,
	"data":{
		"rows":[
			{
				"avatar":"头像url",
				"createTime":"2023-08-05 17:01:56",
				"email":"23412332@qq.com",
				"id":"1",
				"nickName":"昵称",
				"phonenumber":"18888888888",
				"sex":"1",
				"status":"0",
				"updateBy":"1",
				"updateTime":"2023-08-10 21:36:22",
				"userName":"sg"
			}
		],
		"total":"1"
	},
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 在Start-framework工程的vo目录新建UserVo类，写入如下，用于把指定字段返回给前端

```java
package com.Start.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author 35238
 * @date 2023/8/10 0010 20:03
 */
@Data
@Accessors(chain = true)
public class UserVo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 账号状态（0正常 1停用）
     */
    private String status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phonenumber;
    /**
     * 用户性别（0男，1女，2未知）
     */
    private String sex;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建人的用户id
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private Long updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

}
```

第二步: 把Start-framework工程的UserService接口修改为如下，增加了查询用户列表的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:48
 */
public interface UserService extends IService<User> {
    //查询个人信息
    ResponseResult userInfo();

    //更新个人信息
    ResponseResult updateUserInfo(User user);

    //用户注册功能
    ResponseResult register(User user);

    //查询用户列表
    ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize);
}
```

第三步: 把Start-framework工程的UserServiceImpl类修改为如下，增加了查询用户列表的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.mapper.UserMapper;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.PageVo;
import com.Start.vo.UserInfoVo;
import com.Start.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:49
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    //查询个人信息的具体代码
    public ResponseResult userInfo() {

        //获取当前用户的用户id。SecurityUtils是我们在Start-framework工程写的类
        Long userId = SecurityUtils.getUserId();

        //根据用户id查询用户信息
        User user = getById(userId);

        //封装成UserInfoVo(我们在Start-framework工程写的类)，然后返回
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    //更新个人信息的具体代码
    public ResponseResult updateUserInfo(User user) {
        //updateById是mybatisplus提供的方法
        updateById(user);
        return ResponseResult.okResult();
    }

    @Autowired
    //解密和加密用的这套算法。我们在Start-blog工程的securityConfig类里面覆盖过PasswordEncoder这个bean
    private PasswordEncoder passwordEncoder;

    @Override
    //用户注册功能的具体代码
    public ResponseResult register(User user) {

        //对前端传过来的用户名进行非空判断，例如null、""，就抛出异常
        if(!StringUtils.hasText(user.getUserName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        //密码
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        //邮箱
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        //昵称
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //手机号码
        if(!StringUtils.hasText(user.getPhonenumber())){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_NOT_NULL);
        }

        //判断用户传给我们的用户名是否在数据库已经存在。userNameExist方法是下面定义的
        if(userNameExist(user.getUserName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        //判断用户传给我们的昵称是否在数据库已经存在。NickNameExist方法是下面定义的
        if(NickNameExist(user.getNickName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //判断用户传给我们的邮箱是否在数据库已经存在。NickNameExist方法是下面定义的
        if(EmailExist(user.getEmail())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }

        //经过上面的判断，可以确保用户传给我们的用户名和昵称是数据库不存在的，且相关字段都不为空。就可以存入数据库
        //注意用户传给我们的密码是明文，对于密码我们要转成密文之后再存入数据库。注意加密要和解密用同一套算法
        //在Start-blog工程的securityConfig类里面有解密算法，当时我们写了一个passwordEncoder方法，并且注入到了spring容器
        String encodePassword = passwordEncoder.encode(user.getPassword());//加密
        user.setPassword(encodePassword);
        //存入数据库。save方法是mybatisplus提供的方法
        save(user);

        //封装响应返回
        return ResponseResult.okResult();
    }

    //'判断用户传给我们的用户名是否在数据库已经存在' 的方法
    private boolean userNameExist(String userName) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的用户名跟数据库里面的用户名进行比较
        queryWrapper.eq(User::getUserName,userName);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的昵称是否在数据库已经存在' 的方法
    private boolean NickNameExist(String nickName) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的昵称跟数据库里面的昵称进行比较
        queryWrapper.eq(User::getNickName,nickName);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的邮箱是否在数据库已经存在' 的方法
    private boolean EmailExist(String email) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的昵称跟数据库里面的昵称进行比较
        queryWrapper.eq(User::getEmail,email);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //--------------------------------查询用户列表-------------------------------------

    @Override
    public ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.hasText(user.getUserName()),User::getUserName,user.getUserName());
        queryWrapper.eq(StringUtils.hasText(user.getStatus()),User::getStatus,user.getStatus());
        queryWrapper.eq(StringUtils.hasText(user.getPhonenumber()),User::getPhonenumber,user.getPhonenumber());

        Page<User> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换成VO
        List<User> users = page.getRecords();
        List<UserVo> userVoList = users.stream()
                .map(u -> BeanCopyUtils.copyBean(u, UserVo.class))
                .collect(Collectors.toList());
        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(userVoList);
        return ResponseResult.okResult(pageVo);
    }
}
```

第四步: 在Start-admin工程的controller目录新建UserController类，写入如下，是查询用户列表的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/10 0010 19:59
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    //--------------------------------查询用户列表-------------------------------------

    @GetMapping("/list")
    public ResponseResult list(User user, Integer pageNum, Integer pageSize) {
        return userService.selectUserPage(user,pageNum,pageSize);
    }
}
```

第五步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第六步: 测试。运行Start-admin工程的BlogAdminApplication类

第七步: 打开vue前端项目，在浏览器测试点击 '用户管理'，能不能查询到所有的用户

![img](未命名/__项目/assets/1693034038286-e7ae7406-e2a6-4720-9184-a202a18b708c.jpg)

## 2. 新增用户

需要新增用户功能。新增用户时可以直接关联角色。注意如下

```plain
新增用户时注意密码加密存储

用户名不能为空，否则提示：必需填写用户名

用户名必须之前未存在，否则提示：用户名已存在

手机号必须之前未存在，否则提示：手机号已存在

邮箱必须之前未存在，否则提示：邮箱已存在
```

### 一、接口分析

①查询角色列表接口。注意: 查询的是所有状态正常的角色

| 请求方式 | 请求路径                 | 是否需求token头 |
| -------- | ------------------------ | --------------- |
| GET      | /system/role/listAllRole | 是              |

响应格式：

```json
{
	"code":200,
	"data":[
		{
			"createBy":"0",
			"createTime":"2023-08-12 18:46:19",
			"delFlag":"0",
			"id":"1",
			"remark":"超级管理员",
			"roleKey":"admin",
			"roleName":"超级管理员",
			"roleSort":"1",
			"status":"0",
			"updateBy":"0"
		},
		{
			"createBy":"0",
			"createTime":"2023-08-12 18:46:19",
			"delFlag":"0",
			"id":"2",
			"remark":"普通角色",
			"roleKey":"common",
			"roleName":"普通角色",
			"roleSort":"2",
			"status":"0",
			"updateBy":"0",
			"updateTime":"2023-08-13 06:32:58"
		}
	],
	"msg":"操作成功"
}
```

②新增用户

| 请求方式 | 请求路径    | 是否需求token头 |
| -------- | ----------- | --------------- |
| POST     | system/user | 是              |

请求体:

```json
{
    "userName":"wqeree",
    "nickName":"测试新增用户",
    "password":"1234343",
    "phonenumber":"18889778907",
    "email":"233@sq.com",
    "sex":"0",
    "status":"0",
    "roleIds":[
        "2"
    ]
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-framework工程的User类修改为如下，其中的4个字段用了mybatisplus的字段自增，增加了roleIds属性

```java
package com.Start.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-07-22 20:41:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User  {

    //主键，禁用雪花算法，使用mysql的主键自增策略
    @TableId(type = IdType.AUTO)
    private Long id;

    //用户名
    private String userName;
    //昵称
    private String nickName;
    //密码
    private String password;
    //用户类型：0代表普通用户，1代表管理员
    private String type;
    //账号状态（0正常 1停用）
    private String status;
    //邮箱
    private String email;
    //手机号
    private String phonenumber;
    //用户性别（0男，1女，2未知）
    private String sex;
    //头像
    private String avatar;

    //字段自增
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

    //关联角色id数组，非user表字段
    @TableField(exist = false)
    private Long[] roleIds;
}
```

第二步: 在Start-framework工程的domain目录新建UserRole类，写入如下

```java
package com.Start.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/8/10 0010 20:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user_role")
public class UserRole {

    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;
}
```

第三步: 在Start-framework工程的mapper目录新建UserRoleMapper接口，写入如下

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.UserRole;

/**
 * @author 35238
 * @date 2023/8/10 0010 20:30
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
```

第四步: 在Start-framework工程的service目录新建UserRoleService接口，写入如下

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.UserRole;

/**
 * @author 35238
 * @date 2023/8/10 0010 20:26
 */
public interface UserRoleService extends IService<UserRole> {

}
```

第五步: 在Start-framework工程的service目录新建impl.UserRoleServiceImpl类，写入如下

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.UserRole;
import com.Start.mapper.UserRoleMapper;
import com.Start.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author 35238
 * @date 2023/8/10 0010 20:42
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
```

第六步: 把Start-framework工程的RoleService接口修改为如下，增加了查询角色列表的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
public interface RoleService extends IService<Role> {

    //查询用户的角色信息
    List<String> selectRoleKeyByUserId(Long id);

    //查询角色列表
    ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize);

    //新增角色
    void insertRole(Role role);

    //修改角色-保存修改好的角色信息
    void updateRole(Role role);

    //新增用户-①查询角色列表接口
    List<Role> selectRoleAll();
}
```

第七步: 把Start-framework工程的RoleServiceImpl类修改为如下，增加了查询角色列表的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.domain.RoleMenu;
import com.Start.mapper.RoleMapper;
import com.Start.service.RoleMenuService;
import com.Start.service.RoleService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    //查询用户的角色信息
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员，如果是，就返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }

        //否则查询对应普通用户所具有的的角色信息
        List<String> otherRole = getBaseMapper().selectRoleKeyByOtherUserId(id);

        return otherRole;
    }

    //------------------------------查询角色列表---------------------------------------

    @Override
    public ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.hasText(role.getRoleName()),Role::getRoleName,role.getRoleName());
        lambdaQueryWrapper.eq(StringUtils.hasText(role.getStatus()),Role::getStatus,role.getStatus());
        lambdaQueryWrapper.orderByAsc(Role::getRoleSort);

        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,lambdaQueryWrapper);

        //转换成VO
        List<Role> roles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(roles);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------新增角色----------------------------------------

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    @Transactional
    public void insertRole(Role role) {
        save(role);
        System.out.println(role.getId());
        if(role.getMenuIds()!=null&&role.getMenuIds().length>0){
            insertRoleMenu(role);
        }
    }

    private void insertRoleMenu(Role role) {
        List<RoleMenu> roleMenuList = Arrays.stream(role.getMenuIds())
                .map(memuId -> new RoleMenu(role.getId(), memuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenuList);
    }

    //-----------------------修改角色-保存修改好的角色信息----------------------------

    @Override
    public void updateRole(Role role) {
        updateById(role);
        roleMenuService.deleteRoleMenuByRoleId(role.getId());
        insertRoleMenu(role);
    }

    //-----------------------新增用户-①查询角色列表接口----------------------------

    @Override
    public List<Role> selectRoleAll() {
        return list(Wrappers.<Role>lambdaQuery().eq(Role::getStatus, SystemCanstants.NORMAL));
    }
}
```

第八步: 把Start-admin工程的RoleController类修改为如下，增加了查询角色列表的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.dto.ChangeRoleStatusDto;
import com.Start.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 14:05
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //------------------------------查询角色列表---------------------------------------
    @GetMapping("/list")
    public ResponseResult list(Role role, Integer pageNum, Integer pageSize) {
        return roleService.selectRolePage(role,pageNum,pageSize);
    }

    //-----------------------------修改角色的状态--------------------------------------

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody ChangeRoleStatusDto roleStatusDto){
        Role role = new Role();
        role.setId(roleStatusDto.getRoleId());
        role.setStatus(roleStatusDto.getStatus());
        return ResponseResult.okResult(roleService.updateById(role));
    }

    //-------------------------------新增角色-----------------------------------------

    @PostMapping
    public ResponseResult add( @RequestBody Role role) {
        roleService.insertRole(role);
        return ResponseResult.okResult();
    }

    //----------------------修改角色-根据角色id查询对应的角色-----------------------------

    @GetMapping(value = "/{roleId}")
    public ResponseResult getInfo(@PathVariable Long roleId) {
        Role role = roleService.getById(roleId);
        return ResponseResult.okResult(role);
    }

    //-------------------------修改角色-保存修改好的角色信息------------------------------

    @PutMapping
    public ResponseResult edit(@RequestBody Role role) {
        roleService.updateRole(role);
        return ResponseResult.okResult();
    }

    //--------------------------------删除角色---------------------------------------

    @DeleteMapping("/{id}")
    public ResponseResult remove(@PathVariable(name = "id") Long id) {
        roleService.removeById(id);
        return ResponseResult.okResult();
    }

    //--------------------------------新增用户---------------------------------------

    @GetMapping("/listAllRole")
    //①查询角色列表接口
    public ResponseResult listAllRole(){
        List<Role> roles = roleService.selectRoleAll();
        return ResponseResult.okResult(roles);
    }
}
```

第九步: 把Start-framework工程的UserService接口修改为如下，增加了新增用户的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:48
 */
public interface UserService extends IService<User> {
    //查询个人信息
    ResponseResult userInfo();

    //更新个人信息
    ResponseResult updateUserInfo(User user);

    //用户注册功能
    ResponseResult register(User user);

    //查询用户列表
    ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize);

    //增加用户-②新增用户
    boolean checkUserNameUnique(String userName);
    boolean checkPhoneUnique(User user);
    boolean checkEmailUnique(User user);
    ResponseResult addUser(User user);
}
```

第十步: 把Start-framework工程的UserServiceImpl接口修改为如下，增加了新增用户的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.domain.UserRole;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.mapper.UserMapper;
import com.Start.service.UserRoleService;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.PageVo;
import com.Start.vo.UserInfoVo;
import com.Start.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:49
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    //查询个人信息的具体代码
    public ResponseResult userInfo() {

        //获取当前用户的用户id。SecurityUtils是我们在Start-framework工程写的类
        Long userId = SecurityUtils.getUserId();

        //根据用户id查询用户信息
        User user = getById(userId);

        //封装成UserInfoVo(我们在Start-framework工程写的类)，然后返回
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    //更新个人信息的具体代码
    public ResponseResult updateUserInfo(User user) {
        //updateById是mybatisplus提供的方法
        updateById(user);
        return ResponseResult.okResult();
    }

    @Autowired
    //解密和加密用的这套算法。我们在Start-blog工程的securityConfig类里面覆盖过PasswordEncoder这个bean
    private PasswordEncoder passwordEncoder;

    @Override
    //用户注册功能的具体代码
    public ResponseResult register(User user) {

        //对前端传过来的用户名进行非空判断，例如null、""，就抛出异常
        if(!StringUtils.hasText(user.getUserName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        //密码
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        //邮箱
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        //昵称
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //手机号码
        if(!StringUtils.hasText(user.getPhonenumber())){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_NOT_NULL);
        }

        //判断用户传给我们的用户名是否在数据库已经存在。userNameExist方法是下面定义的
        if(userNameExist(user.getUserName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        //判断用户传给我们的昵称是否在数据库已经存在。NickNameExist方法是下面定义的
        if(NickNameExist(user.getNickName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //判断用户传给我们的邮箱是否在数据库已经存在。NickNameExist方法是下面定义的
        if(EmailExist(user.getEmail())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }

        //经过上面的判断，可以确保用户传给我们的用户名和昵称是数据库不存在的，且相关字段都不为空。就可以存入数据库
        //注意用户传给我们的密码是明文，对于密码我们要转成密文之后再存入数据库。注意加密要和解密用同一套算法
        //在Start-blog工程的securityConfig类里面有解密算法，当时我们写了一个passwordEncoder方法，并且注入到了spring容器
        String encodePassword = passwordEncoder.encode(user.getPassword());//加密
        user.setPassword(encodePassword);
        //存入数据库。save方法是mybatisplus提供的方法
        save(user);

        //封装响应返回
        return ResponseResult.okResult();
    }

    //'判断用户传给我们的用户名是否在数据库已经存在' 的方法
    private boolean userNameExist(String userName) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的用户名跟数据库里面的用户名进行比较
        queryWrapper.eq(User::getUserName,userName);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的昵称是否在数据库已经存在' 的方法
    private boolean NickNameExist(String nickName) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的昵称跟数据库里面的昵称进行比较
        queryWrapper.eq(User::getNickName,nickName);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的邮箱是否在数据库已经存在' 的方法
    private boolean EmailExist(String email) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的昵称跟数据库里面的昵称进行比较
        queryWrapper.eq(User::getEmail,email);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //--------------------------------查询用户列表-------------------------------------

    @Override
    public ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.hasText(user.getUserName()),User::getUserName,user.getUserName());
        queryWrapper.eq(StringUtils.hasText(user.getStatus()),User::getStatus,user.getStatus());
        queryWrapper.eq(StringUtils.hasText(user.getPhonenumber()),User::getPhonenumber,user.getPhonenumber());

        Page<User> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换成VO
        List<User> users = page.getRecords();
        List<UserVo> userVoList = users.stream()
                .map(u -> BeanCopyUtils.copyBean(u, UserVo.class))
                .collect(Collectors.toList());
        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(userVoList);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------新增用户-②新增用户--------------------------------

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean checkUserNameUnique(String userName) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getUserName,userName))==0;
    }

    @Override
    public boolean checkPhoneUnique(User user) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getPhonenumber,user.getPhonenumber()))==0;
    }

    @Override
    public boolean checkEmailUnique(User user) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getEmail,user.getEmail()))==0;
    }

    @Override
    @Transactional
    public ResponseResult addUser(User user) {
        //密码加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        save(user);

        if(user.getRoleIds()!=null&&user.getRoleIds().length>0){
            insertUserRole(user);
        }
        return ResponseResult.okResult();
    }

    private void insertUserRole(User user) {
        List<UserRole> sysUserRoles = Arrays.stream(user.getRoleIds())
                .map(roleId -> new UserRole(user.getId(), roleId)).collect(Collectors.toList());
        userRoleService.saveBatch(sysUserRoles);
    }
}
```

第十一步: 在Start-admin工程的controller目录新建UserController类，写入如下，是新增用户的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/10 0010 19:59
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    //--------------------------------查询用户列表-------------------------------------

    @GetMapping("/list")
    public ResponseResult list(User user, Integer pageNum, Integer pageSize) {
        return userService.selectUserPage(user,pageNum,pageSize);
    }


    @PostMapping
    public ResponseResult add(@RequestBody User user) {
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        if (!userService.checkUserNameUnique(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (!userService.checkPhoneUnique(user)){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }
        if (!userService.checkEmailUnique(user)){
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        return userService.addUser(user);
    }
}
```

第十二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第十三步: 测试。运行Start-admin工程的BlogAdminApplication类

第十四步: 打开vue前端项目，在浏览器的 '用户管理' 页面测试点击 '新增'，是否能新增用户

![img](未命名/__项目/assets/1693034038428-d2975508-4a25-45da-a811-623eb3d75645.jpg)

![img](未命名/__项目/assets/1693034038542-6af13e4a-60e4-4a9b-a65b-45bec928d019.jpg)

![img](未命名/__项目/assets/1693034038667-65b3de73-cc70-48a0-8fd4-43717557ced9.jpg)

## 3. 删除用户

### 一、接口分析

删除固定的某个用户，注意是逻辑删除。不能删除当前操作的用户

| 请求方式 | 请求路径               | 是否需求token头 |
| -------- | ---------------------- | --------------- |
| DELETE   | /system/user/{userIds} | 是              |

请求参数:

```plain
userIds：要删除的用户id
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-admin工程的UserController类修改为如下，增加了删除用户的实现代码

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.UserService;
import com.Start.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 19:59
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    //--------------------------------查询用户列表-------------------------------------

    @GetMapping("/list")
    public ResponseResult list(User user, Integer pageNum, Integer pageSize) {
        return userService.selectUserPage(user,pageNum,pageSize);
    }


    @PostMapping
    public ResponseResult add(@RequestBody User user) {
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        if (!userService.checkUserNameUnique(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (!userService.checkPhoneUnique(user)){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }
        if (!userService.checkEmailUnique(user)){
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        return userService.addUser(user);
    }

    //--------------------------------删除用户--------------------------------------

    @DeleteMapping("/{userIds}")
    public ResponseResult remove(@PathVariable List<Long> userIds) {
        if(userIds.contains(SecurityUtils.getUserId())){
            return ResponseResult.errorResult(500,"不能删除当前你正在使用的用户");
        }
        userService.removeByIds(userIds);
        return ResponseResult.okResult();
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-admin工程的BlogAdminApplication类

第四步: 打开vue前端项目，在浏览器的 '用户管理' 页面测试删除用户功能

![img](未命名/__项目/assets/1693034038786-cb8e088b-1483-4dfc-9c47-f5f17d49395a.jpg)

![img](未命名/__项目/assets/1693034038902-bfd82df9-3db7-4d44-8a4e-cc83ffaf58d1.jpg)

## 4. 修改用户

需要提供修改用户的功能。修改用户时可以修改用户所关联的角色

### 一、接口分析

①根据id查询用户信息

| 请求方式 | 请求路径              | 是否需求token头 |
| -------- | --------------------- | --------------- |
| Get      | /system/user/{userId} | 是              |

请求参数:

```plain
userId: 用户id
```

响应格式如下，roleIds表示用户所关联的角色id列表、roles表示所有角色的列表、user表示用户信息:

```json
{
	"code":200,
	"data":{
		"roleIds":[
			"11"
		],
		"roles":[
			{
				"createBy":"0",
				"createTime":"2023-08-10 18:46:19",
				"delFlag":"0",
				"id":"1",
				"remark":"超级管理员",
				"roleKey":"admin",
				"roleName":"超级管理员",
				"roleSort":"1",
				"status":"0",
				"updateBy":"0"
			},
			{
				"createBy":"0",
				"createTime":"2023-08-10 18:46:19",
				"delFlag":"0",
				"id":"2",
				"remark":"普通角色",
				"roleKey":"common",
				"roleName":"普通角色",
				"roleSort":"2",
				"status":"0",
				"updateBy":"0",
				"updateTime":"2023-08-11 06:32:58"
			}
		],
		"user":{
			"email":"weq@2132.com",
			"id":"用户id",
			"nickName":"昵称",
			"sex":"0",
			"status":"0",
			"userName":"用户名"
		}
	},
	"msg":"操作成功"
}
```

②更新用户信息

| 请求方式 | 请求路径     | 是否需求token头 |
| -------- | ------------ | --------------- |
| PUT      | /system/user | 是              |

请求体:

```json
{
    "email":"weq@2132.com",
    "id":"用户id",
    "nickName":"昵称",
    "sex":"1",
    "status":"0",
    "userName":"用户名",
    "roleIds":[
        "11"
    ]
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 在Start-framework工程的dto目录新建ChangeUserStatusDto类，写入如下

```java
package com.Start.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 35238
 * @date 2023/10/26 0026 18:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeUserStatusDto {
    private Long userId;
    private String status;
}
```



第二步: 在Start-framework工程的vo目录新建UserInfoAndRoleIdsVo类，写入如下，用于把指定字段返回给前端

```java
package com.Start.vo;

import com.Start.domain.Role;
import com.Start.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 21:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAndRoleIdsVo {
    private User user;
    private List<Role> roles;
    private List<Long> roleIds;
}
```

第三步: 把Start-framework工程的RoleMapper接口修改为如下，增加了根据id查询用户信息的接口

```java
package com.Start.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.Start.domain.Role;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:32
 */
public interface RoleMapper extends BaseMapper<Role> {
    //查询普通用户的角色权限
    List<String> selectRoleKeyByOtherUserId(Long userId);
    //修改用户-①根据id查询用户信息
    List<Long> selectRoleIdByUserId(Long userId);
}
```

第四步: 把Start-framework工程的RoleMapper.xml修改为如下，增加了根据id查询用户信息的具体实现代码

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.Start.mapper.RoleMapper">
    <!--MenuMapper接口的映射文件-->
    <select id="selectRoleKeyByOtherUserId" resultType="java.lang.String">
        SELECT
            r.`role_key`
        FROM
            `sys_user_role` ur
                LEFT JOIN `sys_role` r ON ur.`role_id` = r.`id`
        WHERE
            ur.`user_id` = #{userId} AND
            r.`status` = 0 AND
            r.`del_flag` = 0
    </select>
    <!--修改用户-①根据id查询用户信息-->
    <select id="selectRoleIdByUserId" resultType="java.lang.Long">
        select r.id
        from sys_role r
                 left join sys_user_role ur on ur.role_id = r.id
        where ur.user_id = #{userId}
    </select>
</mapper>
```

第五步: 把Start-framework工程的RoleService接口修改为如下，增加了根据id查询用户信息的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
public interface RoleService extends IService<Role> {

    //查询用户的角色信息
    List<String> selectRoleKeyByUserId(Long id);

    //查询角色列表
    ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize);

    //新增角色
    void insertRole(Role role);

    //修改角色-保存修改好的角色信息
    void updateRole(Role role);

    //新增用户-①查询角色列表接口
    List<Role> selectRoleAll();

    //修改用户-①根据id查询用户信息
    List<Long> selectRoleIdByUserId(Long userId);
}
```

第六步: 把Start-framework工程的RoleServiceImpl类修改为如下，增加了根据id查询用户信息的具体实现代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.domain.RoleMenu;
import com.Start.mapper.RoleMapper;
import com.Start.service.RoleMenuService;
import com.Start.service.RoleService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/8/4 0004 13:33
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    //查询用户的角色信息
    public List<String> selectRoleKeyByUserId(Long id) {
        //判断是否是管理员，如果是，就返回集合中只需要有admin
        if(id == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }

        //否则查询对应普通用户所具有的的角色信息
        List<String> otherRole = getBaseMapper().selectRoleKeyByOtherUserId(id);

        return otherRole;
    }

    //------------------------------查询角色列表---------------------------------------

    @Override
    public ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.hasText(role.getRoleName()),Role::getRoleName,role.getRoleName());
        lambdaQueryWrapper.eq(StringUtils.hasText(role.getStatus()),Role::getStatus,role.getStatus());
        lambdaQueryWrapper.orderByAsc(Role::getRoleSort);

        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,lambdaQueryWrapper);

        //转换成VO
        List<Role> roles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(roles);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------新增角色----------------------------------------

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    @Transactional
    public void insertRole(Role role) {
        save(role);
        System.out.println(role.getId());
        if(role.getMenuIds()!=null&&role.getMenuIds().length>0){
            insertRoleMenu(role);
        }
    }

    private void insertRoleMenu(Role role) {
        List<RoleMenu> roleMenuList = Arrays.stream(role.getMenuIds())
                .map(memuId -> new RoleMenu(role.getId(), memuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenuList);
    }

    //-----------------------修改角色-保存修改好的角色信息----------------------------

    @Override
    public void updateRole(Role role) {
        updateById(role);
        roleMenuService.deleteRoleMenuByRoleId(role.getId());
        insertRoleMenu(role);
    }

    //-----------------------新增用户-①查询角色列表接口----------------------------

    @Override
    public List<Role> selectRoleAll() {
        return list(Wrappers.<Role>lambdaQuery().eq(Role::getStatus, SystemCanstants.NORMAL));
    }

    //-----------------------修改用户-①根据id查询用户信息----------------------------
    @Override
    public List<Long> selectRoleIdByUserId(Long userId) {
        return getBaseMapper().selectRoleIdByUserId(userId);
    }
}
```

第七步: 把Start-framework工程的UserService接口修改为如下，增加了更新用户信息的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:48
 */
public interface UserService extends IService<User> {
    //查询个人信息
    ResponseResult userInfo();

    //更新个人信息
    ResponseResult updateUserInfo(User user);

    //用户注册功能
    ResponseResult register(User user);

    //查询用户列表
    ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize);

    //增加用户-②新增用户
    boolean checkUserNameUnique(String userName);
    boolean checkPhoneUnique(User user);
    boolean checkEmailUnique(User user);
    ResponseResult addUser(User user);

    //修改用户-②更新用户信息
    void updateUser(User user);
}
```

第八步: 把Start-framework工程的UserServiceImpl类修改为如下，增加了更新用户信息的具体实现代码

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.domain.ResponseResult;
import com.Start.domain.User;
import com.Start.domain.UserRole;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.mapper.UserMapper;
import com.Start.service.UserRoleService;
import com.Start.service.UserService;
import com.Start.utils.BeanCopyUtils;
import com.Start.utils.SecurityUtils;
import com.Start.vo.PageVo;
import com.Start.vo.UserInfoVo;
import com.Start.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 35238
 * @date 2023/7/25 0025 17:49
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    //查询个人信息的具体代码
    public ResponseResult userInfo() {

        //获取当前用户的用户id。SecurityUtils是我们在Start-framework工程写的类
        Long userId = SecurityUtils.getUserId();

        //根据用户id查询用户信息
        User user = getById(userId);

        //封装成UserInfoVo(我们在Start-framework工程写的类)，然后返回
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    //更新个人信息的具体代码
    public ResponseResult updateUserInfo(User user) {
        //updateById是mybatisplus提供的方法
        updateById(user);
        return ResponseResult.okResult();
    }

    @Autowired
    //解密和加密用的这套算法。我们在Start-blog工程的securityConfig类里面覆盖过PasswordEncoder这个bean
    private PasswordEncoder passwordEncoder;

    @Override
    //用户注册功能的具体代码
    public ResponseResult register(User user) {

        //对前端传过来的用户名进行非空判断，例如null、""，就抛出异常
        if(!StringUtils.hasText(user.getUserName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        //密码
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        //邮箱
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        //昵称
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //手机号码
        if(!StringUtils.hasText(user.getPhonenumber())){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_NOT_NULL);
        }

        //判断用户传给我们的用户名是否在数据库已经存在。userNameExist方法是下面定义的
        if(userNameExist(user.getUserName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        //判断用户传给我们的昵称是否在数据库已经存在。NickNameExist方法是下面定义的
        if(NickNameExist(user.getNickName())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //判断用户传给我们的邮箱是否在数据库已经存在。NickNameExist方法是下面定义的
        if(EmailExist(user.getEmail())){
            //SystemException是我们写的异常类、AppHttpCodeEnum是我们写的枚举类
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }

        //经过上面的判断，可以确保用户传给我们的用户名和昵称是数据库不存在的，且相关字段都不为空。就可以存入数据库
        //注意用户传给我们的密码是明文，对于密码我们要转成密文之后再存入数据库。注意加密要和解密用同一套算法
        //在Start-blog工程的securityConfig类里面有解密算法，当时我们写了一个passwordEncoder方法，并且注入到了spring容器
        String encodePassword = passwordEncoder.encode(user.getPassword());//加密
        user.setPassword(encodePassword);
        //存入数据库。save方法是mybatisplus提供的方法
        save(user);

        //封装响应返回
        return ResponseResult.okResult();
    }

    //'判断用户传给我们的用户名是否在数据库已经存在' 的方法
    private boolean userNameExist(String userName) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的用户名跟数据库里面的用户名进行比较
        queryWrapper.eq(User::getUserName,userName);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的昵称是否在数据库已经存在' 的方法
    private boolean NickNameExist(String nickName) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的昵称跟数据库里面的昵称进行比较
        queryWrapper.eq(User::getNickName,nickName);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //'判断用户传给我们的邮箱是否在数据库已经存在' 的方法
    private boolean EmailExist(String email) {
        //要知道是否存在，首先就是根据条件去数据库查
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //拿用户写的昵称跟数据库里面的昵称进行比较
        queryWrapper.eq(User::getEmail,email);
        //如果大于0就说明从数据库查出来了，也就说明是已经存在数据库的
        boolean result = count(queryWrapper) > 0;
        //为true就说明已存在
        return result;
    }

    //--------------------------------查询用户列表-------------------------------------

    @Override
    public ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.hasText(user.getUserName()),User::getUserName,user.getUserName());
        queryWrapper.eq(StringUtils.hasText(user.getStatus()),User::getStatus,user.getStatus());
        queryWrapper.eq(StringUtils.hasText(user.getPhonenumber()),User::getPhonenumber,user.getPhonenumber());

        Page<User> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换成VO
        List<User> users = page.getRecords();
        List<UserVo> userVoList = users.stream()
                .map(u -> BeanCopyUtils.copyBean(u, UserVo.class))
                .collect(Collectors.toList());
        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(userVoList);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------新增用户-②新增用户--------------------------------

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean checkUserNameUnique(String userName) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getUserName,userName))==0;
    }

    @Override
    public boolean checkPhoneUnique(User user) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getPhonenumber,user.getPhonenumber()))==0;
    }

    @Override
    public boolean checkEmailUnique(User user) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getEmail,user.getEmail()))==0;
    }

    @Override
    @Transactional
    public ResponseResult addUser(User user) {
        //密码加密处理
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        save(user);

        if(user.getRoleIds()!=null&&user.getRoleIds().length>0){
            insertUserRole(user);
        }
        return ResponseResult.okResult();
    }

    private void insertUserRole(User user) {
        List<UserRole> sysUserRoles = Arrays.stream(user.getRoleIds())
                .map(roleId -> new UserRole(user.getId(), roleId)).collect(Collectors.toList());
        userRoleService.saveBatch(sysUserRoles);
    }

    //-----------------------------修改用户-②更新用户信息-------------------------------

    @Override
    @Transactional
    public void updateUser(User user) {
        // 删除用户与角色关联
        LambdaQueryWrapper<UserRole> userRoleUpdateWrapper = new LambdaQueryWrapper<>();
        userRoleUpdateWrapper.eq(UserRole::getUserId,user.getId());
        userRoleService.remove(userRoleUpdateWrapper);

        // 新增用户与角色管理
        insertUserRole(user);
        // 更新用户信息
        updateById(user);
    }
}
```

第九步: 把Start-admin工程的UserController类修改为如下，增加了根据id查询用户信息、更新用户信息的访问接口

```java
package com.Start.controller;

import com.Start.domain.ResponseResult;
import com.Start.domain.Role;
import com.Start.domain.User;
import com.Start.enums.AppHttpCodeEnum;
import com.Start.exception.SystemException;
import com.Start.service.RoleService;
import com.Start.service.UserService;
import com.Start.utils.SecurityUtils;
import com.Start.vo.UserInfoAndRoleIdsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 35238
 * @date 2023/8/10 0010 19:59
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    //--------------------------------查询用户列表-------------------------------------

    @GetMapping("/list")
    public ResponseResult list(User user, Integer pageNum, Integer pageSize) {
        return userService.selectUserPage(user,pageNum,pageSize);
    }


    @PostMapping
    public ResponseResult add(@RequestBody User user) {
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        if (!userService.checkUserNameUnique(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (!userService.checkPhoneUnique(user)){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }
        if (!userService.checkEmailUnique(user)){
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
        return userService.addUser(user);
    }

    //--------------------------------删除用户--------------------------------------

    @DeleteMapping("/{userIds}")
    public ResponseResult remove(@PathVariable List<Long> userIds) {
        if(userIds.contains(SecurityUtils.getUserId())){
            return ResponseResult.errorResult(500,"不能删除当前你正在使用的用户");
        }
        userService.removeByIds(userIds);
        return ResponseResult.okResult();
    }

    //-----------------------修改用户-①根据id查询用户信息-----------------------------

    @Autowired
    private RoleService roleService;

    @GetMapping(value = { "/{userId}" })
    public ResponseResult getUserInfoAndRoleIds(@PathVariable(value = "userId") Long userId) {
        List<Role> roles = roleService.selectRoleAll();
        User user = userService.getById(userId);
        //当前用户所具有的角色id列表
        List<Long> roleIds = roleService.selectRoleIdByUserId(userId);

        UserInfoAndRoleIdsVo vo = new UserInfoAndRoleIdsVo(user,roles,roleIds);
        return ResponseResult.okResult(vo);
    }

    //-------------------------修改用户-②更新用户信息--------------------------------

    @PutMapping
    public ResponseResult edit(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseResult.okResult();
    }
}
```

第十步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第十一步: 测试。运行Start-admin工程的BlogAdminApplication类

第十二步: 打开vue前端项目，在浏览器的 '用户管理' 页面测试修改用户功能

![img](未命名/__项目/assets/1693034039034-62cfaa99-d119-4a94-8a2d-ed9e9ae89c8b.jpg)

![img](未命名/__项目/assets/1693034039179-4ecb256d-3600-498d-952c-3f07368552a6.jpg)

![img](未命名/__项目/assets/1693034039316-c450e8cc-d815-4f9b-9ce7-c03fad087073.jpg)

# 博客后台模块-友链列表

## 1. 查询友链

### 一、接口分析

需要分页查询友链列表。能根据友链名称进行模糊查询。能根据状态进行查询

| 请求方式 | 请求路径           | 是否需求token头 |
| -------- | ------------------ | --------------- |
| GET      | /content/link/list | 是              |

请求参数:

```plain
pageNum: 页码

pageSize: 每页条数

name：友链名

status:状态
```

响应格式:

```json
{
	"code":200,
	"data":{
		"rows":[
			{
				"address":"https://www.baidu.com",
				"description":"描述",
				"id":"1",
                "logo":"网站头像url",
				"name":"网站名称",
				"status":"0"
			}
		],
		"total":"1"
	},
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-framework工程的LinkService接口修改为如下，增加了分页查询友链的接口

```java
package com.Start.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.Start.domain.Link;
import com.Start.domain.ResponseResult;
import com.Start.vo.PageVo;

/**
 * @author 35238
 * @date 2023/7/22 0022 14:43
 */
public interface LinkService extends IService<Link> {

    //查询友链
    ResponseResult getAllLink();

    //分页查询友链
    PageVo selectLinkPage(Link link, Integer pageNum, Integer pageSize);

}
```

第二步: 把Start-framework工程的LinkServiceImpl类修改为如下，增加了分类查询友链的具体代码实现

```java
package com.Start.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.Start.constants.SystemCanstants;
import com.Start.domain.Link;
import com.Start.domain.ResponseResult;
import com.Start.mapper.LinkMapper;
import com.Start.service.LinkService;
import com.Start.utils.BeanCopyUtils;
import com.Start.vo.LinkVo;
import com.Start.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author 35238
 * @date 2023/7/22 0022 14:43
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {

        //查询所有审核通过的友链
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        //要求查的是友链表status字段的值为0，注意SystemCanstants是我们写的一个常量类，用来解决字面值的书写问题
        queryWrapper.eq(Link::getStatus, SystemCanstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //把最后的查询结果封装成LinkListVo(我们写的实体类)。BeanCopyUtils是我们写的工具类
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);

        //封装响应返回。ResponseResult是我们在Start-framework工程的domain目录写的实体类
        return ResponseResult.okResult(linkVos);
    }

    //-----------------------------分页查询友链---------------------------------

    @Override
    public PageVo selectLinkPage(Link link, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.hasText(link.getName()),Link::getName, link.getName());
        queryWrapper.eq(Objects.nonNull(link.getStatus()),Link::getStatus, link.getStatus());

        Page<Link> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换成VO
        List<Link> categories = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(categories);
        return pageVo;
    }
}
```

第三步: 在Start-admin工程的controller目录新建LinkController类，写入如下，是分页查询友链的访问接口

```java
package com.Start.controller;

import com.Start.domain.Link;
import com.Start.domain.ResponseResult;
import com.Start.service.LinkService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/11 0011 8:46
 */
@RestController
@RequestMapping("/content/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    //-----------------------------分页查询友链---------------------------------

    @GetMapping("/list")
    public ResponseResult list(Link link, Integer pageNum, Integer pageSize) {
        PageVo pageVo = linkService.selectLinkPage(link,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }
}
```

第四步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第五步: 测试。运行Start-admin工程的BlogAdminApplication类

第六步: 打开vue前端项目，在浏览器点击 '友链管理'，看是否能分页查询出所有的友链信息

![img](未命名/__项目/assets/1693034039435-4cdc19ac-dea1-496f-a98c-508f3afcf974.jpg)

## 2. 新增友链

### 一、接口分析

需要新增友链功能

| 请求方式 | 请求路径      | 是否需求token头 |
| -------- | ------------- | --------------- |
| POST     | /content/link | 是              |

请求体:

```json
{
    "name":"网站名称",
    "description":"描述",
    "address":"https://www.baidu.com",
    "logo":"网站头像url",
    "status":"2"
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-framework工程的domain目录下的Link类修改为如下

```java
package com.Start.domain;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 友链(Link)表实体类
 *
 * @author makejava
 * @since 2023-07-22 14:39:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_link")
public class Link  {

    @TableId
    private Long id;

    private String name;

    private String logo;

    private String description;
    //网站地址
    private String address;
    //审核状态 (0代表审核通过，1代表审核未通过，2代表未审核)
    private String status;

    //字段自增
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
}
```

第二步: 把Start-admin工程的LinkController类修改为如下，增加了新增友链的具体代码实现

```java
package com.Start.controller;

import com.Start.domain.Link;
import com.Start.domain.ResponseResult;
import com.Start.service.LinkService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/11 0011 8:46
 */
@RestController
@RequestMapping("/content/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    //-----------------------------分页查询友链---------------------------------

    @GetMapping("/list")
    public ResponseResult list(Link link, Integer pageNum, Integer pageSize) {
        PageVo pageVo = linkService.selectLinkPage(link,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------增加友链----------------------------------

    @PostMapping
    public ResponseResult add(@RequestBody Link link){
        linkService.save(link);
        return ResponseResult.okResult();
    }
}
```

第三步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第四步: 测试。运行Start-admin工程的BlogAdminApplication类

第五步: 打开vue前端项目，在浏览器测试新增友链功能

![img](未命名/__项目/assets/1693034039578-648c6e52-d802-47f6-9d9c-7e5350109862.jpg)

![img](未命名/__项目/assets/1693034039779-4092e9c8-941e-4e01-be1a-bd3beff37a8f.jpg)

![img](未命名/__项目/assets/1693034039903-bbcb815b-ddcf-4530-b57a-8600849d6391.jpg)

## 3. 修改友链

### 一、接口分析

①根据id查询友链

| 请求方式 | 请求路径          | 是否需求token头 |
| -------- | ----------------- | --------------- |
| Get      | content/link/{id} | 是              |

请求参数:

```plain
id: 友链id
```

响应格式:

```json
{
	"code":200,
	"data":{
		"address":"网站头像url",
		"description":"描述",
		"id":"4",
		"logo":"网站头像url",
		"name":"网站名称",
		"status":"2"
	},
	"msg":"操作成功"
}
```

②修改友链状态

| 请求方式 | 请求路径                  | 是否需求token头 |
| -------- | ------------------------- | --------------- |
| PUT      | /content/changeLinkStatus | 是              |

请求体:

```json
{
    "address":"https://www.baidu.com",
    "description":"描述",
    "id":"2",
    "logo":"网站头像url",
    "name":"网站名称",
    "status":"0"
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

③修改友链

| 请求方式 | 请求路径      | 是否需求token头 |
| -------- | ------------- | --------------- |
| PUT      | /content/link | 是              |

请求体:

```json
{
    "address":"https://www.baidu.com",
    "description":"描述",
    "id":"2",
    "logo":"网站头像url",
    "name":"网站名称",
    "status":"0"
}
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-admin工程的LinkController类修改为如下，增加了修改友链的具体实现代码

```java
package com.Start.controller;

import com.Start.domain.Link;
import com.Start.domain.ResponseResult;
import com.Start.service.LinkService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/11 0011 8:46
 */
@RestController
@RequestMapping("/content/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    //-----------------------------分页查询友链---------------------------------

    @GetMapping("/list")
    public ResponseResult list(Link link, Integer pageNum, Integer pageSize) {
        PageVo pageVo = linkService.selectLinkPage(link,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------增加友链----------------------------------

    @PostMapping
    public ResponseResult add(@RequestBody Link link){
        linkService.save(link);
        return ResponseResult.okResult();
    }

    //-------------------------------修改友链---------------------------------

    @GetMapping(value = "/{id}")
    //①根据id查询友链
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        Link link = linkService.getById(id);
        return ResponseResult.okResult(link);
    }

    @PutMapping("/changeLinkStatus")
    //②修改友链状态
    public ResponseResult changeLinkStatus(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }

    @PutMapping
    //③修改友链
    public ResponseResult edit(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-admin工程的BlogAdminApplication类

第四步: 打开vue前端项目，在浏览器测试修改友链功能

![img](未命名/__项目/assets/1693034040044-5b25a880-d5c0-4da2-a100-1a868ca4509a.jpg)

![img](未命名/__项目/assets/1693034040197-45a52c91-d147-4195-ad8c-25e4aaf1534e.jpg)

![img](未命名/__项目/assets/1693034040359-0fc5267b-de04-430a-8340-385127ad2426.jpg)

第五步: 测试修改友链状态

![img](未命名/__项目/assets/1693034040503-bc9f293b-3b86-4954-b696-58270aa6cbd2.jpg)

![img](未命名/__项目/assets/1693034040661-05f90274-bbef-4f37-a6a3-7d15519a6d46.jpg)

## 4. 删除友链

### 一、接口分析

删除某个友链，注意是逻辑删除

| 请求方式 | 请求路径           | 是否需求token头 |
| -------- | ------------------ | --------------- |
| DELETE   | /content/link/{id} | 是              |

请求参数:

```plain
id：要删除的友链id
```

响应格式:

```json
{
	"code":200,
	"msg":"操作成功"
}
```

### 二、代码实现

第一步: 把Start-admin工程的LinkController类修改为如下，增加了删除友链的具体实现代码

```java
package com.Start.controller;

import com.Start.domain.Link;
import com.Start.domain.ResponseResult;
import com.Start.service.LinkService;
import com.Start.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 35238
 * @date 2023/8/11 0011 8:46
 */
@RestController
@RequestMapping("/content/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    //-----------------------------分页查询友链---------------------------------

    @GetMapping("/list")
    public ResponseResult list(Link link, Integer pageNum, Integer pageSize) {
        PageVo pageVo = linkService.selectLinkPage(link,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }

    //-------------------------------增加友链----------------------------------

    @PostMapping
    public ResponseResult add(@RequestBody Link link){
        linkService.save(link);
        return ResponseResult.okResult();
    }

    //-------------------------------修改友链---------------------------------

    @GetMapping(value = "/{id}")
    //①根据id查询友链
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        Link link = linkService.getById(id);
        return ResponseResult.okResult(link);
    }

    @PutMapping("/changeLinkStatus")
    //②修改友链状态
    public ResponseResult changeLinkStatus(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }

    @PutMapping
    //③修改友链
    public ResponseResult edit(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }

    //-------------------------------删除友链---------------------------------

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        linkService.removeById(id);
        return ResponseResult.okResult();
    }
}
```

第二步: 本地打开你的redis

```plain
d:
cd /redis
redis-server.exe redis.windows.conf
```

![img](未命名/__项目/assets/1693034011918-d1224231-b3b2-4bc1-bfef-17afe425f973.jpg)

第三步: 测试。运行Start-admin工程的BlogAdminApplication类

第四步: 打开vue前端项目，在浏览器测试删除友链功能

![img](未命名/__项目/assets/1693034040811-abae18db-4a28-48e1-8eff-c1088dfffb05.jpg)

![img](未命名/__项目/assets/1693034040963-5725929b-1e3d-42f6-bae7-ed54ded0b226.jpg)

第五步: 批量删除会报错，解决如下

~~~java
解决:
先在前端全局搜索 /content/link 关键字，然后就能找到下面的代码，
然后在link后面拼接 ?ids= 
``` 
// 删除分类
export function delLink(id) {
  return request({
    url: '/content/link?ids=' + id,
    method: 'delete'
  })
}
```

然后把后端对应接口修改为如下
```
@DeleteMapping
public ResponseResult remove(@RequestParam(value = "ids")String ids) {
    if (!ids.contains(",")) {
        linkService.removeById(ids);
    } else {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            linkService.removeById(id);
        }
    }
    return ResponseResult.okResult();
}
```
~~~

到此，全部项目结束，如果你把我上面笔记的所有代码跟着做一遍，那么你就拥有了下面的完善项目工程，才可以进行后面 '部署博客项目' 的动手实践

```plain
2个前端工程，分别是sg-blog-vue(前台)、sg-vue-admin(后台)
4个后端工程，分别是SpringBootBlog(父工程)、Start-framework(子-公共模块)、Start-blog(子-前台模块)、Start-admin(子-后台模块)
1个数据库，叫sg_blog
```

# 部署博客项目-数据库打包

第一步: 在D盘新建SpringBootBlogMySQL文件夹

第二步: win+r，在弹出的命令行黑窗口输入如下，-p是数据库密码，mybolgSite.sql是输出后的文件名

```plain
mysqldump -u root -p228675 sg_blog > D:\SpringBootBlogMySQL\mybolgSite.sql
```

![img](未命名/__项目/assets/1693034041130-8a689616-d6b8-4aed-ae18-b091dfb1ebf4.jpg)

第三步: 查看SpringBootBlogMySQL文件夹，就会发现有一个mybolgSite.sql，这个就是数据库备份文件，也就是我们要的打包文件

![img](未命名/__项目/assets/1693034041258-66b101f6-bb37-4194-8ee3-e782c66fe872.jpg)

第四步: 以后要用的时候，先自己建一个名称为sg_blog的数据库，然后导入刚刚生成的myblogSite.sql文件即可

# 部署博客项目-后端项目打包

第一步: 把Start-admin(子工程)的application.yml文件修改为如下

```yaml
server:
  port: 8989
spring:
  datasource:
    url: jdbc:mysql://192.168.127.180:3306/sg_blog?characterEncoding=utf-8&serverTimezone=UTC
    username: root
    password: 228675
    driver-class-name: com.mysql.cj.jdbc.Driver

  servlet:
    # 文件上传
    multipart:
      # 单个上传文件的最大允许大小
      max-file-size: 20MB
      # HTTP请求中包含的所有文件的总大小的最大允许值
      max-request-size: 20MB

  redis:
    host: 192.168.127.180
    port: 6379


mybatis-plus:
  configuration:
    # 日志
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      logic-delete-field: delFlag
      logic-delete-value: 1
      logic-not-delete-value: 0
      id-type: auto

# 打开七牛云，找到密钥管理，把相关信息填写到下面3行，会被Start-blog工程的OOSTest类获取
myoss:
  xxaccessKey: _ibGP9wytjLCAZPqcFaWQNxbw7fMUvofSOvOFFR3
  xxsecretKey: QSOAU-cv3sSDGNfVNPF6iXz-PsP5X9QTrjFI9zYw
  xxbucket: Start-blog
```

第二步: 把Start-blog(子工程)的application.yml文件修改为如下

```yaml
server:
  port: 7777

spring:
  # 数据库连接信息
  datasource:
    url: jdbc:mysql://192.168.127.180:3306/sg_blog?characterEncoding=utf-8&serverTimezone=Asia/Shanghai
    username: root
    password: 228675
    driver-class-name: com.mysql.cj.jdbc.Driver

  servlet:
    # 文件上传
    multipart:
      # 单个上传文件的最大允许大小
      max-file-size: 20MB
      # HTTP请求中包含的所有文件的总大小的最大允许值
      max-request-size: 20MB

  # springboot 2.6版本之后需要配置ant_path_matcher才能生使swagger生成接口文档
  # 我们目前的springboot版本是2.5.0，不需要配置ant_path_matcher也可正常使用swagger
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher

  redis:
    host: 192.168.127.180
    port: 6379
mybatis-plus:
#  configuration:
#    # 日志
#    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      # 逻辑删除的字段
      logic-delete-field: delFlag
      # 代表已删除的值
      logic-delete-value: 1
      # 代表未删除的值
      logic-not-delete-value: 0
      # 主键自增策略，以mysql数据库为准
      id-type: auto

# 打开七牛云，找到密钥管理，把相关信息填写到下面3行，会被Start-blog工程的OOSTest类获取
myoss:
  xxaccessKey: _ibGP9wytjLCAZPqcFaWQNxbw7fMUvofSOvOFFR3
  xxsecretKey: QSOAU-cv3sSDGNfVNPF6iXz-PsP5X9QTrjFI9zYw
  xxbucket: Start-blog
```

第三步: 把SpringBootBlog(父工程)的pom.xml文件修改为如下，然后刷新

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.Start</groupId>
    <artifactId>SpringBootBlog</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>

    <!--maven的模块聚合，好处就是打包的时候，多个子模块会跟父模块一起打包-->
    <modules>
        <module>Start-framework</module>
        <module>Start-admin</module>
        <module>Start-blog</module>
    </modules>

    <!--编码方式、jdk版本-->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
    </properties>

    <!--依赖的版本控制-->
    <dependencyManagement>
        <dependencies>
            <!-- SpringBoot的依赖配置-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.5.0</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!--fastjson依赖-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
                <version>1.2.33</version>
            </dependency>
            <!--jwt依赖-->
            <dependency>
                <groupId>io.jsonwebtoken</groupId>
                <artifactId>jjwt</artifactId>
                <version>0.9.0</version>
            </dependency>
            <!--mybatisPlus依赖-->
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-Starter</artifactId>
                <version>3.4.3</version>
            </dependency>

            <!--阿里云OSS-->
            <dependency>
                <groupId>com.aliyun.oss</groupId>
                <artifactId>aliyun-sdk-oss</artifactId>
                <version>3.10.2</version>
            </dependency>


            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>easyexcel</artifactId>
                <version>3.0.5</version>
            </dependency>

            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>2.9.2</version>
            </dependency>
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger-ui</artifactId>
                <version>2.9.2</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
            </plugin>
            <!-- 此插件必须放在父 POM 中  -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.3.0</version>
                <executions>
                    <!--
                    执行本插件的方法为，在主目录下执行如下命令：
                    mvn package assembly:single

                    对于 IntelliJ IDEA，生成的 JAR 包位于每个模块下的文件夹 target
                    -->
                    <execution>
                        <id>make-assembly</id>
                        <phase>package</phase>
                        <goals>
                            <!-- 此处 IntelliJ IDEA 可能会报红，这是正常现象  -->
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <archive>
                        <manifest>
                            <!-- 配置程序运行入口所在的类 -->
                            <mainClass>com.Start.StartBlogApplication</mainClass>
                        </manifest>
                        <manifest>
                            <!-- 配置程序运行入口所在的类 -->
                            <mainClass>com.Start.BlogAdminApplication</mainClass>
                        </manifest>
                    </archive>
                    <!-- 设置 JAR 包输出目录 -->
                    <outputDirectory>${project.build.directory}/#maven-assembly-plugin</outputDirectory>
                    <!-- 设置打包后的 JAR 包的目录结构为默认 -->
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```

第四步: 把Start-blog(子工程)的pom.xml文件修改为如下，然后刷新

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringBootBlog</artifactId>
        <groupId>com.Start</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Start-blog</artifactId>

    <!--用Start-framework模块里面的依赖-->
    <dependencies>
        <dependency>
            <groupId>com.Start</groupId>
            <artifactId>Start-framework</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.5.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
        <finalName>${project.artifactId}</finalName>
    </build>

</project>
```

第五步: 把Start-admin(子工程)的pom.xml文件修改为如下，然后刷新

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringBootBlog</artifactId>
        <groupId>com.Start</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Start-admin</artifactId>

    <!--用Start-framework模块里面的依赖-->
    <dependencies>
        <dependency>
            <groupId>com.Start</groupId>
            <artifactId>Start-framework</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.5.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
        <finalName>${project.artifactId}</finalName>
    </build>

</project>
```

第六步: 打开父工程所在的目录，导航栏输入cmd回车会弹出一个黑窗口

![img](未命名/__项目/assets/1693034041373-c0d0e0e5-8e5c-4d80-a60f-637bf8d3575a.jpg)

第七步: 在黑窗口输入如下，即可得到Start-admin、Start-blog工程的jar包。当然也得到了Start-framework工程的jar包(这个jar包用不上)

```plain
mvn package assembly:single
```

![img](未命名/__项目/assets/1693034041493-9dec370b-42cc-4a99-bf7a-bde1193b776c.jpg)

第八步: 测试jar包。只需要输入如下，即可测试Start-admin或Start-blog工程的jar包，建议测试Start-admin工程的jar包，会比较方便

注意: 由于Start-blog在启动时必须要开redis，如果是测试Start-blog工程的jar包，那么你必须先开启redis

```plain
java -jar Start-admin.jar
```

![img](未命名/__项目/assets/1693034041632-a3add617-2fca-4933-8af7-74d3dbdddb31.jpg)

# 部署博客项目-前端项目打包

第一步: 把sg-blog-vue(前台)项目的config目录下的index.js文件，port属性值从8080改为8093

![img](未命名/__项目/assets/1693034041769-d6c5c162-b1c5-47f0-b81c-16203dc32cd8.jpg)

第二步: 把sg-vue-admin(后台)项目的vue.config.js文件的port值从81改为8094

![img](未命名/__项目/assets/1693034041905-cf64cbaf-83fd-43db-a962-1426d6985680.jpg)

第三步: 把sg-blog-vue\src\vue.config.js文件，里面的localhost改为服务器ip

![img](未命名/__项目/assets/1693034042060-dddb3836-45ed-43de-8d40-e4d95e9091d3.jpg)

第四步: 把sg-blog-vue\src\store\index.js文件，里面的localhost改为服务器ip

![img](未命名/__项目/assets/1693034042201-81359c5d-9579-4c7a-b49a-3259d0959904.jpg)

第五步: 把sg-blog-vue的.env.development文件，里面的localhost改为服务器ip，注意端口是8989

![img](未命名/__项目/assets/1693034042318-35eacd8d-8a93-4d10-aa5b-9495cb45c5fb.jpg)

第六步: 把sg-blog-vue的.env.production文件，里面的localhost改为服务器ip，注意端口是8989

![img](未命名/__项目/assets/1693034042432-42400c8c-5379-4321-8935-c14f1077b4a0.jpg)

第七步: 把sg-vue-admin的vue.config.js文件，里面的localhost改为服务器ip，注意端口是8989

![img](未命名/__项目/assets/1693034042536-bce952b0-989f-4957-8673-b283a769db52.jpg)

第八步: 把sg-vue-admin的.env.development文件，里面的localhost改为服务器ip，注意端口是8989

注意写/dev-api就不会有"分类导出"的bug，写服务器ip会有bug。但是要上线就必须按照下面那行写服务器ip

解决方法: 前端端口跟后端端口一致(这里演示采取的是不一致，也就是8094和8989)，且前端和后端部署在不同服务器里面(这里演示采取的是相同，也就是192.168.127.180)

不解决也没事，就是管理后台的分类导出功能出问题，写成/dev-api起码本地运行的时候这个导出功能是正常的

![img](未命名/__项目/assets/1693034042662-1c3f4478-e4ad-43fb-a688-44f6523a1692.jpg)

第九步: 把sg-vue-admin的.env.production文件，里面的localhost改为服务器ip，注意端口是8989

注意写/prod-api就不会有"分类导出"的bug，写服务器ip会有bug。但是要上线就必须按照下面那行写服务器ip

解决方法: 前端端口跟后端端口一致(这里演示采取的是不一致，也就是8094和8989)，且前端和后端部署在不同服务器里面(这里演示采取的是相同，也就是192.168.127.180)

不解决也没事，就是管理后台的分类导出功能出问题，写成/dev-api起码本地运行的时候这个导出功能是正常的

![img](未命名/__项目/assets/1693034042791-bc7e85e4-06a7-463c-8bd2-48ba3c0db6f0.jpg)

第十步: 把sg-vue-admin\src\router\index.js文件修改为如下

```plain
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'dashboard' }
    }]
  },
  {
    path: '/write',
    component: Layout,
    children: [{
      path: '/',
      name: 'Write',
      component: () => import('@/views/content/article/write/index'),
      hidden: true
    }]
  },
  {
    path: '/system/user',
    component: Layout,
    children: [{
      path: '/',
      name: 'User',
      component: () => import('@/views/system/user'),
      hidden: true
    }]
  },
  {
    path: '/system/role',
    component: Layout,
    children: [{
      path: '/',
      name: 'role',
      component: () => import('@/views/system/role'),
      hidden: true
    }]
  },
  {
    path: '/system/menu',
    component: Layout,
    children: [{
      path: '/',
      name: 'menu',
      component: () => import('@/views/system/menu'),
      hidden: true
    }]
  },
  {
    path: '/system/role',
    component: Layout,
    children: [{
      path: '/',
      name: 'role',
      component: () => import('@/views/system/role'),
      hidden: true
    }]
  },
  {
    path: '/content/article',
    component: Layout,
    children: [{
      path: '/',
      name: 'article',
      component: () => import('@/views/content/article/index'),
      hidden: true
    }]
  },
  {
    path: '/content/category',
    component: Layout,
    children: [{
      path: '/',
      name: 'category',
      component: () => import('@/views/content/category/index'),
      hidden: true
    }]
  },
  {
    path: '/content/link',
    component: Layout,
    children: [{
      path: '/',
      name: 'link',
      component: () => import('@/views/content/link/index'),
      hidden: true
    }]
  },
  {
    path: '/content/tag',
    component: Layout,
    children: [{
      path: '/',
      name: 'tag',
      component: () => import('@/views/content/tag/index'),
      hidden: true
    }]
  }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
```

第十一步: 把sg-vue-admin\src\main.js文件，注释掉下面的内容

![img](未命名/__项目/assets/1693034042934-f3d32752-bf70-4721-8f19-051a42f107b6.jpg)

第十二步: 在sg-blog-vue项目的终端执行如下

```shell
npm run build
```

![img](未命名/__项目/assets/1693034043068-94866fa2-bd30-4374-9307-2d944614d6f5.jpg)

![img](未命名/__项目/assets/1693034043295-4805f66f-30fd-4df7-b76a-12fa5da0b7dd.jpg)

第十三步: 在sg-vue-admin项目的终端执行如下

```shell
npm run build:prod
```

![img](未命名/__项目/assets/1693034043437-b6a25482-2f17-44b4-96e4-3467adb647d5.jpg)

![img](未命名/__项目/assets/1693034043610-5c84cae9-9760-4972-bd49-7f85ef1308bb.jpg)

第十四步: 检查打包目录是否生成

![img](未命名/__项目/assets/1693034043756-4071e4ef-f9b1-44c0-bfe4-dd5530b87107.jpg)

# 部署博客项目-服务器部署

## 1. 开放防火墙

```shell
firewall-cmd --zone=public --add-port=80/tcp --permanent
firewall-cmd --zone=public --add-port=7777/tcp --permanent
firewall-cmd --zone=public --add-port=8989/tcp --permanent
firewall-cmd --zone=public --add-port=6379/tcp --permanent
firewall-cmd --zone=public --add-port=3306/tcp --permanent
firewall-cmd --zone=public --add-port=8093/tcp --permanent
firewall-cmd --zone=public --add-port=8094/tcp --permanent

systemctl reStart firewalld.service # 重启防火墙
```

## 2. 开放安全组

![img](未命名/__项目/assets/1693034043889-f3420efb-c04e-4ace-a458-25dcf46e3ced.jpg)

## 3. Docker安装

```plain
yum -y install gcc
yum -y install gcc-c++
yum install -y yum-utils
yum install vim
yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
yum makecache fast
yum install docker-ce docker-ce-cli containerd.io docker-compose-plugin
systemctl Start docker
docker version
```

![img](未命名/__项目/assets/1693034044002-136e7794-a7d2-4bf6-b1cd-3f46b47c4aba.jpg)

## 4. 拉取镜像

```shell
docker pull openjdk:8
docker pull mysql:8.0.19
docker pull redis:6.0.8
docker pull nginx:1.18.0

docker images # 查看有哪些镜像
```

![img](未命名/__项目/assets/1693034044165-28762c03-d0a8-4040-b763-ab002bf0c000.jpg)

## 5. 构建镜像

第一步: 在/root目录(主目录)新建mydata目录，将Start-admin.jar包和Start-blog.jar包传到这个mydata目录里面

```shell
pwd # 显示当前所在目录
mkdir mydata # 创建mydata目录
cd # 先回到主目录
cd mydata && ll # 查看mydata目录里面是否有Start-admin.jar包和Start-blog.jar包
```

![img](未命名/__项目/assets/1693034044301-7043d241-4d83-45f4-bebe-87e5c68fade4.jpg)

第二步: 在mydata目录新建Dockerfile文件，写入如下

```shell
cd
cd mydata
touch Dockerfile
vim Dockerfile
# 基础镜像使用jdk1.8
FROM openjdk:8
# 作者
MAINTAINER xha
# VOLUME 指定临时文件目录为/tmp，在主机/var/lib/docker目录下创建了一个临时文件并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名
ADD Start-blog.jar Start_blog.jar
# 运行jar包
RUN bash -c 'touch /Start_blog.jar'
ENTRYPOINT ["java","-jar","/Start_blog.jar"]
#暴露7777端口作为微服务
EXPOSE 7777
```

第三步: 在mydata目录执行如下，作用是构建Start-blog.jar包的镜像，构建出来的镜像名为sangeng_blog

```shell
docker build -t sangeng_blog:1.0 .
```

![img](未命名/__项目/assets/1693034044430-74a2cb2e-a697-4190-8ad8-cd46f8716b98.jpg)

第四步: 把mydata目录下的Dockerfile文件修改为如下

```dockerfile
# 基础镜像使用jdk1.8
FROM openjdk:8
# 作者
MAINTAINER xha
# VOLUME 指定临时文件目录为/tmp，在主机/var/lib/docker目录下创建了一个临时文件并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名
ADD Start-admin.jar Start_admin.jar
# 运行jar包
RUN bash -c 'touch /Start_admin.jar'
ENTRYPOINT ["java","-jar","/Start_admin.jar"]
#暴露8989端口作为微服务
EXPOSE 8989
```

第五步: 在mydata目录执行如下，作用是构建Start-admin.jar包的镜像，构建出来的镜像名为sangeng_admin

```shell
docker build -t sangeng_admin:1.0 .
```

![img](未命名/__项目/assets/1693034044578-fe5c2945-1032-4f99-8f9c-a56948e80a8b.jpg)

第六步: 检查是否构建出sangeng_blog和sangeng_admin镜像

```shell
docker images
```

![img](未命名/__项目/assets/1693034044746-057a442a-9bb9-4f6a-af7b-fddfcb7eca22.jpg)

## 6. 创建容器

第一步: 查看Docker-compose版本，如果你是按照我上面安装的docker，那么你肯定会有Docker-compose

```shell
docker compose version
```

第二步: 在mydata目录新建docker-compose.yml文件，写入如下

```shell
cd
cd mydata
touch docker-compose.yml
vim docker-compose.yml
#compose版本
version: "3"  
 

services:
  sangeng_blog:
#微服务镜像  
    image: sangeng_blog:1.0
    container_name: sangeng_blog
    ports:
      - "7777:7777"
#数据卷
    volumes:
      - /app/sangeng_blog:/data/sangeng_blog
    networks: 
      - blog_network
    depends_on: 
      - redis
      - mysql
      - nginx


  sangeng_admin:
#微服务镜像
    image: sangeng_admin:1.0
    container_name: sangeng_admin
    ports:
      - "8989:8989"
#数据卷
    volumes:
      - /app/sangeng_admin:/data/sangeng_admin
    networks:
      - blog_network
    depends_on:
      - redis
      - mysql
      - nginx
     
#redis服务
  redis:
    image: redis:6.0.8
    ports:
      - "6379:6379"
    volumes:
      - /app/redis/conf/redis.conf:/etc/redis/redis.conf
      - /app/redis/data:/data
    networks: 
      - blog_network
    command: redis-server /etc/redis/redis.conf
 
 #mysql服务
  mysql:
    image: mysql:8.0.19
    environment:
      MYSQL_ROOT_PASSWORD: '228675'
      MYSQL_ALLOW_EMPTY_PASSWORD: 'no'
      MYSQL_DATABASE: 'sg_blog'
      MYSQL_USER: 'root'
      MYSQL_PASSWORD: '228675'
    ports:
       - "3306:3306"
    volumes:
       - /app/mysql/db:/var/lib/mysql
       - /app/mysql/conf/my.cnf:/etc/my.cnf
       - /app/mysql/init:/docker-entrypoint-initdb.d
    networks:
      - blog_network
    command: --default-authentication-plugin=mysql_native_password #解决外部无法访问

 #nginx服务
  nginx:
    image: nginx:1.18.0
    ports:
      - "80:80"
      - "8093:8093"
      - "8094:8094"
    volumes:
      - /app/nginx/html:/usr/share/nginx/html
      - /app/nginx/logs:/var/log/nginx
      - /app/nginx/conf:/etc/nginx
    networks:
      - blog_network
    

 
 #创建自定义网络
networks: 
   blog_network:
```

第三步: 输入如下，作用是检查docker-compose.yml文件有没有语法错误，如果输入之后没任何输出，就说明没有语法错误

```shell
cd
cd mydata
docker compose config -q
```

![img](未命名/__项目/assets/1693034044862-aa1bc8c5-e76f-48be-ac46-57c58cf83779.jpg)

如果你写的docker-compose.yml文件有语法错误，那么就直接用我写好的，下载链接如下

```java
docker-compose.yml文件下载: https://share.feijipan.com/s/TiAnfiMz
```

第四步: 运行docker-compose.yml文件，就可以创建并运行java容器、mysql容器、redis容器、nginx容器。-d表示后台运行

```shell
docker compose up -d
docker ps #查看正在运行的容器
```

![img](未命名/__项目/assets/1693034044974-29c9e778-e98c-4404-946c-807c2edc4209.jpg)

## 7. 导入数据库

第一步: 把前面在 '部署博客项目-数据库打包' 那里拿到的 'mybolgSite.sql' 文件上传到服务器的 /app/mysql/db 目录

如果没有'mybolgSite.sql' 文件，就直接用我的，下载链接: https://share.feijipan.com/s/6qAnfkTf

```shell
ll /app/mysql/db # 查看目录里面有没有'mybolgSite.sql'文件
```

![img](未命名/__项目/assets/1693034045137-a3d18b66-0abc-4d42-ae43-5e32a6f65340.jpg)

第二步: 如何查看容器ID，每个人的容器ID都是不同的，以你的为准

```plain
docker ps -a
```

![img](未命名/__项目/assets/1693034045307-555ca82f-539b-4b20-87fe-c45801e1ed1d.jpg)

第三步: 进入MySQL容器内部，执行导入sql文件的操作

```shell
docker Start mydata-mysql-1 # 启动mysql容器
docker exec -it 容器ID bash # 进入mysql容器内部
# 下面的是执行导入sql文件的操作，必须要进入了mysql容器内部才能执行如下命令，mysql的登录密码是228675
mysql -u root -p
228675
use sg_blog;
source /var/lib/mysql/mybolgSite.sql;
show tables;
```

![img](未命名/__项目/assets/1693034045437-66556f78-bb36-4187-9fff-5e117d54afdd.jpg)

![img](未命名/__项目/assets/1693034045599-dffadeea-1a5e-44b3-9a7e-a1ae9a03cbfa.jpg)

第四步: 退出MySQL容器内部

```shell
exit # 退出MySQL
exit # 退出MySQL容器
```

![img](未命名/__项目/assets/1693034045740-6bc7446e-8bdc-435e-a27c-ff12dc783e5f.jpg)

## 8. 配置Redis

第一步: 进入 /app/redis/redis.conf 目录下，新建redis.conf文件，写入如下，注意不需要把配置写完全，redis有自己的默认配置

```shell
cd /app/redis/redis.conf
touch redis.conf
vim redis.conf
bind 0.0.0.0
daemonize no
protected-mode no
```

第二步: 启动所有容器。nginx容器启动不了没关系，现在还没配置nginx

```shell
systemctl Start docker # 启动docker
docker ps -a # 查看容器ID
docker reStart 容器ID # 重新启动所有容器
docker ps # 查看实际启动的容器
```

![img](未命名/__项目/assets/1693034045872-f15cb245-83ae-4619-ba6f-7e711da5e69d.jpg)

## 9. 配置Nginx

第一步: 下载conf.zip文件，下载链接如下，解压后是conf文件夹，把conf文件夹里面的所有文件，上传到服务器的 /app/nginx 目录下，注意/app/nginx目录里面已有一个conf目录，也就是替换掉这个conf即可

```plain
conf.zip文件下载: https://share.feijipan.com/s/TYAnffH4
```

其中conf文件夹里面有个nginx文件，文件的内容如下

```nginx
#user  nobody;
worker_processes  1;

events {
    worker_connections  1024;
}

http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
    keepalive_timeout  65;

    server {
        listen       8093;
        server_name  localhost;
              location / {
                     root   /usr/share/nginx/html/blog_dist;
                     index  index.html index.htm;
                     try_files $uri $uri/ /index.html;
                   }

        }

    server {
        listen       8094;
        server_name  localhost;

              location / {
                     root   /usr/share/nginx/html/admin_dist;
                     index  index.html index.htm;
                     try_files $uri $uri/ /index.html;
                   }

        }
}
```

第二步: 把前面在 '部署博客项目-前端项目打包'，我们在sg-blog-vue项目下有一个dist文件夹、在sg-vue-admin项目下有一个dist文件夹，如下图

![img](未命名/__项目/assets/1693034046033-2e9315db-b515-4257-a672-3a0bc0890902.jpg)

第三步: 将两个dist文件夹分别重命名为admin_dist、blog_dist，然后上传到服务器的 /app/nginx/html 目录下

![img](未命名/__项目/assets/1693034046180-20e92bcf-1639-4e8b-ae7d-2c75bdf0958c.jpg)

第四步: 启动所有容器。注意，这次nginx容器是可以正常启动的，并且全部容器都是正常启动的

```shell
systemctl Start docker # 启动docker
docker ps -a # 查看容器ID
docker reStart 容器ID # 重新启动所有容器
docker ps # 查看实际启动的容器
```

![img](未命名/__项目/assets/1693034046308-fd641b8b-25a0-4e84-90dd-98a41eb872b3.jpg)

到此就结束了所有部署相关的操作。我的b站账号: 涣沷a靑惷。如果您愿意对我进行赞赏，那么私信我可获得如下解压密码

如果你全程从写下第一行代码，到部署都是跟着我的笔记完成，那么下面的完整资源你其实也有一份，所以下面的资源仅提供给除你我之外的人

```shell
上述演示的'部署博客项目'的完整资源: https://cowtransfer.com/s/2a2044e136d740 # 下载后需解压密码才可打开
```

部署操作结束之后，就可以到网站访问所有效果了，效果展示如下

## 10. 效果展示

前台地址:

```plain
http://192.168.127.180:8093
```

![img](未命名/__项目/assets/1693034046489-2a0dfbcd-b3ed-4390-a5e1-d5b6be4593ce.jpg)

后台地址:

```plain
http://192.168.127.180:8094
```

![img](未命名/__项目/assets/1693034046637-aa06bb6c-6f18-4561-8d48-db2dca253c11.jpg)

# 完结撒花

## readme

关于个人博客的知识全部学习完毕，以上所有笔记由b站up主 涣沷a靑惷 所写，如有错误请在社交平台(评论区或私信)指出，该笔记中，我也在相应的笔记位置给出了快速下载的链接，以便于大家下载所需软件或配置资源，若失效请联系我及时上传补充

该笔记对标的视频是BV1hq4y1F7zk，拿着这个BV号在b站搜索就能搜到

我会把该笔记分享到个人网站、语雀。欢迎大家前来学习，该笔记中如若出现技术问题、错别字等各种问题，请联系我，我会及时进行修改

个人网站: [https://Startqc.cn](https://Startqc.cn/)，累了就来这听听歌

个人博客: [https://Start.top](https://Start.top/)，你能发现哪些小彩蛋?

个人博客管理后台: http://Start.top:8444/ (用户名: HFuser，密码: 123)

个人博客前台swagger接口文档: https://Start.top:7447/swagger-ui.html#/

语雀: https://www.yuque.com/Startqc/my-blog，很不错的在线知识管理平台

本人暑假后就是大三，该笔记写了26天共10万字，具体是2023年7月18日~8月12日，实际共耗时25天，另外用了1天时间写部署的笔记。笔记记录了每一个完整的知识点，从资源下载、环境配置、项目搭建、具体代码、测试验证、项目部署上线等各个步骤。每一步骤都有非常详细的截图

在写笔记的过程中，所有的项目工程都已经打包，赞赏可全部拿走。如果你跟着我的笔记，完全可以写一份一样的出来，赞赏拿到的功能跟我线上的功能一致(有额外功能)，请先到线上查看效果，线上地址 https://Start.top

```shell
获取源码需要赞赏39r，然后在b站私信发付款截图即可，一天内我会给你源码
赞赏地址: https://Start.top/#/Reward
```

还有累积到200多MB的本地仓库，可以在这个仓库找到笔记中所有出现的坐标，下载链接如下

```shell
https://share.feijipan.com/s/NBAnfy69
```

接下来会学习 23种设计模式，在学习中我会把过程写成笔记，期待我下一篇关于 23种设计模式 的笔记吧