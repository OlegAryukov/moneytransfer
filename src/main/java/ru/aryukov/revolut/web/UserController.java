package ru.aryukov.revolut.web;

import com.google.gson.Gson;
import com.google.inject.Inject;
import ru.aryukov.revolut.dto.post.UserPost;
import ru.aryukov.revolut.service.UserService;
import ru.aryukov.revolut.utils.JsonTransformer;
import ru.aryukov.revolut.utils.MapperUtils;
import spark.Spark;

import java.util.stream.Collectors;

public class UserController extends AbstractController {
    @Inject
    private UserService userService;

    public UserController() {

        Spark.get("/user/:id", "application/json", (request, response) -> {
            response.type("application/json");
            Long userId = Long.valueOf(request.params("id"));
            return userService.getUserById(userId);
        }, new JsonTransformer());

        Spark.get("/users", (request, response) -> {
            response.type("application/json");
            return userService.getAllUsers().stream()
                .map(user -> MapperUtils.mapUser(user))
                .collect(Collectors.toList());
            }, new JsonTransformer());

        Spark.post("/user", (request, response) -> {
            response.type("application/json");
            UserPost userPost = new Gson().fromJson(request.body(), UserPost.class);
            validateIncome(userPost);
            return userService.createUser(userPost);
        }, new JsonTransformer());
    }
}
