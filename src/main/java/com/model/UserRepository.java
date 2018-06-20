package com.model;

import java.util.List;
import java.util.function.Consumer;

public interface UserRepository {
    List<String> getUsers();

    List<String> getUsers(String pattern);

    void fetchUsers(Consumer<List<String>> consumer);
}
