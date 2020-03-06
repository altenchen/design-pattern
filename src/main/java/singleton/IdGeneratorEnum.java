package singleton;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public enum IdGeneratorEnum {

    INSTANCE;
    private AtomicInteger id = new AtomicInteger(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
