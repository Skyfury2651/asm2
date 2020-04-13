import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static java.sql.Connection connection;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/human_resource?useUnicode=true&serverTimezone=Asia/Bangkok&characterEncoding=utf-8";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "";

    public static java.sql.Connection getConnection() throws SQLException {
        if(connection == null){
            System.out.println("Khởi tạo kết nối đến database.");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PWD);
        }
        return connection;
    }
}
