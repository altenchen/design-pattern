package designpattern.behavior.observer.basicdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
