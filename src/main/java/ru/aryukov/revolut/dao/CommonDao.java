package ru.aryukov.revolut.dao;

import java.io.Serializable;
import java.util.List;

public interface  CommonDao<T, ID extends Serializable> {

        public T create(T entity);

        public T update(T entity);

        public void delete(T entity);

        public List findAll(Class clazz);

        public T findByID(Class clazz, long id);
}
