package ru.aryukov.revolut.dto.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Объект создания банковского счета.
 */

@Data
@Builder
@AllArgsConstructor
public class BankAccPost implements Validable {


    /**
     * Тип валюты счета.
     */
    @NotNull(message = "Must be not null")
    String currType;

    /**
     * Начальное состояние счета.
     */
    @NotNull(message = "Must be not null")
    BigDecimal amount;

    /**
     * Идентификатор пользователя, владельца счета.
     */
    @NotNull(message = "Must be not null")
    Long userId;
}
