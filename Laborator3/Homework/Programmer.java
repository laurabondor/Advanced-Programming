import java.util.Map;
import java.util.Objects;
public class Programmer extends Person {
    private String limbaj;
    /**
     * Programmer reprezinta constructorul clasei
     * @param name reprezinta numele programatorului Programmer
     * @param dataNastere reprezinta data nasterii a programatorului Programmer
     * @param limbaj reprezinta tipul de limbaj in care lucreaza programatorul Programmer
     */
    public Programmer(String name, String dataNastere, String limbaj) {
        super(name, dataNastere);
        this.limbaj = limbaj;
    }
    /**
     * este o metoda mostenita de la clasa Person
     * @return returneaza numele programatorului Programmer
     * */
    @Override
    public String getName() {
        return super.getName();
    }
    /**
     * este o metoda mostenita de la clasa Person
     * @param name seteaza numele name pentru programatorul Programmer
     * */
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    /**
     * este o metoda mostenita de la clasa Person
     * @return returneaza data nasterii a programatorului Programmer
     * */
    @Override
    public String getDataNastere() {
        return super.getDataNastere();
    }
    /**
     * este o metoda mostenita de la clasa Person
     * @param dataNastere seteaza data nasterii pentru programatorul Programmer
     * */
    @Override
    public void setDataNastere(String dataNastere) {
        super.setDataNastere(dataNastere);
    }
    /**
     * este o metoda getter
     * @return returneaza numele limbajului in care lucreaza programatorului Programmer
     * */
    public String getLimbaj() {
        return limbaj;
    }
    /**
     * este o metoda setter
     * @param limbaj seteaza numele limbajului in care lucreaza programatorului Programmer
     * */
    public void setLimbaj(String limbaj) {
        this.limbaj = limbaj;
    }

    @Override
    public int compareTo(Person other) {
        return super.compareTo(other);
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + getName() + '\'' +
                ", dataNastere=" + getDataNastere() +
                ", limbaj=" + getLimbaj() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Programmer that = (Programmer) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getDataNastere(), that.getDataNastere());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDataNastere());
    }

    @Override
    public Map<Node, String> getRelationships() {
        return super.getRelationships();
    }

    @Override
    public void addRelationship(Node node, String relatie) {
        super.addRelationship(node, relatie);
    }
}
