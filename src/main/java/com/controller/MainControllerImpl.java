package com.controller;

import com.google.inject.Inject;
import com.model.UserRepository;
import com.view.UserListView;

public class MainControllerImpl implements MainController {

    private UserListView userListView;
    private UserRepository userRepository;
    private String filter;

    @Inject
    public MainControllerImpl(UserListView userListView, UserRepository userProvider) {
        this.userListView = userListView;
        this.userRepository = userProvider;
        this.filter = "";
    }

    @Override
    public void init() {
        userListView.initView();
        userListView.displayUsers(userRepository.getUsers());
    }

    @Override
    public void setFilter(String filter) {
        this.filter = filter.trim();
    }

    @Override
    public void updateUserList() {
        userListView.displayUsers(userRepository.getUsers(filter));
    }

    @Override
    public void fetchUsers() {
        userRepository.fetchUsers(u -> updateUserList());
    }


}
