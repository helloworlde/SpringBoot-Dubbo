package cn.com.hellowood.dubboclient;

import cn.com.hellowood.dubboclient.dubbo.PersonDubboConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args) {

//        SpringApplication.run(DubboClientApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(DubboClientApplication.class, args);
        PersonDubboConsumerService service = context.getBean(PersonDubboConsumerService.class);
        service.sayHello();
    }
}
