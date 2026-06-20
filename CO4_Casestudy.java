import java.util.*;

public class CO4_ShortestPathAlgorithms {

    static final int INF = 999999;

    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    static void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            int u = -1, min = INF;

            for (int j = 0; j < V; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("=== Dijkstra ===");
        for (int i = 0; i < V; i++)
            System.out.println("Distance to " + i + " = " + dist[i]);
    }

    static void bellmanFord(List<Edge> edges, int V, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.src] != INF &&
                        dist[e.src] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[e.src] + e.weight;
                }
            }
        }

        System.out.println("\n=== Bellman Ford ===");
        for (int i = 0; i < V; i++)
            System.out.println("Distance to " + i + " = " + dist[i]);
    }

    static void floydWarshall(int[][] graph) {

        int V = graph.length;
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++)
            dist[i] = graph[i].clone();

        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        System.out.println("\n=== Floyd Warshall ===");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(dist[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0,4,2,INF},
                {INF,0,5,10},
                {INF,INF,0,3},
                {INF,INF,INF,0}
        };

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,4));
        edges.add(new Edge(0,2,2));
        edges.add(new Edge(1,2,5));
        edges.add(new Edge(1,3,10));
        edges.add(new Edge(2,3,3));

        dijkstra(graph,0);
        bellmanFord(edges,4,0);
        floydWarshall(graph);
    }
}
