package ru.gb.hw;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class DatabaseWatchdog {

    private static final long CHECK_INTERVAL_MS = 500; // Периодичность проверки (30 секунд)

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
        try (Connection connection = DatabaseConnector.connect()) {
            if (connection.isValid(2)) {
                System.out.println("Соединение с базой данных активно.");
            } else {
                System.out.println("Соединение с базой данных утеряно. Повторное подключение...");
                // Попробуйте восстановить соединение
                // (может потребоваться пересоздать соединение в вашем приложении)
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при проверке соединения: " + e.getMessage());
            // Логгирование или другие действия при ошибке
        }
    }
}

