package Model;
import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private int id;
    private String bookName;
    private int pageNumbers;
    private Topic topic;
    private Date releaseDate;

    // Enum pour les différents topics
    public enum Topic {
        ROMANCE, COMEDY, OTHER
    }
}
