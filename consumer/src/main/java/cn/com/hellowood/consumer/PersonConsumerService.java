package cn.com.hellowood.consumer;

import cn.com.hellowood.model.entity.Person;
import cn.com.hellowood.model.exception.ServiceException;
import cn.com.hellowood.service.PersonService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author HelloWood
 **/
@Component
public class PersonConsumerService {

    @Reference(version = "1.0.0")
    PersonService service;

    /**
     * Query person by id
     *
     * @param id
     * @return
     */
    public Person getPerson(Integer id) {
        return service.getPerson(id);
    }

    /**
     * Query all person
     *
     * @return
     */
    public List<Person> getAllPerson() {
        return service.getAllPerson();
    }

    /**
     * Add person
     *
     * @param person
     * @return
     * @throws ServiceException
     */
    public Person addPerson(Person person) throws ServiceException {
        if (service.addPerson(person) <= 0) {
            throw new ServiceException("Add person failed");
        }
        return person;
    }

    /**
     * Update person
     *
     * @param id
     * @param person
     * @return
     * @throws ServiceException
     */
    public Person updatePerson(Integer id, Person person) throws ServiceException {
        if (service.updatePerson(person) <= 0) {
            throw new ServiceException("Update person failed");
        }
        return person;
    }

    /**
     * Delete person
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    public boolean deletePerson(Integer id) throws ServiceException {
        if (service.deletePerson(id) <= 0) {
            throw new ServiceException("Delete person failed");
        }
        return true;
    }
}
