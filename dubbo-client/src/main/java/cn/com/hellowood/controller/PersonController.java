package cn.com.hellowood.controller;

import cn.com.hellowood.dubbo.PersonDubboConsumerService;
import cn.com.hellowood.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @create 2017-08-28 13:14
* @author HelloWood
* @email hellowoodes@outlook.com
**/

@RestController
public class PersonController {

    @Autowired
    PersonDubboConsumerService consumerService;

    @GetMapping("/getPerson")
    public Person getPerson(String name) {
        return consumerService.getPerson(name);
    }
}
