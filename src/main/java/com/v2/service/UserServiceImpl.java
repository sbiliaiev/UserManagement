package com.v2.service;

import com.v2.repo.UserRepository;
import com.v2.service.validation.CreateUserValidator;

public class UserServiceImpl implements UserService {

    private UserRepository repo = UserRepository.getInstance();

    @Override
    public UserDto createUser(UserDto dto) {
        if (!CreateUserValidator.validate(dto)) {
            return null;
        }

        return UserDtoMapper.map(
            repo.createUser(dto.getName(), dto.getEmail())
        );
    }

    @Override
    public UserDto findById(long id) {
        return UserDtoMapper.map(
            repo.findById(id)
        );
    }

    @Override
    public UserDto updateUser(UserDto dto) {
        return UserDtoMapper.map(
            repo.updateUser(dto.getId(), dto.getName(), dto.getEmail())
        );
    }
}
