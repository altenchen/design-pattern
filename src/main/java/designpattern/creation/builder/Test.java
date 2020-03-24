package designpattern.creation.builder;

/**
 * @description:
 * @create: 2020/3/22
 * @author: altenchen
 */
public class Test {

    public static void main(String[] args) {

        // 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbconnectionpool")
                .setMaxTotal(16)
                .setMaxIdle(8)
                .setMinIdle(18)
                .build();

    }
}
