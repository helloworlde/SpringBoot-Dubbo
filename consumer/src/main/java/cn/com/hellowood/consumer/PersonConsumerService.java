package cn.com.hellowood.consumer;

import cn.com.hellowood.service.PersonService;
import cn.com.hellowood.model.Person;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author HelloWood
 * @create 2017-08-25 17:07
 * @email hellowood@outlook.com
 **/
@Component
public class PersonConsumerService {

    @Reference(version = "1.0.0")
    PersonService service;

    public Person getPerson(String name) {
        return service.getPerson(name);
    }
}
