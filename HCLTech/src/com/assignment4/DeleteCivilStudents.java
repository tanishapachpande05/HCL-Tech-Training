package com.assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteCivilStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "mysql@123"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            String deleteQuery =
                    "DELETE FROM Students " +
                    "WHERE year_of_passing = 2024 AND branch = 'Civil'";

            int rows = stmt.executeUpdate(deleteQuery);

            if (rows > 0) {
                System.out.println("Students deleted successfully");
                System.out.println("Rows affected: " + rows);
            } else {
                System.out.println("No matching student records found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error while deleting records");
            e.printStackTrace();
        }
    }
}
