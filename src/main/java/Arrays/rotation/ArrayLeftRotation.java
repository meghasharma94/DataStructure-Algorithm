package Arrays.rotation;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        //leftRotate(arr, d);
        System.out.println("Before rotation");
        print(arr);
        System.out.println();
        rotateWithJuggling(arr, d);
        System.out.println("After rotation");
        print(arr);

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

    private static void leftRotate(int[] arr, int d) {
        System.out.println("Before rotation");
        print(arr);
        System.out.println();
        for (int i = 0; i < d; i++) {
            rotateLeftArray(arr);
        }
        System.out.println("After rotation");

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
