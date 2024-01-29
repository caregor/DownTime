package ru.gb.hw;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData {
    public static void selectData(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            String selectTableQuery = "SELECT * FROM workers LIMIT 1";
            ResultSet resultSet = statement.executeQuery(selectTableQuery);

            // Обработка результатов запроса
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
            }

            System.out.println("Данные запрошены");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
