package ru.aryukov.revolut.dao.impl;

import ru.aryukov.revolut.dao.BankAccountDao;
import ru.aryukov.revolut.dao.CommonDAOImpl;
import ru.aryukov.revolut.model.BankAccount;

import javax.persistence.LockModeType;

public class BankAccountDaoImpl extends CommonDAOImpl<BankAccount, Long> implements BankAccountDao{

    @Override
    public BankAccount update(BankAccount entity) {
        em.lock(entity, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    public void transfer(BankAccount source, BankAccount dest){
        em.getTransaction().begin();
        em.lock(source, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        em.lock(dest, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        em.persist(source);
        em.persist(dest);
        em.flush();
        em.getTransaction().commit();
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
