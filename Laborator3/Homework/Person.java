import java.util.HashMap;
import java.util.Map;
public abstract class Person implements Node, Comparable<Person> {
    private String name;
    private String dataNastere;
    private Map<Node, String> relationships = new HashMap<>();
    @Override
    public abstract String toString();
    @Override
    public abstract int hashCode();
    @Override
    public abstract boolean equals(Object obj);
    /**
     * Person reprezinta constructorul clasei
     * @param name reprezinta numele persoanei Person
     * @param dataNastere reprezinta data nasterii a persoanei Person
     * */
    public Person(String name, String dataNastere){
        this.name = name;
        this.dataNastere = dataNastere;
    }
    /**
     * Implementam metoda getName() datorita faptului ca exista in interfata Node pe care o implementeaza clasa noastra Person
     * @return returneaza numele persoanei Person
     * */
    @Override
    public String getName() {
        return name;
    }
    /**
     * este o metoda setter
     * @param name seteaza numele pentru persoana Person
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * este o metoda getter
     * @return returneaza data nasterii pentru persoana Person
     * */
    public String getDataNastere() {
        return dataNastere;
    }
    /**
     * este o metoda setter
     * @param dataNastere seteaza data nasterii pentru persoana Person
     * */
    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }
    /**
     * functia compara doua obiecte de tip Person in functie de nume
     * */
    @Override
    public int compareTo(Person other) {
        if (other == null ) throw new NullPointerException("Compare with null");
        if (!( other instanceof Person ))
            throw new ClassCastException ("Uncomparable objects!");
        return this.name.compareTo(other.name);
    }
    /**
     * functia adauga o relatie intre doua noduri
     * @param node reprezinta nodul pentru care vrem sa cream conexiune
     * @param relatie reprezinta tipul relatiei dintre noduri
     * */
    public void addRelationship(Node node, String relatie) {
        relationships.put(node, relatie);
    }
    /**
     * @return returneaza tipul de relatie pe care il are nodul Node
     */
    public Map<Node, String> getRelationships() {
        return relationships;
    }
}
