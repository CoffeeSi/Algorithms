package Assignment4;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        bfs(graph, source);
    }

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        this(graph, new Vertex<>(source));
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> current) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(current);
        marked.add(current);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();

            for (Vertex<V> vertex : graph.getNeighbors(v).keySet()) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
