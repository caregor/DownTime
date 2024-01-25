package ru.gb.hw;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DropTable {
    public static void dropTable() {
        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement()) {
            String dropTableQuery = "DROP TABLE IF EXISTS workers";
            statement.executeUpdate(dropTableQuery);
            System.out.println("Таблица 'работники' удалена успешно.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

