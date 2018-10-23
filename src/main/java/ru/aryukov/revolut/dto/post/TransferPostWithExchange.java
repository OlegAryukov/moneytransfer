package ru.aryukov.revolut.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aryukov.revolut.dto.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Объект трансфера между счетами, с конвертацией валют.
 */
@Data
@Builder
@AllArgsConstructor
public class TransferPostWithExchange implements ResponseEntity, Validable {
    /**
     * Идентификатор счета списания
     */
    @NotNull(message = "Id is necessary and positive")
    private Long bankAccIdSource;

    /**
     * Идентификатор счета поступления.
     */
    @NotNull(message = "Id is necessary and positive")
    private Long bankAccIdDest;

    /**
     * Сумма трансфера.
     */
    @NotNull(message = "Sum is necessary and not blank")
    private BigDecimal sum;

    /**
     * Курс конвертации.
     */
    @NotNull(message = "Cross course necessary and not null")
    private BigDecimal exchangeCourse;
}
