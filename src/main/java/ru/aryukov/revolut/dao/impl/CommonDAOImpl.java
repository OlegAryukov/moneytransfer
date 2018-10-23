package ru.aryukov.revolut.dao.impl;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import ru.aryukov.revolut.dao.CommonDao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class CommonDAOImpl<T, ID extends Serializable> implements CommonDao<T, ID> {

    private static Logger logger = Logger.getLogger(CommonDAOImpl.class);

    @Inject
    protected EntityManager em;

    public T create(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
            return entity;
        } catch (RuntimeException e) {
            if(em.getTransaction()!=null && em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            logger.error("failed to persist entity" + e.getMessage());
            return null;
        }
    }

    public T update(T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            em.detach(entity);
            return entity;
        } catch (Exception e) {
            if(em.getTransaction()!=null && em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            logger.error("failed to update entity" + e.getMessage());
            return null;
        }
    }

    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }


    public T findByID(Class clazz, long id) {
        T o = (T) em.find(clazz, id);
        return o;
    }

    public List<T> findAll(Class clazz) {
        List<T> list = em.createQuery(" from " + clazz.getName(), clazz).getResultList();
        return list;
    }
}
