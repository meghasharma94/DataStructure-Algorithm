package sliding.window;

import java.util.*;

public class Duplicates {

    public static void main(String[] args) {
        int[] nums = {5, 6, 8, 2, 4, 6, 9};
        int k = 4;
        System.out.println(" Duplicates are " + k + " vals are :" + findDuplicatesByHash(nums, k));

        System.out.println(" Does array contains Duplicates within  " + k + " vals are :" + findDuplicatesWithSlidingWindow(nums, k));
    }


    private static Set<Integer> findDuplicatesByHash(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> dup = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                if (i - map.get(arr[i]) <= k) {
                    dup.add(arr[i]);
                }
            }
            map.put(arr[i], i);
        }
        if (dup != null) {
            return dup;
        }
        return Collections.EMPTY_SET;
    }


    private static boolean findDuplicatesWithSlidingWindow(int[] arr, int k) {

        Set<Integer> dup = new HashSet<>(k);

        for (int i = 0; i < arr.length; i++) {
            if (dup.contains(arr[i])) {
                return true;
            }
            dup.add(arr[i]);

            if (i >= k) {
                dup.remove(arr[i - k]);
            }

        }
        return false;
    }
}