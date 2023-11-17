package DatabaseConfig;

import lombok.Getter;
import org.apache.commons.dbcp2.BasicDataSource;
 @Getter
public class DatabaseManager {
    private static final BasicDataSource dataSource = new BasicDataSource();

    static{
        dataSource.setUrl(DBSettings.url);
        dataSource.setUsername(DBSettings.user);
        dataSource.setPassword(DBSettings.password);
    }

}
