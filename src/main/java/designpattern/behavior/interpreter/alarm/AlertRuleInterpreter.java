package designpattern.behavior.interpreter.alarm;

import designpattern.behavior.interpreter.alarm.expression.Expression;
import designpattern.behavior.interpreter.alarm.expression.OrExpression;

import java.util.Map;

/**
 * @description:
 * @create: 2020/6/3
 * @author: altenchen
 */
public class AlertRuleInterpreter {
    private Expression expression;

    public AlertRuleInterpreter(String ruleExpression) {
        this.expression = new OrExpression(ruleExpression);
    }

    public boolean interpret(Map<String, Long> stats) {
        return expression.interpret(stats);
    }

}
