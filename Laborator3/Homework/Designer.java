import java.util.Map;
import java.util.Objects;
public class Designer extends Person{
    private String catalog;
    /**
     * Designer reprezinta constructorul clasei
     * @param name reprezinta numele designerului Designer
     * @param dataNastere reprezinta data nasterii a designerului Designer
     * @param catalog reprezinta catalogul designerului Designer
     */
    public Designer(String name, String dataNastere, String catalog) {
        super(name, dataNastere);
        this.catalog = catalog;
    }
    /**
     * este o metoda mostenita de la clasa Person
     * @return returneaza numele designerului Designer
     * */
    @Override
    public String getName() {
        return super.getName();
    }
    /**
     * este o metoda mostenita de la clasa Person
     * @param name seteaza numele name pentru designerului Designer
     * */
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    /**
     * este o metoda mostenita de la clasa Person
     * @return returneaza data nasterii a designerului Designer
     * */
    @Override
    public String getDataNastere() {
        return super.getDataNastere();
    }
    /**
     * este o metoda mostenita de la clasa Person
     * @param dataNastere seteaza data nasterii pentru designerul Designer
     * */
    @Override
    public void setDataNastere(String dataNastere) {
        super.setDataNastere(dataNastere);
    }
    /**
     * este o metoda getter
     * @return returneaza numele catalogului al designerului Designer
     * */
    public String getCatalog() {
        return catalog;
    }
    /**
     * este o metoda setter
     * @param catalog seteaza numele catalogului al designerului Designer
     * */
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    @Override
    public int compareTo(Person other) {
        return super.compareTo(other);
    }

    @Override
    public String toString() {
        return "Designer{" +
                "name='" + getName() + '\'' +
                ", dataNastere=" + getDataNastere() +
                ", catalog=" + getCatalog() +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designer that = (Designer) o;
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
