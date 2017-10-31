# SpringBoot 项目集成 Dubbo

------------
 
## 使用 ZooKeeper 作为注册中心
- [下载](https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.4.9/zookeeper-3.4.9.tar.gz) ZooKeeper 
- 解压 ZooKeeper
```
    tar zookeeper-3.4.9.tar.gz
```
- 启动 ZooKeeper
``` 
    cd zookeeper-3.4.9/bin/
    ./zkServer.sh start
```

-----------------

## 配置 Provider

### 1. 添加依赖(build.gradle)

````groovy
    dependencies {
        compile('org.springframework.boot:spring-boot-starter-web')
        compile('org.springframework.boot:spring-boot-starter-parent:1.5.6.RELEASE')
        compile('io.dubbo.springboot:spring-boot-starter-dubbo:1.0.0')
        testCompile('org.springframework.boot:spring-boot-starter-test')
    }
````

### 2. 修改配置文件(application.properties)
````properties
    spring.dubbo.application.name=provider
    spring.dubbo.registry.address=zookeeper://127.0.0.1:2181
    spring.dubbo.protocol.name=dubbo
    spring.dubbo.protocol.port=20880
    # 要扫描的 package 目录
    spring.dubbo.scan=cn.com.hellowood.service
    spring.dubbo.module.default=false
    server.port=8082
````

### 3. 发布服务
#### 服务接口
````java
    package cn.com.hellowood.service;
    
    import cn.com.hellowood.model.Person;
    
    public interface PersonService {
    
        Person getPerson(String name);
    }

````
#### 实现服务接口，为要发布的服务添加 `@Service` 注解
````java
    package cn.com.hellowood.service.impl;
    
    import cn.com.hellowood.service.PersonService;
    import cn.com.hellowood.model.Person;
    import com.alibaba.dubbo.config.annotation.Service;
    
    @Service(version = "1.0.0")
    public class PersonServiceImpl implements PersonService {
    
        @Override
        public Person getPerson(String name) {
            Person person = new Person();
            person.setName(name);
            person.setId(1);
            person.setGender(0);
            person.setAge(18);
    
            return person;
        }
    }

````

## 配置 Consumer

### 1. 添加依赖(build.gradle)
````groovy
    dependencies {
        compile('org.springframework.boot:spring-boot-starter-web')
        compile('org.springframework.boot:spring-boot-starter-parent:1.5.6.RELEASE')
        compile('io.dubbo.springboot:spring-boot-starter-dubbo:1.0.0')
        testCompile('org.springframework.boot:spring-boot-starter-test')
    }
````

### 2. 修改配置文件(application.properties)
````properties
    server.port=8081
    spring.dubbo.application.name=consumer
    spring.dubbo.registry.address=zookeeper://127.0.0.1:2181
    # 要扫描的 package 目录，需要指向 @Reference 注解的类所在包
    spring.dubbo.scan=cn.com.hellowood.consumer
    spring.dubbo.module.default=false
````
### 3. 消费服务
#### 服务接口
````java
    package cn.com.hellowood.service;
    
    import cn.com.hellowood.model.Person;
    
    public interface PersonService {
        Person getPerson(String name);
    }

````
#### 引用 Dubbo 服务，为需要引用服务的类添加 `@Reference` 注解
````java
    package cn.com.hellowood.consumer;
    
    import cn.com.hellowood.service.PersonService;
    import cn.com.hellowood.model.Person;
    import com.alibaba.dubbo.config.annotation.Reference;
    import org.springframework.stereotype.Component;
    
    @Component
    public class PersonConsumerService {
    
        @Reference(version = "1.0.0")
        PersonService service;
    
        public Person getPerson(String name) {
            return service.getPerson(name);
        }
    }

````

#### 接口调用
````java
    package cn.com.hellowood.controller;
    
    import cn.com.hellowood.consumer.PersonConsumerService;
    import cn.com.hellowood.model.Person;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    public class PersonController {
    
        @Autowired
        PersonConsumerService consumerService;
    
        @GetMapping("/getPerson")
        public Person getPerson(String name) {
            return consumerService.getPerson(name);
        }
    }

````

## 调用服务

- 启动 Provider 和 Consumer
- 访问接口[http://localhost:8081/getPerson?name=helloworld](http://localhost:8081/getPerson?name=helloworld)
````json
    {
        "id": 1,
        "name": "helloworld",
        "gender": 0,
        "age": 18
    }
````

----------------------

### 项目地址
[https://github.com/helloworlde/SpringBoot-Dubbo](https://github.com/helloworlde/SpringBoot-Dubbo)
