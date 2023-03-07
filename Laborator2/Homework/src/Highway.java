public class Highway extends Road{
    private String typeRoad;
    /**
     * Highway reprezinta constructorul clasei aferente(Highway)
     * @param name reprezinta numele drumului Road
     * @param length reprezinta lungimea drumului Road
     * @param limit reprezinta limita de viteza pentru drumului Road
     * @param a reprezinta sursa(locatia) de plecare a drumului Road
     * @param b reprezinta destinatia(locatia) de sosire a drumului Road
     * */
    public Highway(String name, double length, double limit, Location a, Location b) {
        super(name, length, limit, a, b);
        this.typeRoad = "Highway";
    }
    /**
     * getTypeRoad() este o metoda getter
     * @return returneaza tipul drumului Road(Highway)
     * */
    public String getTypeRoad() {
        return typeRoad;
    }
    /**
     * @return returneaza toate campurile/valorile obiectlui Highway concatenate intre ele, de forma unui String
     * */
    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", typeRoad=" + typeRoad +
                ", length=" + length +
                ", limit=" + limit +
                "}";
    }
}
