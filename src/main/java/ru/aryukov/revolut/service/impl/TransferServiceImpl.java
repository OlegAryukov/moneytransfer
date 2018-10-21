package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.service.TransactionsLog;
import ru.aryukov.revolut.service.TransferService;

public class TransferServiceImpl implements TransferService {
    @Inject
    private BankAccountService bankService;
    @Inject
    private TransactionsLog transactionsLog;

    @Transactional
    public void makeDraft(long bankAccIdFrom, long bankAccIdTo, double summ){

    }

    @Transactional
    public void makeDraftWithExchange(long bankAccIdFrom, long bankAccIdTo,
                                      String currTypeFrom, String currTypeTo,
                                      double summ){

    }
}
