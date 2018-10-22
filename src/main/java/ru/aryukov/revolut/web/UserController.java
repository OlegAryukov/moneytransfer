package ru.aryukov.revolut.web;

import com.google.inject.Inject;
import ru.aryukov.revolut.dto.NotFoundEntity;
import ru.aryukov.revolut.model.User;
import ru.aryukov.revolut.service.UserService;
import ru.aryukov.revolut.utils.JsonTransformer;
import ru.aryukov.revolut.utils.MapperUtils;
import spark.Spark;

public class UserController {
    @Inject
    private UserService userService;

    public UserController() {

        Spark.get("/user/:id", "application/json",  (request, response) -> {
            Long userId = Long.valueOf(request.params("id"));
            User entity = userService.getUserById(userId);
            if(entity != null){
                return MapperUtils.mapUser(entity);
            } else {
                return NotFoundEntity.builder()
                    .message("Not found user with id: " + userId)
                    .build();
            }
        }, new JsonTransformer());
    }
}
