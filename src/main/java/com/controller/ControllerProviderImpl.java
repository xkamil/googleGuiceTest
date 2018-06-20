package com.controller;

import com.google.inject.Inject;

public class ControllerProviderImpl implements ControllerProvider {
    private MainController mainController;

    @Inject
    public ControllerProviderImpl(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public MainController getMainController() {
        return mainController;
    }
}
