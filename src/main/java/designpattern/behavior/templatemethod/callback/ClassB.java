package designpattern.behavior.templatemethod.callback;

/**
 * @author altenchen
 * @time 2020/4/30
 * @description 功能
 */
public class ClassB {

    public void process(ICallBack callBack) {
        //...
        callBack.methodToCallBack();
        //...
    }

}
