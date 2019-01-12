# HAP Cloud Demo
## 前提
### 1 已经配置好HAP Cloud 开发环境
[HAP Cloud Manual](http://eco.hand-china.com/doc/hap-cloud/latest/)
### 2 至少启动以下服务

 - hap-register-server
 - hap-oauth-server 
 - hap-api-gateway
 
## 配置api-gateway
直接修改application-default.yml,注意根据自己的需求进行修改，修改dev的配置信息，不要提交代码。
```properties
spring:
    datasource:
    url: jdbc:mysql://localhost/hap_user_service?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: hapcloud
    password: handhand
    rabbitmq:
    host: localhost
    port: 5672
    zuul:
    addHostHeader: true
    routes:
        dev:
        path: /todo/**
        serviceId: hap-todo-service
        uaa:
        path: /uaa/**
        serviceId: hap-user-service
        fws:
        path: /fws/**
        serviceId: hap-framework-service
        admin:
        path: /admin/**
        serviceId: hap-user-admin-service
        oauth:
        path: /oauth/**
        sensitiveHeaders:
        serviceId: hap-oauth-server
        stripPrefix: false
    security:
    oauth2:
        resource:
        userInfoUri: http://hap-oauth-server/oauth/api/user
    ignored:
        - /oauth/**
```
## 初始化数据
```shell
sh init-local-database.sh
```

## 启动

```shell
mvn spring-boot:run
```