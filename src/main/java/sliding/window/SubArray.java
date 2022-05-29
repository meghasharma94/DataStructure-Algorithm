package sliding.window;

import java.util.Arrays;

/**
 * Given an array of positive integers, and a positive number k, find the maximum sum of any contiguous subarray of size k.
 */
public class SubArray {

    public static void main(String[] args) {
        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        int k = 3;
        System.out.printf("Max sum subarray of size %d = %d%n", k, findSumMaxSubArrayOfSizeK(arr, k));
    }

    private static int findSumMaxSubArrayOfSizeK(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return 0;
        }
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
          if (i - j + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[j];
                j++;
            }
          }
         return maxSum;
     }
}
