public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        Person p1 = new Programmer("Ana", "10/01/2002", "Java");
        Person p2 = new Designer("Maria", "05/10/1997", "Vestimentar");
        Person p3 = new Designer("Ion", "23/05/1981", "Mobiliar");
        network.addNode(p1);
        network.addNode(p2);
        network.addNode(p3);

        Company c1 = new Company("Continental");
        Company c2 = new Company("Bitdefender");
        network.addNode(c1);
        network.addNode(c2);

        p1.addRelationship(p2, "Best-friend");
        p2.addRelationship(p3, "Coleg");
        p1.addRelationship(c1, "Boss");
        p3.addRelationship(c2, "Student");
        p2.addRelationship(c2, "UX/UI");

        System.out.println(network);
        network.sortNodeOfImportance();
        network.printRezultat();
    }
}