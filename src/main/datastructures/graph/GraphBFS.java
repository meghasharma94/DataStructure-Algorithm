package graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    private int V;
    private Queue<Integer> queue;
    private LinkedList<Integer> adj[];


    // The running time complexity of the BFS in Java is O(V+E) where V is the number of nodes in the graph, and E is the number of edges.
    // space complexity is O(V).
    public GraphBFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        this.queue = new LinkedList<>();
    }

    private void addEdge(int v1, int v2) {
        adj[v1].add(v2);
    }

    private void BFS(int n) {

        boolean nodes[] = new boolean[V];
        nodes[n] = true;
        int a = 0;

        queue.add(n);

        while (queue.size() != 0) {
            n = queue.poll();             //remove the top element of the queue
            System.out.print(n + " ");

            for (int i = 0; i < adj[n].size(); i++)  //iterate through the linked list and push all neighbors into queue
            {
                a = adj[n].get(i);
                if (!nodes[a])                    //only insert nodes into queue if they have not been explored already
                {
                    nodes[a] = true;
                    queue.add(a);
                }
            }

        }
    }

    public static void main(String args[])
    {
        GraphBFS graph = new GraphBFS(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);

        System.out.println("The Breadth First Traversal of the graph is as follows :");

        graph.BFS(0);
    }
}
