package ru.aryukov.revolut.modules;

import com.google.inject.AbstractModule;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.service.TransactionsLog;
import ru.aryukov.revolut.service.impl.AwsomeBankServiceImp;
import ru.aryukov.revolut.service.impl.DatabaseTransactionLog;

public class TransferModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionsLog.class).to(DatabaseTransactionLog.class);
        bind(BankAccountService.class).to(AwsomeBankServiceImp.class);
    }
}
