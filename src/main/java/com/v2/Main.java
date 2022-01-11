package com.v2;

import com.v2.service.UserDto;
import com.v2.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl us = UserServiceImpl.getInstance();

        System.out.println(us.findById(13));

//        System.out.println(us.updateUser(new UserDto(13, "nasdasdas name", "asdasdasnew@mail")));
//
//        System.out.println(us.findById(13));

        us.removeUser(13);

        System.out.println(us.findById(13));

//        System.out.println(us.createUser(new UserDto("test", "test@mail.co")));
//        System.out.println(us.createUser(new UserDto("another user", "aaaa@mail.ru")));
//        System.out.println( us.createUser(new UserDto("one more user", "bbbb@mail.ua")));
    }
}
