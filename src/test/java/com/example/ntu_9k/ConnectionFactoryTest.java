package com.example.ntu_9k;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionFactoryTest {
    @Test
    public void testGetConnection() {
        Connection conn = ConnectionFactory.getConnection();
        assertNotNull(conn);
        try {
            assertFalse(conn.isClosed());
        } catch (SQLException e) {
            fail("Не удалось проверить состояние соединения");
        }
    }

    @Test
    public void testGetPassword() {
        String password = ConnectionFactory.getPassword();
        assertNotNull(password);
        assertTrue(password.length() > 0);
    }
}