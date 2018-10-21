package ru.aryukov.revolut.dao;

import ru.aryukov.revolut.model.OperationHistory;

import java.util.UUID;

/**
 * Created by oaryukov on 21.10.2018.
 */
public interface HistoryOperationDao extends CommonDao<OperationHistory, UUID> {
}
