package ru.aryukov.revolut.dto.response;

import lombok.Builder;
import lombok.Data;
import ru.aryukov.revolut.dto.ResponseEntity;

/**
 * Объект ответа в случае, если не найдена сущность.
 */
@Data
@Builder
public class NotFoundResponse implements ResponseEntity {

    /**
     * Сообщение для пользователя.
     */
    String message;
}
