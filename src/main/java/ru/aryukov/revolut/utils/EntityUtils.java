package ru.aryukov.revolut.utils;


import ru.aryukov.revolut.dto.post.UserPost;
import ru.aryukov.revolut.model.User;

public class EntityUtils {
    public EntityUtils() {
    }

    public User createUser(UserPost user) {
        User entity = new User();
        entity.setName(user.getName());
        entity.setSecondName(user.getSecondName());
        return entity;
    }
}
