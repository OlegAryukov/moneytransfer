package ru.aryukov.revolut.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aryukov.revolut.dto.ResponseEntity;

/**
 * Объект ответа на операцию перевода
 */
@Data
@Builder
@AllArgsConstructor
public class TransferResultResponse implements ResponseEntity {

    /**
     * Сообщение пользователя
     */
    private String message;
}
