package com.v2.service.validation;

import com.v2.service.UserDto;

public class CreateUserValidator {
    private CreateUserValidator() {
    }

    public static boolean validate(UserDto dto) {
        if (dto.getId() != 0) {
            return false;
        }

        if (!(dto.getEmail().contains("@"))) {
            return false;
        }

        int nameLength = dto.getName().length();
        return nameLength >= 3 && nameLength <= 20;
    }
}
