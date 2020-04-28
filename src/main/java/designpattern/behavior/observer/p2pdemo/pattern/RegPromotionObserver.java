package designpattern.behavior.observer.p2pdemo.pattern;

import com.google.common.eventbus.Subscribe;
import designpattern.behavior.observer.p2pdemo.PromotionService;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class RegPromotionObserver {
    private PromotionService promotionService = new PromotionService(); //依赖注入
    
    @Subscribe
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
