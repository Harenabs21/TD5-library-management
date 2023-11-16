import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url =System.getenv("url");
        String user= System.getenv("user");
        String password = System.getenv("password");
         try{
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
