public abstract class Road{
    protected String name;
    protected double length;
    protected double limit;
    protected Location source;
    protected Location destination;
    /**
     * Functia calculeaza distanta euclidiana dintre coordonatele a doua locatii
     * @param x1 este coordonata x1 a primei locatii
     * @param y1 este coordonata y1 a primei locatii
     * @param x2 este coordonata x2 a celei de-a doua locatie
     * @param y2 este coordonata y2 a celei de-a doua locatie
     * @return returneaza distanta euclidiana
     * */
    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
    /**
     * Road reprezinta constructorul clasei aferente
     * @param name reprezinta numele drumului Road
     * @param length reprezinta lungimea drumului Road
     * @param limit reprezinta limita de viteza pentru drumului Road
     * @param a reprezinta sursa(locatia) de plecare a drumului Road
     * @param b reprezinta destinatia(locatia) de sosire a drumului Road
     * */
    public Road(String name, double length, double limit, Location a, Location b){
        if(euclideanDistance(a.getX(), a.getY(), b.getX(), b.getY()) > length) {
            System.out.println("Lungimea drumului este prea mica");
        } else {
            this.name = name;
            this.length = length;
            this.limit = limit;
            this.source = a;
            this.destination = b;
        }
    }
    /**
     * getName() este o metoda getter
     * @return returneaza numele drumului Road
     * */
    public String getName() {
        return name;
    }
    /**
     * este o metoda setter
     * @param name seteaza numele name pentru drumul Road
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getLength() este o metoda getter
     * @return returneaza lungimea drumului Road
     * */
    public double getLength(){
        return length;
    }
    /**
     * este o metoda setter
     * @param length seteaza lungimea length de tip double pentru drumul Road
     * */
    public void setLength(double length){
        this.length = length;
    }
    /**
     * getLimit() este o metoda getter
     * @return returneaza limita de viteza pentru drumului Road
     * */
    public double getLimit(){
        return limit;
    }
    /**
     * este o metoda setter
     * @param limit seteaza limita de viteza limit de tip double pentru drumul Road
     * */
    public void setLimit(double limit){
        this.limit = limit;
    }
    /**
     * getSource() este o metoda getter
     * @return returneaza locatia de plecare a drumului Road
     * */
    public Location getSource() {
        return source;
    }
    /**
     * getSource() este o metoda getter
     * @return returneaza destinatia(locatia) de sosire a drumului Road
     * */
    public Location getDestination() {
        return destination;
    }
    @Override
    public abstract String toString();

    /**
     * @return true daca obiectele sunt egale, false daca nu sunt egale
     * */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Road)) {
            return false;
        }
        Road other = (Road) obj;
        return (name.equals(other.name) && source.equals(other.source) && destination.equals(other.destination));
    }
}
