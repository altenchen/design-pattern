package designpattern.behavior.observer.p2pdemo.pattern;

import designpattern.behavior.observer.p2pdemo.NotificationService;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService = new NotificationService(); //依赖注入
    
    @Override
    public void handleRegSuccess(long userId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                notificationService.sendInboxMessage(userId, "mutiple run...");
            }
        });
        thread.start();
    }
}
