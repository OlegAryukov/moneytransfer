package ru.aryukov.revolut.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotFoundEntity implements ResponseEntity {

    String message;
}
