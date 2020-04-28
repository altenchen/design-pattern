package designpattern.behavior.observer.p2pdemo.pattern;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import designpattern.behavior.observer.p2pdemo.UserService;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class UserController {
    private UserService userService = new UserService(); //依赖注入
    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;
    
    @SuppressWarnings("AlibabaThreadPoolCreation")
    public UserController() {
//        eventBus = new EventBus(); //同步阻塞方式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }
    
    //一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }
    
    public long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        
        eventBus.post(userId);
        
        return userId;
    }

}
