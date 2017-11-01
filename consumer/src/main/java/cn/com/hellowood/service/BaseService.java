package cn.com.hellowood.service;

import cn.com.hellowood.model.exception.ServiceException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
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

    T findBy(String fieldName, Object value) throws ServiceException;

    List<T> findByIds(String ids);

    List<T> findByCondition(Condition condition);

    List<T> findAll();
}
