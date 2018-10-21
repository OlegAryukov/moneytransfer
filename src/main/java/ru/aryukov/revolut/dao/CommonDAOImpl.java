package ru.aryukov.revolut.dao;

import com.google.inject.Inject;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class CommonDAOImpl<T, ID extends Serializable> implements CommonDao<T,ID> {

	@Inject
    private EntityManager em;


    public void create(T entity) {
        em.persist(entity);
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }


    public T findByID(Class clazz, long id) {
        T o =  (T) em.find(clazz, id);
        return o;
    }

    public List findAll(Class clazz) {
        List<T>  list = em.createQuery(" from "+ clazz.getName() , clazz).getResultList();
        return list;
    }
}
