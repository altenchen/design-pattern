package designpattern.creation.factory.didemo;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public interface ApplicationContext {

    Object getBean(String beanId);

}
