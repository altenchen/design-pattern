package designpattern.behavior.interpreter.alarm.expression;

import java.util.Map;

/**
 * @description:
 * @create: 2020/6/3
 * @author: altenchen
 */
public class GreaterExpression implements Expression {
    private String key;
    private long value;

    public GreaterExpression(String strExpression) {
        /**
         * \\s表示专 空格,回车,换行属等空白符, +号表示一个或多个
         */
        String[] elements = strExpression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].trim().equals(">")) {
            throw new RuntimeException("Expression is invalid: " + strExpression);
        }
        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2].trim());
    }

    public GreaterExpression(String key, long value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if (!stats.containsKey(key)) {
            return false;
        }
        long statValue = stats.get(key);
        return statValue > value;
    }
}
