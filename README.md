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


## 数据结构设计
User

CheckLog

DietLog

DietPlan

GluLog

GluPlan

HealthFile

HealthLog

MedicineLog

MedicinePlan

SportItem

SportLog

SportPlan

WeightLog

WeightPlan


## 接口功能


## 后端上线服务器

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







