package com.example.ntu_9k;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Фабрика подключений к базе данных
 */
public class ConnectionFactory {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/ntuk?useSSL=false";
    public static final String DB_USER = "root"; // ваш пользователь, у нас root
    public static final String DB_PASSWORD = getPassword(); // ваш пароль (получение из безопасного источника)

    /**
     * Получение подключения к базе данных
     *
     * @return Объект Connection
     */
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException("Ошибка подключения к базе данных", ex);
        }
    }

    /**
     * Получение пароля из безопасного источника (например, файл настроек, переменная окружения и т. д.)
     *
     * @return Пароль
     */
    private static String getPassword() {
        // Ваш код для получения пароля из безопасного источника
        String password = "sabarak"; // Пример: пароль получен из безопасного источника
        return password;
    }
}
