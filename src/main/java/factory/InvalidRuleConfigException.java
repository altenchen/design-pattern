package factory;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class InvalidRuleConfigException extends Throwable {

    public InvalidRuleConfigException(String exceptionMsg) {
        System.out.println(exceptionMsg);
    }
}
