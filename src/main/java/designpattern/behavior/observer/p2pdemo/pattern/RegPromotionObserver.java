package designpattern.behavior.observer.p2pdemo.pattern;

import designpattern.behavior.observer.p2pdemo.PromotionService;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService = new PromotionService(); //依赖注入
    
    @Override
    public void handleRegSuccess(long userId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                promotionService.issueNewUserExperienceCash(userId);
            }
        });
        thread.start();
    }
}
