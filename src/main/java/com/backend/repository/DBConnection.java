package com.backend.repository;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class DBConnection {
    protected Connection conn;

    public DBConnection() {

    }

    public DBConnection(Connection conn) {
        this.conn = conn;
    }

    public void connect() {
        try {
            String url = "jdbc:postgresql://localhost:5432/POS";
            this.conn = DriverManager.getConnection(url, "ianys", "blacklotus");
        }catch (Exception e) {
            System.out.println("error" + e.toString());
        }
    }

    public void disconnect() {
        try {
            this.conn.close();
        }catch (Exception e) {
            System.out.println("error" + e.toString());
        }
    }
}
