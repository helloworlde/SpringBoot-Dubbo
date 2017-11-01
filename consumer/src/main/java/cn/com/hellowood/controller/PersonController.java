package cn.com.hellowood.controller;

import cn.com.hellowood.consumer.PersonConsumerService;
import cn.com.hellowood.model.entity.Person;
import cn.com.hellowood.model.exception.ServiceException;
import cn.com.hellowood.model.util.CommonResponse;
import cn.com.hellowood.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HelloWood
 **/
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonConsumerService personService;

    @GetMapping
    public CommonResponse getAllPerson() {
        return ResponseUtil.generateResponse(personService.getAllPerson());
    }

    @GetMapping("/{id}")
    public CommonResponse person(@PathVariable Integer id) {
        return ResponseUtil.generateResponse(personService.getPerson(id));
    }

    @PostMapping
    public CommonResponse addPerson(@RequestBody Person person) throws ServiceException {
        return ResponseUtil.generateResponse(personService.addPerson(person));
    }

    @PutMapping("/{id}")
    public CommonResponse updatePerson(@PathVariable Integer id, @RequestBody Person person) throws ServiceException {
        return ResponseUtil.generateResponse(personService.updatePerson(id, person));
    }

    @DeleteMapping("/{id}")
    public CommonResponse deletePerson(@PathVariable Integer id) throws ServiceException {
        return ResponseUtil.generateResponse(personService.deletePerson(id));
    }
}
