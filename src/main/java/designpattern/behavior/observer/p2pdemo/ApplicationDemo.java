package designpattern.behavior.observer.p2pdemo;

import designpattern.behavior.observer.p2pdemo.pattern.RegNotificationObserver;
import designpattern.behavior.observer.p2pdemo.pattern.RegObserver;
import designpattern.behavior.observer.p2pdemo.pattern.RegPromotionObserver;
import designpattern.behavior.observer.p2pdemo.pattern.UserController;

import java.util.ArrayList;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class ApplicationDemo {
    
    public static void main(String[] args) {
        UserController userController = new UserController();
        
        RegNotificationObserver regNotificationObserver = new RegNotificationObserver();
        RegPromotionObserver regPromotionObserver = new RegPromotionObserver();
        ArrayList<RegObserver> regObservers = new ArrayList<>();
        regObservers.add(regNotificationObserver);
        regObservers.add(regPromotionObserver);
        
        userController.setRegObservers(regObservers);
        userController.register("15210097420", "123456");
    }
}
