
import model.Account;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    
    //CREATE

    public void addAccount(Account account) {
        String sql = """
            INSERT INTO Account
            (account_id, customer_id, acocunt_type, balance)
            VALUES (?, ?, ?, ?)
        """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, account.getAccountId());
            statement.setInt(2, account.getCustomerId());
            statement.setString(3, account.getAccountType());
            statement.setDouble(4, account.getBalance());

            statement.executeUpdate();

            System.out.println("Account added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account findAccountById(int accountId) {
        String sql = """
            SELECT accound_id, customer_id, account_type, balance
            FROM Account
            WHERE account_id = ?
            """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, accountId);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                return new Account(
                    result.getInt("account_id"),
                    result.getInt("customer_id"),
                    result.getString("account_type"),
                    result.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
