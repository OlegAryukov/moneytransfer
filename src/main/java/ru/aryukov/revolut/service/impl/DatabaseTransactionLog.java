package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import ru.aryukov.revolut.dao.HistoryOperationDao;
import ru.aryukov.revolut.dto.post.TransactionPost;
import ru.aryukov.revolut.model.OperationHistory;
import ru.aryukov.revolut.service.TransactionsLog;

import java.util.List;

public class DatabaseTransactionLog implements TransactionsLog {
    @Inject
    HistoryOperationDao historyOperation;

    @Override
    public void logTransaction(TransactionPost params) {
        OperationHistory transferRecord = new OperationHistory(params);
        historyOperation.create(transferRecord);
    }

    @Override
    public void logTransactionWithExchenge(TransactionPost params) {
        OperationHistory transferRecord = new OperationHistory(params);
        historyOperation.create(transferRecord);
    }

    @Override
    public List<OperationHistory> getHistory() {
        return historyOperation.findAll(OperationHistory.class);
    }
}
