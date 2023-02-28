public class Road {
    public enum type {
        highway,
        express,
        country
    }
    private type typeRoad;
    private double length;
    private double limit;
    public Road(type typeRoad, double length, double limit){
        this.typeRoad = typeRoad;
        this.length = length;
        this.limit = limit;
    }
    public type getTypeRoad() {
        return typeRoad;
    }
    public void setTypeRoad(type typeRoad) {
        this.typeRoad = typeRoad;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getLimit() {
        return limit;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Road{" +
                "typeRoad=" + typeRoad +
                ", length=" + length +
                ", limit=" + limit +
                '}';
    }
}
