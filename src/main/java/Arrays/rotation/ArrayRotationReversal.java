package Arrays.rotation;

public class ArrayRotationReversal {
    /*
     * Reversal is the three steps process
     * Step1 : divide the array in two part
     * A : n-r
     * B : r
     * Step2 : Reverse A and B => ArBr
     * Step3 : Reverse whole ArBr=>(ArBr)r
     *
     * complexity : O(n)
     *
     **/

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        print(arr);
        System.out.println("");

        System.out.println("Print rotation in left");
        leftReverseRotate(arr, d);
        print(arr);
        System.out.println("");

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Print rotation in right");
        rightReverseRotate(arr1, d);
        print(arr1);

    }

    private static void print(int[] arr) {
        System.out.println(" ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void leftReverseRotate(int[] arr, int d) {
        int n = arr.length;
        if (d == 0) {
            return;
        }
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }


    private static void rightReverseRotate(int[] arr, int d) {
        int n = arr.length;
        if (d == 0) {
            return;
        }
        d = d % n;
        reverse(arr, 0, n - d - 1);
        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
}
