package recursion;

public class Subsets {


    public static void main(String[] args) {
        String str = "abcd";
        int index = 0;
        String curr = "";
        solve(str, index, curr);
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

}
