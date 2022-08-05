package recursion;

public class HeightOfTree {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(12);
        root.right = new Node(13);

        root.right.left = new Node(14);
        root.right.right = new Node(15);

        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        System.out.println(printHeightOfTree(root));

    }

    private static int printHeightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftH = printHeightOfTree(root.left);
        int rightH = printHeightOfTree(root.right);

        return 1 + Math.max(leftH, rightH);
    }

    static class Node {
        int data;
        Node right;
        Node left;

        Node(int val) {
            this.data = val;
        }
    }
}
