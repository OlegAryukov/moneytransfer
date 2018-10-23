package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import ru.aryukov.revolut.dao.UserDao;
import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.post.UserPost;
import ru.aryukov.revolut.dto.response.NotFoundResponse;
import ru.aryukov.revolut.model.User;
import ru.aryukov.revolut.service.UserService;
import ru.aryukov.revolut.utils.EntityUtils;
import ru.aryukov.revolut.utils.MapperUtils;

public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;
    @Inject
    private EntityUtils entityUtils;

    @Override
    public ResponseEntity getUserById(Long userId) {
        User entity = userDao.findByID(User.class, userId);
        if (entity != null) {
            return MapperUtils.mapUser(entity);
        } else {
            return NotFoundResponse.builder()
                    .message("Not found user with id: " + userId)
                    .build();
        }
    }

    public ResponseEntity createUser(UserPost params) {
        User user = userDao.create(entityUtils.createUser(params));
        return MapperUtils.mapUser(user);
    }


}
