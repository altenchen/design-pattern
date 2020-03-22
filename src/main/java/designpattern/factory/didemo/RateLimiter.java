package designpattern.factory.didemo;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class RateLimiter {

    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test() {
        System.out.println("Hello World!");
    }


}
