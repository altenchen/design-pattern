package designpattern.behavior.observer.basicdemo;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class ApplicationDemo {
    
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message());
    }
    
}
