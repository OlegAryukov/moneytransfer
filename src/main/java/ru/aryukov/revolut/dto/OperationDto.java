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
public class OperationDto implements ResponseEntity {

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
     *
     */
    private String currTypeFrom;

    /**
     *
     */
    private String sum;

    /**
     * Идентфикатор пользователя, от которого пришли средства
     */
    private Long userTo;

    /**
     * Идентификатор банковского счета, с которого пришли средства
     */
    private Long bankAccountTo;

    private String currTypeTo;

    private String crossCourse;

    /**
     * Время совершения транзакции
     */
    private Instant operationTime;
}
