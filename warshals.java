package daamanual;

import java.util.Scanner; 
public class WarshallAlgorithm { 
public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 

System.out.print("Enter the number of vertices: "); 
int vertices = scanner.nextInt();

int[][] graph = new int[vertices][vertices];

System.out.println("Enter the adjacency matrix (0 for no edge, 1 for edge):"); 
for (int i = 0; i < vertices; i++) { 
for (int j = 0; j < vertices; j++) { 
 graph[i][j] = scanner.nextInt();
}
}

for (int k = 0; k < vertices; k++) { 
for (int i = 0; i < vertices; i++) {
for (int j = 0; j < vertices; j++) { 
 graph[i][j] = graph[i][j] | (graph[i][k] & 
graph[k][j]); 
} 
}
}
System.out.println("Transitive Closure:"); 
for (int i = 0; i < vertices; i++) { 
for (int j = 0; j < vertices; j++) { 
System.out.print(graph[i][j] + " ");
} 
System.out.println(); 
} 
scanner.close(); 
 }
}