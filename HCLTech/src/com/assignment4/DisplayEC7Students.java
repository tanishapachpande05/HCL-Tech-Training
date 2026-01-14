package com.assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DisplayEC7Students {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "mysql@123"; // change if required

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create Statement
            Statement stmt = con.createStatement();

            // SELECT Query
            String selectQuery =
                    "SELECT * FROM Students " +
                    "WHERE semester = 7 AND branch = 'EC'";

            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("Eno\tName\tBranch\tSemester\tPercentage");
            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getInt("eno") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("branch") + "\t" +
                        rs.getInt("semester") + "\t\t" +
                        rs.getDouble("percentage")
                );
            }

            if (!found) {
                System.out.println("No records found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error while fetching records");
            e.printStackTrace();
        }
    }
}

