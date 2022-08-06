package backtracking;

import java.util.ArrayList;

/**
 * Time Complexity: O(3^(n^2)).
 * As there are N^2 cells from each cell there are 3 unvisited neighboring cells. So the time complexity O(3^(N^2).
 * Auxiliary Space: O(3^(n^2)).
 * As there can be at most 3^(n^2) cells in the answer so the space complexity is O(3^(n^2)).
 *
 * **/
public class RatInAMaze {
    static int N;
    private static String s = "";
    private static ArrayList<String> path = new ArrayList<>();

    public static void main(String[] args) {

        int maze[][] = { { 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1 } };

        N = maze.length;
        findPath(maze, N);
    }

    public static void findPath(int[][] m, int n) {

        int[][] sol = new int[N][N];
        int x = 0, y = 0;
        solveMaze(m, sol, x, y);

        if (path.isEmpty()) {
            System.out.println("No path found");
        } else {
            System.out.println(path);
        }

    }

    static boolean isSafe(
            int m[][], int sol[][], int x, int y) {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0
                && y < N && m[x][y] == 1 && sol[x][y] == 0);
    }

    private static void solveMaze(int[][] m, int[][] sol, int x, int y) {

        // Base condition

        if (x == N - 1 && y == N - 1 && m[x][y] == 1) {
            path.add(s);
            return;
        }

        //Check the valid move

        if (x >= 0 && x < N && y >= 0
                && y < N && m[x][y] == 0 && sol[x][y] == 1) {
            return;
        }

        sol[x][y] = 1;

        if (isSafe(m, sol, x, y - 1)) {
            s = s + "L";
            solveMaze(m, sol, x, y - 1);
        }
        if (isSafe(m, sol, x, y + 1)) {
            s = s + "R";
            solveMaze(m, sol, x, y + 1);
        }
        if (isSafe(m, sol, x - 1, y)) {
            s = s + "U";
            solveMaze(m, sol, x - 1, y);
        }
        if (isSafe(m, sol, x + 1, y)) {
            s = s + "D";
            solveMaze(m, sol, x + 1, y);
        }
        sol[x][y] = 0;
    }


    private void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                        " " + sol[i][j] + " ");
            System.out.println();
        }
    }
}
