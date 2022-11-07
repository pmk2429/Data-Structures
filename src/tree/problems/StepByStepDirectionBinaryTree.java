package tree.problems;

public class StepByStepDirectionBinaryTree {
    private boolean find(TreeNode n, int val, StringBuilder sb) {
        if (n.data == val) {
            return true;
        }
        if (n.left != null && find(n.left, val, sb)) {
            sb.append("L");
        }
        else if (n.right != null && find(n.right, val, sb)) {
            sb.append("R");
        }
        return sb.length() > 0;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();
        find(root, startValue, s);
        find(root, destValue, d);
        int sLength = s.length();
        int dLength = d.length();
        int i = 0, maxOfI = Math.min(sLength, dLength);
        while (i < maxOfI && s.charAt(sLength - i - 1) == d.charAt(dLength - i - 1)) {
            i++;
        }
        return "U".repeat(s.length() - i) + d.reverse().substring(i);
    }
}
