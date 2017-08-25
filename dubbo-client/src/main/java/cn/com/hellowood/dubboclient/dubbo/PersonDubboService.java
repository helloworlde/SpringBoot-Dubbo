package cn.com.hellowood.dubboclient.dubbo;

import cn.com.hellowood.dubboclient.model.Person;

/**
 * @author 何惠民
 * @create 2017-08-25 17:01
 * @email huimin.he@yi23.net
 **/

public interface PersonDubboService {

    Person sayHello(String name);
}
