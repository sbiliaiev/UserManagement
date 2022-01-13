package com.v2.service;

import java.sql.SQLException;

public interface UserService {

    UserDto createUser(UserDto dto) throws SQLException;

    UserDto findById(long id) throws SQLException, Exception;

    UserDto updateUser(UserDto dto) throws SQLException;

    void removeUser(long id) throws SQLException;
}

