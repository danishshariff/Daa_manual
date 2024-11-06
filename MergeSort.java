package daamanual;

import java.util.Random;
import java.util.Scanner;

public class MErgeSort {
    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { 
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid); 
            mergeSort(arr, mid + 1, right); 
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) { 
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArray[i++];
        }
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
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
            mergeSort(arr, 0, i - 1);
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
