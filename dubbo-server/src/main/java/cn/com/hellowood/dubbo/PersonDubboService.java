package cn.com.hellowood.dubbo;

import cn.com.hellowood.model.Person;

/**
* @create 2017-08-25 17:19
* @author HelloWood
* @email hellowood@outlook.com
**/

public interface PersonDubboService {

    Person sayHello(String name);
}
