import model.Account;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    
    public void addCustomer(Customer customer) {
        String sql = """
            INSERT INTO CUSTOMER (customer_id, name, address, email, phone_number, date_of_birth)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getEmail());
            statement.String(5, customer.getPhoneNumber());

            statement.setDate(6, java.sql.Date.valueOf(customer.getDateOfBirth()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer findCustomerByIDd(int customerId) {
        String sql = """
            SELECT customer_id, name, address, email, phone_number, date_of_birth
            FROM Customer
            WHERE customer_id = ?
        """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.preparedStatement(sql);

        ) {
            statement.setInt(1, customerId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Customer(
                    result.getInt("customer_id"),
                    result.getString("name"),
                    result.getString("address"),
                    result.getString("email"),
                    result.getString("phone_number"),
                    result.getDate("date_of_birth").toLocalDate()

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
