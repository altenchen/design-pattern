package designpattern.behavior.observer.p2pdemo;

import designpattern.behavior.observer.p2pdemo.pattern.RegNotificationObserver;
import designpattern.behavior.observer.p2pdemo.pattern.RegObserver;
import designpattern.behavior.observer.p2pdemo.pattern.RegPromotionObserver;
import designpattern.behavior.observer.p2pdemo.pattern.UserController;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class ApplicationDemo {
    
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                10,
                5L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        UserController userController = new UserController(threadPoolExecutor);
        
        RegNotificationObserver regNotificationObserver = new RegNotificationObserver();
        RegPromotionObserver regPromotionObserver = new RegPromotionObserver();
        ArrayList<RegObserver> regObservers = new ArrayList<>();
        regObservers.add(regNotificationObserver);
        regObservers.add(regPromotionObserver);
        
        userController.setRegObservers(regObservers);
        userController.register("15210097420", "123456");
    
        //任务一是否完全结束
        threadPoolExecutor.shutdown();
        while (true) {
            //判断线程池是否中线程是否全部执行完成
            if (threadPoolExecutor.isTerminated()) {
                System.out.println("任务执行完成...");
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("任务执行异常...");
                e.printStackTrace();
            }
        }
        
    }
}
