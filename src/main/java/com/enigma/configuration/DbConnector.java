package com.enigma.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static Connection conn;
    public Connection startConnect(){
        String url = "jdbc:postgresql://localhost/db_bioskop";
        String username = System.getenv("USERNAME_DB");
        String password = System.getenv("PASSWORD_DB");
        try {
            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("sukses");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return conn;

    }
}
