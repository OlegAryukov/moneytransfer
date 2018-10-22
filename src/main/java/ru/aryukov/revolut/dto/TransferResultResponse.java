package ru.aryukov.revolut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TransferResultResponse implements ResponseEntity{
    private String message;
}
