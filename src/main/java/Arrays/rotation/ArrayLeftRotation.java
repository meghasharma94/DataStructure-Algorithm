package Arrays.rotation;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        leftRotate(arr, d);

    }

    private static void leftRotate(int[] arr, int d) {
        System.out.println("Before rotation");
        print(arr);
        System.out.println();
        for (int i = 0; i < d; i++) {
            rotateLeftArray(arr);
        }
        System.out.println("After rotation");
        print(arr);
    }

    private static void rotateLeftArray(int[] arr) {
        int n = arr.length;
        int temp = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
         }
    }


}
