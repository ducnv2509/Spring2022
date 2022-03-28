package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseService {
    static final String db_url = "jdbc:mysql://localhost:3306/it16305";
    static final String user = "root";
    static final String password = "123456";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException el) {
            el.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(db_url, user, password);
        return conn;
    }

}
