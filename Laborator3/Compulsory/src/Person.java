public class Person implements Node, Comparable<Person> {
    private String name;
    /**
     * Person reprezinta constructorul clasei
     * @param name reprezinta numele persoanei Person
     * */
    public Person(String name){
        this.name = name;
    }
    /**
     * Implementam metoda getName() datorita faptului ca exista in interfata Node pe care o implementeaza clasa noastra Person
     * @return returneaza numele persoanei
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
     * functia compara doua obiecte de tip Person in functie de nume
     * */
    @Override
    public int compareTo(Person other) {
        if (other == null ) throw new NullPointerException("Compare with null");
        if (!( other instanceof Person ))
            throw new ClassCastException ("Uncomparable objects!");
        return this.name.compareTo(other.name);
    }
}
