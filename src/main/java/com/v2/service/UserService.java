package com.v2.service;

import java.sql.SQLException;

public interface UserService {

    UserDto createUser(UserDto dto) throws SQLException;

    UserDto findById(long id);

    UserDto updateUser(UserDto dto);

    void removeUser(long id);
}

