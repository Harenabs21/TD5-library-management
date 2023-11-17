package Model;
public class Visitors {
    private int id;
    private String name;
    private String reference;

    public Visitors(int id, String name, String reference) {
        this.id = id;
        this.name = name;
        this.reference = reference;
    }
    public Visitors(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Visitors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
