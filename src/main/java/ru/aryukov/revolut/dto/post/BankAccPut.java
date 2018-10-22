package ru.aryukov.revolut.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Объект обновления счета
 */
@Data
@Builder
@AllArgsConstructor
public class BankAccPut {

    /**
     * Новове состояние счета
     */
    BigDecimal amount;
}
