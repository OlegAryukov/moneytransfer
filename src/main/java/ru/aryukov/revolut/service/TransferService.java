package ru.aryukov.revolut.service;

import com.google.inject.Inject;

public class TransferService {
    private final BankAccountService bankService;
    private final TransactionsLog transactionsLog;

    @Inject
    public TransferService(BankAccountService bankService, TransactionsLog transactionsLog) {
        this.bankService = bankService;
        this.transactionsLog = transactionsLog;
    }

    public void makeDraft(){}

    public void makeDraftWithExchange(){}
}
