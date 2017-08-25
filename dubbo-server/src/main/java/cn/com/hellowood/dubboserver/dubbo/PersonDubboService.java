package cn.com.hellowood.dubboserver.dubbo;

import cn.com.hellowood.dubboserver.model.Person;

/**
* @create 2017-08-25 17:19
* @author 何惠民
* @email huimin.he@yi23.net
**/

public interface PersonDubboService {

    Person sayHello(String name);
}
