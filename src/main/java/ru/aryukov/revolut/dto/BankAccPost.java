package ru.aryukov.revolut.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class BankAccPost {

    @NotNull
    String currType;

    @NotNull
    @Positive
    BigDecimal amount;

    @NotNull
    @Positive
    Long userId;
}
