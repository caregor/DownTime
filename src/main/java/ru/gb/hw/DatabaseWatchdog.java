package ru.gb.hw;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class DatabaseWatchdog {

    private static final long CHECK_INTERVAL_MS = 500; // Периодичность проверки (0.5 секунд)
    public static void startWatchdog() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkConnection();
            }
        }, 0, CHECK_INTERVAL_MS);
    }

    private static void checkConnection() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        boolean success = false;
        while (!success) {
            try (Connection connection = DatabaseConnector.connect()) {
                if (connection.isValid(2)) {
                    System.out.println(LocalTime.now().format(formatter) +": Соединение с базой данных активно.");
                    SelectData.selectData(connection);
                    success = true;
                }
            } catch (SQLException e) {
                System.out.println("Ошибка при проверке соединения: " + e.getMessage());
            }
        }
    }
}

