public abstract class Location extends Object{
    protected String name;
    protected double x;
    protected double y;
    /**
     * Location reprezinta constructorul clasei aferente
     * @param name reprezinta numele locatiei
     * @param x reprezinta coordonata x a locatiei
     * @param y reprezinta coordonata y a locatiei
     * */
    public Location(String name, double x, double y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    /**
     * getName() este o metoda getter
     * @return returneaza numele locatiei
     * */
    public String getName() {
        return name;
    }
    /**
     * este o metoda setter
     * @param name seteaza numele name pentru locatia Location
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getX() este o metoda getter
     * @return returneaza coordonata x
     * */
    public double getX() {
        return x;
    }
    /**
     * este o metoda setter
     * @param x seteaza valoarea x de tip double(coordonata x) pentru locatia Location
     * */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * getY() este o metoda getter
     * @return returneaza coordonata y
     * */
    public double getY() {
        return y;
    }
    /**
     * este o metoda setter
     * @param y seteaza valoarea y de tip double(coordonata y) pentru locatia Location
     * */
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public abstract String toString();

    /**
     * @return true daca obiectele sunt egale, false daca nu sunt egale
     * */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Location)) {
            return false;
        }
        Location other = (Location) obj;
        return (name.equals(other.name) && x == other.x && y == other.y);
    }
}
