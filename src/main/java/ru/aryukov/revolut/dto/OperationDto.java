package ru.aryukov.revolut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {

    /**
     * Идентфикатор траназакции
     */
    private UUID id;

    /**
     * Тип операции
     */
    private String operationType;

    /**
     * Идентификатор пользователя, источника поступлений
     */
    private Long userFrom;

    /**
     * Идентификатор банковского счета, источника поступлений
     */
    private Long bankAccountFrom;

    /**
     * Идентфикатор пользоватлея, от которого пришли средства
     */
    private Long userTo;

    /**
     * Идентификатор банковского счета, с которого пришли средства
     */
    private Long bankAccountTo;

    /**
     * Время совершения транзакции
     */
    private Instant operationTime;
}
