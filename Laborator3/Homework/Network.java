import java.util.*;
public class Network {
    private List<Node> nodes = new ArrayList<>();
    /**
     * Network reprezinta constructorul clasei
     * */
    public Network() {}
    /**
     * functia adauga nodul node in ArrayList-ul nodes
     * */
    public void addNode(Node node) {
        nodes.add(node);
    }
    /**
     * @return functia returneaza lista de obiecte nodes de tip Node
     * */
    public List<Node> getNodes() {
        return nodes;
    }
    /**
     * @param nodes seteaza lista de obiecte nodes de tip Node
     * */
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return Objects.equals(nodes, network.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }
    /**
     * @param node reprezinta nodul pentru care calculam numarul de conexiuni
     * @return returneaza numarul de conexiuni pe care le are nodul node cu alte noduri(arce care ies din nod)
     * */
    public int getNodeImportance(Node node) {
        return node.getRelationships().size();
    }
    /**
     * functia sorteaza descrescator ArrayList-ul nodes in functie de numarul de conexiuni al nodurilor
     * */
    public void sortNodeOfImportance() {
        boolean ok;
        do {
            ok = false;
            for (int i = 0; i < nodes.size() - 1; i++) {
                Node currentNode = nodes.get(i);
                Node nextNode = nodes.get(i + 1);
                if (getNodeImportance(currentNode) < getNodeImportance(nextNode)) {
                    nodes.set(i, nextNode);
                    nodes.set(i + 1, currentNode);
                    ok = true;
                }
            }
        } while (ok);
    }
    /**
     * functia afiseaza la ecran nodurile urmate de numarul de conexiuni ale acestora
     * */
    public void printRezultat() {
        for (Node nod : this.nodes) {
            if (nod instanceof Person) {
                System.out.println("Persoana: " + nod + ", Nr conexiuni: " + getNodeImportance(nod));
            } else if (nod instanceof Company) {
                System.out.println("Companie: " + nod + ", Nr conexiuni: " + getNodeImportance(nod));
            }
        }
    }
}
