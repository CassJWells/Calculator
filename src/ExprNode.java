public class ExprNode {
    String value;
    ExprNode left;
    ExprNode right;

    ExprNode(String value, ExprNode left, ExprNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    ExprNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /* boolean isOperator() {
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }

    boolean isLeaf() {
        return left == null && right == null;
    } */

    public void printTree(int depth) {
        if (right != null) right.printTree(depth + 1);

        for (int i = 0; i < depth; i++) System.out.print("    ");
        System.out.println(value);

        if (left != null) left.printTree(depth + 1);
    }
}
