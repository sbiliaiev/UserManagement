package com.v2.repo;

public interface UserRepository {

    User createUser(String name, String email);

    User findById(long id);

    User updateUser(long id, String name, String email);

    public static UserRepository getInstance() {
        return null;
    }
}

