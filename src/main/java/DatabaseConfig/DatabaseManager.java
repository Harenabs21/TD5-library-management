package DatabaseConfig;

import java.sql.*;

public class DatabaseManager {
    private static DatabaseManager instance;
    private final Connection connection;

    private DatabaseManager() {
        try {
            connection = DriverManager.getConnection(DBSettings.url , DBSettings.user, DBSettings.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return preparedStatement;
    }

}
