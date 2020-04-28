package designpattern.behavior.observer.p2pdemo.nonpattern;

import designpattern.behavior.observer.p2pdemo.PromotionService;
import designpattern.behavior.observer.p2pdemo.UserService;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class UserController {
    private UserService userService; //依赖注入
    private PromotionService promotionService; //依赖注入
    
    public long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()方法异常的try-catch代码
        long userId = userService.register(telephone, password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
}
