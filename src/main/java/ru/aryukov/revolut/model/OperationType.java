package ru.aryukov.revolut.model;

public enum OperationType {
    RECEIPT("ПОЛУЧЕНИЕ", 0L),
    EXPENSE("РАСХОД", 1L),
    TRANSFER("ПЕРЕВОД", 2L),
    TRANSFER_WITH_EXCHANGE("ПЕРЕВОД С ОБМЕНОМ", 3L);

    public final Long id;

    public String operationName;

    OperationType(String operationName, Long id) {
        this.operationName = operationName;
        this.id = id;
    }
}
