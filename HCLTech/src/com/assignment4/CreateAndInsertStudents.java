package com.assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateAndInsertStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "mysql@123";

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String createTable =
                    "CREATE TABLE IF NOT EXISTS Students (" +
                    "eno INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "branch VARCHAR(20)," +
                    "percentage DOUBLE" +
                    ")";

            stmt.executeUpdate(createTable);
            System.out.println("Students table created successfully");

            String insert1 =
                    "INSERT INTO Students VALUES (1, 'Tanisha', 'CSE', 89.5)";
            String insert2 =
                    "INSERT INTO Students VALUES (2, 'Amit', 'IT', 82.3)";
            String insert3 =
                    "INSERT INTO Students VALUES (3, 'Neha', 'ECE', 76.4)";

            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);

            System.out.println("Records inserted successfully");

            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}

