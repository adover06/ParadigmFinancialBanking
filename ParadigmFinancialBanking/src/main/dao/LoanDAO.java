import model.Loan;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoanDAO {
    public void addLoan(Loan loan) {
        String sql = """
            INSERT INTO LOAN (loan_id, interest_rate, loan_type, account_id, start_date, amount)
            VALUES (?, ?, ?, ?, ?, ?)
            """;
        
         try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
         ) {
            statement.setInt(1, loan.getLoanId());
            statement.setInt(2, loan.getInterestRate());
            statement.setString(3, loan.getLoanType());
            statement.setInt(4, loan.getAccountId());
            statement.setDate(5, java.sql.Date.valueOf(loan.getStartDate()));
            statement.setInt(6, loan.getAmount());

         } catch (SQLException e) {
            e.printStackTrace();
         }
    }

    public Loan findLoanById(int loanId) {
        String sql = """
            SELECT loan_id, interest_rate, loan_type, account_id, start_date, amount
            FROM Loan
            WHERE loan_id = ?
            """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, loanId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Loan(
                    result.getInt("loan_id"),
                    result.getInt("interest_rate"),
                    result.getString("loan_type"),
                    result.getInt("account_id"),
                    result.getDate("start_date").toLocalDate(),
                    result.getInt("amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
