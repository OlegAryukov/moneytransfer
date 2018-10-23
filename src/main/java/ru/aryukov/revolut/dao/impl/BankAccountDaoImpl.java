package ru.aryukov.revolut.dao.impl;

import org.apache.log4j.Logger;
import ru.aryukov.revolut.dao.BankAccountDao;
import ru.aryukov.revolut.dao.CommonDAOImpl;
import ru.aryukov.revolut.model.BankAccount;

import javax.persistence.LockModeType;

public class BankAccountDaoImpl extends CommonDAOImpl<BankAccount, Long> implements BankAccountDao {

    private static Logger logger = Logger.getLogger(BankAccountDaoImpl.class);

    @Override
    public BankAccount update(BankAccount entity) {
        try {
            em.lock(entity, LockModeType.PESSIMISTIC_WRITE);
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if(em.getTransaction()!=null && em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            logger.error("failed to update account" + e.getMessage());
            return null;
        }
    }

    public void transfer(BankAccount source, BankAccount dest) {
        try {
            em.getTransaction().begin();
            em.lock(source, LockModeType.PESSIMISTIC_WRITE);
            em.lock(dest, LockModeType.PESSIMISTIC_WRITE);
            em.persist(source);
            em.persist(dest);
            em.flush();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if(em.getTransaction()!=null && em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            logger.error("failed to persist transfer" + e.getMessage());
        }
    }

    @Override
    public void delete(BankAccount entity) {
        super.delete(entity);
    }

    @Override
    public BankAccount findByID(Class clazz, long id) {
        return super.findByID(clazz, id);
    }
}
