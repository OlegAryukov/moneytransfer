package ru.aryukov.revolut.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.aryukov.revolut.dto.ResponseEntity;

import java.math.BigDecimal;

/**
 * Объект перевода без конвертации.
 */
@Data
@Builder
@AllArgsConstructor
public class TransferPost implements ResponseEntity {
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
}
