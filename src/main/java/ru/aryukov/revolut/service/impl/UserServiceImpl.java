package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import ru.aryukov.revolut.model.User;
import ru.aryukov.revolut.service.UserService;

import javax.persistence.EntityManager;

public class UserServiceImpl implements UserService {

    @Inject
    EntityManager entityManager;

    @Override
    public User getUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }
}
