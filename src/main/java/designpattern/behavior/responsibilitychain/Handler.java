package designpattern.behavior.responsibilitychain;

/**
 * @author altenchen
 * @time 2020/4/27
 * @description 功能
 */
public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    
    public final void handle() {
        //责任链变体，请求会被所有处理器都处理一遍
        doHandle();
        if (successor != null) {
            successor.handle();
        }
    }
    
    protected abstract boolean doHandle();
}
