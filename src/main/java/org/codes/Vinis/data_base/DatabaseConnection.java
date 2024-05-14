package org.codes.Vinis.data_base;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection implements AutoCloseable {
    private final String hostname;
    private final int port;
    private final String username;
    private final String password;
    private final String url;

    public DatabaseConnection(String hostname, int port, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.url = "jdbc:mysql://" + hostname + ":" + port + "/test_foda";
    }
    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
