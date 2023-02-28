public class Location {
    public enum type{
        city,
        airport,
        gasStation
    }
    private String name;
    private type typeLocation;
    private double x;
    private double y;
    //Each class should have appropriate constructors, getters and setters.
    public Location(String name,type typeLocation, double x, double y){
        this.name = name;
        this.typeLocation = typeLocation;
        this.x = x;
        this.y = y;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public type getTypeLocation() {
        return typeLocation;
    }
    public void setTypeLocation(type typeLocation) {
        this.typeLocation = typeLocation;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", typeLocation=" + typeLocation +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
