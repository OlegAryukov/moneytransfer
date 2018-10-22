package ru.aryukov.revolut.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Объект представление пользователя.
 */
@Data
@Builder
@AllArgsConstructor
public class UserDto implements ResponseEntity {

    /**
     * Идентификатор пользователя.
     */
    private Long id;

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Фамилия пользователя.
     */
    private String secondName;

    /**
     * Список банковских счетов.
     */
    List<BankAccountDto> bankAccounts;

}
