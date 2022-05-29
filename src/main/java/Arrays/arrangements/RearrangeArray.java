package Arrays.arrangements;

import java.util.Arrays;

/**
 * Rearrange array in alternating positive & negative items with O(1) extra space
 * <p>
 * Input:  arr[] = {1, 2, 3, -4, -1, 4}
 * Output: arr[] = {-4, 1, -1, 2, 3, 4}
 * <p>
 * Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
 */
public class RearrangeArray {

    public static void main(String[] args) {
        //int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int arr[]={1, 2, 3, -4, -1, 4};
       Arrays.toString(rearrange(arr));

    }


    private static void print(int[] arr) {
        System.out.println(" ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void rotate(int[] arr, int start, int end) {
        int temp = arr[end];
        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = temp;
    }

    private static int[] rearrange(int[] arr) {

        int p = 0, q = p + 1;


        while (p <= arr.length && q <= (arr.length -1)) {

            if (arr[q] < 0) {
                rotate(arr, p, q);
                print(arr);
                p = p + 2;
            }
            q++;
        }
        return arr;
    }
}
