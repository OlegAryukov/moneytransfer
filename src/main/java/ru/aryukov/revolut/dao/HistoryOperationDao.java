package ru.aryukov.revolut.dao;

import ru.aryukov.revolut.model.OperationHistory;

import java.util.UUID;

public interface HistoryOperationDao extends CommonDao<OperationHistory, UUID> {
}
