package ru.aryukov.revolut.dao;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class CommonDAOImpl<T, ID extends Serializable> implements CommonDao<T,ID> {

	@Inject
    protected EntityManager em;


    public T create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.clear();
        return entity;
    }

    public T update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.clear();
        return entity;
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
