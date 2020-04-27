package designpattern.behavior.responsibilitychain;

/**
 * @author altenchen
 * @time 2020/4/27
 * @description 功能
 */
public class HandlerA extends Handler {
    
    @Override
    protected boolean doHandle() {
        boolean handled = false;
        //...
        return handled;
    }
}
