package ru.aryukov.revolut.modules;

import com.google.inject.AbstractModule;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.service.TransactionsLog;
import ru.aryukov.revolut.service.UserService;
import ru.aryukov.revolut.service.impl.AwsomeBankServiceImp;
import ru.aryukov.revolut.service.impl.DatabaseTransactionLog;
import ru.aryukov.revolut.service.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseModule extends AbstractModule {
    @Override
    protected void configure() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaUnit");
        bind(EntityManagerFactory.class).toInstance(entityManagerFactory);
        bind(EntityManager.class).toInstance(entityManagerFactory.createEntityManager());

        bind(UserService.class).to(UserServiceImpl.class);
        bind(TransactionsLog.class).to(DatabaseTransactionLog.class);
        bind(BankAccountService.class).to(AwsomeBankServiceImp.class);
    }
}
