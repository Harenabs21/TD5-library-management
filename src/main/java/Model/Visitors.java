package Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Visitors extends  User{
    private String reference;
    public Visitors(int id, String name, String reference) {
        super(id, name);
        this.reference = reference;
    }
}
