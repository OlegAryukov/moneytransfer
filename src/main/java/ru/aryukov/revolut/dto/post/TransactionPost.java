package ru.aryukov.revolut.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aryukov.revolut.model.CurrencyType;
import ru.aryukov.revolut.model.OperationType;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
public class TransactionPost {

    /**
     * Тип операции
     */
    private OperationType operationType;

    /**
     * Пользователь отправитель
     */
    private Long userFrom;

    /**
     * Счет списания
     */
    private Long bankAccountSource;

    /**
     * Тип валюты счета списания
     */
    private CurrencyType currSourceType;

    /**
     * Сумма трансфера
     */
    private BigDecimal sum;

    /**
     * Кросс курс.
     */
    private BigDecimal crossCourse;

    /**
     * Пользователь получатель
     */
    private Long userTo;

    /**
     * Счет поступления
     */
    private Long bankAccountDest;

    /**
     * Тип валюты счета поступления
     */
    private CurrencyType currDestType;

    /**
     * Время записи транзакции
     */
    private Instant operationTime;
}
