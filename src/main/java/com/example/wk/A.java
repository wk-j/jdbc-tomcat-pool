package com.example.wk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.DataSourceProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

public class A {

    @Configuration
    @ConditionalOnProperty(prefix = "datasource.main", name = "jmx-enabled")
    @ConditionalOnClass(DataSourceProxy.class)
    @ConditionalOnMissingBean(name = "mainDataSourceMBean")
    public static class Config {

        @Bean
        @DependsOn("mbeanExporter")
        public Object mainDataSourceMBean(@Qualifier("mainDataSource") DataSource dataSource) {
            if (dataSource instanceof DataSourceProxy) {
                try {
                    return ((DataSourceProxy) dataSource).createPool().getJmxPool();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
