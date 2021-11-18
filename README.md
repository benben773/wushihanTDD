# Server

## 本地环境安装

- Java JDK 1.8
- IntelliJ IDEA
- Docker
- Maven

### 技术栈

- Java
- Springboot
- MyBatis (MyBatis-Plus)
- Junit4
- JMockit
- h2
- Assertj
- flywaydb

## 测试

- 接口测试 使用 MockMvc 测试
- 单元测试 使用 JUnit4 + JMockito + AssertJ

## 命令行操作

#### 1、运行测试

* 运行测试

```shell
mvn clean test
```

#### 2、本地运行项目

* 本地启动MySQL和数据库查看工具

```shell
docker-compose -f env/local/docker-compose.yml up
```

* 运行项目

```shell
mvn clean install
mvn spring-boot:run
 ```

#### 数据初始化脚本

地址

```text
./env/init.sql
```


