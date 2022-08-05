package graph;

import java.util.LinkedList;
import java.util.Stack;

public class HasPath {

    private int V;
    private LinkedList<Integer> adjList[];
    private Stack<Integer> stack;

    public HasPath(int v) {
        this.V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        HasPath g = new HasPath(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

        System.out.println("The Depth First Traversal has path of the graph is as follows : " + g.hasPath(5, 1));
    }

    private boolean hasPath(int src, int dest) {
        if (src == dest) {
            return true;
        }

        boolean visted[] = new boolean[V];

        stack.push(src);
        visted[src] = true;
        int index = 0;
        int a;

        while (!stack.empty()) {
            index = stack.peek();
            stack.pop();
            for (int j = 0; j < adjList[index].size(); j++) {
                a = adjList[index].get(j);
                if (!visted[a]) {
                    stack.push(a);
                    visted[a] = true;
                }
                if (a == dest) {
                    return true;
                }
            }
        }
        return false;
    }

    private void addEdge(int i, int i1) {
        adjList[i].add(i1);
    }


}
