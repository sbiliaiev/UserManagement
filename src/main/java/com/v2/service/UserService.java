package com.v2.service;

public interface UserService {

    UserDto createUser(UserDto dto);

    UserDto findById(long id);

    UserDto updateUser(UserDto dto);
}

