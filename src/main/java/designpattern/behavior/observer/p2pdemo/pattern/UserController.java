package designpattern.behavior.observer.p2pdemo.pattern;

import designpattern.behavior.observer.p2pdemo.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class UserController {
    private UserService userService = new UserService(); //依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();
    
    //一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }
    
    public long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        for (RegObserver observer : regObservers) {
            observer.handleRegSuccess(userId);
        }
        return userId;
    }

}
