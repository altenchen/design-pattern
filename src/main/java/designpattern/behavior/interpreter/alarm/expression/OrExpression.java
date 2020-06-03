package designpattern.behavior.interpreter.alarm.expression;

import javax.naming.ldap.ExtendedRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @create: 2020/6/3
 * @author: altenchen
 */
public class OrExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();

    public OrExpression(String strOrExpression) {
        String[] andExpressions = strOrExpression.split("\\|\\|");
        for (String andExpr : andExpressions) {
            expressions.add(new AndExpression(andExpr));
        }
    }

    public OrExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expr : expressions) {
            if (expr.interpret(stats)) {
                return true;
            }
        }
        return false;
    }
}
