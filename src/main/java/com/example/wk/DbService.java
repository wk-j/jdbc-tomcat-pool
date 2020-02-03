package com.example.wk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DbService implements IDbService {
    @Autowired
    private DataSource source;

    public void q() throws SQLException {
        long startTime = System.currentTimeMillis();

        try (Connection c = source.getConnection(); Statement stmt = c.createStatement()) {
            String SQL = "SELECT TOP 10 * FROM dbo.spt_monitor";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.print(rs.getString("cpu_busy"));
            }
            long endTime = System.currentTimeMillis();
            System.out.println(" That took " + (endTime - startTime) + " milliseconds");
        }
    }

    public DataSource getDataSource() throws SQLException {
        return source;
    }
}