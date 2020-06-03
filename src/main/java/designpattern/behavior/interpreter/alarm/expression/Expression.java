package designpattern.behavior.interpreter.alarm.expression;

import java.util.Map;

/**
 * @description:
 * @create: 2020/6/3
 * @author: altenchen
 */
public interface Expression {
    boolean interpret(Map<String, Long> stats);
}
