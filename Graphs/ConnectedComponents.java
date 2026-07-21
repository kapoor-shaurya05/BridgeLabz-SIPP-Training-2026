import java.util.*;

public class ConnectedComponents {

    public static int countNetworkSegments(
            Map<Integer, List<Integer>> network,
            int n) {

        Set<Integer> visited = new HashSet<>();

        int segments = 0;

        for (int server = 0; server < n; server++) {

            if (!visited.contains(server)) {

                segments++;

                dfs(network, server, visited);
            }
        }

        return segments;
    }

    private static void dfs(
            Map<Integer, List<Integer>> network,
            int node,
            Set<Integer> visited) {

        visited.add(node);

        for (int neighbor :
                network.getOrDefault(node, Collections.emptyList())) {

            if (!visited.contains(neighbor)) {

                dfs(network, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1));
        graph.put(1, Arrays.asList(0));

        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(2));

        int components = countNetworkSegments(graph, 4);

        System.out.println("Components = " + components);

        if (components == 1)
            System.out.println("Network is Fully Connected");
        else
            System.out.println("Network is NOT Fully Connected");
    }
}