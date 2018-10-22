package ru.aryukov.revolut.service;

import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.UserPost;

public interface UserService {

    ResponseEntity getUserById(Long userId);

    ResponseEntity createUser(UserPost params);

}
