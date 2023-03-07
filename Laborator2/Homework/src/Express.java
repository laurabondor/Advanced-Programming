public class Express extends Road{
    private String typeRoad;
    /**
     * Express reprezinta constructorul clasei aferente(Express)
     * @param name reprezinta numele drumului Road
     * @param length reprezinta lungimea drumului Road
     * @param limit reprezinta limita de viteza pentru drumului Road
     * @param a reprezinta sursa(locatia) de plecare a drumului Road
     * @param b reprezinta destinatia(locatia) de sosire a drumului Road
     * */
    public Express(String name, double length, double limit, Location a, Location b) {
        super(name, length, limit, a, b);
        this.typeRoad = "Express";
    }
    /**
     * getTypeRoad() este o metoda getter
     * @return returneaza tipul drumului Road(Express)
     * */
    public String getTypeRoad() {
        return typeRoad;
    }
    /**
     * @return returneaza toate campurile/valorile obiectlui Express concatenate intre ele, de forma unui String
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
