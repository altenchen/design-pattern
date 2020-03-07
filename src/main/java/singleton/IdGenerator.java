package singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
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

    /**饿汉式
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
    private static volatile IdGenerator instance;
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

    /**双重校验优化
    private static volatile IdGenerator instance;
    private IdGenerator(){}
    public static IdGenerator getInstance() {
        IdGenerator temp = instance;
        if (temp == null) {
            synchronized (IdGenerator.class) {
                temp = instance;
                if (temp == null) {
                    temp = new IdGenerator();
                    instance = temp;
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

    /**支持有参构造方案一：使用时，先调用init方法，再调用getInstance方法
    private static IdGenerator instance = null;
    private final int paramA;
    private final int paramB;

    private IdGenerator(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            throw new RuntimeException("Run init() first.");
        }
        return instance;
    }

    public synchronized static IdGenerator init(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("Singleton has been created!");
        }
        instance = new IdGenerator(paramA, paramB);
        return instance;
    }
    end*/

    /**支持有参构造方案二
    private static IdGenerator instance = null;
    private final int paramA;
    private final int paramB;
    private IdGenerator(int paramA, int paramB){
        this.paramA = paramA;
        this.paramB = paramB;
    }
    public synchronized static IdGenerator getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new IdGenerator(paramA, paramB);
        }
        return instance;
    }
    end*/

    /**支持有参数构造方案三
    private static IdGenerator instance = null;
    private final int paramA;
    private final int paramB;
    private IdGenerator() {
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }
    public synchronized static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }
    end*/

    /**线程唯一的单例实现
    private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<>();
    private IdGenerator() {}
    public static IdGenerator getInstance() {
        long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGenerator());
        return instances.get(currentThreadId);
    }
    end*/

    /**集群模式的单例实现(伪代码)
    private static IdGenerator instance;
    private static SharedObjectStorage storage = FileSharedObjectStorage(入参省略，比如文件地址);
    private static DistributedLock lock = new DistributedLock();
    private static SharedObjectStorage FileSharedObjectStorage() {
        return null;
    }
    public synchronized static IdGenerator getInstance() {
        if (instance == null) {
            lock.lock();
            instance = storage.load(IdGenerator.class);
        }
        return instance;
    }
    public synchronized void freeInstance() {
        storage.save(this, IdGenerator.class);
        instance = null; //释放对象
        lock.unlock();
    }
    end*/

    /**多例模式实现一
    private long serverNo;
    private String serverAddress;
    private static final int SERVER_COUNT = 3;
    private static final Map<Long, IdGenerator> serverInstances = new HashMap<>();

    static {
        serverInstances.put(1L, new IdGenerator(1L, "1"));
        serverInstances.put(2L, new IdGenerator(2L, "2"));
        serverInstances.put(3L, new IdGenerator(3L, "3"));
    }

    private IdGenerator(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public IdGenerator getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    public IdGenerator getRandomInstance() {
        Random random = new Random();
        int no = random.nextInt(SERVER_COUNT) + 1;
        return serverInstances.get(no);
    }
    end*/

    /**多例模式实现二
    private static final ConcurrentHashMap<String, IdGenerator> instances = new ConcurrentHashMap<>();
    private IdGenerator(){}
    public static IdGenerator getInstance(String serverNo) {
        instances.putIfAbsent(serverNo, new IdGenerator());
        return instances.get(serverNo);
    }
    end*/


    public long getId() {
        return id.incrementAndGet();
    }

}
