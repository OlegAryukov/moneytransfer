package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import ru.aryukov.revolut.dao.HistoryOperationDao;
import ru.aryukov.revolut.dto.post.TransferPost;
import ru.aryukov.revolut.dto.post.TransferPostWithExchange;
import ru.aryukov.revolut.service.TransactionsLog;

public class DatabaseTransactionLog implements TransactionsLog {
    @Inject
    HistoryOperationDao historyOperation;

    @Override
    public void logTransaction(TransferPost params) {

    }

    @Override
    public void logTransactionWithExchenge(TransferPostWithExchange params) {

    }
}
