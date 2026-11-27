package com.pfb.dao;

import com.pfb.model.Transaction;
import com.pfb.db.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDAO {
    public void addTransaction(Transaction transaction) {
        String sql = """
            INSERT INTO Transaction (transaction_id, amount, account_id, transaction_date)
            VALUES (?, ?, ?, ?)
            """;
        
        try (
            Connection connection = Db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, transaction.getTransactionId());
            statement.setInt(2, transaction.getAmount());
            statement.setInt(3, transaction.getAccountId());
            statement.setDate(4, java.sql.Date.valueOf(transaction.getTransactionDate()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Transaction findTransactionById(int transactionId) {
        String sql = """
            SELECT transaction_id, amount, account_id, transaction_date
            FROM Transaction
            WHERE transaction_id = ?
            """;
        
        try (
            Connection connection = Db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, transactionId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Transaction(
                    result.getInt("transaction_id"),
                    result.getInt("amount"),
                    result.getInt("account_id"),
                    result.getDate("transaction_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
