package designpattern.factory.didemo;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class RedisCounter {

    private String ipAddress;
    private int port;

    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

}
