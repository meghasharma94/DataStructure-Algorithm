package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CountPath {

    private int V;
    private LinkedList<Integer> adjList[];
    private Stack<Integer> stack;

    public CountPath(int v) {
        this.V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }

    }

    public static void main(String[] args) {
        CountPath p = new CountPath(4);
        p.addEdge(0, 1);
        p.addEdge(0, 2);
        p.addEdge(0, 3);
        p.addEdge(2, 0);
        p.addEdge(2, 1);
        p.addEdge(1, 3);

        boolean[] isVisited = new boolean[p.V];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(2);
        p.countPathUtils(2, 3, isVisited, pathList);
    }

    private void countPathUtils(Integer u, Integer d,
                                boolean[] isVisited,
                                List<Integer> localPathList) {

        if (u.equals(d)) {
            System.out.println(localPathList);
            return;
        }

        isVisited[u] = true;

        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                localPathList.add(i);
                countPathUtils(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }

        }
        isVisited[u] = false;
    }

    private void addEdge(int i, int i1) {
        adjList[i].add(i1);
    }


}
