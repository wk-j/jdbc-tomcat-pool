package com.example.springboot;

import javax.sql.DataSource;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class A {

    @Autowired
    private DataSource dataSource;

    @Test
    public void givenTomcatConnectionPoolInstance_whenCheckedPoolClassName_thenCorrect() {
        String name = dataSource.getClass().getName();
        assertThat(name).isEqualTo("org.apache.tomcat.jdbc.pool.DataSource");
    }
}