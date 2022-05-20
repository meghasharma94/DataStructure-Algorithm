package Arrays.rotation;

public class ArrayRightRotation {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 0, 1};//{1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        rightRotate(arr, d);
        rotateWithJuggling(arr, d);
    }

    private static void rotateWithJuggling(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        int gcdVal = gcd(d, n);
        int temp, i, j, k;

        for (i = 0; i < gcdVal; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
