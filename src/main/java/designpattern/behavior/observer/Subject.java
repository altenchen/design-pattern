package designpattern.behavior.observer;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);
}
