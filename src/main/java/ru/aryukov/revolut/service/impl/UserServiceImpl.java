package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import ru.aryukov.revolut.dao.UserDao;
import ru.aryukov.revolut.model.User;
import ru.aryukov.revolut.service.UserService;

public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public User getUserById(Long userId) {
        return userDao.findByID(User.class, userId);
    }

    
}
