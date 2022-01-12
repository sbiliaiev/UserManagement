package com.v2.service;

import com.v2.repo.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDtoTest {
    @Test
    public void testGetters() {
        UserDto user = new UserDto(123, "some name", "some email");
        assertEquals(123, user.getId());
        assertEquals("some name", user.getName());
        assertEquals("some email", user.getEmail());
    }
}
