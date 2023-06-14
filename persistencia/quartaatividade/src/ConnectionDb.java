import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    
    private ConnectionDb() {
        throw new IllegalStateException("Utility class");
    }

    public static Connection buildConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "user",
                "password");
    }
}
