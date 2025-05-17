package Assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
    private Map<Vertex<T>, Map<Vertex<T>, Double>> adjList;
    private boolean directed;

    public WeightedGraph() {
        adjList = new HashMap<>();
        directed = false;
    }

    public WeightedGraph(boolean directed) {
        this();
        this.directed = directed;
    }

    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> dest, double weight) {
        addVertex(source);
        addVertex(dest);
        adjList.get(source).put(dest, weight);
        if (!directed) {
            adjList.get(dest).put(source, weight);
        }
    }

    public Map<Vertex<T>, Map<Vertex<T>, Double>> getAdjList() {
        return adjList;
    }

    public Set<Vertex<T>> getVertices() {
        return adjList.keySet();
    }

    public Map<Vertex<T>, Double> getNeighbors(Vertex v) {
        return adjList.getOrDefault(v, new HashMap<>());
    }

    public void printGraph() {
        for (Vertex<T> vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (Map.Entry<Vertex<T>, Double> edge : adjList.get(vertex).entrySet()) {
                System.out.print(edge.toString());
            }
            System.out.println();
        }
    }
}
