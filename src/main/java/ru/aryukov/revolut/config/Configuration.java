package ru.aryukov.revolut.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ru.aryukov.revolut.modules.BaseModule;
import ru.aryukov.revolut.web.UserController;

public class Configuration {
    private static Injector injector;

    public static void initialize() {
        injector = Guice.createInjector(new BaseModule());
        injector.getInstance(UserController.class);
    }

    static Injector getInjector() {
        return injector;
    }
}
