package ru.aryukov.revolut.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Optional;

/**
 * Enum для типов валют
 */
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CurrencyType {
    USD("USD", 0L),
    EUR("EUR", 1L),
    RUR("RUR", 2L);

    private static final String KEY_NAME_FIELD = "keyName";

    private String worldCode;
    private Long id;

    public String getWorldCode() {
        return worldCode;
    }

    public Long getId() {
        return id;
    }

    public String getKeyName() {
        return name();
    }

    @JsonCreator
    public static CurrencyType valueOf(Map<String, String> currencyTypeMap) {
        return Optional.ofNullable(currencyTypeMap)
                .map(map -> CurrencyType.valueOf(map.get(KEY_NAME_FIELD)))
                .orElse(null);
    }

    public static CurrencyType fromValue(String value) {
        for (CurrencyType c : CurrencyType.values()) {
            if (c.worldCode.equals(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
