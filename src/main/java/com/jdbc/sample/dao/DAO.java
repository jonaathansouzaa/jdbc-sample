package com.jdbc.sample.dao;

import java.util.List;

public interface DAO<T> {

    public void save(T entity);

    public void update(T entity);

    public void delete(T entity);

    public T findById(Long entityId);

    public List<T> findAll();

}
