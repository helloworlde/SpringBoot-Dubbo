package cn.com.hellowood.dubboclient.dubbo;

import cn.com.hellowood.dubboclient.model.Person;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author 何惠民
 * @create 2017-08-25 17:07
 * @email huimin.he@yi23.net
 **/
@Component
public class PersonDubboConsumerService {

    @Reference(version = "1.0.0")
    PersonDubboService service;

    public void sayHello() {
        String name = "哈哈哈哈";
        Person person = service.sayHello(name);
        System.out.println(person);
    }
}
