package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.sql.SQLException;
import java.util.Set;

import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.example.wk.IDbService;

import org.apache.tomcat.jdbc.pool.jmx.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    IDbService db;

    @Bean
    public ConnectionPool getJmxPool() throws SQLException {
        org.apache.tomcat.jdbc.pool.DataSource jdbc = (org.apache.tomcat.jdbc.pool.DataSource) db.getDataSource();
        return jdbc.createPool().getJmxPool();
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/q")
    public String q() throws SQLException {
        System.out.println("new request /q");
        db.q();
        return "Hello";
    }

    @RequestMapping("/n")
    public int n() throws SQLException, JsonProcessingException {
        org.apache.tomcat.jdbc.pool.DataSource jdbc = (org.apache.tomcat.jdbc.pool.DataSource) db.getDataSource();
        int n = jdbc.getNumActive();
        return n;
    }

    @RequestMapping("/p")
    public String p() throws SQLException, JsonProcessingException {
        // ObjectMapper mapper = new ObjectMapper();
        // mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        // mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);

        // String str = mapper.writeValueAsString(db.getDataSource());
        // return str;
        return db.getDataSource().toString();
    }

    @RequestMapping("/m")
    public void m(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p><h1>Tomcat Pool</h1></p><p>");
        try {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objectNames = server.queryNames(null, null);
            for (ObjectName name : objectNames) {
                MBeanInfo info = server.getMBeanInfo(name);
                if (info.getClassName().equals("org.apache.tomcat.jdbc.pool.jmx.ConnectionPool")) {
                    for (MBeanAttributeInfo mf : info.getAttributes()) {
                        Object attributeValue = server.getAttribute(name, mf.getName());
                        if (attributeValue != null) {
                            writer.println("" + mf.getName() + " : " + attributeValue.toString() + "<br/>");

                        }
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.println("</p></body>");
        writer.println("</html>");
    }
}