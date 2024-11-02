import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class quickSort {
public static void quicksort(int[] arr, int low, int high) 
{
if (low < high) {
int partitionIndex = partition(arr, low, high);
quickSort(arr, low, partitionIndex - 1);
quickSort(arr, partitionIndex + 1, high);
}
}
public static int partition(int[] arr, int low, int
high) {
int pivot = arr[high];
int i = low - 1;
for (int j = low; j < high; j++) {
if (arr[j] < pivot) {
i++;
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
}
int temp = arr[i + 1];
arr[i + 1] = arr[high];
arr[high] = temp;
return i + 1;
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of elements: ");
int n = scanner.nextInt();
int[] arr = new int[n];
System.out.println("Enter the elements:");
for (int i = 0; i < n; i++) {
arr[i] = scanner.nextInt();
}
System.out.println("Original array: " + 
Arrays.toString(arr));
long startTime = System.nanoTime();
quicksort(arr, 0, arr.length - 1);
long endTime = System.nanoTime();
System.out.println("Sorted array: " + 
Arrays.toString(arr));
double timeElapsed = (endTime - startTime) / 1e6; // Convert nanoseconds to 
System.out.println("Time complexity: " + timeElapsed + " milliseconds");
scanner.close();
}
}