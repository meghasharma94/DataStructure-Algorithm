package arrays.swap;

import java.util.*;
import java.lang.*;
/*
 * Rearrange an array such that arr[i] = i else -s
 * */

public class SwapArray {
    public static void main(String[] args) {
        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        System.out.println(Arrays.toString(swap(arr)));

    }

    private static int[] swap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1 && arr[i] != i) {
                int x = arr[i];
                while (arr[x] != -1 && arr[x] != x) {
                    int y = arr[x];
                    arr[x] = x;
                    x = y;
                }
                arr[x] = x;
                if (arr[i] != i) {
                    arr[i] = -1;
                }
            }
        }
        return arr;

    }
}
