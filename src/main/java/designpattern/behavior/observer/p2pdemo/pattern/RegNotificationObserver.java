package designpattern.behavior.observer.p2pdemo.pattern;

import com.google.common.eventbus.Subscribe;
import designpattern.behavior.observer.p2pdemo.NotificationService;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class RegNotificationObserver {
    private NotificationService notificationService = new NotificationService(); //依赖注入
    
    @Subscribe
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "mutiple run...");
    }
}
