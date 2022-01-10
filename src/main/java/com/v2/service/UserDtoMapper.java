package com.v2.service;

import com.v2.repo.User;

public class UserDtoMapper {
    private UserDtoMapper() {

    }

    static UserDto map(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
