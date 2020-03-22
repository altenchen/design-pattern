package designpattern.singleton;


/**
 * @description:
 * @create: 2020/3/6
 * @author: altenchen
 */
public class UserController {

    private NoneSingletonLogger noneSingletonLogger = new NoneSingletonLogger();

    public void login(String username, String password) {
        //...省略业务逻辑代码...
//        noneSingletonLogger.log(username + " logined!");
        Logger.getInstance().log(username + " logined!");
    }

}
