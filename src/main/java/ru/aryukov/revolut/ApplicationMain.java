package ru.aryukov.revolut;


import org.apache.log4j.Logger;
import org.h2.tools.Server;
import ru.aryukov.revolut.config.Configuration;
import ru.aryukov.revolut.dto.response.ErrorResponse;
import ru.aryukov.revolut.utils.JsonUtil;

import java.sql.SQLException;

import static spark.Spark.exception;

public class ApplicationMain {
    public static void main(String[] args) throws SQLException {
        Logger logger = Logger.getLogger(ApplicationMain.class);

        //Код для возможности контроля базы данных в консоли
        Server webServer = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
        Server server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
        //
        Configuration.initialize();

        exception(Exception.class, (e, req, res) -> {
            logger.error(String.format("%s : Got an exception for request : %s  ", e.getLocalizedMessage(), req.url()));
            logger.error(e.getLocalizedMessage(), e);
            res.status(500);
            res.body(JsonUtil.toJson(new ErrorResponse(500, e.getMessage())));
        });
    }
}
