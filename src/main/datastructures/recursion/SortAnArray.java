package recursion;

import java.util.ArrayList;
import java.util.List;

public class SortAnArray {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(23);
        nums.add(43);
        nums.add(1);
        nums.add(5);
        nums.add(0);
        System.out.println("Before sorting");
        nums.stream().forEach(x -> System.out.print(" " + x));

        sort(nums);
        System.out.println("");
        System.out.println("After sorting");

        nums.stream().forEach(x -> System.out.print(" " + x));

    }

    private static void sort(List<Integer> arr) {

        if (arr.size() == 1) return; //Base condition

        int temp = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        sort(arr); // Hypothesis -- reduced the size of array
        insert(arr, temp); // Induction
    }

    private static void insert(List<Integer> arr, int temp) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= temp) {
            arr.add(temp); //Base condition
            return;

        }
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);

        insert(arr, temp); // Hypothesis -- reduced the size of array
        arr.add(val); // Induction
    }
}
