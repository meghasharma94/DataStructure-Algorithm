package Arrays.search;

import Arrays.rotation.MaxSum;

/**
 * Find the minimum element in a sorted and rotated array
 * A sorted array is rotated at some unknown point, find the minimum element in it.
 * Input: {5, 6, 1, 2, 3, 4}
 * Output: 1
 * it can be achieved by linear search O(n)
 * BinarySearch O(log n)
 */
public class Minimum {

    public static void main(String[] args) {
        Minimum min = new Minimum();
        int arr[] = {5, 6, 1, 2, 3, 4};
        min.print(arr);
        int n = arr.length;
        System.out.println("The minimum element is " +
                min.findMin(arr, 0, n - 1));

    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    private int findMin(int[] arr, int low, int high) {
        if (low == high) return arr[low];

        if (high < low) return arr[0];

        int mid = (low + high) / 2;

        if (mid < high && arr[mid + 1] < arr[mid])
            return arr[mid + 1];

        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        if(arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
     }
}
