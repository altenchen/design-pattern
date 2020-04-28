package designpattern.behavior.observer;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo is notified.");
    }
}
