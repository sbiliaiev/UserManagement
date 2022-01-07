package com.userManagement;

import java.sql.SQLException;

public final class UserService implements Crud<User> {
    private static UserService INSTANCE;

    private static UserRepository repository;

    private UserService() {
        repository = UserRepository.getInstance();
    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }

        return INSTANCE;
    }

    @Override
    public User create(User user) throws SQLException {
        return repository.create(user);
    }

    @Override
    public User read(int id) {
        return repository.read(id);
    }

    @Override
    public User update(User user) {
        return repository.update(user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
