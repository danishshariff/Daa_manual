package daamanual;

import java.util.Scanner;

public class HeapSort {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int cur, int n) {
        int idxOfLargest = cur;
        int l = 2 * idxOfLargest + 1;
        int r = 2 * idxOfLargest + 2;

        // Check if the left child is larger than root
        if (l < n && arr[idxOfLargest] < arr[l]) {
            idxOfLargest = l;
        }

        // Check if the right child is larger than the largest so far
        if (r < n && arr[idxOfLargest] < arr[r]) {
            idxOfLargest = r;
        }

        // If the largest is not root
        if (idxOfLargest != cur) {
            swap(arr, cur, idxOfLargest);
            heapify(arr, idxOfLargest, n); // Recursive call to heapify the affected sub-tree
        }
    }

    public static void buildHeap(int[] arr, int n) {
        // Complexity: O(n) - Building the max heap from unsorted array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    public static void heapSort(int[] arr, int n) {
        // Complexity: O(n log n) - Extracting each element from the heap
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Record start time
        long startTime = System.nanoTime();

        // Build heap and sort
        buildHeap(arr, n); // Time Complexity: O(n)
        heapSort(arr, n);  // Time Complexity: O(n log n)

        // Record end time and calculate duration
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Print sorted array
        System.out.println("Sorted array:");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();

        // Print time complexity details
        System.out.println("Execution Time: " + duration + " nanoseconds");

        scanner.close();
    }
}
