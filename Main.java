public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0, 1); g.addEdge(0, 2);
        g.addEdge(1, 3); g.addEdge(2, 4);
        g.addEdge(3, 5); g.addEdge(4, 6);
        g.addEdge(5, 7); g.addEdge(6, 8);
        g.addEdge(7, 9);

        AdaptiveBFS bfs = new AdaptiveBFS(g);
        bfs.runBFS(0);
        bfs.printParents();
    }
}
