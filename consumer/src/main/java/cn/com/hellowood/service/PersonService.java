package cn.com.hellowood.service;

import cn.com.hellowood.model.entity.Person;

import java.util.List;

/**
 * @author HelloWood
 **/
public interface PersonService {

    /**
     * Query person by id
     *
     * @param id
     * @return
     */
    Person getPerson(Integer id);

    /**
     * Query all person
     *
     * @return
     */
    List<Person> getAllPerson();


    /**
     * Add person
     *
     * @param person
     * @return
     */
    Integer addPerson(Person person);

    /**
     * Update person
     *
     * @param person
     * @return
     */
    Integer updatePerson(Person person);

    /**
     * Delete person by id
     *
     * @param id
     * @return
     */
    Integer deletePerson(Integer id);
}
