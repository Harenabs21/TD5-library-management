package DatabaseConfig;

public class DBSettings {
    public String url = System.getenv("url");
    public String user= System.getenv("user");
    public String password = System.getenv("password");
}
