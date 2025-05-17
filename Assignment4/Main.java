package Assignment4;

public class Main {
    private static Vertex<String> almaty = new Vertex<String>("Almaty");
    private static Vertex<String> astana = new Vertex<String>("Astana");
    private static Vertex<String> shymkent = new Vertex<String>("Shymkent");
    private static Vertex<String> atyrau = new Vertex<String>("Atyrau");
    private static Vertex<String> kostanay = new Vertex<String>("Kostanay");
    private static Vertex<String> kyzylorda = new Vertex<String>("Kyzylorda");

    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        fillWithWeights(graph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, almaty);
        outputPath(djk, kostanay);

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, almaty);
        outputPath(bfs, kyzylorda);
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge(almaty, astana, 2.1);
        graph.addEdge(shymkent, atyrau, 7.8);
        graph.addEdge(atyrau, astana, 7.1);
        graph.addEdge(almaty, shymkent, 7.2);
        graph.addEdge(shymkent, astana, 3.9);
        graph.addEdge(astana, kostanay, 3.5);
        graph.addEdge(shymkent, kyzylorda, 5.4);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        for (Vertex<String> v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}
