package ru.aryukov.revolut;


import org.apache.log4j.Logger;
import ru.aryukov.revolut.utils.SparkUtils;

import static spark.Spark.get;

public class ApplicationMain {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(ApplicationMain.class);
        SparkUtils.createServerWithRequestLog(logger);
        get("/hello", (request, response) -> "world");
    }
}
