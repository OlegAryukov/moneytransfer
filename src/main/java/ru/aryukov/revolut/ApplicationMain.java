package ru.aryukov.revolut;


import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.h2.tools.Server;
import ru.aryukov.revolut.config.Configuration;
import ru.aryukov.revolut.utils.SparkUtils;

import javax.jnlp.PersistenceService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

import static spark.Spark.get;

public class ApplicationMain {
    public static void main(String[] args) throws SQLException {
        //Код для возможности контроля базы данных в консоли
        Server webServer = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
        Server server = Server.createTcpServer("-tcpPort" ,"9092", "-tcpAllowOthers").start();
        //
        Configuration.initialize();

        Logger logger = Logger.getLogger(ApplicationMain.class);
        SparkUtils.createServerWithRequestLog(logger);
        get("/hello", (request, response) -> "world");
    }
}
