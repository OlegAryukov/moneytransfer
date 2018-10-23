package ru.aryukov.revolut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Объект банковского счета пользователя
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto implements ResponseEntity {

    /**
     * Идентификатор счета
     */
    private Long id;

    /**
     * Баланс счета
     */
    private BigDecimal amount;

    /**
     * Валюта счета
     */
    private String currencyType;

    /**
     * Вледелец счета
     */
    private UserDto user;
}
