package cn.com.hellowood.model;

import java.io.Serializable;

/**
 * @author 何惠民
 * @create 2017-08-25 17:02
 * @email hellowood@outlook.com
 **/

public class Person implements Serializable {
    private static final long serialVersionUID = -1L;

    private Integer id;

    private String name;

    private Integer gender;

    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
