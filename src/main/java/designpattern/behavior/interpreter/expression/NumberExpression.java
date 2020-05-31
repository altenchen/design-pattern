package designpattern.behavior.interpreter.expression;

/**
 * @description:
 * @create: 2020/5/31
 * @author: altenchen
 */
public class NumberExpression implements Expression {
    private long number;

    public NumberExpression(long number) {
        this.number = number;
    }

    public NumberExpression(String number) {
        this.number = Long.parseLong(number);
    }

    @Override
    public long interpret() {
        return this.number;
    }
}
