package heap;


import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Root is at index 0 in array.
 * Left child of i-th node is at (2*i + 1)th index.
 * Right child of i-th node is at (2*i + 2)th index.
 * Parent of i-th node is at (i-1)/2 index.
 * <p>
 * Time Complexity Analysis: Heapify a single node takes O(log N)
 * Building the entire Heap will take N heapify operations and the total time complexity will be O(N*logN).
 * Auxiliary Space: O(N)
 **/

public class MaxHeap {

    public static void main(String args[]) {

        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int N = arr.length;
        buildHeap(arr, N);
        printHeap(arr, N);

        int arr1[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};

        priorityMaxHeap(arr1, N);
    }

    // PriorityQueue class to implement Heaps in Java. By default Min Heap is implemented by this class.
    // To implement Max Heap, we use Collections.reverseOrder() method.

    private static void priorityMaxHeap(int[] arr, int n) {
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                Collections.reverseOrder());

        for (int i : arr) {
            pQueue.add(i);
        }

        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.print(itr.next() + " ");

    }

    private static void buildHeap(int[] arr, int n) {
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    private static void heapify(int[] arr, int i, int n) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {

            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, largest, n);

        }
    }

    static void printHeap(int arr[], int N) {
        System.out.println(
                "Array representation of Heap is:");

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
