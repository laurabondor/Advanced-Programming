public class Airport extends Location{
    private String typeLocation;
    private int numberOfTerminals;
    /**
     * Airport reprezinta constructorul clasei aferente(Airport)
     * @param name reprezinta numele locatiei
     * @param x reprezinta coordonata x a locatiei
     * @param y reprezinta coordonata y a locatiei
     * @param numberOfTerminals reprezinta numarul de terminale ale aeroportului Airport
     * */
    public Airport(String name, double x, double y, int numberOfTerminals) {
        super(name, x, y);
        this.typeLocation = "Airport";
        this.numberOfTerminals = numberOfTerminals;
    }
    /**
     * getTypeLocation() este o metoda getter
     * @return returneaza tipul locatiei(Airport)
     * */
    public String getTypeLocation() {
        return typeLocation;
    }
    /**
     * getNumberOfTerminals() este o metoda getter
     * @return returneaza numarul de terminale ale aeroportului Airport
     * */
    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }
    /**
     * este o metoda setter
     * @param numberOfTerminals seteaza numarul de terminale pentru aeroportului Airport
     * */
    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
    /**
     * @return returneaza toate campurile/valorile obiectlui Airport concatenate intre ele, de forma unui String
     * */
    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", typeLocation=" + typeLocation +
                ", x=" + x +
                ", y=" + y +
                "}";
    }
}
