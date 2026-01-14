package com.assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdatePercentages {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "mysql@123";

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String updateQuery =
                    "UPDATE Students " +
                    "SET percentage = percentage + (percentage * 0.05) " +
                    "WHERE branch = 'CSE'";

            int rows = stmt.executeUpdate(updateQuery);

            if (rows > 0) {
                System.out.println("Percentage increased by 5% for CSE students");
                System.out.println("Rows affected: " + rows);
            } else {
                System.out.println("No CSE students found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error while updating records");
            e.printStackTrace();
        }
    }
}

