package graph;

import java.util.LinkedList;

/**
 * There is a cycle in a graph only if there is a back edge present in the graph.
 * A back edge is an edge that is joining a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
 **/
public class CycleDetection {

    private int V;
    private LinkedList<Integer> adjList[];

    public CycleDetection(int v) {
        this.V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }

    }

    public static void main(String[] args) {

        CycleDetection graph = new CycleDetection(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");


    }

    private void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    // Time Complexity: O(V+E).
    // Space Complecity : O(V+E)
    private boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (isCyclicUtil(i, visited, recursionStack)) {
                return true;
            }
        }

        return false;


    }

    private boolean isCyclicUtil(int src, boolean[] visited, boolean[] recursionStack) {

        if (visited[src] || recursionStack[src]) {
            return true;
        }

        visited[src] = true;
        recursionStack[src] = true;

        for (int j = 0; j < adjList[src].size(); j++) {

            if (!visited[adjList[src].get(j)]) {
                if (isCyclicUtil(adjList[src].get(j), visited, recursionStack)) {
                    return true;
                }
            }

        }
        recursionStack[src] = false;
        return false;
    }


}
