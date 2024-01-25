package ru.gb.hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertFakeData {
    public static void insertData() {
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO workers (name, position, salary) VALUES (?, ?, ?)")) {

            // Вставляем фейковые данные
            for (int i = 1; i <= 10; i++) {
                preparedStatement.setString(1, "Сотрудник " + i);
                preparedStatement.setString(2, "Должность " + i);
                preparedStatement.setDouble(3, 50000 + i * 1000);
                preparedStatement.executeUpdate();
            }

            System.out.println("Данные успешно добавлены в таблицу 'работники'.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

