package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public static void main(String[] args) {
        String str = "abcd";
        int index = 0;
        String curr = "";
        solve(str, index, curr);

       // int[] nums = {1, 2, 3};
        int[] nums = {0};
        subsets(nums);
    }

    private static void solve(String str, int index, String output) {

        if (str.length() - 1 == index) {
            System.out.println(output);
            return;
        }
        String op1 = output;
        String op2 = output + str.charAt(index);

        solve(str, index + 1, op1);
        solve(str, index + 1, op2);
    }

    public static void subsets(int[] nums) {

        List<List<Integer>> current = new ArrayList<List<Integer>>();
        current.add(new ArrayList<>());
        subsets(nums, 0, current, new ArrayList<>());
        current.stream().forEach(x -> System.out.println(x));
    }

    private static void subsets(int[] nums, int index, List<List<Integer>> current, List<Integer> ls) {

        //Base condition
        if (nums.length - 1 == index) {
            ls.add(nums[index]);
            current.add(new ArrayList<>(ls));
            return;
        }
        List<Integer> ls1 = new ArrayList<>(ls);
        if (!current.contains(ls1)) {
            current.add(new ArrayList<>(ls1));

        }

        List<Integer> ls2 = new ArrayList<>(ls);
        ls2.add(nums[index]);
        if (!current.contains(ls2)) {
            current.add(new ArrayList<>(ls2));
        }


        subsets(nums, index + 1, current, ls1);
        subsets(nums, index + 1, current, ls2);
    }


}
