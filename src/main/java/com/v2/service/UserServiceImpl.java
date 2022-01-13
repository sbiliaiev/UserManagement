package com.v2.service;

import com.v2.repo.UserRepository;
import com.v2.repo.UserRepositoryImpl;
import com.v2.service.validation.CreateUserValidator;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl INSTANCE;

    private final UserRepository repo = UserRepositoryImpl.getInstance();

    public static UserServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserServiceImpl();
        }

        return INSTANCE;
    }

    @Override
    public UserDto createUser(UserDto dto) throws SQLException {
        if (!CreateUserValidator.validate(dto)) {
            return null;
        }

        return UserDtoMapper.map(
                repo.createUser(dto.getName(), dto.getEmail())
        );
    }

    @Override
    public UserDto findById(long id) throws Exception {
        return UserDtoMapper.map(
                repo.findById(id)
        );
    }

    @Override
    public UserDto updateUser(UserDto dto) throws SQLException {
        return UserDtoMapper.map(
                repo.updateUser(dto.getId(), dto.getName(), dto.getEmail())
        );
    }

    @Override
    public void removeUser(long id) throws SQLException {
        repo.removeUser(id);
    }
}
