package ru.aryukov.revolut.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ru.aryukov.revolut.modules.BaseModule;

public class Configuration {
    private static Injector injector;

    public static void initialize(){
        injector = Guice.createInjector(new BaseModule());
    }

    static Injector getInjector(){
        return injector;
    }
}
