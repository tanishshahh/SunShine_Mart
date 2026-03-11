import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getPostgresConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Sunshine_Mart",
                "postgres",
                "1612");

    }
}
