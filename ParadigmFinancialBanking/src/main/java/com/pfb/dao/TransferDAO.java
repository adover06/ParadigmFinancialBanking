package com.pfb.dao;

import com.pfb.model.Transfer;
import com.pfb.db.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferDAO {
    public void addTransfer(Transfer transfer) {
        String sql = """
            INSERT INTO Transfer (transfer_id, sender_id, receiver_id, amount, transfer_date)
            VALUES (?, ?, ?, ?, ?)
            """;
        try (
            Connection connection = Db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
        ) {
            statement.setInt(1, transfer.getTransferId());
            statement.setInt(2, transfer.getSenderId());
            statement.setInt(3, transfer.getReceiverId());
            statement.setInt(4, transfer.getAmount());
            statement.setDate(5, java.sql.Date.valueOf(transfer.getTransferDate()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Transfer findTransferById(int transferId) {
        String sql = """
            SELECT transfer_id, sender_id, receiver_id, amount, transfer_date
            FROM Transfer
            WHERE transfer_id = ?
            """;
        try (
            Connection connection = Db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, transferId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return new Transfer(
                    result.getInt("amount"),
                    result.getDate("transfer_date").toLocalDate(),
                    result.getInt("transfer_id"),
                    result.getInt("sender_id"),
                    result.getInt("receiver_id")
                );
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
