package recursion;

public class Permutation {

    public static void main(String[] args) {
       // String str = "abc";
        String str = "a1b2";
        int index = 0;
        String curr = "";
        solve(str, index, curr);

    }

    /*
        output
    *   ab
        aB
        Ab
        AB
    * */
    private static void solve(String str, int index, String curr) {

        if (str.length() - 1 == index) {
            System.out.println(curr);
            return;
        }

        String op1 = curr + String.valueOf(str.toLowerCase().charAt(index));

        String op2 = curr + String.valueOf(str.toUpperCase().charAt(index));


        solve(str, index + 1, op1);
        solve(str, index + 1, op2);
    }

}
