package com;

import com.controller.ControllerProvider;
import com.controller.ControllerProviderImpl;
import com.controller.MainController;
import com.controller.MainControllerImpl;
import com.google.inject.AbstractModule;
import com.model.UserRepository;
import com.model.UserRepositoryImpl;
import com.view.OnTextChangedListener;
import com.view.UserListViewImpl;
import com.view.UserListView;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MainController.class).to(MainControllerImpl.class);
        bind(UserRepository.class).to(UserRepositoryImpl.class);
        bind(UserListView.class).to(UserListViewImpl.class);
        bind(ControllerProvider.class).to(ControllerProviderImpl.class);
    }
}
