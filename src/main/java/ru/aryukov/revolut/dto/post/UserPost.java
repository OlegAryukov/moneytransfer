package ru.aryukov.revolut.dto.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Объект создания пользователя.
 */
@Data
@Builder
@AllArgsConstructor
public class UserPost implements Validable {

    /**
     * Имя
     */
    @NotNull(message = "Name cannot be empty")
    private String name;

    /**
     * Фамилия
     */
    @NotNull(message = "Second name cannot be empty")
    private String secondName;
}
