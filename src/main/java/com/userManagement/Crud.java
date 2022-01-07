package com.userManagement;

import java.sql.SQLException;

public interface Crud<T> {
    T create(T entity) throws SQLException;

    T read(int id);

    T update(T entity);

    void delete(int id);
}
