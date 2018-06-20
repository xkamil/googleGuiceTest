package com.model;

import com.google.inject.Singleton;

import javax.swing.Timer;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Singleton
public final class UserRepositoryImpl implements UserRepository {
    private static List<String> users = new ArrayList<>();

    public List<String> getUsers() {
        return users.subList(0, users.size());
    }

    @Override
    public void fetchUsers(Consumer<List<String>> consumer) {

        try {

            Thread.sleep(new Random().nextInt(1000));
            users = Files.readAllLines(Paths.get(this.getClass().getResource("users.txt").toURI()));
            consumer.accept(users);

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public List<String> getUsers(String pattern) {
        return users.stream()
                .map(String::toLowerCase)
                .filter(e -> e.contains(pattern))
                .collect(Collectors.toList());
    }
}
