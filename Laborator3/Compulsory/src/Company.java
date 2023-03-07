public class Company implements Node, Comparable<Company>{

    private String name;
    /**
     * Company reprezinta constructorul clasei
     * @param name reprezinta numele companiei Company
     * */
    public Company(String name){
        this.name = name;
    }
    /**
     * Implementam metoda getName() datorita faptului ca exista in interfata Node pe care o implementeaza clasa noastra Company
     * @return returneaza numele companiei Company
     * */
    @Override
    public String getName() {
        return name;
    }
    /**
     * este o metoda setter
     * @param name seteaza numele pentru compania Company
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * functia compara doua obiecte de tip Company in functie de nume
     * */
    @Override
    public int compareTo(Company other) {
        if (other == null ) throw new NullPointerException("Compare with null");
        if (!( other instanceof Company ))
            throw new ClassCastException ("Uncomparable objects!");
        return this.name.compareTo(other.name);
    }
}
