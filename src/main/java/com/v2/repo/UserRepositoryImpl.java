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
        st.execute();
        ResultSet result = st.getGeneratedKeys();
        result.next();

        return new User(result.getInt(1), result.getString(2), result.getString(3));
    }

    @Override
    public User findById(long id) throws SQLException {
        String query = String.format("SELECT * FROM USERS WHERE id=%s;", id);
        PreparedStatement st = conn.prepareStatement(query);
        st.execute();
        ResultSet result = st.getResultSet();
        result.next();

        return new User(result.getInt(1), result.getString(2), result.getString(3));
    }

    @Override
    public User updateUser(long id, String name, String email) throws SQLException {
        String query = String.format("UPDATE USERS SET name='%s', email='%s' WHERE id=%s;", name, email, id);
        PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.execute();
        ResultSet result = st.getGeneratedKeys();
        result.next();

        return new User(result.getInt(1), result.getString(2), result.getString(3));
    }

    @Override
    public void removeUser(long id) throws SQLException {
        String query = String.format("DELETE FROM USERS WHERE id=%s;", id);
        PreparedStatement st = conn.prepareStatement(query);
        st.execute();
    }
}
