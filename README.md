# 糖肝共管_后端


## 项目简介
  基于临床指南以及专家意见设计并实现糖肝共管路径，为糖尿病、脂肪肝患者及医生提供健康管理服务。

## 环境配置
SpringBoot 2.6.13

JDK 1.8

## 引入依赖
Spring Web

Spring JDBC

Spring JPA

Lombok

MYSQL(version 5.7.33)

### 问题汇总

*1.创建项目时初始化，maven下载依赖包特别慢*

解决方法：

配置镜像国内镜像，参考：https://blog.csdn.net/fengyuyeguirenenen/article/details/123621163


## 数据结构设计
User

用户信息

CheckLog

检查报告记录

DietLog

饮食记录

DietPlan

饮食目标、饮食计划

GluLog

血糖记录

GluPlan

血糖目标、血糖计划

HealthFile

健康档案

HealthLog

健康指标记录

MedicineLog

药物记录

MedicinePlan

药物方案

SportItem

运动项目

SportLog

运动记录

SportPlan

运动计划、运动目标

WeightLog

体重记录

WeightPlan

减重计划、减重目标

## 接口功能

## 后端上线服务器

### 上线流程

软件：

XShell:远程连接服务器

XFtp：远程传输文件

服务器：

阿里云服务器 

操作系统 CentOs

参考链接：https://developer.aliyun.com/article/1283130

Jar包可在本地打包并上传至服务器。

先在本地以及服务器进行测试:Java -jar xxx.jar 查看是否可以成功运行


### 防火墙以及出入站规则

部署完成后外网依旧访问不到。检查以下内容：

*服务器中，端口对应的防火墙是否已经关闭？*

*设定服务器的安全组：入站和出站规则*

### 问题汇总
*1.高版本JAVA能否运行在低版本生产环境？*

不可以。JAVA是向后兼容的，也就是低版本的可以在高版本环境下运行，反之不成立。

*2.从高版本的JAVA转到低版本（JAVA 17-JAVA 8）需要做哪些改变？*

SprintBoot版本：原SpringBoot版本为3.2.1。Spring Boot 3.0 使用 Java 17作为最低版本。使用Java 8 只能采用SpringBoot2。

JAVA版本：降低版本后部分类包需要进行更改，包括：

jakarta.* 更改为javax.*

这是由于Springboot内嵌的Tomcat容器版本的兼容性决定的。改为jdk8后，内嵌的tomcat版本降低了，不支持jakarta，所以只能把jakarta全部换成javax。

*3.如何在本地服务器上打包jar包？*

两种方法。

一种是使用IntelliJ IDEA的构建工具，生成out文件，jar包在内。

一种是使用mvn install指令。

*4.打包中出现的问题？*

打包完成之后运行java -jar xxx.jar，出现了以下问题：

*提示没有manifest主清单或主类属性*

解决方式见https://cloud.tencent.com/developer/article/1764737

使用maven打包时，pom.xml配置如下：

```
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>${spring-boot.version}</version>
                <configuration>
                    <mainClass>zjubiomedit.mafld_backend.MafldBackendApplication</mainClass>
                </configuration>
                <executions>
                    <execution>
                        <id>repackage</id>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```
解析：

```
<version>3.8.1</version>
<configuration>
    <source>1.8</source>
    <target>1.8</target>
    <encoding>UTF-8</encoding>
</configuration>
```

指明maven版本、源代码Java版本、目标Java版本

使用SpringBoot内嵌的maven，否则可能会出现版本问题。

```<mainClass>zjubiomedit.mafld_backend.MafldBackendApplication</mainClass>```

指明主类位置

## nginx 重定向

小程序要求安全域名必须是https开头，具备SSL证书且有域名。

现已有SSL证书和域名，要求使用nginx代理，将https的网络请求代理至本地的相应接口。

例如：当前服务运行在http://.....:8799端口。当接收到https://.....的消息时，需要将其重定向至本地的:8799端口。

参考方法：https://blog.csdn.net/gao511147456/article/details/132226072

例如，更改配置文件如下：

```
location /mafld{
  rewrite ^/mafld/(.*)$ /$1 break;
  proxy pass http://localhost:8799;
}

```

重启nginx服务后生效。

例如：

原访问接口为：http://xxx.xxx.xxx:8799/user/getpatients

则在重定向后访问接口为:https://xxx.xxx.xxx/mafld/user/getpatients












