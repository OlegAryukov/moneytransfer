package ru.aryukov.revolut.dto.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Объект создания пользователя.
 */
@Data
@Builder
@AllArgsConstructor
public class UserPost {

    /**
     * Имя
     */
    private String name;

    /**
     * Фамилия
     */
    private String secondName;
}
