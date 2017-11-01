package cn.com.hellowood.service.impl;

import cn.com.hellowood.dao.PersonMapper;
import cn.com.hellowood.model.entity.Person;
import cn.com.hellowood.core.AbstractService;
import cn.com.hellowood.service.PersonService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HelloWood
 **/
@Service(version = "1.0.0")
@Transactional
public class PersonServiceImpl extends AbstractService<Person> implements PersonService {

    @Autowired
    private PersonMapper personMapper;
}
