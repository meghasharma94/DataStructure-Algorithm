package dp;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 **/
public class SimpleKnapsack {

    public static void main(String[] args) {

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;

        // a recursive solution
        // Time Complexity: O(2^n) As there are redundant subproblems..
        // Auxiliary Space :O(1) + O(N). t O(N) auxiliary stack space(ASS)
        int max1 = solution1(wt, val, W, n);

        System.out.println("a recursive solution ---- " + max1);
        // a recursive + memoization
        int max2 = solution2(wt, val, W, n);

        System.out.println("a recursive + memoization ---- " + max2);

        // tabulation solution -
        // Time complexity O(N*W). As redundant calculations of states are avoided.
        //Auxiliary Space: O(N*W)
        int max3 = solution3(wt, val, W, n);

        System.out.println("tabulation solution ---- " + max3);


    }

    private static int solution3(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        return knapsack3(wt, val, w, n, dp);
    }


    private static int solution2(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return knapsack2(wt, val, w, n, dp);
    }

    private static int solution1(int[] wt, int[] val, int w, int n) {
        return knapsack(wt, val, w, n);
    }


    private static int knapsack3(int[] wt, int[] val, int w, int n, int[][] dp) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {

                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }
            }
        }

        return dp[n][w];
    }

    private static int knapsack2(int[] wt, int[] val, int w, int n, int[][] dp) {
        if (n == 0 || w == 0) return 0;

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] > w) {
            return dp[n][w] = knapsack(wt, val, w, n - 1);
        } else {
            return dp[n][w] = Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
        }
    }

    private static int knapsack(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) return 0;

        if (wt[n - 1] > w) {
            return knapsack(wt, val, w, n - 1);
        } else {
            return Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
        }
    }

}
