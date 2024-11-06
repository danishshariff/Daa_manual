package daamanual;
import java.util.Random;
import java.util.Scanner;

/* The worst case time complexity of quickSort is O(N^2) */
/* The average case time complexity of quickSort is O(N*LogN) */
/* Plot a graph between N -> Input size (1, 2, 3, 4,... 10) and Time Taken to sort using quickSort */

public class QuickSort {
    
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(arr, low, high); // Returns the pivot's correct position
            quicksort(arr, low, pivotIdx - 1);
            quicksort(arr, pivotIdx + 1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        // swap
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i;
    }

    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100); // Random number between 0 and 99
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum size of the array (N): ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            int[] arr = generateRandomArray(i);

            System.out.print("Original Array of size " + i + ": ");
            for (int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();

            long startTime = System.nanoTime(); 
            quicksort(arr, 0, i - 1);
            long endTime = System.nanoTime(); 

            System.out.print("Sorted Array of size " + i + ": ");
            for (int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();

            System.out.println("Execution time for sorting " + i + " elements: " + (endTime - startTime) + " nanoseconds\n");
        }

        scanner.close();
    }
}
