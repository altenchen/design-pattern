package singleton;

/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public class OrderController {

    private NoneSingletonLogger noneSingletonLogger = new NoneSingletonLogger();


    public void create(String message) {
//        noneSingletonLogger.log("Created an order: " + message);
        Logger.getInstance().log("Created an order: " + message);
    }

}
