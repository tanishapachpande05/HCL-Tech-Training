package com.assignment4;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "mysql@123";   

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Connection Successful");
            } else {
                System.out.println("Unable to connect");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Unable to connect");
            System.out.println(e);
        }
    }
}

