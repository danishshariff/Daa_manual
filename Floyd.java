package daamanual;
import java.util.Scanner;

public class Floyd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        // Initialize the distance matrix
        int[][] dist = new int[vertices][vertices];

        // Get the adjacency matrix from the user (use a large value to represent infinity for no edge)
        System.out.println("Enter the adjacency matrix (use 99999 for no edge):");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = scanner.nextInt();
                // Set the diagonal to 0
                if (i == j) {
                    dist[i][j] = 0;
                }
            }
        }

        // Apply Floyd-Warshall Algorithm
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] != 99999 && dist[k][j] != 99999) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Display the shortest distances matrix
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == 99999) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
}