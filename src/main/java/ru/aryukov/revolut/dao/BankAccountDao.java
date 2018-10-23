package ru.aryukov.revolut.dao;

import ru.aryukov.revolut.model.BankAccount;


public interface BankAccountDao extends CommonDao<BankAccount, Long> {
    void transfer(BankAccount source, BankAccount dest);
}
