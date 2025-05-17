package Assignment4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<V> extends Search<V> {
    private final Set<Vertex<V>> visited;
    private final Map<Vertex<V>, Double> distances;
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        visited = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0.0);
        visited.add(source);

        while (!visited.isEmpty()) {
            Vertex<V> current = getVertexMinimumWeight(visited);

            marked.add(current);
            visited.remove(current);

            for (Vertex<V> neighbor : graph.getNeighbors(current).keySet()) {
                double newDist = getShortestDistance(current) + getDistance(current, neighbor);

                if (getShortestDistance(neighbor) > newDist) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    visited.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Vertex<V> node, Vertex<V> target) {
        Map<Vertex<V>, Double> neighbors = graph.getNeighbors(node);
        if (neighbors.containsKey(target)) {
            return neighbors.get(target);
        }

        throw new RuntimeException("Not found!");
    }

    private Vertex<V> getVertexMinimumWeight(Set<Vertex<V>> vertices) {
        Vertex<V> min = null;
        for (Vertex<V> vertex : vertices) {
            if (min == null) {
                min = vertex;
                continue;
            }

            if (getShortestDistance(vertex) < getShortestDistance(min))
                min = vertex;
        }
        return min;
    }

    private double getShortestDistance(Vertex<V> dest) {
        Double d = distances.get(dest);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
