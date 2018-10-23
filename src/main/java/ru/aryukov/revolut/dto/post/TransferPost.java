package ru.aryukov.revolut.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aryukov.revolut.dto.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Объект перевода без конвертации.
 */
@Data
@Builder
@AllArgsConstructor
public class TransferPost implements ResponseEntity, Validable {
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
    @NotNull(message = "Sum of transfer must be not empty")
    private BigDecimal sum;
}
