package ru.aryukov.revolut.service;

public interface TransactionsLog {

    void logTransaction(String transaction);
}
