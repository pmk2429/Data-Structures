package tree.problems;

public class InorderTraversal {

    private static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(12);
        // 2nd level
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(9);
        root.right.right = new Node(16);
        // 3rd level
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(3);
        root.left.right.left = new Node(5);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(11);

        inOrderTraversal(root);
    }
}
