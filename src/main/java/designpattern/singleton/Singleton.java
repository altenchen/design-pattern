package designpattern.singleton;

/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public class Singleton {

    /**饿汉式
    private static final Singleton designpattern.singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getSingleton() {
        return designpattern.singleton;
    }
    end*/

    private static Singleton singleton;

    private Singleton() {

    }



}
