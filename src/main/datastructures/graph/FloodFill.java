package graph;

import java.util.LinkedList;

/*
 * To find the bounded area which is connected to a given node in a 2-dimensional array,
 * to solve this problem we use a flood-fill algorithm or also called the seed fill algorithm
 * Applications :
 * Bucket Fill Tool of the Paint Program
 * In Games like Go and Minesweeper
 * Check Whether Two Cells are in the Same Connected Area
 **/
public class FloodFill {
    static int M = 8;
    static int N = 8;
    private int V;
    private LinkedList<Integer> adjList[];

    public FloodFill(int v) {
        this.V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }

    }

    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 4, y = 4, newC = 3;
        floodFill(screen, x, y, newC);

        System.out.println("Updated screen after call to floodFill: ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(screen[i][j] + " ");
            System.out.println();
        }
    }

    /**
     * Time complexity: O(M x N).
     * Auxiliary Space: O(M x N)
     * **/
    private static void floodFill(int[][] screen, int x, int y, int newC) {

        if (screen[x][y] == newC) {
            return;
        }
        floodFilll(screen, x, y, newC, screen[x][y]);
    }

    private static void floodFilll(int[][] screen, int x, int y, int newC, int oldC) {
        // check for coordinates
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }
        //check for valid values 
        if (screen[x][y] != oldC) {
            return;
        }

        screen[x][y] = newC;

        floodFilll(screen, x + 1, y, newC, oldC);
        floodFilll(screen, x - 1, y, newC, oldC);
        floodFilll(screen, x, y - 1, newC, oldC);
        floodFilll(screen, x, y + 1, newC, oldC);
    }
}
