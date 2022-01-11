package com.v2.repo;

import java.sql.SQLException;

// TODO: implement
public interface UserRepository {

    User createUser(String name, String email) throws SQLException;

    User findById(long id);

    User updateUser(long id, String name, String email);

    void removeUser(long id);
}

