package ru.aryukov.revolut.service;

import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.post.UserPost;
import ru.aryukov.revolut.model.User;

import java.util.List;

public interface UserService {

    ResponseEntity getUserById(Long userId);

    ResponseEntity createUser(UserPost params);

    List<User> getAllUsers();

}
