abstract class BinaryExpression extends Expression {
    protected Expression left;
    protected Expression right;

    BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + right.toString();
    }

    @Override
    public double evaluate() {
        return left.evaluate();
    }
}
