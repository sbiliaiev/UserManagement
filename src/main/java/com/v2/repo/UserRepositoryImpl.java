package com.v2.repo;

import com.v2.ConnectionService;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl INSTANCE;

    private static Connection conn;

    public UserRepositoryImpl() {
        conn = ConnectionService.getConnection();
        System.out.println(conn);
    }

    public static UserRepositoryImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepositoryImpl();
        }

        return INSTANCE;
    }

    @Override
    public User createUser(String name, String email) throws SQLException {
        String query = String.format("INSERT INTO USERS (name, email) VALUES ('%s', '%s');", name, email);
        PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.executeUpdate();
        ResultSet result = st.getGeneratedKeys();
        result.next();

        return new User(result.getInt(1), result.getString(2), result.getString(3));
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User updateUser(long id, String name, String email) {
        return null;
    }

    @Override
    public void removeUser(long id) {

    }
}
