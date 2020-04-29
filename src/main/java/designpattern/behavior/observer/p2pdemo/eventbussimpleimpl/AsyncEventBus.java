package designpattern.behavior.observer.p2pdemo.eventbussimpleimpl;

import java.util.concurrent.Executor;

/**
 * @author altenchen
 * @time 2020/4/29
 * @description 功能
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
