package ru.aryukov.revolut.model;

import lombok.AllArgsConstructor;

/**
 * Enum для типов операций между счетами
 */
@AllArgsConstructor
public enum OperationType {
    RECEIPT("ПОЛУЧЕНИЕ", 0L),
    EXPENSE("РАСХОД", 1L),
    TRANSFER("ПЕРЕВОД", 2L),
    TRANSFER_WITH_EXCHANGE("ПЕРЕВОД С ОБМЕНОМ", 3L);

    public final String operationName;
    public final Long id;

}
