package cn.com.hellowood.dubbo;

import cn.com.hellowood.model.Person;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author 何惠民
 * @create 2017-08-25 17:07
 * @email hellowood@outlook.com
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
