package daamanual;

import java.util.Scanner;

public class TSPexp {
    static final int INF = 1000; 
    static int[][] weight; 
    static int n; 
    static int[] tour; 
    static int finalCost; 

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

  
        System.out.print("Enter the number of nodes: ");
        n = s.nextInt();

        weight = new int[n][n];
        tour = new int[n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    System.out.print("Enter the distance from node " + (i + 1) + " to node " + (j + 1) + ": ");
                    weight[i][j] = s.nextInt();
                }
            }
        }

    
        System.out.println("Starting node assumed to be node 1.");
        
    
        calculateTour();
    }


    public static int calculateCost(int currentNode, boolean[] visited) {
        int min = INF;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && weight[currentNode][i] < min) {
                min = weight[currentNode][i];
            }
        }
        return min;
    }

    public static void calculateTour() {
        boolean[] visited = new boolean[n];
        int currentNode = 0;
        visited[currentNode] = true;
        tour[0] = currentNode;

        for (int i = 1; i < n; i++) {
            int minCost = INF;
            int nextNode = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && weight[currentNode][j] < minCost) {
                    minCost = weight[currentNode][j];
                    nextNode = j;
                }
            }
            tour[i] = nextNode;
            visited[nextNode] = true;
            currentNode = nextNode;
        }

       
        displayTour();
    }

   
    public static void displayTour() {
        System.out.print("The tour is: ");
        for (int i = 0; i < n; i++) {
            System.out.print((tour[i] + 1) + " ");
        }
        System.out.println();

        finalCost = 0;
        for (int i = 0; i < n - 1; i++) {
            finalCost += weight[tour[i]][tour[i + 1]];
        }
        finalCost += weight[tour[n - 1]][tour[0]]; 
        System.out.println("The total cost of the tour is: " + finalCost);
    }
}
