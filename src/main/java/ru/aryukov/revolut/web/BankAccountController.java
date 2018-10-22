package ru.aryukov.revolut.web;

import com.google.gson.Gson;
import com.google.inject.Inject;
import ru.aryukov.revolut.dto.post.BankAccPost;
import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.post.TransferPost;
import ru.aryukov.revolut.service.BankAccountService;
import spark.Spark;

public class BankAccountController {

    @Inject
    BankAccountService bankAccountService;

    public BankAccountController() {
        Spark.post("/account", (request, response) -> {
            response.type("application/json");
            BankAccPost accPost = new Gson().fromJson(request.body(), BankAccPost.class);
            ResponseEntity resp = bankAccountService.createAccount(accPost);
            return new Gson().toJson(resp);
        });

        Spark.post("/account/transfer", (request, response) -> {
            response.type("application/json");
            TransferPost transferPost = new Gson().fromJson(request.body(), TransferPost.class);
            ResponseEntity resp = bankAccountService.transfer(transferPost);
            return new Gson().toJson(resp);
        });
    }
}
