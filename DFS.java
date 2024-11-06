package daamanual;

import java.util.Scanner;

public class DFS {
    private int vertices;
    private int[][] adjacencyMatrix;

    // Constructor to initialize the graph with a given number of vertices
    public DFS(int v) {
        vertices = v;
        adjacencyMatrix = new int[v][v];
    }

    // Method to add an edge between two nodes (for an undirected graph)
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    // Recursive method to perform DFS traversal
    public void dfs(int startVertex, boolean[] visited) {
        // Mark the start vertex as visited and print it
        System.out.print(startVertex + " ");
        visited[startVertex] = true;

        // Explore all adjacent vertices recursively
        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[startVertex][i] == 1 && !visited[i]) {
                dfs(i, visited); // Recursive call for the unvisited neighbor
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();

        DFS graph = new DFS(v);

        // Input the adjacency matrix
        System.out.println("Enter the adjacency matrix (0 for no edge, 1 for edge):");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph.adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Input the starting vertex
        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = scanner.nextInt();

        // Validate the start vertex
        if (startVertex < 0 || startVertex >= v) {
            System.out.println("Invalid start vertex. Please enter a vertex between 0 and " + (v - 1) + ".");
        } else {
            // Initialize visited array and start DFS traversal
            boolean[] visited = new boolean[v];
            System.out.print("DFS traversal starting from vertex " + startVertex + ": ");
            graph.dfs(startVertex, visited);
            System.out.println(); // Print newline after traversal
        }

        scanner.close(); // Close the scanner
    }
}
