import java.util.*;

public class ShortestFlightPath {

    public static List<Integer> fewestFlights(
            Map<Integer, List<Integer>> routes,
            int origin,
            int destination) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {

            int city = queue.poll();

            if (city == destination)
                break;

            for (int next : routes.getOrDefault(city, Collections.emptyList())) {

                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, city);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination))
            return Collections.emptyList();

        LinkedList<Integer> path = new LinkedList<>();

        Integer node = destination;

        while (node != null) {
            path.addFirst(node);
            node = parent.get(node);
        }

        return path;
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> routes = new HashMap<>();

        routes.put(0, Arrays.asList(1, 2));
        routes.put(1, Arrays.asList(3));
        routes.put(2, Arrays.asList(3));
        routes.put(3, Arrays.asList(4));

        System.out.println(fewestFlights(routes, 0, 4));
    }
}