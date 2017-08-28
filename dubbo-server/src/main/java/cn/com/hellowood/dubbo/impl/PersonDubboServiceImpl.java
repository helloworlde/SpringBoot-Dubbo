package cn.com.hellowood.dubbo.impl;

import cn.com.hellowood.dubbo.PersonDubboService;
import cn.com.hellowood.model.Person;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author HelloWood
 * @create 2017-08-25 17:21
 * @email hellowood@outlook.com
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
