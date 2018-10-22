package ru.aryukov.revolut.dto.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Объект создания банковского счета.
 */

@Data
@Builder
@AllArgsConstructor
public class BankAccPost {


    /**
     * Тип валюты счета.
     */
    String currType;

    /**
     * Начальное состояние счета.
     */
    BigDecimal amount;

    /**
     * Идентификатор пользователя, владельца счета.
     */
    Long userId;
}
