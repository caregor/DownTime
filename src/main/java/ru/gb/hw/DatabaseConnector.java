package ru.gb.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://qa-srv-tk-bd247b1cefd29919ca70b7188a78bd05c666a66742a9e1adebd.postgres-stg.k-stg-1.luxembourg-2.cloud.gc.onl:5432/qadb";
    private static final String USER = "caregor";
    private static final String PASSWORD = "FtijP25z9qdrYLU6PGCjVRWesnwRGlv1H-8S4yONEm4";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
