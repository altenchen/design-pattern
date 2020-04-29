package designpattern.behavior.observer.p2pdemo.eventbussimpleimpl;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author altenchen
 * @time 2020/4/29
 * @description 功能
 */
public class ObserverAction {
    
    private Object target;
    private Method method;
    
    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }
    
    public void execute(Object event) { //event是method方法的参数
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
}
