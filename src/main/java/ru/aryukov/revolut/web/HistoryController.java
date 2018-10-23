package ru.aryukov.revolut.web;

import com.google.inject.Inject;
import ru.aryukov.revolut.service.TransactionsLog;
import ru.aryukov.revolut.utils.JsonTransformer;
import ru.aryukov.revolut.utils.MapperUtils;
import spark.Spark;

import java.util.stream.Collectors;

public class HistoryController extends AbstractController {

    @Inject
    TransactionsLog transactionsLog;

    public HistoryController() {
        Spark.get("/history", "application/json", (request, response) -> transactionsLog.getHistory()
                .stream().map(operationHistory -> MapperUtils.mapOperationDto(operationHistory))
                .collect(Collectors.toList()), new JsonTransformer());
    }
}
