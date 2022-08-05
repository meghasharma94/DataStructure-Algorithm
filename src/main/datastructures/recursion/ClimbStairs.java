package recursion;

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println("The number of steps to climb are " + climbStairs(5));
    }

    private static int climbStairs(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
