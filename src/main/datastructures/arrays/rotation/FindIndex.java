package arrays.rotation;

/**
 *
 * Input : arr[] : {1, 2, 3, 4, 5}
 *         ranges[] = { {0, 2}, {0, 3} }
 *         index : 1
 * Output : 3
 * Algorithm
 *
 * So,  3 cases :
 * If index = left, index will be changed to right.
 * If index is not bounds by the range, no effect of rotation.
 * If index is in bounds, index will have the element at index-1.
 *
 * */
public class FindIndex {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // No. of rotations
        int rotations = 2;

        // Ranges according to 0-based indexing
        int[][] ranges = {{0, 2}, {0, 3}};

        int index = 1;
        System.out.println(findElement(arr, ranges,
                rotations, index));
    }

    private static int findElement(int[] arr, int[][] ranges,
                                   int rotations, int index) {
        for (int i = rotations - 1; i >= 0; i--) {

            // Range[left...right]
            int left = ranges[i][0];
            int right = ranges[i][1];

            // Rotation will not have any effect
            if (left <= index && right >= index) {
                if (index == left)
                    index = right;
                else
                    index--;
            }
        }

        // Returning new element
        return arr[index];
    }

}
