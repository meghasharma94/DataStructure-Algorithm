package recursion;

public class SimpleRecursion {


    public static void main(String[] args) {
        printNumbers(10);
        System.out.println(" ");
        printReverseNumbers(10);
        System.out.println(" ");

        for (int i = 0; i < 5; i++) {
            System.out.print(printFib(i) + " ");
        }
    }


    private static void printNumbers(int n) {
        if (n == 1) {
            System.out.print(" " + 1);
            return;
        }
        printNumbers(n - 1);
        System.out.print(" " + n);
    }

    private static void printReverseNumbers(int n) {
        if (n == 1) {
            System.out.print(" " + 1);
            return;
        }
        System.out.print(" " + n);
        printReverseNumbers(n - 1);
    }


    private static int printFib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return printFib(n - 1) + printFib(n - 2);
    }






}
