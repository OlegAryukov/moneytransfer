package ru.aryukov.revolut.service;

public interface BankAccountService {

    void getMoney(Long bankAccountId, double summ);

    void putMoney(Long bankAccountId, double summ);
}
