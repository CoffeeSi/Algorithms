package Assignment4;

import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjecentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertex(Vertex<V> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }
    
    @Override
    public String toString() {
        return "Vertex{" + "data=" + data + '}';
    }
}
