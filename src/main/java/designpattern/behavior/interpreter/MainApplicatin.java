package designpattern.behavior.interpreter;

/**
 * @description:
 * @create: 2020/5/31
 * @author: altenchen
 */
public class MainApplicatin {
    public static void main(String[] args) {
        ExpressionInterpreter expressionInterpreter = new ExpressionInterpreter();
        long result = expressionInterpreter.interpret("1 2 3 + - *");

        System.out.println(result);

    }

}
