package cn.com.hellowood.dubboserver.dubbo.impl;

import cn.com.hellowood.dubboserver.dubbo.PersonDubboService;
import cn.com.hellowood.dubboserver.model.Person;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author 何惠民
 * @create 2017-08-25 17:21
 * @email huimin.he@yi23.net
 **/

@Service(version = "1.0.0")
public class PersonDubboServiceImpl implements PersonDubboService {

    @Override
    public Person sayHello(String name) {
        Person person = new Person();
        person.setName(name);
        person.setId(1);
        person.setGender(1);
        person.setAge(33);

        return person;
    }
}
