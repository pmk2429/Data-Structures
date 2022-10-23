package tree.problems;

/**
 * Combinations of words formed by replacing given numbers with corresponding alphabets.
 * Given a set of single-digit positive numbers, find all possible combinations of words formed by replacing the
 * continuous digits with corresponding character in the English alphabet, i.e., subset {1} can be replaced by A,
 * {2} can be replaced by B, {1, 0} can be replaced by J, {2, 1} can be replaced by U, etc.
 * <p>
 * Example 1:
 * ------------
 * Input:  digits[] = {1, 2, 2}
 * Output: ABB, AV, LB
 * {1, 2, 2} = ABB
 * {1, 22} = AV
 * {12, 2} = LB
 * <p>
 * Example 2:
 * ----------
 * Input:  digits[] = {1, 2, 2, 1}
 * Output: ABBA, ABU, AVA, LBA, LU
 * {1, 2, 2, 1} = ABBA
 * {1, 2, 21} = ABU
 * {1, 22, 1} = AVA
 * {12, 2, 1} = LBA
 * {12, 21} = LU
 */
public class CombinationOfWords {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void print(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }
        else {
            print(node.right);
            print(node.left);
        }
    }

    public static void construct(Node root, int[] digits, int i) {
        if (root == null || i == digits.length) {
            return;
        }

        // check if `digits[i+1]` exists
        if (i + 1 < digits.length) {
            // process current and next digit
            int sum = 10 * digits[i] + digits[i + 1];

            // if both digits can form a valid character, create the left child from it
            if (sum <= 26) {
                root.left = new Node(root.data + alphabet.charAt(sum - 1));
            }

            // construct the left subtree by remaining digits
            construct(root.left, digits, i + 2);
        }

        // process the current digit and create the right child from it
        root.right = new Node(root.data + alphabet.charAt(digits[i] - 1));

        // construct the right subtree by remaining digits
        construct(root.right, digits, i + 1);
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 2, 1};

        Node root = new Node(0);

        construct(root, digits, 0);

        print(root);
    }
}
