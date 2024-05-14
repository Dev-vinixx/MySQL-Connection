package org.codes.Vinis.data_base.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.codes.Vinis.data_base.DatabaseConnection;
import org.codes.Vinis.user.User;

public class UserDAO {
    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (user_id, user_name, user_age) VALUES (?, ?, ?)";

        try (DatabaseConnection dbConnection = new DatabaseConnection("localhost", 3306, "Vinis", "111111");
             PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getAge());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new SQLException("Error creating user: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
