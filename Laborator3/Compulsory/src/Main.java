import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        Person p1 = new Person("Ana");
        Person p2 = new Person("Maria");
        Person p3 = new Person("Ion");

        nodes.add(p1);
        nodes.add(p2);
        nodes.add(p3);
        nodes.add(new Company("Continental"));
        nodes.add(new Company("Bitdefender"));

        Collections.sort(nodes);

        for (Node node : nodes) {
            System.out.println(node.getName());
        }
    }
}