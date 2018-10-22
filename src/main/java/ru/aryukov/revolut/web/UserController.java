package ru.aryukov.revolut.web;

import com.google.gson.Gson;
import com.google.inject.Inject;
import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.post.UserPost;
import ru.aryukov.revolut.service.UserService;
import ru.aryukov.revolut.utils.JsonTransformer;
import spark.Spark;

public class UserController {
    @Inject
    private UserService userService;

    public UserController() {

        Spark.get("/user/:id", "application/json", (request, response) -> {
            Long userId = Long.valueOf(request.params("id"));
            return userService.getUserById(userId);
        }, new JsonTransformer());

        Spark.post("/user", (request, response) -> {
            response.type("application/json");
            UserPost userPost = new Gson().fromJson(request.body(), UserPost.class);
            ResponseEntity resp = userService.createUser(userPost);
            return new Gson().toJson(resp);
        });
    }
}
