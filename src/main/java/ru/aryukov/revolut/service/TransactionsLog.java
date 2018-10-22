package ru.aryukov.revolut.service;

import ru.aryukov.revolut.dto.post.TransferPost;
import ru.aryukov.revolut.dto.post.TransferPostWithExchange;

public interface TransactionsLog {

    void logTransaction(TransferPost params);

    void logTransactionWithExchenge(TransferPostWithExchange params);

}
