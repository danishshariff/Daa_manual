import java.util.*;
class Graph {
private int vertices;
private LinkedList<Integer>[] adjacencyList;
public Graph(int vertices) {
this.vertices = vertices;
adjacencyList = new LinkedList[vertices];
for (int i = 0; i < vertices; ++i) {
adjacencyList[i] = new LinkedList<>();
}
}
public void addEdge(int v, int w) {
adjacencyList[v].add(w);
}
public void printReachableNodes(int startNode) {
boolean[] visited = new boolean[vertices];
LinkedList<Integer> queue = new LinkedList<>();
visited[startNode] = true;
queue.add(startNode);
System.out.println("Nodes reachable from node " + 
startNode + " are:");
while (!queue.isEmpty()) {
startNode = queue.poll();
System.out.print(startNode + " ");
Iterator<Integer> iterator = 
adjacencyList[startNode].listIterator();
while (iterator.hasNext()) {
int nextNode = iterator.next();
if (!visited[nextNode]) {
visited[nextNode] = true;
queue.add(nextNode);
}
}
}
}
public static void main(String[] args) {
Graph graph = new Graph(7);
graph.addEdge(0, 1);
graph.addEdge(0, 2);
graph.addEdge(1, 3);
graph.addEdge(1, 4);
graph.addEdge(2, 5);
graph.addEdge(2, 6);
int startNode = 0;
graph.printReachableNodes(startNode);
}
}
