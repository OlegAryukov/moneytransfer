package ru.aryukov.revolut.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aryukov.revolut.dto.ResponseEntity;

import java.math.BigDecimal;

/**
 * Объект трансфера между счетами, с конвертацией валют.
 */
@Data
@Builder
@AllArgsConstructor
public class TransferPostWithExchange implements ResponseEntity {
    /**
     * Идентификатор счета списания
     */
    private Long bankAccIdSource;

    /**
     * Идентификатор счета поступления.
     */
    private Long bankAccIdDest;

    /**
     * Сумма трансфера.
     */
    private BigDecimal sum;

    /**
     * Курс конвертации.
     */
    private BigDecimal exchangeCourse;
}
