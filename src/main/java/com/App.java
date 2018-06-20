package com;

import com.controller.MainController;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());

        MainController controller = injector.getInstance(MainController.class);

        controller.init();
    }
}
