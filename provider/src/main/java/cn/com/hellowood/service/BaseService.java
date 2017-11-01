package cn.com.hellowood.service;

import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.TooManyListenersException;
/**
 * @author HelloWood
 **/
public interface BaseService<T> {
    Integer save(T model);

    Integer save(List<T> models);

    Integer deleteById(Integer id);

    Integer deleteByIds(String ids);

    Integer update(T model);

    T findById(Integer id);

    T findBy(String fieldName, Object value) throws TooManyListenersException;

    List<T> findByIds(String ids);

    List<T> findByCondition(Condition condition);

    List<T> findAll();
}
