package Arrays.rotation;

public class ArrayRightRotation {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 0, 1};//{1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        rightRotate(arr, d);
    }

    private static void rightRotate(int[] arr, int d) {
        System.out.println("Before rotation");
        print(arr);
        System.out.println();
        for (int i = 0; i < d; i++) {
            rotateRightArray(arr);
        }
        System.out.println("After rotation");
        print(arr);
    }

    private static void rotateRightArray(int[] arr) {
        int n = arr.length;
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


}
