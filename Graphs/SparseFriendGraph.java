import java.util.*;

public class SparseFriendGraph {

    private Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    // Add friendship (Undirected Graph)
    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    // Check friendship
    public boolean isFriend(int u, int v) {
        return friendGraph
                .getOrDefault(u, Collections.emptySet())
                .contains(v);
    }

    public static void main(String[] args) {

        SparseFriendGraph graph = new SparseFriendGraph();

        graph.addFriendship(1, 2);
        graph.addFriendship(1, 3);
        graph.addFriendship(2, 4);

        System.out.println(graph.isFriend(1, 2)); // true
        System.out.println(graph.isFriend(3, 4)); // false
    }
}