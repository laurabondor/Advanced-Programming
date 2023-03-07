public class GasStation extends Location{
    private String typeLocation;
    private double gasPrice;
    /**
     * GasStation reprezinta constructorul clasei aferente(GasStation)
     * @param name reprezinta numele locatiei
     * @param x reprezinta coordonata x a locatiei
     * @param y reprezinta coordonata y a locatiei
     * @param gasPrice reprezinta pretul gazului pentru statia de gaz GasStation
     * */
    public GasStation(String name, double x, double y, double gasPrice) {
        super(name, x, y);
        this.typeLocation = "Gas Station";
        this.gasPrice = gasPrice;
    }
    /**
     * getTypeLocation() este o metoda getter
     * @return returneaza tipul locatiei(GasStation)
     * */
    public String getTypeLocation() {
        return typeLocation;
    }
    /**
     * getGasPrice() este o metoda getter
     * @return returneaza pretul gazului al statiei de gaz GasStation
     * */
    public double getGasPrice() {
        return gasPrice;
    }
    /**
     * este o metoda setter
     * @param gasPrice seteaza pretul gazului pentru statia de gaz GasStation
     * */
    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }
    /**
     * @return returneaza toate campurile/valorile obiectlui GasStation concatenate intre ele, de forma unui String
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
