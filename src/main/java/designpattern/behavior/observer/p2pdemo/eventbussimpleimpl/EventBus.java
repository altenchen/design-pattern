package designpattern.behavior.observer.p2pdemo.eventbussimpleimpl;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;


/**
 * @author altenchen
 * @time 2020/4/29
 * @description 功能
 */
public class EventBus {
    
    private Executor executor;
    private ObserverRegistery registry = new ObserverRegistery();
    
    public EventBus() {
        this(MoreExecutors.directExecutor());
    }
    
    public EventBus(Executor executor) {
        this.executor = executor;
    }
    
    public void register(Object object) {
        registry.register(object);
    }
    
    public void post(Object event) {
        List<ObserverAction> matchedObservers = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : matchedObservers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
