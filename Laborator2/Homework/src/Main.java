public class Main {
    public static void main(String[] args) {

        InstanceOfTheProblem pb = new InstanceOfTheProblem(3,2);

        Location loc1 = new City("Iasi", 12.2, 21.99, 45.2);
        pb.addLocation(0, loc1);
        Location loc2 = new Airport("Henri Coada", 11.1, 22.0, 10);
        pb.addLocation(1, loc2);
        Location loc3 = new GasStation("Statiune numar 1", 10.9, 12.4, 4.5);
        pb.addLocation(2, loc3);

        Road road1 = new Country("road number 1", 312.32, 56.1, loc1, loc2);
        pb.addRoad(0, road1);
        Road road2 = new Highway("road number 2", 292.0, 95.9, loc2, loc3);
        pb.addRoad(1, road2);

        pb.printare();
        System.out.println(pb.isInstanceValid());
        if(pb.isInstanceValid()){
            System.out.println(pb.isPossibleToFindAPath(loc1, loc3));
        }
    }
}
