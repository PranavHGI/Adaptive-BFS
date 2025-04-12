import java.util.*;

public class Graph {
    int numVertices;
    List<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        numVertices = n;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // undirected
    }

    public List<Integer> getNeighbors(int u) {
        return adjList[u];
    }
}
