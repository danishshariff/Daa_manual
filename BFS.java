
package daamanual;
import java.util.*;

public class Graph {
    public static void bfs(int[][] adj, int st, int vertices) {
        
        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();

        visited[st] = true; // Mark the start node as visited
        q.add(st);
        System.out.print("BFS traversal starting from vertex " + st + ": ");
        System.out.print(st + " "); // Print the start node

        while (!q.isEmpty()) {
            int cur = q.poll(); // Get the front node from the queue
            // Traverse the adjacency list of the current node
            for (int i = 0; i < vertices; i++) {
                // Check if there is an edge and if the node is not visited
                if (adj[cur][i] == 1 && !visited[i]) {
                    System.out.print(i + " "); // Print the connected node
                    visited[i] = true; // Mark it as visited
                    q.add(i); // Add it to the queue for further exploration
                }
            }
        }
        System.out.println(); // Print a newline after traversal
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        // Create an adjacency matrix
        int[][] adj = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix (0 for no edge, 1 for edge): ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adj[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the start vertex (0 to " + (vertices - 1) + "): ");
        int startVertex = scanner.nextInt();

        // Validate the start vertex
        if (startVertex < 0 || startVertex >= vertices) {
            System.out.println("Invalid start vertex. Please enter a vertex between 0 and " + (vertices - 1) + ".");
        } else {
            bfs(adj, startVertex, vertices);
        }

        scanner.close(); // Close the scanner
    }
}
