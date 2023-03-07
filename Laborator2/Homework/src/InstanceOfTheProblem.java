public class InstanceOfTheProblem {
    private Location[] locations;
    private Road[] roads;
    /** InstanceOfTheProblem reprezinta constructorul clasei aferente
     * @param n reprezinta dimensiunea vectorului locations
     * @param m reprezinta dimensiunea vectorului roads
     * */
    public InstanceOfTheProblem(int n, int m){
        this.locations = new Location[n];
        this.roads = new Road[m];
    }
    /**
     * @throws IllegalArgumentException  daca un input este incorect
     * @param position reprezinta pozitia pe care va fi plasat elementul in vectorul locations
     * @param element reprezinta elementul pe care vrem sa il inseram in vectorul locations
     */
    public void addLocation(int position, Location element){
        for(int i = 0; i < position; i++ ){
            if(element.getName().equals(locations[i].getName())) {
                throw new IllegalArgumentException("Location name already exists");
            }
            if(element.getX() == locations[i].getX()) {
                throw new IllegalArgumentException("Location: X coordinates already exists");
            }
            if(element.getY() == locations[i].getY()) {
                throw new IllegalArgumentException("Location: Y coordinates already exists");
            }
        }
        locations[position] = element;
    }
    /**
     * @throws IllegalArgumentException  daca un input este incorect
     * @param position reprezinta pozitia pe care va fi plasat elementul in vectorul roads
     * @param element reprezinta elementul pe care vrem sa il inseram in vectorul roads
     */
    public void addRoad(int position, Road element){
        for(int i = 0; i < position; i++ ){
            if(element.getName().equals(roads[i].getName())) {
                throw new IllegalArgumentException("Road name already exists");
            }
        }
        if (element.getLimit() < 0) {
            throw new IllegalArgumentException("Error: LimitRoad is negative");
        }
        if (element.getSource().equals(element.getDestination())) {
            throw new IllegalArgumentException("Error: The source is the same as the destination");
        }
        roads[position] = element;
    }
    /**
     * Printam elementele celor doi vectori la ecran
     * */
    public void printare(){
        for(int i = 0; i < locations.length; i++){
            System.out.println(locations[i]);
        }
        System.out.println();
        for(int i = 0; i < roads.length; i++){
            System.out.println(roads[i]);
        }
    }
    /**
     * Verificam daca instanta probelemi este valida
     * */
    public boolean isInstanceValid() {
        for (Road road : roads) {
            if (road == null ) {
                return false;
            }
        }
        for (Location location : locations) {
            if ( location == null ) {
                return false;
            }
        }
        return true;
    }
    /**
     * Cautam in vectorul roads daca elementul dat ca parametru(destinatie de sosire) se gaseste ca sursa de plecare
     * @param destinationElem reprezinta elementul pe care il cautam in functie
     * @return true daca l-am gasit, false daca nu-l gasim
     * */
    public boolean findSourceSameDestination(Location destinationElem){
        for (Road road : roads) {
            if(road.getSource().getName().equals(destinationElem.getName())){
                return true;
            }
        }
        return false;
    }
    /**
     * @param source reprezinta sursa de plecare
     * @param destination reprezinta destinatia de sosire
     * @return true daca putem ajunge din locatia data ca input in primul parametru la locatia data ca input in cel de-al doilea parametru, false daca nu putem ajunge
     * */
    public boolean isPossibleToFindAPath(Location source, Location destination) {
        for (Road road : roads) {
            if (road.getSource().equals(source) && road.getDestination().equals(destination)){
                return true;
            }
            if(road.getSource().equals(source) && findSourceSameDestination(road.getDestination())){
                return isPossibleToFindAPath(road.getDestination(), destination);
            }
        }
        return false;
    }
}

