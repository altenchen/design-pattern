package designpattern.behavior.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author altenchen
 * @time 2020/4/27
 * @description 功能
 */
public class HandlerChain {
    private List<IHandler> handlers = new ArrayList<>();
    
    public void addHandlers(IHandler handler) {
        this.handlers.add(handler);
    }
    
    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                break;
            }
        }
    }
    
}
