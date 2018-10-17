package ru.aryukov.revolut.model;

public enum CurrencyType {
    USD("USD", 0L),
    EUR("EUR", 1L),
    RUR("RUR", 2L);

    private String worldCode;
    private Long id;

    CurrencyType(String worldCode, Long id) {
        this.worldCode = worldCode;
        this.id = id;
    }
}
