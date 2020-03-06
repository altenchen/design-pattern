package singleton;

/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public class Test {

    public static void main(String[] args) {

        OrderController orderController = new OrderController();
        UserController userController = new UserController();

        orderController.create("create method...");
        userController.login("altenchen", "login message...");

        //IdGeneration使用距离
        long id = SingletonIdGeneration.getIdGeneration().getId();

    }
}
