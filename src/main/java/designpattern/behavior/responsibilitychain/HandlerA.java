package designpattern.behavior.responsibilitychain;

/**
 * @author altenchen
 * @time 2020/4/27
 * @description 功能
 */
public class HandlerA extends Handler {
    @Override
    public boolean handler() {
        boolean handled = false;
        //todo:
        if (!handled && successor != null) {
            successor.handler();
        }
        return handled;
    }
}
