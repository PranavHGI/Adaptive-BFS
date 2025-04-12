import java.util.*;

public class AdaptiveBFS {
    Graph graph;
    int[] parent;
    boolean[] visited;

    public AdaptiveBFS(Graph g) {
        graph = g;
        parent = new int[g.numVertices];
        visited = new boolean[g.numVertices];
        Arrays.fill(parent, -1);
    }

    public void runBFS(int root) {
        Set<Integer> frontier = new HashSet<>();
        frontier.add(root);
        visited[root] = true;
        parent[root] = root;

        while (!frontier.isEmpty()) {
            boolean useTopDown = frontier.size() < graph.numVertices / 10;

            Set<Integer> next = useTopDown ? topDown(frontier) : bottomUp(frontier);
            System.out.println("Using " + (useTopDown ? "TOP-DOWN" : "BOTTOM-UP") + " strategy");

            frontier = next;
        }
    }

    private Set<Integer> topDown(Set<Integer> frontier) {
        Set<Integer> next = new HashSet<>();
        for (int u : frontier)
            for (int v : graph.getNeighbors(u))
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    next.add(v);
                }
        return next;
    }

    private Set<Integer> bottomUp(Set<Integer> frontier) {
        Set<Integer> next = new HashSet<>();
        for (int v = 0; v < graph.numVertices; v++) {
            if (!visited[v]) {
                for (int u : graph.getNeighbors(v)) {
                    if (frontier.contains(u)) {
                        visited[v] = true;
                        parent[v] = u;
                        next.add(v);
                        break;
                    }
                }
            }
        }
        return next;
    }

    public void printParents() {
        for (int i = 0; i < parent.length; i++) {
            System.out.println("Vertex " + i + " <- Parent " + parent[i]);
        }
    }
}
