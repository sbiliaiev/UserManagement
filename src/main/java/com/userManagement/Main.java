package com.userManagement;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService us = UserService.getInstance();

        System.out.println(us.create(new User("test", "tes")));
//        us.create(new User("another user", "aaaa@mail.ru"));
//        us.create(new User("one more user", "bbbb@mail.ua"));
    }
}
