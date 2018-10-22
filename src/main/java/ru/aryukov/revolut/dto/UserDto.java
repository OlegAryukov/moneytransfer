package ru.aryukov.revolut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements ResponseEntity {

    /**
     * Идентификатор пользователя
     */
    private Long id;

    /**
     * Имя пользователя
     */
    private String name;

    /**
     * Фамилия пользователя
     */
    private String secondName;

    /**
     * Список банковских счетов
     */
    List<@NotNull BankAccountDto> bankAccounts;

}
