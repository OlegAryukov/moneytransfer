package ru.aryukov.revolut.web;

import com.google.inject.Inject;
import ru.aryukov.revolut.service.UserService;
import spark.Spark;

public class UserController {
    @Inject
    private UserService userService;

    public UserController() {

        Spark.get("/user/:id", (request, response) -> {
            Long userId = Long.valueOf(request.params("id"));
            return userService.getUserById(userId);
        });
    }
}
