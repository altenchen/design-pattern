package designpattern.behavior.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author altenchen
 * @time 2020/4/27
 * @description 功能
 */
public class HandlerChain {
    
    List<IHandler> handlers = new ArrayList<IHandler>();
    
    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }
    
    public void handle() {
        for (IHandler handle : handlers) {
            //责任链变体，请求会被所有处理器都处理一遍
            handle.handle();
        }
    }
    
}
