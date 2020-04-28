package designpattern.behavior.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author altenchen
 * @time 2020/4/27
 * @description 功能
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;
    
    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        
        tail.setSuccessor(handler);
        tail = handler;
    }
    
    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
    
}
