package ru.aryukov.revolut.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import ru.aryukov.revolut.dao.BankAccountDao;
import ru.aryukov.revolut.dao.HistoryOperationDao;
import ru.aryukov.revolut.dao.UserDao;
import ru.aryukov.revolut.dao.impl.BankAccountDaoImpl;
import ru.aryukov.revolut.dao.impl.HistoryOperationDaoImpl;
import ru.aryukov.revolut.dao.impl.UserDaoImpl;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.service.TransactionsLog;
import ru.aryukov.revolut.service.UserService;
import ru.aryukov.revolut.service.impl.BankAccountServiceImp;
import ru.aryukov.revolut.service.impl.DatabaseTransactionLog;
import ru.aryukov.revolut.service.impl.UserServiceImpl;
import ru.aryukov.revolut.web.BankAccountController;
import ru.aryukov.revolut.web.HistoryController;
import ru.aryukov.revolut.web.UserController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class BaseModule extends AbstractModule {
    @Override
    protected void configure() {
        //DAO layer
        bind(BankAccountDao.class).to(BankAccountDaoImpl.class).asEagerSingleton();
        bind(UserDao.class).to(UserDaoImpl.class).asEagerSingleton();
        bind(HistoryOperationDao.class).to(HistoryOperationDaoImpl.class).asEagerSingleton();

        //Service layer
        bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();
        bind(TransactionsLog.class).to(DatabaseTransactionLog.class).asEagerSingleton();
        bind(BankAccountService.class).to(BankAccountServiceImp.class).asEagerSingleton();

        //Controller
        bind(UserController.class).asEagerSingleton();
        bind(BankAccountController.class).asEagerSingleton();
        bind(HistoryController.class).asEagerSingleton();
    }

    @Singleton
    @Provides
    public EntityManager providersEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        return em;
    }

    @Singleton
    @Provides
    public Validator provideValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
