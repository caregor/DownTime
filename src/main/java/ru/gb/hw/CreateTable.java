package ru.gb.hw;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createTable() {
        dropTable();
        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE workers ("
                    + "id SERIAL PRIMARY KEY,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "position VARCHAR(50) NOT NULL,"
                    + "salary DOUBLE PRECISION NOT NULL)";
            statement.executeUpdate(createTableQuery);
            System.out.println("Таблица 'работники' создана успешно.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void dropTable(){
        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement()){
            String dropTableQuery = "DROP TABLE IF EXISTS workers";
            statement.executeUpdate(dropTableQuery);
            System.out.println("Таблица удалена.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
