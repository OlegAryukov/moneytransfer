package ru.aryukov.revolut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class TransferPost implements ResponseEntity {
     private Long bankAccIdSource;
     private Long bankAccIdDest;
     private BigDecimal sum;
}
