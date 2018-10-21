package ru.aryukov.revolut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class BankAccPut {

    @NotNull
    BigDecimal amount;
}
