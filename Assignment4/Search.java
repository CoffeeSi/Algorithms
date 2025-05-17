package Assignment4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Search<V> {
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    protected Search(Vertex<V> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> dest) {
        return marked.contains(dest);
    }

    public List<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> i = v; !i.equals(source); i = edgeTo.get(i)) {
            path.push(i);
        }
        path.push(source);
        return path;
    }
}
