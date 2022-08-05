package graph;

import java.util.LinkedList;
import java.util.Stack;

public class GraphDFS {

    private int V;
    private Stack<Integer> stack;
    private LinkedList<Integer> adjList[];

    public GraphDFS(int v) {
        this.V = v;
        this.adjList = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            this.adjList[i] = new LinkedList<>();
        }
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {

        GraphDFS g = new GraphDFS(6);

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

        System.out.println("The Depth First Traversal of the graph is as follows :");

        g.DFS2(0);

    }


    private void DFS2(int n) {

        boolean nodes[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(n);                                    //push root node to the stack
        int a = 0;

        while (!stack.empty()) {
            n = stack.peek();                       //extract the top element of the stack
            stack.pop();                            //remove the top element from the stack

            if (nodes[n] == false) {
                System.out.print(n + " ");
                nodes[n] = true;
            }

            for (int i = 0; i < adjList[n].size(); i++)  //iterate through the linked list and then propagate to the next few nodes
            {
                a = adjList[n].get(i);
                if (!nodes[a])                    //only push those nodes to the stack which aren't in it already
                {
                    stack.push(a);                          //push the top element to the stack
                }
            }

        }
    }

    private void DFS(int i) {

        boolean[] nodes = new boolean[V];
        stack.push(i);
        nodes[i] = true;

        int a = 0;

        while (!stack.empty()) {

            i = stack.peek();
            System.out.print(i + " ");
            stack.pop();

            for (int j = 0; j < adjList[i].size(); j++) {
                a = adjList[i].get(j);
                if (!nodes[a]) {
                    nodes[a] = true;
                    stack.push(a);
                }
            }


        }


    }

    private void addEdge(int i, int i1) {
        adjList[i].add(i1);
    }


}
