package com.example.wk;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public interface IDbService {
    public void q() throws SQLException;

    public DataSource getDataSource() throws SQLException;
}