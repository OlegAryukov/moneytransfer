package ru.aryukov.revolut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 * Объект банковского счета пользователя
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {

    /**
     * Идентификатор счета
     */
    @NotNull
    @Positive
    private Long id;

    /**
     * Баланс счета
     */
    @NotNull
    @Positive
    private BigDecimal amount;

    /**
     * Валюта счета
     */
    @NotNull
    private String currencyType;

    /**
     * Вледелец счета
     */
    @NotNull
    private UserDto user;
}
