package designpattern.behavior.responsibilitychain;

/**
 * @author altenchen
 * @time 2020/4/27
 * @description 功能
 */
public class HandlerB extends Handler {
    @Override
    public boolean handler() {
        boolean handled = false;
        if (!handled && successor != null) {
            successor.handler();
        }
        return false;
    }
}
