package com.v2.repo;

import java.sql.SQLException;

// TODO: implement
public interface UserRepository {

    User createUser(String name, String email) throws SQLException;

    User findById(long id) throws SQLException;

    User updateUser(long id, String name, String email) throws SQLException;

    void removeUser(long id) throws SQLException;
}

