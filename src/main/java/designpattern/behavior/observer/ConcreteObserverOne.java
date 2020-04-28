package designpattern.behavior.observer;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑
        System.out.println("ConcreteObserverOne is notified.");
    }
}
