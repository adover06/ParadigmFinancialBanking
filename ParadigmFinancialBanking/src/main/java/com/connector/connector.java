package com.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

//boilerplate code from geeks for geeks

public class connector {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting");
        Dotenv env = Dotenv.load();
        String url = env.get("DB_URL");
        String username = env.get("DB_USER"); // MySQL credentials
        String password = env.get("DB_PASSWORD");
        String query = "select * from Customer"; // Query to be run
        System.out.println("Attempting to load driver");
        // Load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        // Establish connection
        System.out.println("Attempting to establish connection");
        Connection con;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.err.println("Could not establish the database connection: " + e.getMessage());
            throw e;
        }
        System.out.println("Connection object created");
        System.out.println("Connection Established successfully");
        System.out.println("Creating statement");
        // Create a statement
        Statement st = con.createStatement();

        // Execute the query
        ResultSet rs = st.executeQuery(query);

        // Process the results
        System.out.println("Processing results");
        while (rs.next()) {
                String customerId = rs.getString("customer_id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String dob = rs.getString("DOB");
                System.out.printf("Customer ID: %s | Name: %s | Address: %s | Email: %s | Phone: %s | DOB: %s%n",
                    customerId, name, address, email, phoneNumber, dob);
        }

        // Close the statement and connection
        rs.close();
        st.close();
        con.close();
        System.out.println("Connection Closed....");
    }
}
