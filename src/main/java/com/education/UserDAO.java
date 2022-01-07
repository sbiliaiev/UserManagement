package com.education;

import java.util.LinkedList;
import java.util.List;

public class UserDAO {
    private List<User> users = new LinkedList<>();

    private static UserDAO userDAOInstance = null;

    private UserDAO() {

    }

    public static UserDAO getInstance() {
        if (userDAOInstance == null) {
            userDAOInstance = new UserDAO();
        }

        return userDAOInstance;
    }

    public int create(User user) {
        if (user != null) {
            users.add(user);
            return user.getId();
        }

        return 0;
    }

    public User read(int id) {
        return (User) users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User update(User user) {
        int index = users.indexOf(read(user.getId()));
        return users.set(index, user);
    }

    public void delete(int id) {
        users.remove(read(id));
    }

    public List<User> readAll() {
        return users;
    }
}
