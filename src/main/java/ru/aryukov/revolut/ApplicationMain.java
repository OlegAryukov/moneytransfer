package ru.aryukov.revolut;


import org.apache.log4j.Logger;
import ru.aryukov.revolut.utils.SparkUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static spark.Spark.get;

public class ApplicationMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ru.aryukov.revolut.model.User");
        Logger logger = Logger.getLogger(ApplicationMain.class);
        SparkUtils.createServerWithRequestLog(logger);
        get("/hello", (request, response) -> "world");
    }
}
