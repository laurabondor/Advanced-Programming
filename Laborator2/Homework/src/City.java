public class City extends Location{
    private String typeLocation;
    private double population;
    /**
     * City reprezinta constructorul clasei aferente(City)
     * @param name reprezinta numele locatiei
     * @param x reprezinta coordonata x a locatiei
     * @param y reprezinta coordonata y a locatiei
     * @param population reprezinta populatia lui orasului City
     * */
    public City(String name, double x, double y, double population) {
        super(name, x, y);
        this.population = population;
        this.typeLocation = "City";
    }
    /**
     * getTypeLocation() este o metoda getter
     * @return returneaza tipul locatiei(City)
     * */
    public String getTypeLocation() {
        return typeLocation;
    }
    /**
     * getPopulation() este o metoda getter
     * @return returneaza populatia orasului City
     * */
    public double getPopulation() {
        return population;
    }
    /**
     * este o metoda setter
     * @param population seteaza populatia pentru orasul City
     * */
    public void setPopulation(double population) {
        this.population = population;
    }
    /**
     * @return returneaza toate campurile/valorile obiectlui City concatenate intre ele, de forma unui String
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
