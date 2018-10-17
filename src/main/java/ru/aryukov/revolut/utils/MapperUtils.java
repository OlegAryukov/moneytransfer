package ru.aryukov.revolut.utils;

import ru.aryukov.revolut.dto.UserDto;
import ru.aryukov.revolut.model.User;

public class MapperUtils {

    UserDto mapUser(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .secondName(user.getSecondName())
                .bankAccounts(user.getBankAccounts())
                .build();
    }
}
