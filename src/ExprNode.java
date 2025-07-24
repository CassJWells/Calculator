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

    public double evaluate() {
        if (this.left == null && this.right == null) {
            return Double.parseDouble(this.value); // it's a number
        }

        double leftVal = this.left.evaluate();
        double rightVal = this.right.evaluate();

        return switch (this.value) {
            case "+" -> leftVal + rightVal;
            case "-" -> leftVal - rightVal;
            case "*" -> leftVal * rightVal;
            case "/" -> leftVal / rightVal;
            default -> throw new IllegalArgumentException("Unknown operator: " + this.value);
        };
    }

    public void printTree(int depth) {
        if (right != null) right.printTree(depth + 1);

        for (int i = 0; i < depth; i++) System.out.print("    ");
        System.out.println(value);

        if (left != null) left.printTree(depth + 1);
    }
}
