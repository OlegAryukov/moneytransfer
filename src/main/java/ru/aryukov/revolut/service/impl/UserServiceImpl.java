package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import ru.aryukov.revolut.dao.UserDao;
import ru.aryukov.revolut.dto.UserDto;
import ru.aryukov.revolut.model.User;
import ru.aryukov.revolut.service.UserService;
import ru.aryukov.revolut.utils.MapperUtils;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public Optional<UserDto> getUserById(Long userId) {
        return Optional.of(userDao.findByID(User.class, userId)).map(MapperUtils::mapUser);
    }

    
}
