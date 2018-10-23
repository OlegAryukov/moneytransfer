package ru.aryukov.revolut.service;

import ru.aryukov.revolut.dto.post.TransactionPost;
import ru.aryukov.revolut.model.OperationHistory;

import java.util.List;

public interface TransactionsLog {

    void logTransaction(TransactionPost params);

    void logTransactionWithExchenge(TransactionPost params);

    List<OperationHistory> getHistory();

}
