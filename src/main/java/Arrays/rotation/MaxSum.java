package Arrays.rotation;

/*
 * https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/?ref=lbp
 * Maximum sum of i*arr[i] among all rotations of a given array
 * Form equation > S(max)=S - C + arr[i-1] * n
 * where S is the original computed sum
 * C: cumulative sum of all elements
 * */
public class MaxSum {

    public static void main(String[] args) {
        MaxSum max = new MaxSum();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        max.print(arr);
        System.out.println("Maximum value will be "+ max.max(arr));

    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int max(int[] arr) {
        int s1 = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++){
            s1 += arr[i] * i; // sum of i*arr[i]
        }
        int cumulativeSum = 0;
        for (int i = 0; i < n; i++) {
            cumulativeSum += arr[i]; //sum of arr[i]
        }

        int res = s1;
        for (int i = 1; i < n; i++) {
            int next_val = s1 - cumulativeSum -
                    +arr[i - 1] * n;

            s1 = next_val;
            res = Math.max(res, next_val);
        }
        return res;
    }

}
