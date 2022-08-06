package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 * Topological sorting for Directed Acyclic Graph (DAG)
 * is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering
 *  Topological Sorting for a graph is not possible if the graph is not a DAG
 *  The first vertex in topological sorting is always a vertex with an in-degree of 0 (a vertex with no incoming edges).
 * */
public class KahnAlgo {

    private int V;
    private LinkedList<Integer> adjList[];

    public KahnAlgo(int nodes) {
        this.V = nodes;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList();
        }

    }

    public static void main(String args[]) {
        KahnAlgo g = new KahnAlgo(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println(
                "Following is a Topological Sort");
        g.topologicalSort();
    }

    //Time Complexity: O(V+E).
    //The outer for loop will be executed V number of times and the inner for loop will be executed E number of times.
    //Auxiliary Space: O(V).
    //The queue needs to store all the vertices of the graph. So the space required is O(V)
    private void topologicalSort() {


        //First step : to calculate the indegree of each vertex

        int[] indegree = new int[V];
        int a = 0;

        // Time complexity O(V+E)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                a = adjList[i].get(j);
                indegree[a]++;
            }
        }

        // Second Step : Create a queue and enqueue
        //all vertices with indegree 0

        Queue<Integer> q
                = new LinkedList<Integer>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Third step : create an arrayList with top order sorting

        ArrayList<Integer> topOrder = new ArrayList<>();

        while (!q.isEmpty()) {

            int x = q.peek();
            topOrder.add(x);
            q.poll();

            for (int i : adjList[x]) {
                if (--indegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        System.out.print(topOrder);
    }

    private void addEdge(int u, int v) {
        adjList[u].add(v);
    }
}
