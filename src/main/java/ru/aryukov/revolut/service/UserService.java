package ru.aryukov.revolut.service;

import ru.aryukov.revolut.dto.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> getUserById(Long userId);

}
