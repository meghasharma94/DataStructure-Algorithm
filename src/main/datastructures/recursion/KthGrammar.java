package recursion;

public class KthGrammar {

    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(solve(n, k));

    }

    private static int solve(int n, int k) {

        if (n == 1 || k == 1) return 0;

        int mid = (int) Math.pow(2, n-1) / 2;

        if (k <= mid) {
            return solve(n - 1, k);
        } else {
            return flip(solve(n - 1, k - mid));
        }
    }

    public static int flip(int val) {
        return val == 0 ? 1 : 0;
    }
}
