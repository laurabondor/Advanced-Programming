import java.util.HashMap;
import java.util.Map;
public interface Node{
    String getName();
    /**
     * @return returneaza un HashMap gol
     * */
    default Map<Node, String> getRelationships() {
        return new HashMap<>();
    }
}
