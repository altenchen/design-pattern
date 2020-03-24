package designpattern.creation.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public class SingletonIdGeneration {

    private AtomicInteger id = new AtomicInteger(0);

    private static final SingletonIdGeneration idGeneration = new SingletonIdGeneration();
//    private static SingletonIdGeneration idGeneration;

    private SingletonIdGeneration() {
    }

    public static SingletonIdGeneration getIdGeneration() {
        return idGeneration;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
