package designpattern.behavior.interpreter.expression;

/**
 * @description:
 * @create: 2020/5/31
 * @author: altenchen
 */
public class MultiplicationExpression implements Expression {
    private Expression exp1;
    private Expression exp2;

    public MultiplicationExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public long interpret() {
        return exp1.interpret() * exp2.interpret();
    }
}
