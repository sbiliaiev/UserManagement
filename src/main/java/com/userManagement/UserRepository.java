package com.userManagement;

import java.sql.*;

public final class UserRepository implements Crud<User> {
    private static UserRepository INSTANCE;

    private static ConnectionService cs;
    private static Connection conn;

    private UserRepository() {
        cs = ConnectionService.getInstance();
        conn = ConnectionService.getConnection();
    }

    public static UserRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }

        return INSTANCE;
    }

    @Override
    public User create(User user) throws SQLException {
        String query = String.format("INSERT INTO USERS (name, email) VALUES ('%s', '%s');", user.getName(), user.getEmail());
        System.out.println(query);
        PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.executeUpdate();
        ResultSet result = st.getGeneratedKeys();
        result.next();
        user.setId(result.getInt(1));
//        while (result.next()) {
//            int id = result.getInt(1);
//            String name = result.getString(2);
//            String email = result.getString(3);
//            System.out.print("id = ");
//            System.out.println(id);
//
//            System.out.print("name = ");
//            System.out.println(name);
//
//            System.out.print("email = ");
//            System.out.println(email);
//        }
        return user;
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
