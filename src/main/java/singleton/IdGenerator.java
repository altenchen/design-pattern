package singleton;

import java.net.PortUnreachableException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public class IdGenerator {

    private AtomicInteger id = new AtomicInteger(0);

    /**懒汉式
    private static final IdGenerator instance = new IdGenerator();
    private IdGenerator() {}
    public static IdGenerator getInstance() {
        return instance;
    }
    end*/

    /**懒汉式
    private static IdGenerator instance;
    private IdGenerator() {}
    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }
    end*/

    /**双重校验
    private static IdGenerator instance;
    private IdGenerator(){}
    public static IdGenerator getInstance() {
        if (instance == null) {
            synchronized (IdGenerator.class) {
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }
    end*/


    /**静态内部类
    private IdGenerator(){}

    private static class SingletonHolder{
        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
    }
    end*/


    public long getId() {
        return id.incrementAndGet();
    }

}
