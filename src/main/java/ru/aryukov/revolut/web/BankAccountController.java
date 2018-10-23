package ru.aryukov.revolut.web;

import com.google.gson.Gson;
import com.google.inject.Inject;
import ru.aryukov.revolut.dto.post.BankAccPost;
import ru.aryukov.revolut.dto.post.TransferPost;
import ru.aryukov.revolut.dto.post.TransferPostWithExchange;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.utils.JsonTransformer;
import spark.Spark;

public class BankAccountController extends AbstractController {

    @Inject
    BankAccountService bankAccountService;

    public BankAccountController() {
        Spark.get("/account/:id",(request, response) -> {
            response.type("application/json");
            Long accId = Long.valueOf(request.params("id"));
            return bankAccountService.getBankAccount(accId);
        }, new JsonTransformer());

        Spark.post("/account", (request, response) -> {
            response.type("application/json");
            BankAccPost accPost = new Gson().fromJson(request.body(), BankAccPost.class);
            validateIncome(accPost);
            return bankAccountService.createAccount(accPost);
        }, new JsonTransformer());

        Spark.post("/account/transfer", (request, response) -> {
            response.type("application/json");
            TransferPost transferPost = new Gson().fromJson(request.body(), TransferPost.class);
            validateIncome(transferPost);
            return bankAccountService.transfer(transferPost);
        }, new JsonTransformer());

        Spark.post("/account/transferex", (request, response) -> {
            response.type("application/json");
            TransferPostWithExchange transferPostex = new Gson().fromJson(request.body(), TransferPostWithExchange.class);
            validateIncome(transferPostex);
            return bankAccountService.transferWithExchange(transferPostex);
        }, new JsonTransformer());
    }
}
