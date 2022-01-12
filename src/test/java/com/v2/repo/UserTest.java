package com.v2.repo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTest {
    @Test
    public void testGetters() {
        User user = new User(123, "some name", "some email");
        assertEquals(123, user.getId());
        assertEquals("some name", user.getName());
        assertEquals("some email", user.getEmail());
    }
}
