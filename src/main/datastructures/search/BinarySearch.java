package search;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        binarySearchRecursive(arr, 0, n - 1, x);
    }

    /**
     * Time Complexity: O(log n)
     * Auxiliary Space: O(log n)
     * **/
    private static void binarySearchRecursive(int[] arr, int s, int l, int x) {

        if (l >= s) {
            int mid = (s + l) / 2;
            if (arr[mid] == x) {
                System.out.println("Found the number " + x + " at index " + mid);
                return;
            }

            if (x > arr[mid]) {
                binarySearchRecursive(arr, mid + 1, l, x);
                return;

            }
            binarySearchRecursive(arr, s, mid - 1, x);
            return;
        }
    }
}
