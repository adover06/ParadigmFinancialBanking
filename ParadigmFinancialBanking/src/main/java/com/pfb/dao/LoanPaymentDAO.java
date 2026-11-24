package com.pfb.dao;

import com.pfb.model.LoanPayment;
import com.pfb.db.Db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanPaymentDAO {
    
    public void addLoanPayment(LoanPayment loanPayment) {
        String sql = """
            INSERT INTO LoanPayment (payment_id, loan_id, payment_date, amount)
            VALUES (?, ?, ?, ?)
            """;

        try (
            Connection connection = Db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, loanPayment.getPaymentId());
            statement.setInt(2, loanPayment.getLoanId());
            statement.setDate(3, java.sql.Date.valueOf(loanPayment.getPaymentDate()));
            statement.setInt(4, loanPayment.getAmount());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LoanPayment findLoanPaymentById(int paymentId) {
        String sql = """
            SELECT payment_id, loan_id, payment_date, amount
            FROM LoanPayment
            WHERE payment_id = ?
            """;

        try (
            Connection connection = Db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, paymentId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new LoanPayment(
                    result.getInt("payment_id"),
                    result.getInt("loan_id"),
                    result.getDate("payment_date").toLocalDate(),
                    result.getInt("amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
