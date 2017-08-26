package cn.com.hellowood.dubbo;

import cn.com.hellowood.model.Person;

/**
 * @author 何惠民
 * @create 2017-08-25 17:01
 * @email hellowood@outlook.com
 **/

public interface PersonDubboService {

    Person sayHello(String name);
}
