package designpattern.factory.didemo;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class DiDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xm");

        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");

        rateLimiter.test();


    }


}
