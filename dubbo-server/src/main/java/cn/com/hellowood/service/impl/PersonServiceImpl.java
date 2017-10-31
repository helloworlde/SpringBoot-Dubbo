package cn.com.hellowood.service.impl;

import cn.com.hellowood.service.PersonService;
import cn.com.hellowood.model.Person;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author HelloWood
 * @create 2017-08-25 17:21
 * @email hellowood@outlook.com
 **/

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
