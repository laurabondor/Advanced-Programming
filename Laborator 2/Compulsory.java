public class Compulsory {
    public static void main(String[] args) {
        Location location1 = new Location("Iasi", Location.type.city, 32.45, 78.1);
        Location location2 = new Location("Henri Coanda", Location.type.airport, 421.6, 582.99);
        Road road1 = new Road(Road.type.country, 321.7, 70);
        Road road2 = new Road(Road.type.highway, 1300, 130);

        System.out.println(location1);
        System.out.println(location2);
        System.out.println(road1);
        System.out.println(road2);
    }
}

