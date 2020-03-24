package designpattern.creation.factory.exception;

/**
 * @description:
 * @create: 2020/3/22
 * @author: altenchen
 */
public class NoSuchBeanDefinitionException extends Throwable {

    public NoSuchBeanDefinitionException(String msg) {
        System.out.println(msg);
    }
}
