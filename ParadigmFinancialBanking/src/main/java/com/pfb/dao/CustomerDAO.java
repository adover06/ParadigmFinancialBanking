package com.pfb.dao;

import com.pfb.model.Customer;
import com.pfb.db.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    
    public void addCustomer(Customer customer) {
        String sql = """
            INSERT INTO Customer (customer_id, name, address, email, phone_number, DOB)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (
            Connection connection = Db.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getPhoneNumber());

            statement.setDate(6, java.sql.Date.valueOf(customer.getDob()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer findCustomerById(int customerId) {
        String sql = """
            SELECT customer_id, name, address, email, phone_number, DOB
            FROM Customer
            WHERE customer_id = ?
        """;

        try (
            Connection connection = Db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

        ) {
            statement.setInt(1, customerId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Customer(
                    result.getInt("customer_id"),
                    result.getString("name"),
                    result.getString("address"),
                    result.getString("email"),
                    result.getDate("DOB").toLocalDate(),
                    result.getString("phone_number")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
