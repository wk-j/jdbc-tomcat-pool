package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.wk.IDbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    IDbService db;

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

    @RequestMapping("/p")
    public String p() throws SQLException {
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
                // org.apache.tomcat.jdbc.pool.DataSource
                // if
                // (info.getClassName().equals("org.apache.tomcat.jdbc.pool.jmx.ConnectionPool"))
                // {
                if (info.getClassName().equals(" org.apache.tomcat.jdbc.pool.DataSource")) {
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